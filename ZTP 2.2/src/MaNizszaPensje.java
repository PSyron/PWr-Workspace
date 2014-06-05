

public class MaNizszaPensje implements Specification<Pracownik>{

	double pensja;
	
	public MaNizszaPensje(double pensja){
		this.pensja = pensja;
	}
	
	@Override
	public boolean isSatisfiedBy(Pracownik t) {
		
		return (t!=null && t.pensja<pensja);
	}
}
