
package zadanieTrzecieWzorce;

public class Pracownik {
    private MagazynBuilder MagazynBuilder;

    public void setMagazynBuilder(MagazynBuilder pb) {
        MagazynBuilder = pb;
    }

    public Magazyn getMagazyn() {
        return MagazynBuilder.getMagazyn();
    }

    public void constructMagazyn() {
        MagazynBuilder.createNewMagazynProduct();
        MagazynBuilder.buildTytul();
        MagazynBuilder.buildZawartosc();
        MagazynBuilder.buildCena();
    }
}
