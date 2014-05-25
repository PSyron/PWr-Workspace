
package zadanieTrzecieWzorce;

public class MagazynProgramTvBuilder extends MagazynBuilder {
    @Override
    public void buildTytul() {
        magazyn.setTytul("Program TV");

    }

    @Override
    public void buildZawartosc() {
        magazyn.setZawartosc("Program TV na nadchodzacy tydzien");

    }

    @Override
    public void buildCena() {
        magazyn.setCena(8.90);

    }
}
