
/**
 * Created by rado on 3/19/14.
 */
public class Display {
    public static void main(String[] args) {
        //        zadanie2A();
        zadanie2B();
    }

    private static void zadanie2A() {
        System.out.println("ZADANIE 2 A");
        Zadanie2A<Para> zadanie2a = new Zadanie2A<Para>(Para.class);
        Para para = zadanie2a.getNewInstanceOfT();
        para.setX(10);
        para.setY(15);
        Kontener<Para> kontener = new Kontener<Para>();
        kontener.addElement(para);
        pokazPary(kontener);

        System.out.println("");

        Para[] pary = zadanie2a.getArrayOfT(5);
        for (int i = 0; i < pary.length; i++) {
            pary[i] = new Para(i, i + pary.length);
            System.out.println(pary[i].toString());
        }

    }

    private static void zadanie2B() {
        Kontener<Para> pary = new Kontener<Para>();
        Kontener<Trojka> trojki = new Kontener<Trojka>();
        Kontener<Czworka> czworki = new Kontener<Czworka>();

        // pięć par
        for (int i = 0; i < 10; i += 2)
            pary.addElement(new Para(i, i + 1));

        // trzy trójki
        for (int i = 10; i < 18; i += 3)
            trojki.addElement(new Trojka(i, i + 1, i + 2));

        // dwie czwórki
        for (int i = 20; i < 27; i += 4)
            czworki.addElement(new Czworka(i, i + 1, i + 2, i + 3));

        pokazPary(pary);
        pokazPary(trojki);
        pokazPary(czworki);

        //        pokazTrojki(pary);
        pokazTrojki(trojki);
        pokazTrojki(czworki);

        //        pokazCzworki(pary);
        //        pokazCzworki(trojki);
        pokazCzworki(czworki);
    }

    private static void pokazPary(Kontener<? extends Para> kontener) {
        System.out.println("POKAŻ PARY");
        for (Para para : kontener.getZawartosc())
            System.out.println(para.toString());
    }

    private static void pokazTrojki(Kontener<? extends Trojka> kontener) {
        System.out.println("POKAŻ TRÓJKI");
        for (Trojka trojka : kontener.getZawartosc())
            System.out.println(trojka.toString());
    }

    private static void pokazCzworki(Kontener<? extends Czworka> kontener) {
        System.out.println("POKAŻ CZWÓRKI");
        for (Czworka czworka : kontener.getZawartosc())
            System.out.println(czworka.toString());
    }
}
