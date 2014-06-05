import java.util.Stack;


public class CalculatorVisitator implements Visitator {

	Stack<Float> stos;
	
	CalculatorVisitator(){
		stos = new Stack<Float>();
	}
	
	@Override
	public void Visit(SumNode sum) {
		sum.right.accept(this);
		sum.left.accept(this);
		Float temp = stos.pop()+stos.pop();
		System.out.println("Putting "+temp);
		stos.push(temp);
	}

	@Override
	public void Visit(SubNode sub) {
		sub.right.accept(this);
		sub.left.accept(this);
		Float temp = stos.pop()-stos.pop();
		System.out.println("Putting "+temp);
		stos.push(temp);	}

	@Override
	public void Visit(MultNode mult) {
		mult.right.accept(this);
		mult.left.accept(this);
		Float temp = stos.pop()*stos.pop();
		System.out.println("Putting "+temp);
		stos.push(temp);	}

	@Override
	public void Visit(DivNode div) {
		div.right.accept(this);
		div.left.accept(this);
		Float temp = stos.pop()/stos.pop();
		System.out.println("Putting "+temp);
		stos.push(temp);	}

	@Override
	public void Visit(NumNode num) {
		System.out.println("Putting num"+num.val);
		stos.push(num.val);
	}

}
