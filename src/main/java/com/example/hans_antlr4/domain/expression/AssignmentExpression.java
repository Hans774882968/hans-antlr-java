package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.UnsupportedAssignmentTypeException;

import lombok.Getter;
import java.util.Objects;

@Getter
public class AssignmentExpression extends Expression {
    private String varName;
    private AssignmentSign sign;
    private Expression expression;

    public AssignmentExpression(String varName, AssignmentSign sign, Expression expression) {
        super(expression.getType(), null, null);
        this.varName = varName;
        this.sign = sign;
        this.expression = expression;
        if (sign != AssignmentSign.ASSIGN && expression.getType() != BuiltInType.INT) {
            throw new UnsupportedAssignmentTypeException(expression.getType());
        }
    }

    public boolean notNecessaryToGenerateDupInstruction() {
        if (!isRootExpression()) {
            return false;
        }
        Statement statement = getBelongStatement();
        return statement instanceof ExpressionStatement;
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
                && Objects.equals(varName, assignmentExpression.varName)
                && Objects.equals(sign, assignmentExpression.sign)
                && Objects.equals(expression, assignmentExpression.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), varName, sign, expression);
    }
}
