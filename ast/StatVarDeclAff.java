package ast;
 import java.util.List;

public class StatVarDeclAff extends Statement{
	
	private Id id;
	private Type type;
	private Expression exp;

	public StatVarDeclAff(Position pos, Id id,Type t,Expression exp){
		this.position=pos;
		this.id=id;
		this.exp=exp;
		this.type=t;
	}

	public Id getId(){ return id;}
	public Type getType(){return type;}
	public Expression getExpression(){return exp;}

	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
			
	
