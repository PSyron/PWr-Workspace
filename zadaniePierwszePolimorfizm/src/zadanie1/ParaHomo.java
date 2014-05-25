
package zadanie1;

public class ParaHomo<ONLY> extends Para<ONLY, ONLY> {

    protected ONLY lonely;

    public ParaHomo(ONLY p, ONLY second) {
        super(p, second);
        lonely = p;

    }

    public ONLY getOnly() {
        return lonely;
    };

    public String toString() {
        return "(" + lonely + ", " + second + ")";
    }
}
