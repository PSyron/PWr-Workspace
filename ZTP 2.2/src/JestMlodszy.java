

public class JestMlodszy implements Specification<Pracownik>{

	int wiek;
	
	public JestMlodszy(int wiek){
		this.wiek = wiek;
	}
	
	@Override
	public boolean isSatisfiedBy(Pracownik t) {
		
		if(t!=null && t.wiek<wiek) return true;
		
		return false;
	}
}