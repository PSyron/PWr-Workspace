
public class DivNode extends Node{

	
	DivNode(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public void accept(Visitator v) {
		v.Visit(this);		
	}

}
