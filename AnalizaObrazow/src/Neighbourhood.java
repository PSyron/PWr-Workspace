import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class Neighbourhood {
	
	public void calculateNearestPoints(ImageRepresentation image1, ImageRepresentation image2)
	{		
		for (KeyPoint keyPoint: image1.getKeyPoints())
			findNearestPoint(keyPoint, image2.getKeyPoints());

		for (KeyPoint keyPoint : image2.getKeyPoints())
			findNearestPointBack(keyPoint, image1.getKeyPoints());

		carryPointsWithoutNeighbours(image1, image2);
	}
	
	public float getDistance(KeyPoint keyPoint1, KeyPoint keyPoint2) {
		float distance = 0;
		for (int i = 0; i < keyPoint1.getProperties().length; i++)
			distance +=
                    (keyPoint1.getProperties()[i] - keyPoint2.getProperties()[i]) *
                    (keyPoint1.getProperties()[i] - keyPoint2.getProperties()[i]);
		
		return distance;
	}

    public void findNearestPoint(KeyPoint mainKeyPoint, ArrayList<KeyPoint> listOfKeyPoints)
    {
        KeyPoint foundPoint;
        HashMap<KeyPoint, Float> distances = new HashMap<KeyPoint, Float>();

        for(KeyPoint keyPoint2 : listOfKeyPoints)
            distances.put(keyPoint2, getDistance(mainKeyPoint, keyPoint2));

        float minDistance = Collections.min(distances.values());
        for(KeyPoint keyPoint : distances.keySet())
            if (minDistance == distances.get(keyPoint)) {
                foundPoint = keyPoint;
                mainKeyPoint.setNearestPoint(foundPoint);
            }
    }

    public void findNearestPointBack(KeyPoint mainKeyPoint, ArrayList<KeyPoint> listOfKeyPoints)
    {
        KeyPoint foundPoint;
        HashMap<KeyPoint, Float> distances = new HashMap<KeyPoint, Float>();

        for(KeyPoint keyPoint : listOfKeyPoints)
            distances.put(keyPoint, getDistance(mainKeyPoint, keyPoint));

        float minDistance = Collections.min(distances.values());

        for(KeyPoint keyPoint : distances.keySet()) {
            if (minDistance == distances.get(keyPoint)) {
                foundPoint = keyPoint;
                if (foundPoint.getNearestPoint()==mainKeyPoint)
                    mainKeyPoint.setNearestPoint(foundPoint);
            }
        }
    }

	public void carryPointsWithoutNeighbours(ImageRepresentation image1, ImageRepresentation image2) {
		for(KeyPoint keyPoint : image1.getKeyPoints()) {
			if(keyPoint.getNearestPoint().getNearestPoint() != keyPoint) {
                keyPoint.setNearestPoint(null);
			}
		}

        this.removeAlone(image1);
        this.removeAlone(image2);
	}
	
	public void removeAlone(ImageRepresentation image) {
		for (int i = image.getKeyPoints().size() - 1; i >= 0; i--)
			if (image.getKeyPoints().get(i).getNearestPoint() == null)
                image.getKeyPoints().remove(i);
	}

    public void analyseCohesion(ImageRepresentation image1, ImageRepresentation image2, int numberOfNeighbours, float cohesionLevel) {
        for (KeyPoint keyPoint : image1.getKeyPoints()) {
            ArrayList<Pair> distanceArray = new ArrayList<Pair>();
            ArrayList<Pair> neighbourArray = new ArrayList<Pair>();

            calculateDistances(keyPoint, image1, distanceArray);
            findNeighbours(distanceArray, numberOfNeighbours);

            calculateDistances(keyPoint.getNearestPoint(), image2, neighbourArray);
            findNeighbours(neighbourArray, numberOfNeighbours);

            if ((float)(checkCohesion(distanceArray, neighbourArray))/numberOfNeighbours < cohesionLevel)
                keyPoint.setNearestPoint(null);
        }

        for (int i = image1.getKeyPoints().size() - 1; i >= 0; i--)
            if (image1.getKeyPoints().get(i).getNearestPoint() == null)
                image1.getKeyPoints().remove(i);

        for (int i = image2.getKeyPoints().size() - 1; i >= 0; i--)
            if (image2.getKeyPoints().get(i).getNearestPoint() == null)
                image2.getKeyPoints().remove(i);
    }

    public int checkCohesion(ArrayList<Pair> distanceArray, ArrayList<Pair> neighbourArray) {
        int count = 0;
        for (Pair pair1 : distanceArray)
            for (Pair pair2 : neighbourArray)
                if (pair1.getKeyPoint().getNearestPoint() == pair2.getKeyPoint())
                    count++;
        return count;
    }

    public void calculateDistances(KeyPoint keyPoint, ImageRepresentation image1, ArrayList<Pair> distanceArray) {
        for (KeyPoint image1KeyPoint : image1.getKeyPoints())
            if (image1KeyPoint != keyPoint)
                distanceArray.add(new Pair(image1KeyPoint, checkDistance(keyPoint, image1KeyPoint)));
    }

    public static float checkDistance(KeyPoint keyPoint1, KeyPoint keyPoint2) {
        float diffX = keyPoint1.getCoordinateX() - keyPoint2.getCoordinateX();
        float diffY = keyPoint1.getCoordinateY() - keyPoint2.getCoordinateY();
        return diffX * diffX + diffY * diffY;
    }

    public void findNeighbours(ArrayList<Pair> distanceArray, int numberOfNeighbours) {
        Collections.sort(distanceArray);
        for (int i = distanceArray.size() - 1; i > numberOfNeighbours-1; i--)
            distanceArray.remove(i);
    }
}
