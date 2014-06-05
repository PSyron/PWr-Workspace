
public class WykorzystujeUrlop implements Specification<Pracownik> {

	int dni;
	
	public WykorzystujeUrlop(int dni){
		this.dni = dni;
	}
	
	@Override
	public boolean isSatisfiedBy(Pracownik t) {
		return t.wzieteDniUrlopu>=dni;
	}

}
