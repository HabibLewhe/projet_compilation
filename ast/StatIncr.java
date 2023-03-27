package ast;
 public class StatIncr extends Statement{

	private Id id;

	public StatIncr(Position pos, Id i){
		this.id=i;
		this.position=pos;
	}
	public Id getId(){ return id;}

	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
