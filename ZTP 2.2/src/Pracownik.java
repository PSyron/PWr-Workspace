
public class Pracownik extends Osoba {
	int liczbaSprzedazy;
	double pensja;
	int wiek;
	int wzieteDniUrlopu;

	public void bierzeUrlop(int dni) {
		this.wzieteDniUrlopu += dni;
	}

	public Pracownik(String imie, String nazwisko, long pesel) {
		super(imie, nazwisko, pesel);
		wzieteDniUrlopu = 0;
	}

	public Pracownik(String imie, String nazwisko, long pesel, double pensja,
			int wiek) {
		super(imie, nazwisko, pesel);
		this.pensja = pensja;
		this.wiek = wiek;
		wzieteDniUrlopu = 0;
	}

	public String toString() {
		return "Pracownik: " + imie + " " + nazwisko + " pesel: " + pesel;
	}

	public void setWiek(int w) {
		wiek = w;
	}

	public void setLiczbaSprzedazy(int liczbaSprzedazy) {
		this.liczbaSprzedazy = liczbaSprzedazy;
	}

	public void setPensja(double p) {
		pensja = p;
	}

}