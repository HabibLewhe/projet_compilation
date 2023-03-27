package ast;
public abstract class Type extends Node{
	protected String id;
	public String getName(){
		return id;
	}
	public boolean equals(Type t){
		return t.getName().equals(this.id);
	}

	public abstract Type copy();


}
