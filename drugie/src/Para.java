/**
 * Created by rado on 3/19/14.
 */
public class Para
{
    protected int x = 0, y = 0;
    public Para(){}
    public Para(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public String toString() { return x+" "+y; }
}
