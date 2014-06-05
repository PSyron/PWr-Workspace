
public interface Visitator {
void Visit(SumNode sum);
void Visit(SubNode sub);
void Visit(MultNode mult);
void Visit(DivNode div);
void Visit(NumNode num);
}
