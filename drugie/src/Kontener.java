import java.util.ArrayList;

/**
 * Created by rado on 3/19/14.
 */
public class Kontener<T extends Para>
{
    protected ArrayList<T> zawartosc;

    public Kontener() {zawartosc = new ArrayList<T>();}

    public ArrayList<T> getZawartosc() {return zawartosc;}

    public void addElement(T element) {zawartosc.add(element);}
}
