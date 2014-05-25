
package zadanieTrzecieWzorce;

public class Ksiazka {
    private String name;

    Ksiazka(String newBook) {
        this.name = newBook;
    }

    @Override
    public String toString() {
        return name;
    }
}
