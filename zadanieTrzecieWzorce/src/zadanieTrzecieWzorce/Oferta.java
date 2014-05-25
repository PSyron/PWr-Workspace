
package zadanieTrzecieWzorce;

import java.util.HashMap;
import java.util.Map;

public class Oferta {
    private Map<String, Ksiazka> ksiazki = new HashMap<String, Ksiazka>();

    Ksiazka lookup(String tytulKsiazki) {
        if (!ksiazki.containsKey(tytulKsiazki))
            ksiazki.put(tytulKsiazki, new Ksiazka(tytulKsiazki));
        return ksiazki.get(tytulKsiazki);
    }

    int iloscZrobionychKsiazek() {
        return ksiazki.size();
    }
}
