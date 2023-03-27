package parser;
 // Generated from antlr/tl.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(tlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link tlParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(tlParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link tlParser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(tlParser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link tlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(tlParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link tlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(tlParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statList}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(tlParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIf(tlParser.StatIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatWhile(tlParser.StatWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statFor}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatFor(tlParser.StatForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statPrint}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatPrint(tlParser.StatPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAff}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAff(tlParser.StatAffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statIncr}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIncr(tlParser.StatIncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatReturn(tlParser.StatReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statVarDeclAff}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatVarDeclAff(tlParser.StatVarDeclAffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statVarDecl}
	 * labeled alternative in {@link tlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatVarDecl(tlParser.StatVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exUnop}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExUnop(tlParser.ExUnopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exId}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExId(tlParser.ExIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exFalse}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExFalse(tlParser.ExFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exCall}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExCall(tlParser.ExCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exParenthesis}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExParenthesis(tlParser.ExParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exInt}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExInt(tlParser.ExIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exBinop}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExBinop(tlParser.ExBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exTrue}
	 * labeled alternative in {@link tlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExTrue(tlParser.ExTrueContext ctx);
}