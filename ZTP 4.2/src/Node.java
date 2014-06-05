
public abstract class Node {
	Node left;
	Node right;
	
	Node(Node left, Node right) {
		this.left=left;
		this.right=right;
	}
	
	public abstract void accept(Visitator v);

}
