/**
 * Created by rado on 3/19/14.
 */
public class Czworka extends Trojka
{
    protected int p;
    public Czworka(int x, int y, int z, int p)
    {
        super(x, y, z);
        this.p = p;
    }

    public void setP(int p) {this.p = p;}

    public String toString() { return super.toString()+" "+p; }
}
