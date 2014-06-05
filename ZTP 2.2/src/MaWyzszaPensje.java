

public class MaWyzszaPensje implements Specification<Pracownik>{

	double pensja;
	
	public MaWyzszaPensje(double pensja){
		this.pensja = pensja;
	}
	
	@Override
	public boolean isSatisfiedBy(Pracownik t) {
		
		if(t!=null && t.pensja>pensja) return true;
		
		return false;
	}
}
