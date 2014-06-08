import java.util.ArrayList;
import java.util.Collection;

public class Ransac {

	public AffineTransform runRansac(ImageRepresentation image, float r, float R, int numberOfIterations) {
		AffineTransform bestModel = null;
		float minError = Float.MAX_VALUE;
		for (int i = 0; i < numberOfIterations; i++) {
			Triangle triangle = chooseTriangle(image, r, R);
			if (triangle != null) {
                AffineTransform currentTransform = new AffineTransform(triangle);
                float currentError = calcError(currentTransform, image);
                if (currentError < minError) {
                    bestModel = currentTransform;
                    minError = currentError;
                }
            }
		}
		return bestModel;
	}

	private float calcError(AffineTransform currentTransform, ImageRepresentation image) {
		float error = 0f;
		for(KeyPoint keyPoint : image.getKeyPoints())
			error += Neighbourhood.checkDistance(currentTransform.transform(keyPoint), keyPoint.getNearestPoint());
		return error;
	}

	boolean passTest(float x1, float y1, float x2, float y2, float r, float R) {
		return r * r < (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) &&
                (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < R * R;
	}

	private Triangle chooseTriangle(ImageRepresentation image, float r, float R) {
		ArrayList<KeyPoint> copyKeyPoints = new ArrayList<KeyPoint>(image.getKeyPoints());
		KeyPoint p1 = image.getKeyPoints().get((int) (Math.random() * image.getKeyPoints().size()));
		removeFarPoints(copyKeyPoints, p1, null, r, R);
		if (copyKeyPoints.size() == 0)
			return null;

		KeyPoint p2 = copyKeyPoints.get((int) (Math.random() * copyKeyPoints.size()));
		removeFarPoints(copyKeyPoints, p1, p2, r, R);
		if (copyKeyPoints.size() == 0)
			return null;

        KeyPoint p3 = copyKeyPoints.get((int) (Math.random() * copyKeyPoints.size()));
		return new Triangle(p1, p2, p3);
	}

	private void removeFarPoints(ArrayList<KeyPoint> copyKeyPoints,
			KeyPoint p1, KeyPoint p2, float r, float R) {
		for (int i = copyKeyPoints.size() - 1; i >= 0; i--) {
			boolean pointMatchesZ1 =
                    passTest(
                        p1.getCoordinateX(),
                        p1.getCoordinateY(),
                        copyKeyPoints.get(i).getCoordinateX(),
                        copyKeyPoints.get(i).getCoordinateY(), r, R
                    );
			boolean obrazyMatchesZ1 =
                    passTest(
                        p1.getNearestPoint().getCoordinateX(),
                        p1.getNearestPoint().getCoordinateY(),
                        copyKeyPoints.get(i).getNearestPoint().getCoordinateX(),
                        copyKeyPoints.get(i).getNearestPoint().getCoordinateY(),r, R
                    );
			boolean pointMatchesZ2 = p2 == null ||
                    passTest(
                        p2.getCoordinateX(),
                        p2.getCoordinateY(),
                        copyKeyPoints.get(i).getCoordinateX(),
                        copyKeyPoints.get(i).getCoordinateY(), r, R
                    );
			boolean obrazyMatchesZ2 = p2 == null ||
                    passTest(
                        p2.getNearestPoint().getCoordinateX(),
                        p2.getNearestPoint().getCoordinateY(),
						copyKeyPoints.get(i).getNearestPoint().getCoordinateX(),
                        copyKeyPoints.get(i).getNearestPoint().getCoordinateY(), r, R
                    );

			if (!pointMatchesZ1 || !obrazyMatchesZ1 || !pointMatchesZ2 || !obrazyMatchesZ2 || copyKeyPoints.get(i) == p1 || copyKeyPoints.get(i) == p2)
				copyKeyPoints.remove(i);
		}
	}
}
