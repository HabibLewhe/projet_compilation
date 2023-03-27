package ast;
 public class StatFor extends Statement{

	private Expression condition;
	private Statement action;
	private Statement init;
	private Statement loop;

	public StatFor(Position pos, 
			Statement init,
			Expression condition, 
			Statement action,
			Statement loop){
		this.init=init;
		this.condition=condition;
		this.action=action;
		this.position=pos;
		this.loop=loop;
	}
	
	public Statement getInit(){ return init;}
	public Expression getCondition(){ return condition;}
	public Statement getAction(){ return action;}
	public Statement getLoop(){ return loop;}

	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
