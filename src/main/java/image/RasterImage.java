package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image {
    private int width;
    private int height;

    /**
     * Constructs an image of the specified size with all pixels of the specified color.
     *
     * @param color the color for all pixels
     * @param width the width of the image
     * @param height the height of the image
     */
    public RasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    /**
     * Constructs an image from a matrix of colors.
     * The first index corresponds to the x coordinate and the second to the y coordinate.
     *
     * @param pixels the matrix of colors
     */
    public RasterImage(Color[][] pixels) {
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        
        this.width = Matrices.getRowCount(pixels);
        this.height = Matrices.getColumnCount(pixels);
        createRepresentation();
        setPixelsColor(pixels);
    }

    /**
     * Allocates the internal representation of the image.
     */
    public abstract void createRepresentation();

    /**
     * Sets the color of a specific pixel.
     *
     * @param color the color to set
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public abstract void setPixelColor(Color color, int x, int y);

    /**
     * Returns the color of a pixel.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the color of the pixel
     */
    @Override
    public abstract Color getPixelColor(int x, int y);

    /**
     * Updates the pixel colors using the values from the given matrix.
     *
     * @param pixels the matrix of colors
     */
    protected void setPixelsColor(Color[][] pixels) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    /**
     * Sets all pixels to the specified color.
     *
     * @param color the color to set for all pixels
     */
    protected abstract void setPixelsColor(Color color);

    /**
     * Returns the width of the image.
     *
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the image.
     *
     * @return the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Sets the width of the image.
     *
     * @param width the width to set
     */
    protected void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height of the image.
     *
     * @param height the height to set
     */
    protected void setHeight(int height) {
        this.height = height;
    }
}
