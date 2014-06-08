import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ImageRepresentation {
	private ArrayList<KeyPoint> keyPoints = new ArrayList<KeyPoint>();
	private String imageRepresentationFilePath;
	private Image image;
	
	public ImageRepresentation(String imageRepresentationFilePath) {
		this.imageRepresentationFilePath = imageRepresentationFilePath;
	}
	
	public Image getImage() {
		return this.image;
	}
	public ArrayList<KeyPoint> getKeyPoints() {
		return this.keyPoints;
	}

    public void readImage(Image image) {
        this.image = image;
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        try {
            Scanner scanner = new Scanner(new File(this.imageRepresentationFilePath));
            int numberOfKeyPoints = 0;

            for (int i = 0; i < 2; i++)
                numberOfKeyPoints = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numberOfKeyPoints; i++) {
                String[] properties = scanner.nextLine().split(" ");

                KeyPoint keyPoint = new KeyPoint();
                keyPoint.setCoordinateX((Float.parseFloat(properties[0]))/width);
                keyPoint.setCoordinateY((Float.parseFloat(properties[1]))/height);

                for (int j = 5; j < properties.length-5; j++)
                    keyPoint.addProperty(Integer.parseInt(properties[j]));

                this.keyPoints.add(keyPoint);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
