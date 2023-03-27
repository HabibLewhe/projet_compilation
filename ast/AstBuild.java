package ast;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.*;
import parser.*;
import parser.tlParser.*;
import ast.*;



public class AstBuild extends parser.tlBaseVisitor<Node> implements parser.tlVisitor<Node> {

	private static Position position(ParserRuleContext ctx){
		return new Position(ctx.start.getLine(),ctx.start.getCharPositionInLine());
	}


	@Override public Node visitProgram(tlParser.ProgramContext ctx) {
		List<MethodDeclContext> listMetCont = ctx.methodDecl();
		List<MethodDecl> metList=new ArrayList<MethodDecl>();
		for(MethodDeclContext md : listMetCont){
			metList.add((MethodDecl)visit(md));
		}

		return new Program(position(ctx),metList);
	}
	@Override public Node visitStatAff(tlParser.StatAffContext ctx){
		Id id=new Id(position(ctx),ctx.Id().getText());
		Expression e = (Expression)visit(ctx.exp());
		return new StatAff(position(ctx),id,e);
	}

	@Override public Node visitStatVarDecl(tlParser.StatVarDeclContext ctx){
		Type t=(Type) visit(ctx.type());
		Id id=new Id(position(ctx),ctx.Id().getText());
		return new StatVarDecl(position(ctx),id,t);
	}

	@Override public Node visitStatReturn(tlParser.StatReturnContext ctx){
		Expression e = (Expression)visit(ctx.exp());
		return new StatReturn(position(ctx),e);
	}
	@Override public Node visitStatIncr(tlParser.StatIncrContext ctx){
		Id i=new Id(position(ctx),ctx.Id().getText());
		return new StatIncr(position(ctx),i);
	}
	
	@Override public Node visitStatVarDeclAff(tlParser.StatVarDeclAffContext ctx){
		Expression e = (Expression)visit(ctx.exp());
		Id id=new Id(position(ctx),ctx.Id().getText());
		Type type=(Type)visit(ctx.type());

		return new StatVarDeclAff(position(ctx),id,type,e);
	}


	@Override public Node visitMethodDecl(tlParser.MethodDeclContext ctx) { 
		Type type =(Type) visit(ctx.type());
		Id id = new Id(position(ctx),ctx.Id().getText());
		StatementContext statContext =(ctx.statement());
		Statement statement=(Statement)visit(statContext);
		Block block=new Block(position(ctx),statement);
		
		List<FormalContext> formalContextList = ctx.formal();
		List<Formal> formalList = new ArrayList<Formal>();
		for(FormalContext fc : formalContextList){
			Formal f = (Formal)visit(fc);
			formalList.add(f);
		}

		return new MethodDecl(position(ctx),type,id,formalList,block);


	}
	@Override public Node visitFormal(tlParser.FormalContext ctx) { 
		Type type = (Type)visit(ctx.type());
		Id id = new Id(position(ctx),ctx.Id().getText());

		return new Formal(position(ctx), type, id);
	}

	@Override public Node visitBoolType(tlParser.BoolTypeContext ctx){
		return new TypePrim(position(ctx),TypePrim.Prim.BOOL);
	}

	@Override public Node visitIntType(tlParser.IntTypeContext ctx){
		return new TypePrim(position(ctx),TypePrim.Prim.INT);
	}
	
	@Override public Node visitStatList(tlParser.StatListContext ctx) { 
		List<StatementContext> listStat = ctx.statement();
		List<Statement> statList= new ArrayList<Statement>();
		for(StatementContext stat : listStat){
			statList.add((Statement)visit(stat));
		}
		return new StatList(position(ctx), statList);
				
	}

	@Override public Node visitStatIf(tlParser.StatIfContext ctx) { 
		Expression exp = (Expression)visit(ctx.exp());
		Statement test = (Statement)visit(ctx.statement(0));
		Block bTest=new Block(position(ctx),test);
		Statement statElse = (Statement)visit(ctx.statement(1));
		Block bElse=new Block(position(ctx),statElse);
		
		return new StatIf(position(ctx),exp,bTest,bElse);	
	}

		
	@Override public Node visitStatWhile(tlParser.StatWhileContext ctx) { 
		Expression exp =(Expression) visit(ctx.exp());
		Statement stat = (Statement)visit (ctx.statement());
		Block b=new Block(position(ctx),stat);
		return new StatWhile(position(ctx),exp,b);
	}
	@Override public Node visitStatFor(tlParser.StatForContext ctx){
		Expression cond=(Expression)visit(ctx.exp());
		Statement init = (Statement)visit(ctx.statement(0));
		Statement action = (Statement)visit(ctx.statement(1));
		Statement loop = (Statement)visit(ctx.statement(2));
		return new StatFor(position(ctx),init,cond,action,loop);
	}


	@Override public Node visitStatPrint(tlParser.StatPrintContext ctx) { 
		Expression exp = (Expression)visit(ctx.exp());
		return new StatPrint(position(ctx),exp);
	}

	/**
	 * EXPRESSIONS
	 * */
	@Override public Node visitExId(tlParser.ExIdContext ctx) { 
		return new ExpId(position(ctx),ctx.Id().getText());
	}
	@Override public Node visitExFalse(tlParser.ExFalseContext ctx) { 
		return new ExpCons(position(ctx),Constant.FALSE);
	}
	@Override public Node visitExTrue(tlParser.ExTrueContext ctx) { 
		return new ExpCons(position(ctx),Constant.TRUE);
	}

	@Override public Node visitExParenthesis(tlParser.ExParenthesisContext ctx) { 
		return visit(ctx.exp());
       	}
	@Override public Node visitExCall(tlParser.ExCallContext ctx) {
		Id method = new Id(position(ctx),ctx.Id().getText());
		List<Expression> args = new ArrayList<>();
		for(ExpContext ec : ctx.exp()){
			args.add((Expression)visit(ec));
		}

		return new ExpCallMethod(position(ctx),method,args); 
	}
	@Override public Node visitExInt(tlParser.ExIntContext ctx) {
		return new ExpInt(position(ctx), Integer.parseInt(ctx.Int().getText())); 
	}
	@Override public Node visitExUnop(tlParser.ExUnopContext ctx) { 
		Expression exp=(Expression)visit(ctx.exp());
		String unop=ctx.Unop().getSymbol().getText();
		UnOp op = switch(unop){
			case "!" -> UnOp.NOT;
			default -> throw new IllegalStateException("Unexpected value");
		};
		return new ExpUn(position(ctx), exp, op);
	}
	@Override public Node visitExBinop(tlParser.ExBinopContext ctx) {
		Expression exp1=(Expression)visit(ctx.exp(0));
		Expression exp2=(Expression)visit(ctx.exp(1));
		String binop = ctx.Binop().getSymbol().getText();
		BinOp op = switch(binop){
			case "+" -> BinOp.ADD;
			case "-" -> BinOp.MIN;
			case "*" -> BinOp.MULT;
			case "<" -> BinOp.LT;
			case "&&" -> BinOp.AND;
			case "==" -> BinOp.EQ;
			default -> throw new IllegalStateException("Unexpected value");
		};
		return new ExpBin(position(ctx), exp1,op,exp2);
	}



}
