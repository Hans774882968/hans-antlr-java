// Generated from src\main\java\com\example\hans_antlr4\HansAntlr.g by ANTLR 4.13.0

package com.example.hans_antlr4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.HansAntlrParser.ValueContext;
import com.example.hans_antlr4.bytecode_gen.instructions.Instruction;
import com.example.hans_antlr4.bytecode_gen.instructions.PrintVariable;
import com.example.hans_antlr4.bytecode_gen.instructions.VariableDeclaration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("CheckReturnValue")
public class HansAntlrBaseListener implements HansAntlrListener {
	private Map<String, Variable> variables = new HashMap<>();
	private Queue<Instruction> instructionsQueue = new ArrayDeque<>();

	public Queue<Instruction> getInstructionsQueue() {
		return instructionsQueue;
	}

	@Override
	public void enterCompilationUnit(HansAntlrParser.CompilationUnitContext ctx) {
	}

	@Override
	public void exitCompilationUnit(HansAntlrParser.CompilationUnitContext ctx) {
	}

	@Override
	public void enterVariable(HansAntlrParser.VariableContext ctx) {
	}

	@Override
	public void exitVariable(HansAntlrParser.VariableContext ctx) {
		final TerminalNode varName = ctx.ID();
		final ValueContext varValue = ctx.value();
		if (varValue == null) {
			return;
		}
		final int varType = varValue.getStart().getType();
		final int varIndex = variables.size();
		final String varTextValue = varValue.getText();
		final Variable variable = new Variable(varIndex, varType, varName.getText(), varTextValue);
		variables.put(varName.getText(), variable);
		instructionsQueue.add(new VariableDeclaration(variable));
		logVariableDeclarationStatementFound(varName, variable);
	}

	@Override
	public void enterPrint(HansAntlrParser.PrintContext ctx) {
	}

	@Override
	public void exitPrint(HansAntlrParser.PrintContext ctx) {
		final TerminalNode varName = ctx.ID();
		if (varName == null) {
			return;
		}
		if (!variables.containsKey(varName.getText())) {
			log.error("ERROR: You are trying to print var '{}' which has not been declared!", varName.getText());
			return;
		}
		final Variable variable = variables.get(varName.getText());
		instructionsQueue.add(new PrintVariable(variable));
		logPrintStatementFound(varName, variable);
	}

	private void logVariableDeclarationStatementFound(TerminalNode varName, Variable variable) {
		final int line = varName.getSymbol().getLine();
		log.info("OK: Define variable '{}' with type '{}' and value '{}' at line {}",
				variable.getName(), variable.getVarType(), variable.getVarTextValue(), line);
	}

	private void logPrintStatementFound(TerminalNode varName, Variable variable) {
		final int line = varName.getSymbol().getLine();
		final String format = "OK: You instructed to print variable '{}' which has type '{}' value of '{}' at line {}";
		log.info(format, variable.getVarIndex(), variable.getVarType(), variable.getVarTextValue(), line);
	}

	@Override
	public void enterValue(HansAntlrParser.ValueContext ctx) {
	}

	@Override
	public void exitValue(HansAntlrParser.ValueContext ctx) {
	}

	// 下面4个方法是每个 .g 文件都会生成的，其他方法则是为 CFG 的每个非终结符生成的
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
	}
}