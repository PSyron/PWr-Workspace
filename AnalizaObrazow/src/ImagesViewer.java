import javax.swing.*;
import java.awt.*;

public class ImagesViewer extends JFrame {

	public ImagesViewer(ImageRepresentation image1, ImageRepresentation image2, String title) {
		DrawPanel dpnl = new DrawPanel(image1, image2);
		add(dpnl);

		setSize(1000, 600);
		setTitle(title);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


    class DrawPanel extends JPanel {

        ImageRepresentation image1;
        ImageRepresentation image2;
        Color colorTransp = new Color(1, 0, 0, 127); // Red

        public DrawPanel(ImageRepresentation image1, ImageRepresentation image2) {
            this.image1 = image1;
            this.image2 = image2;

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Dimension size = getSize();
            float w = size.width;
            float h = size.height;

            float wCoeffIm1 = w / (2 * image1.getImage().getWidth(null));
            float hCoeffIm1 = h / image1.getImage().getHeight(null);
            float resizeIm1 = wCoeffIm1 < hCoeffIm1 ? wCoeffIm1 : hCoeffIm1;

            float wCoeffIm2 = w / (2 * image2.getImage().getWidth(null));
            float hCoeffIm2 = h / image2.getImage().getHeight(null);
            float resizeIm2 = wCoeffIm2 < hCoeffIm2 ? wCoeffIm2 : hCoeffIm2;

            g2d.drawImage(image1.getImage(), 0, 0, (int) (resizeIm1 * image1
                    .getImage().getWidth(null)), (int) (resizeIm1 * image1
                    .getImage().getHeight(null)), Color.WHITE, null);

            g2d.drawImage(image2.getImage(), (int) (w / 2 + (w / 2 - resizeIm2 * image2.getImage().getWidth(null))), 0,
                    (int) (resizeIm2 * image2.getImage().getWidth(null)),
                    (int) (resizeIm2 * image2.getImage().getHeight(null)),
                    Color.WHITE, null);

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(2));
            for (KeyPoint point : image1.getKeyPoints()) {
                g2d.setColor(new Color((int) (Math.random() * 255), (int) (Math
                        .random() * 255), (int) (Math.random() * 255), 180));

                g2d.drawLine(
                        (int) (point.getCoordinateX() * resizeIm1 * image1
                                .getImage().getWidth(null)),
                        (int) (point.getCoordinateY() * resizeIm1 * image1
                                .getImage().getHeight(null)),
                        (int) (w / 2 + point.getNearestPoint().getCoordinateX()
                                * resizeIm2 * image2.getImage().getWidth(null)),
                        (int) (point.getNearestPoint().getCoordinateY() * resizeIm2 * image2
                                .getImage().getHeight(null)));

            }

        }
    }
}