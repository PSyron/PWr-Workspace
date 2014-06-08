import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) throws IOException {
		args = new String[] { "9", "10" };
		if (args.length < 2) {
			args = new String[] { "1", "2" };
		}
		Image image1 = ImageIO.read(new File(args[0] + ".png"));
		Image image2 = ImageIO.read(new File(args[1] + ".png"));

		int numberOfNeighbours = 1;
		float cohesionLevel = 1f;

		int numberOfIterations = 5000;
		float transformError = 0.3f, distanceBetweenPoints = 3f;

		final ImageRepresentation imageRepresentation1 = new ImageRepresentation(
				args[0] + ".sift");
		final ImageRepresentation imageRepresentation2 = new ImageRepresentation(
				args[1] + ".sift");
		imageRepresentation1.readImage(image1);
		imageRepresentation2.readImage(image2);

		Neighbourhood neighbourhood = new Neighbourhood();
		neighbourhood.calculateNearestPoints(imageRepresentation1,
				imageRepresentation2);

		neighbourhood.analyseCohesion(imageRepresentation1,
				imageRepresentation2, numberOfNeighbours, cohesionLevel);

		ransac(imageRepresentation1, transformError, distanceBetweenPoints,
				numberOfIterations);

		showImages(imageRepresentation1, imageRepresentation2, "Crucial points");
	}

	private static void showImages(final ImageRepresentation image1,
			final ImageRepresentation image2, final String title) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImagesViewer imagesViewer = new ImagesViewer(image1, image2,
						title);
				imagesViewer.setVisible(true);
			}
		});
	}

	private static void ransac(ImageRepresentation image, float r, float R,
			int numberOfIterations) {
		Ransac ransac = new Ransac();
		AffineTransform bestModel = ransac.runRansac(image, r, R,
				numberOfIterations);

		float diff = 0.001f;
		for (KeyPoint keyPoint : image.getKeyPoints())
			if (Neighbourhood.checkDistance(bestModel.transform(keyPoint),
					keyPoint.getNearestPoint()) > diff) {
				keyPoint.getNearestPoint().setNearestPoint(null);
				keyPoint.setNearestPoint(null);
			}

		for (int i = image.getKeyPoints().size() - 1; i >= 0; i--)
			if (image.getKeyPoints().get(i).getNearestPoint() == null)
				image.getKeyPoints().remove(i);
	}
}
