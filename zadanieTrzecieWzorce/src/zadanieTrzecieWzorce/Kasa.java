
package zadanieTrzecieWzorce;

public class Kasa {
    private final int tableNumber;
    private final Ksiazka zamowionaKsiazka;

    Kasa(int tableNumber, Ksiazka ksiazka) {
        this.tableNumber = tableNumber;
        this.zamowionaKsiazka = ksiazka;
    }

    void serve() {
        System.out.println("Sprzedaje " + zamowionaKsiazka + " przy kasie nr. " + tableNumber);
    }
}
