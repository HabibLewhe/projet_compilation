package parser;
 // Generated from antlr/tl.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tlParser}.
 */
public interface tlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tlParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(tlParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link tlParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(tlParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link tlParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(tlParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link tlParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(tlParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link tlParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(tlParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link tlParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(tlParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link tlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(tlParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link tlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(tlParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link tlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(tlParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link tlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(tlParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statList}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatList(tlParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statList}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatList(tlParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatIf(tlParser.StatIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatIf(tlParser.StatIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatWhile(tlParser.StatWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatWhile(tlParser.StatWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statFor}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatFor(tlParser.StatForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statFor}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatFor(tlParser.StatForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statPrint}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatPrint(tlParser.StatPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statPrint}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatPrint(tlParser.StatPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAff}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatAff(tlParser.StatAffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAff}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatAff(tlParser.StatAffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statIncr}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatIncr(tlParser.StatIncrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statIncr}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatIncr(tlParser.StatIncrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatReturn(tlParser.StatReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatReturn(tlParser.StatReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statVarDeclAff}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatVarDeclAff(tlParser.StatVarDeclAffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statVarDeclAff}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatVarDeclAff(tlParser.StatVarDeclAffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statVarDecl}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatVarDecl(tlParser.StatVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statVarDecl}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatVarDecl(tlParser.StatVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exUnop}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExUnop(tlParser.ExUnopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exUnop}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExUnop(tlParser.ExUnopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exId}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExId(tlParser.ExIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exId}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExId(tlParser.ExIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exFalse}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExFalse(tlParser.ExFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exFalse}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExFalse(tlParser.ExFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exCall}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExCall(tlParser.ExCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exCall}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExCall(tlParser.ExCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exParenthesis}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExParenthesis(tlParser.ExParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exParenthesis}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExParenthesis(tlParser.ExParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exInt}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExInt(tlParser.ExIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exInt}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExInt(tlParser.ExIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exBinop}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExBinop(tlParser.ExBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exBinop}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExBinop(tlParser.ExBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exTrue}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExTrue(tlParser.ExTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exTrue}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExTrue(tlParser.ExTrueContext ctx);
}