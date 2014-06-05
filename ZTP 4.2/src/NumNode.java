
public class NumNode extends Node{

	Float val;
	NumNode(Float val){
		super(null, null);
		this.val=val;
	}
	public void accept(Visitator v) {
		v.Visit(this);		
	}

}
