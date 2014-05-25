
package zadanie1;

public class Para<FIRST, SECOND> {

    protected FIRST first;
    protected SECOND second;

    public Para(FIRST p, SECOND f) {
        first = p;
        second = f;
    }

    public FIRST getParagon() {
        return first;
    };

    public SECOND getFaktura() {
        return second;
    };

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
