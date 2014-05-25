
package zadanieTrzecieWzorce;

public class MagazynMotosportBuilder extends MagazynBuilder {

    @Override
    public void buildTytul() {
        magazyn.setTytul("Motosport");

    }

    @Override
    public void buildZawartosc() {
        magazyn.setZawartosc("Zawartosc magazynu Motosport");

    }

    @Override
    public void buildCena() {
        magazyn.setCena(6.90);

    }

}
