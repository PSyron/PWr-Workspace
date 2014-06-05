
public class SubNode extends Node{

	
	SubNode(Node left, Node right) {
		super(left, right);
	}

	public void accept(Visitator v) {
		v.Visit(this);		
	}

}
