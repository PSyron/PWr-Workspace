
package zadanieTrzecieWzorce;

public class Magazyn {

    String tytul = "";
    private String zawartosc = "";
    private double cena = 0;

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setZawartosc(String zawartosc) {
        this.zawartosc = zawartosc;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return this.cena;
    }

    public String getTytul() {
        return this.tytul;

    }

    public String getZawartosc() {
        return zawartosc;
    }

    public String toString() {
        return tytul + " - " + zawartosc + " kosztuje " + cena;
    }

}
