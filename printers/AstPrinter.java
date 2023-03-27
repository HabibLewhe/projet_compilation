package printers;
import java.util.List;
import ast.*;

public class AstPrinter extends ast.BaseVisitor<Void>{
	private int indent;
	public void indent(){
		System.out.println();
		for(int i=0; i<indent;i++){
			System.out.print("   ");
		}
	}
		
	public void end(){
		System.out.print(";");
	}

	public AstPrinter(){
		super(null);
		indent=0;
	}

	public Void visit(Id i){
		System.out.print(i.getName());
		return null;
	}

	public Void visit(StatVarDecl v){
		indent();
		v.getType().accept(this);
		System.out.print(" ");
		v.getId().accept(this);end();
		return null;
	}
	public Void visit(StatPrint sp){
		indent();
		System.out.print("print(");
		sp.getExpression().accept(this);
		System.out.print(")");end();
		return null;
	}
	public Void visit(ExpBin e){
		Expression eg=e.getLeftExp();
		Expression ed=e.getRightExp();
		BinOp op=e.getOp();
		System.out.print("(");eg.accept(this);
		System.out.print(" "+op.toString()+" ");
		ed.accept(this);
		System.out.print(")");
		return null;
	}
	public Void visit(ExpCallMethod e){
		e.getMethod().accept(this);
		System.out.print("(");
		List<Expression> l=e.getArgs();
		for(int i=0;i<l.size();i++){
			l.get(i).accept(this);
			if(i<l.size()-1){
				System.out.print(",");
			}
		}

		System.out.print(")");
		return null;
	}
	public Void visit(ExpInt e){
		System.out.print(e.getValue());
		return null;
	}

	public Void visit(ExpId i){
		System.out.print(i.getValue());
		return null;
	}
	public Void visit(ExpCons e){
		System.out.print(e.getConstant().toString());
		return null;
	}
	
	public Void visit(MethodDecl m){
		indent();
		m.getType().accept(this);
		System.out.print(" ");
		m.getId().accept(this);
		System.out.print("(");
		Formal f;
		for(int i=0; i<m.getFormal().size();i++){
			f=m.getFormal().get(i);
			f.accept(this);
			if(i<m.getFormal().size()-1){
				System.out.print(",");
			}
		}
		System.out.print(")");
		m.getBlock().accept(this);
		return null;
	}

	public Void visit(StatReturn s){
		indent();
		System.out.print("return "); s.getExpression().accept(this);
		end();
		return null;
	}
	public Void visit(StatIncr s){
		indent();
		s.getId().accept(this);System.out.print(" ++;");
		return null;
	}	
	public Void visit(ExpUn e){
		System.out.print(e.getOp().toString());
		e.getExp().accept(this);
		return null;
	}
	public Void visit(TypePrim t){
		System.out.print(t.getName());
		return null;
	}
	
	public Void visit(Formal f){
		f.getType().accept(this);
		System.out.print(" ");
		f.getId().accept(this);
		return null;
	}
	public Void visit(StatAff a){
		indent();
		a.getId().accept(this);
		System.out.print("=");
		a.getExpression().accept(this);
		end();
		return null;
	}
	public Void visit(StatVarDeclAff s){
		indent();
		s.getType().accept(this); System.out.print(" ");
		s.getId().accept(this);
		System.out.print("=");
		s.getExpression().accept(this);
		System.out.print(";");
		return null;
	}

	public Void visit(StatList sl){
		List<Statement> l=sl.getStatList();
		System.out.print("{");
		indent++;
		for(Statement s : l){
			s.accept(this);
		}
		indent--;
		indent();System.out.print("}");


		return null;
	}

	public Void visit(StatIf a){
		Expression e = a.getExpression();
		Block ib = a.getIfBlock();
		Block eb= a.getElseBlock();
		indent();
		System.out.print("if(");e.accept(this);	System.out.print(")");
		ib.accept(this);
		indent();System.out.print("else");
		eb.accept(this);

		return null;
	}
	public Void visit(StatWhile s){
		Expression e= s.getExpression();
		Block b = s.getBlock();
		indent();
		System.out.print("while(");e.accept(this);System.out.print(")");
		b.accept(this);
		return null;
	}
	public Void visit(Block b){
		b.getStatement().accept(this);
		return null;
	}
	public Void visit(StatFor s){
		Expression cond=s.getCondition();
		Statement init=s.getInit();
		Statement loop=s.getLoop();
		Statement action=s.getAction();
		
		indent();
		System.out.print("for(");
		init.accept(this);
		System.out.print(";");
		cond.accept(this);
		System.out.print(";");
		action.accept(this);
		System.out.print(")");
		loop.accept(this);
		return null;
	}



}
