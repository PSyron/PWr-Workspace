package ztp3drugie;

import java.io.Serializable;

public class Osoba implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7836657316066074824L;
	private String imie;
	private String nazwisko;
	private double pensja = 1800;

	private Piesel object;

	public Osoba(String imie, String nazwisko, double pensja) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pensja = pensja;
		setObject(new Piesel(imie + " " + nazwisko, true));
	}

	@Override
	public Object clone() {
		return new Osoba(this.imie, this.nazwisko, this.pensja);
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public double getPensja() {
		return pensja;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setPensja(double pensja) {
		this.pensja = pensja;
	}

	public String toString() {
		return "Imie: " + imie + " Nazwisko: " + nazwisko + " Pensja: "
				+ pensja;
	}

	public Piesel getObject() {
		return object;
	}

	public void setObject(Piesel object) {
		this.object = object;
	}

}