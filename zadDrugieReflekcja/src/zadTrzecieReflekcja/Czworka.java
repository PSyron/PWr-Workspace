
package zadTrzecieReflekcja;

public class Czworka extends Trojka {
    private int p;

    public Czworka(int x, int y, int z, int p) {
        super(x, y, z);
        this.p = p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public String toString() {
        return super.toString() + " " + p;
    }
}
