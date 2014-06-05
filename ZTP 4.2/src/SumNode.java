
public class SumNode extends Node{
	SumNode(Node left, Node right) {
		super(left, right);
	}

	public void accept(Visitator v) {
		v.Visit(this);
	}

}
