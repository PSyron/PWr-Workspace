

public abstract class Osoba {
	String imie, nazwisko;
	long pesel;
	
	protected Osoba(String imie, String nazwisko, long pesel){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
	}
	
	public abstract String toString();
}
