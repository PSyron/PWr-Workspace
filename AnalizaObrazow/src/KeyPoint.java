
public class KeyPoint {
	private int[] properties= new int[128];
    private int lastProperty = 0;
	private float coordinateX;
	private float coordinateY;
	private KeyPoint nearestPoint;

	public KeyPoint getNearestPoint() {
		return this.nearestPoint;
	}
	public void setNearestPoint(KeyPoint nearestPoint) {
		this.nearestPoint = nearestPoint;
	}
	public int[] getProperties() {
		return this.properties;
	}
    public void addProperty(int property) { this.properties[this.lastProperty] = property; this.lastProperty++; }
	public float getCoordinateX() {
		return this.coordinateX;
	}
	public void setCoordinateX(float CoordinateX) {
		this.coordinateX = CoordinateX;
	}
	public float getCoordinateY() {
		return this.coordinateY;
	}
	public void setCoordinateY(float CoordinateY) {
		this.coordinateY = CoordinateY;
	}
}
