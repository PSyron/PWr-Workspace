
public class Pair implements Comparable<Pair>{
	KeyPoint keyPoint;
	float distance;
	
	public Pair (KeyPoint keyPoint, float distance) {
		this.keyPoint = keyPoint;
		this.distance = distance;
	}
	
	public KeyPoint getKeyPoint() {
		return keyPoint;
	}

	public int compareTo(Pair pair) {
		return Float.compare(this.distance, pair.distance);
	}
}
