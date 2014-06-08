public class AffineTransform  {
    private double[][] matrix;

    public AffineTransform(Triangle triangle) {
        this.matrix = new double[3][3];
        double normaliser =
            (triangle.getP2().getCoordinateX() - triangle.getP1().getCoordinateX()) * triangle.getP3().getCoordinateY() +
            (triangle.getP1().getCoordinateX() - triangle.getP3().getCoordinateX()) * triangle.getP2().getCoordinateY() +
            (triangle.getP3().getCoordinateX() - triangle.getP2().getCoordinateX()) * triangle.getP1().getCoordinateY();

        this.matrix[0][0] =
            (triangle.getP2().getNearestPoint().getCoordinateX() - triangle.getP1().getNearestPoint().getCoordinateX()) * triangle.getP3().getCoordinateY() +
            (triangle.getP1().getNearestPoint().getCoordinateX() - triangle.getP3().getNearestPoint().getCoordinateX()) * triangle.getP2().getCoordinateY() +
            (triangle.getP3().getNearestPoint().getCoordinateX() - triangle.getP2().getNearestPoint().getCoordinateX()) * triangle.getP1().getCoordinateY();
        this.matrix[0][0] /= normaliser;

        this.matrix[0][1] =
            (triangle.getP1().getNearestPoint().getCoordinateX() - triangle.getP2().getNearestPoint().getCoordinateX()) * triangle.getP3().getCoordinateX() +
            (triangle.getP3().getNearestPoint().getCoordinateX() - triangle.getP1().getNearestPoint().getCoordinateX()) * triangle.getP2().getCoordinateX() +
            (triangle.getP2().getNearestPoint().getCoordinateX() - triangle.getP3().getNearestPoint().getCoordinateX()) * triangle.getP1().getCoordinateX();
        this.matrix[0][1] /= normaliser;

        this.matrix[0][2] =
            (triangle.getP1().getNearestPoint().getCoordinateX() * triangle.getP2().getCoordinateX() - triangle.getP2().getNearestPoint().getCoordinateX() * triangle.getP1().getCoordinateX()) * triangle.getP3().getCoordinateY() +
            (triangle.getP3().getNearestPoint().getCoordinateX() * triangle.getP1().getCoordinateX() - triangle.getP1().getNearestPoint().getCoordinateX() * triangle.getP3().getCoordinateX()) * triangle.getP2().getCoordinateY() +
            (triangle.getP2().getNearestPoint().getCoordinateX() * triangle.getP3().getCoordinateX() - triangle.getP3().getNearestPoint().getCoordinateX() * triangle.getP2().getCoordinateX()) * triangle.getP1().getCoordinateY();
        this.matrix[0][2] /= normaliser;

        this.matrix[1][0] =
            (triangle.getP2().getNearestPoint().getCoordinateY() - triangle.getP1().getNearestPoint().getCoordinateY()) * triangle.getP3().getCoordinateY() +
            (triangle.getP1().getNearestPoint().getCoordinateY() - triangle.getP3().getNearestPoint().getCoordinateY()) * triangle.getP2().getCoordinateY() +
            (triangle.getP3().getNearestPoint().getCoordinateY() - triangle.getP2().getNearestPoint().getCoordinateY()) * triangle.getP1().getCoordinateY();
        this.matrix[1][0] /= normaliser;

        this.matrix[1][1] =
            (triangle.getP1().getNearestPoint().getCoordinateY() - triangle.getP2().getNearestPoint().getCoordinateY()) * triangle.getP3().getCoordinateX() +
            (triangle.getP3().getNearestPoint().getCoordinateY() - triangle.getP1().getNearestPoint().getCoordinateY()) * triangle.getP2().getCoordinateX() +
            (triangle.getP2().getNearestPoint().getCoordinateY() - triangle.getP3().getNearestPoint().getCoordinateY()) * triangle.getP1().getCoordinateX();
        this.matrix[1][1] /= normaliser;

        this.matrix[1][2] =
            (triangle.getP1().getNearestPoint().getCoordinateY() * triangle.getP2().getCoordinateX() - triangle.getP2().getNearestPoint().getCoordinateY() * triangle.getP1().getCoordinateX()) * triangle.getP3().getCoordinateY() +
            (triangle.getP3().getNearestPoint().getCoordinateY() * triangle.getP1().getCoordinateX() - triangle.getP1().getNearestPoint().getCoordinateY() * triangle.getP3().getCoordinateX()) * triangle.getP2().getCoordinateY() +
            (triangle.getP2().getNearestPoint().getCoordinateY() * triangle.getP3().getCoordinateX() - triangle.getP3().getNearestPoint().getCoordinateY() * triangle.getP2().getCoordinateX()) * triangle.getP1().getCoordinateY();
        this.matrix[1][2] /= normaliser;
    }

    public KeyPoint transform(KeyPoint keyPoint)
    {
        KeyPoint projectPoint = new KeyPoint();
        projectPoint.setCoordinateX((float) (this.matrix[0][1] * keyPoint.getCoordinateY() + this.matrix[0][0] * keyPoint.getCoordinateX() + this.matrix[0][2]));
        projectPoint.setCoordinateY((float) (this.matrix[1][1] * keyPoint.getCoordinateY() + this.matrix[1][0] * keyPoint.getCoordinateX() + this.matrix[1][2]));
        return projectPoint;
    }
}