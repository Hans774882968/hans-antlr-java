package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.InsnUtil;
import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.reference.GlobalVarReference;
import com.example.hans_antlr4.domain.expression.reference.Reference;
import com.example.hans_antlr4.domain.expression.reference.VarReference;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.scope.GlobalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RangedForStatementGenerator implements Opcodes {
    private MethodVisitor mv;

    private void generateIIncInsn(
            RangedForStatement rangedForStatement,
            Scope newScope,
            int increment) {
        final String iteratorVarName = rangedForStatement.getIteratorVarName();
        if (newScope.localVariableExists(iteratorVarName)) {
            final int iteratorVarIndex = newScope.getLocalVariableIndex(iteratorVarName);
            mv.visitIincInsn(iteratorVarIndex, increment);
            return;
        }
        GlobalVariable globalVariable = newScope.getGlobalVariable(iteratorVarName);
        String publicClassName = newScope.getClassName();
        Type type = globalVariable.getType();
        String descriptor = type.getDescriptor();
        mv.visitFieldInsn(GETSTATIC, publicClassName, iteratorVarName, descriptor);
        if (type == BuiltInType.LONG) {
            mv.visitLdcInsn((long) increment);
        } else {
            InsnUtil.generateIntInsn(mv, increment);
        }
        mv.visitInsn(type.getAddOpcode());
        mv.visitFieldInsn(PUTSTATIC, publicClassName, iteratorVarName, descriptor);
    }

    public void generate(RangedForStatement rangedForStatement) {
        final Scope newScope = rangedForStatement.getScope();
        final String iteratorVarName = rangedForStatement.getIteratorVarName();
        final Expression startExpression = rangedForStatement.getStartExpression();
        final Expression endExpression = rangedForStatement.getEndExpression();
        final Type endExprType = rangedForStatement.getEndExpressionType();
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(mv, newScope);
        StatementGenerator statementGenerator = new StatementGenerator(mv, newScope);

        // 1. 生成变量定义语句
        rangedForStatement.getIteratorVariableStatement().accept(statementGenerator);

        // 2. 生成 GOTO 结束条件判断区的 label
        Label conditionLabel = new Label();
        mv.visitJumpInsn(GOTO, conditionLabel);

        // 3. 方法体
        Label bodyLabel = new Label();
        mv.visitLabel(bodyLabel);
        rangedForStatement.getBodyStatement().accept(statementGenerator);

        // 4. 生成加1或减1的操作
        mv.visitLabel(rangedForStatement.getOperationLabel());
        ConditionalExpression startLessThenEndExpression = new ConditionalExpression(
                startExpression, endExpression, CompareSign.LESS);
        startLessThenEndExpression.accept(expressionGenerator);
        Label decOneLabel = new Label();
        mv.visitJumpInsn(IFEQ, decOneLabel);
        generateIIncInsn(rangedForStatement, newScope, 1);
        mv.visitJumpInsn(GOTO, conditionLabel);

        mv.visitLabel(decOneLabel);
        generateIIncInsn(rangedForStatement, newScope, -1);

        // 5. 生成条件判断
        mv.visitLabel(conditionLabel);
        startLessThenEndExpression.accept(expressionGenerator);
        // start < end 固定走加1， var 大于 end 则退出；
        // 否则固定走减1， var 小于 end 则退出
        Label iteratorLessThanEndLabel = new Label();
        mv.visitJumpInsn(IFEQ, iteratorLessThanEndLabel);
        {
            Reference reference = newScope.localVariableExists(iteratorVarName)
                    ? new VarReference(iteratorVarName, endExprType)
                    : new GlobalVarReference(iteratorVarName, endExprType);
            ConditionalExpression iteratorGreaterThanEndCondition = new ConditionalExpression(
                    reference, endExpression, CompareSign.GREATER);
            iteratorGreaterThanEndCondition.accept(expressionGenerator);
        }
        // 满足 var 大于 end 就退出，否则跳 body
        mv.visitJumpInsn(IFNE, rangedForStatement.getEndLoopLabel());
        mv.visitJumpInsn(GOTO, bodyLabel);

        // 同理
        mv.visitLabel(iteratorLessThanEndLabel);
        {
            Reference reference = newScope.localVariableExists(iteratorVarName)
                    ? new VarReference(iteratorVarName, endExprType)
                    : new GlobalVarReference(iteratorVarName, endExprType);
            ConditionalExpression iteratorLessThanEndCondition = new ConditionalExpression(
                    reference, endExpression, CompareSign.LESS);
            iteratorLessThanEndCondition.accept(expressionGenerator);
        }
        mv.visitJumpInsn(IFNE, rangedForStatement.getEndLoopLabel());
        mv.visitJumpInsn(GOTO, bodyLabel);

        mv.visitLabel(rangedForStatement.getEndLoopLabel());
    }
}
