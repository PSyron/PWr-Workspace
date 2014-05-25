
package zadanie1;

import java.util.Date;

public class Main {

    static String[] produkty = {
            "mleko", "chipsy", "ogorki", "maslo"
    };

    public static void main(String args[]) {
        Paragon p = new Paragon(20, produkty, new Date(), "coœ");
        Faktura f = new Faktura(20, produkty, new Date(), "coœ", 91391931);

        double something = 5.4 + 3;
        System.out
                .println("--Ad hoc -- Koercja-- rzutowanie typów \n(double + int)  5.4 + 3=(double) "
                        + something);
        System.out.println();

        System.out.println("--Ad hoc -- Overloading-- ");
        System.out.print("p.drukuj(p) = ");
        p.drukuj(p);
        System.out.print("p.drukuj(f) = ");
        p.drukuj(f);
        System.out.print("f.drukuj(p) = ");
        f.drukuj(p);
        System.out.print("f.drukuj(f) = ");
        f.drukuj(f);
        System.out.println();

        System.out
                .println("--Overriding(inkluzyjny,dziedziczenie)-- wywo³anie metody drukujName na obu obiektach!");
        p.drukujName();
        f.drukujName();
        System.out.println();

        System.out
                .println("--Polimorfizm Typów -- Poli. parametryczny -- tablica parametryczna tab[0] Int , tab[1] Float");
        ParaHomo<?>[] tab = new ParaHomo<?>[5];
        tab[0] = new ParaHomo<Integer>(1, 2);
        tab[1] = new ParaHomo<Float>(2.2f, 3.5f);
        System.out.println(tab[0]);
        System.out.println(tab[1]);
        System.out.println();

        System.out
                .println("-- Polimorfizm Typów -- Poli. ograniczony --  <TYP extends Paragon> TYP getInstancje(TYP o)  = typ zwracany musi rozszerzac Paragon");
        System.out.println("p.getInstancje(p) " + p.getInstancje(p));
        System.out.println("p.getInstancje(f) " + p.getInstancje(f));

    }

}
