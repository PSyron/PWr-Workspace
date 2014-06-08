public class Triangle {

    private KeyPoint keyPoint1;
    private KeyPoint keyPoint2;
    private KeyPoint keyPoint3;

    public Triangle(KeyPoint keyPoint1, KeyPoint keyPoint2, KeyPoint keyPoint3) {
        this.keyPoint1 = keyPoint1;
        this.keyPoint2 = keyPoint2;
        this.keyPoint3 = keyPoint3;
    }

    public KeyPoint getP1() {
        return keyPoint1;
    }
    public KeyPoint getP2() {
        return keyPoint2;
    }
    public KeyPoint getP3() {
        return keyPoint3;
    }
}