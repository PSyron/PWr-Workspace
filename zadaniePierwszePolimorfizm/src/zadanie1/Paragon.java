
package zadanie1;

import java.util.Date;

public class Paragon {

    private int mKwota;
    private String[] mProdukty;
    private Date mDataWystawienia;
    private String mName = "Paragon";
    private Object mPodpis;

    public Paragon(int kwota, String[] produkty, Date dataWystawienia, Object podpis) {
        this.mKwota = kwota;
        this.mProdukty = produkty;
        this.mDataWystawienia = dataWystawienia;
        this.mPodpis = podpis;
    }

    public void drukuj(Paragon p) {
        System.out.println("Paragon");
    }

    public void drukujName() {
        System.out.println(mName);
    }

    public int getKwota() {
        return mKwota;
    }

    <TYP extends Paragon> TYP getInstancje(TYP o) {
        return o;
    }

    public String[] getProdukty() {
        return mProdukty;
    }

    public Date getDataWyst() {
        return mDataWystawienia;
    }
}
