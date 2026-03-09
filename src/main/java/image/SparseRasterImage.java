package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage {
    private Map<Point, Color> pixelsMap;

    /**
     * Constructs an image of the specified size with all pixels of the specified color.
     *
     * @param color the color for all pixels
     * @param width the width of the image
     * @param height the height of the image
     */
    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    /**
     * Constructs an image from a matrix of colors.
     * The first index corresponds to the x coordinate and the second to the y coordinate.
     *
     * @param pixels the matrix of colors
     */
    public SparseRasterImage(Color[][] pixels) {
        super(pixels);
    }

    /**
     * Creates the HashMap to store the association between points and colors.
     */
    @Override
    public void createRepresentation() {
        this.pixelsMap = new HashMap<>();
    }

    /**
     * Sets the color of a specific pixel.
     * Associates the point at coordinates (x, y) with the color.
     *
     * @param color the color to set
     * @param x the x coordinate
     * @param y the y coordinate
     */
    @Override
    public void setPixelColor(Color color, int x, int y) {
        Point point = new Point(x, y);
        if (color.equals(Color.WHITE)) {
            // Remove white pixels from the map to save space
            pixelsMap.remove(point);
        } else {
            pixelsMap.put(point, color);
        }
    }

    /**
     * Returns the color of a pixel.
     * Returns WHITE if the pixel is not in the map.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the color of the pixel
     */
    @Override
    public Color getPixelColor(int x, int y) {
        Point point = new Point(x, y);
        return pixelsMap.getOrDefault(point, Color.WHITE);
    }

    /**
     * Sets all pixels to the specified color.
     *
     * @param color the color to set for all pixels
     */
    @Override
    protected void setPixelsColor(Color color) {
        pixelsMap.clear();
        if (!color.equals(Color.WHITE)) {
            // Only store non-white pixels
            for (int x = 0; x < getWidth(); x++) {
                for (int y = 0; y < getHeight(); y++) {
                    pixelsMap.put(new Point(x, y), color);
                }
            }
        }
    }
}
