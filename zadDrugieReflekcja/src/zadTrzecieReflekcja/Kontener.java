
package zadTrzecieReflekcja;

import java.util.ArrayList;

public class Kontener<T extends Para> {

    private ArrayList<T> zawartosc;

    public Kontener() {
        zawartosc = new ArrayList<T>();
    }

    public ArrayList<T> getZawartosc() {
        return zawartosc;
    }

    public void addElement(T element) {
        zawartosc.add(element);
    }

}
