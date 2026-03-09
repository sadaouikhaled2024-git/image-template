package image;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {
    private Color[][] pixels;

    /**
     * Constructs an image of the specified size with all pixels of the specified color.
     *
     * @param color the color for all pixels
     * @param width the width of the image
     * @param height the height of the image
     */
    public BruteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    /**
     * Constructs an image from a matrix of colors.
     * The first index corresponds to the x coordinate and the second to the y coordinate.
     *
     * @param colors the matrix of colors
     */
    public BruteRasterImage(Color[][] colors) {
        super(colors);
    }

    /**
     * Allocates the matrix representing the image.
     */
    @Override
    public void createRepresentation() {
        this.pixels = new Color[getWidth()][getHeight()];
    }

    /**
     * Sets the color of a specific pixel.
     *
     * @param color the color to set
     * @param x the x coordinate
     * @param y the y coordinate
     */
    @Override
    public void setPixelColor(Color color, int x, int y) {
        pixels[x][y] = color;
    }

    /**
     * Returns the color of a pixel.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the color of the pixel
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    /**
     * Sets all pixels to the specified color.
     *
     * @param color the color to set for all pixels
     */
    @Override
    protected void setPixelsColor(Color color) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                pixels[x][y] = color;
            }
        }
    }
}
