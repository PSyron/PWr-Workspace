
public class MultNode extends Node{

	
	MultNode(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public void accept(Visitator v) {
		v.Visit(this);		
	}

}
