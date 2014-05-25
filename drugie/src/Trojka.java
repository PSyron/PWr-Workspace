/**
 * Created by rado on 3/19/14.
 */
public class Trojka extends Para
{
    protected int z;
    public Trojka(int x, int y, int z)
    {
        super(x, y);
        this.z = z;
    }

    public void setZ(int z) {this.z = z;}

    public String toString() { return super.toString()+" "+z; }
}
