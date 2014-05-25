
package zadanieTrzecieWzorce;

public abstract class MagazynBuilder {
    protected Magazyn magazyn;

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void createNewMagazynProduct() {
        magazyn = new Magazyn();
    }

    public abstract void buildTytul();

    public abstract void buildZawartosc();

    public abstract void buildCena();
}
