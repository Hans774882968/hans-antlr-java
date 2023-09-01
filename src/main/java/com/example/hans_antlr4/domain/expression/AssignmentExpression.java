package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import java.util.Objects;

@Getter
public class AssignmentExpression extends Expression {
    private LocalVariable variable;
    private AssignmentSign sign;
    private Expression expression;

    public AssignmentExpression(LocalVariable variable, AssignmentSign sign, Expression expression) {
        // AssignmentExpression 的类型为 LHS 类型，计算时左右侧入栈顶并转为 max 类型，计算完毕后把 max 类型转为 LHS 类型再赋值
        super(variable.getType(), null, null);
        this.variable = variable;
        this.sign = sign;
        this.expression = expression;
    }

    public boolean notNecessaryToGenerateDupInstruction() {
        if (!isRootExpression()) {
            return false;
        }
        Statement statement = getBelongStatement();
        return statement instanceof ExpressionStatement;
    }

    public Type getLhsType() {
        return variable.getType();
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
                && Objects.equals(variable, assignmentExpression.variable)
                && Objects.equals(sign, assignmentExpression.sign)
                && Objects.equals(expression, assignmentExpression.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), variable, sign, expression);
    }
}
