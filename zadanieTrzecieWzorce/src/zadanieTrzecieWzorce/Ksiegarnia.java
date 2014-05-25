
package zadanieTrzecieWzorce;

import java.util.ArrayList;
import java.util.List;

public class Ksiegarnia {
    private final List<Kasa> zamowienia = new ArrayList<Kasa>();
    private final Oferta oferta = new Oferta();

    void takeOrder(String ksiazeczka, int table) {
        Ksiazka ksiazka = oferta.lookup(ksiazeczka);
        Kasa zamowienie = new Kasa(table, ksiazka);
        zamowienia.add(zamowienie);
    }

    void service() {
        for (Kasa zamowienie : zamowienia)
            zamowienie.serve();
    }

    String report() {
        return "\nilosc powstalych obiektow typu ksiazka: " + oferta.iloscZrobionychKsiazek();
    }

    public static void main(String[] args) {

        System.out.println("-- WAGA PIÓRKOWA -- flyweight");
        System.out.println();
        Ksiegarnia ksiegarnia = new Ksiegarnia();

        ksiegarnia.takeOrder("Harry Potter", 2);
        ksiegarnia.takeOrder("Wladca Pierscieni", 1);
        ksiegarnia.takeOrder("Pachnidlo", 1);
        ksiegarnia.takeOrder("Wladca Pierscieni", 897);
        ksiegarnia.takeOrder("Harry Potter", 97);
        ksiegarnia.takeOrder("Wladca Pierscieni", 3);
        ksiegarnia.takeOrder("Pachnidlo", 3);
        ksiegarnia.takeOrder("Harry Potter", 3);
        ksiegarnia.takeOrder("Pachnidlo", 96);
        ksiegarnia.takeOrder("Wladca Pierscieni", 552);
        ksiegarnia.takeOrder("Harry Potter", 1);
        ksiegarnia.takeOrder("Pachnidlo", 2);

        ksiegarnia.service();
        System.out.println(ksiegarnia.report());

        System.out.println();

        System.out.println("-- BUDOWNICZY -- builder");
        System.out.println();

        Pracownik pracownik = new Pracownik();
        MagazynBuilder motosport = new MagazynMotosportBuilder();
        MagazynBuilder programTv = new MagazynProgramTvBuilder();

        System.out.println("Zamowienie na magazyn motosport");
        pracownik.setMagazynBuilder(motosport);
        pracownik.constructMagazyn();

        Magazyn magazyn = pracownik.getMagazyn();

        System.out.println(magazyn.toString());

        System.out.println("Zamowienie na magazyn program TV");
        pracownik.setMagazynBuilder(programTv);
        pracownik.constructMagazyn();

        magazyn = pracownik.getMagazyn();

        System.out.println(magazyn.toString());

    }
}
