package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.scope.AssignmentLhs;
import com.example.hans_antlr4.domain.scope.Variable;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.domain.type.TypeChecker;
import com.example.hans_antlr4.exception.assignment.AssignmentLhsAndRhsTypeIncompatibleException;

import lombok.Getter;
import java.util.Objects;

@Getter
public class AssignmentExpression extends Expression {
    private AssignmentLhs lhs;
    private AssignmentSign sign;
    private Expression expression;
    private int sourceLine;

    // AssignmentExpression 的类型为 LHS 类型，计算时左右侧入栈顶并转为 max 类型，计算完毕后把 max 类型转为 LHS 类型再赋值
    public AssignmentExpression(
            Variable variable,
            AssignmentSign sign,
            Expression expression,
            int sourceLine) {
        super(variable.getType(), null, null);
        this.lhs = new AssignmentLhs(variable);
        this.sign = sign;
        this.expression = expression;
        this.sourceLine = sourceLine;
        typeCheck();
    }

    public AssignmentExpression(
            ClassFieldReference classFieldReference,
            AssignmentSign sign,
            Expression expression,
            int sourceLine) {
        super(classFieldReference.getType(), null, null);
        this.lhs = new AssignmentLhs(classFieldReference);
        this.sign = sign;
        this.expression = expression;
        this.sourceLine = sourceLine;
        typeCheck();
    }

    public AssignmentExpression(
            ArrayAccess arrayAccess,
            AssignmentSign sign,
            Expression expression,
            int sourceLine) {
        super(arrayAccess.getType(), null, null);
        this.lhs = new AssignmentLhs(arrayAccess);
        this.sign = sign;
        this.expression = expression;
        this.sourceLine = sourceLine;
        typeCheck();
    }

    public void typeCheck() {
        Type lhsType = getLhsType();
        Type rhsType = getRhsType();
        if (!TypeChecker.assignmentLhsTypeAndRhsAreCompatible(sign, lhsType, rhsType)) {
            throw new AssignmentLhsAndRhsTypeIncompatibleException(lhsType, rhsType, sign, sourceLine);
        }
    }

    public boolean lhsIsVariable() {
        return lhs.getVariable() != null;
    }

    public boolean lhsIsClassFieldReference() {
        return lhs.getClassFieldReference() != null;
    }

    public boolean lhsIsArrayAccess() {
        return lhs.getArrayAccess() != null;
    }

    public Variable getLhsVariable() {
        return lhs.getVariable();
    }

    public ClassFieldReference getLhsClassFieldReference() {
        return lhs.getClassFieldReference();
    }

    public ArrayAccess getLhsArrayAccess() {
        return lhs.getArrayAccess();
    }

    public boolean notNecessaryToGenerateDupInstruction() {
        if (!isRootExpression()) {
            return false;
        }
        Statement statement = getBelongStatement();
        return statement instanceof ExpressionStatement;
    }

    public Type getLhsType() {
        return lhs.getType();
    }

    public Type getRhsType() {
        return expression.getType();
    }

    public Type getMaxPriorityNumericType() {
        if (getLhsType().getPriority().compareTo(getRhsType().getPriority()) >= 0) {
            return getLhsType();
        }
        return getRhsType();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void processSubExpressionTree(
            ExpressionTreeProcessor processor,
            Expression parent,
            Statement belongStatement) {
        processor.processExpressionTree(this, parent, belongStatement);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AssignmentExpression)) {
            return false;
        }
        AssignmentExpression assignmentExpression = (AssignmentExpression) o;
        return Objects.equals(getType(), assignmentExpression.getType())
                && Objects.equals(lhs, assignmentExpression.lhs)
                && Objects.equals(sign, assignmentExpression.sign)
                && Objects.equals(expression, assignmentExpression.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), lhs, sign, expression);
    }
}
