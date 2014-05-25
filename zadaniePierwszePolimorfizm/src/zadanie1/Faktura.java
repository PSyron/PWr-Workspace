
package zadanie1;

import java.util.Date;

public class Faktura extends Paragon {
    private String mName = "Faktura";
    private long mNIP;

    public Faktura(int kwota, String[] produkty, Date dataWystawienia, Object podpis, long nip) {
        super(kwota, produkty, dataWystawienia, podpis);
        mNIP = nip;
    }

    // overloading + ad hoc
    public void drukuj(Faktura f) {
        System.out.println("Faktura");
    }

    // overriding
    public void drukujName() {
        System.out.println(mName);
    }

    // inkluzyjny
    public Faktura getInstancje() {
        return this;
    }

}
