
package zadTrzecieReflekcja;

import java.lang.reflect.Array;

public class Zadanie2A<T> {
    Class<T> reference;

    Zadanie2A(Class<T> classRef) {
        reference = classRef;
    }

    public T getNewInstanceOfT() {
        try {
            return reference.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public T[] getArrayOfT(int size) {
        T[] array = (T[]) Array.newInstance(reference, size);
        return array;
    }
}
