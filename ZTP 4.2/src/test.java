
public class test {

	public static void main(String[] args) {

		Node root = new SubNode(new DivNode(new NumNode(4.f), new NumNode(2.f)), new MultNode(new NumNode(0.5f), new NumNode(7.f)));
		
		CalculatorVisitator calculator = new CalculatorVisitator();

		root.accept(calculator);
		System.out.println(calculator.stos.peek());
	}

}
