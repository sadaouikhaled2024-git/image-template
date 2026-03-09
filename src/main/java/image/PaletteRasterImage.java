package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {
    private List<Color> palette;
    private int[][] indexesOfColors;

    /**
     * Constructs an image of the specified size with all pixels of the specified color.
     *
     * @param color the color for all pixels
     * @param width the width of the image
     * @param height the height of the image
     */
    public PaletteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    /**
     * Constructs an image from a matrix of colors.
     * The first index corresponds to the x coordinate and the second to the y coordinate.
     *
     * @param pixels the matrix of colors
     */
    public PaletteRasterImage(Color[][] pixels) {
        super(pixels);
    }

    /**
     * Allocates the palette list and the matrix representing the image.
     */
    @Override
    public void createRepresentation() {
        this.palette = new ArrayList<>();
        this.indexesOfColors = new int[getWidth()][getHeight()];
    }

    /**
     * Sets the color of a specific pixel.
     * Adds the color to the palette if it's not already present.
     *
     * @param color the color to set
     * @param x the x coordinate
     * @param y the y coordinate
     */
    @Override
    public void setPixelColor(Color color, int x, int y) {
        int colorIndex = palette.indexOf(color);
        if (colorIndex == -1) {
            palette.add(color);
            colorIndex = palette.size() - 1;
        }
        indexesOfColors[x][y] = colorIndex;
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
        return palette.get(indexesOfColors[x][y]);
    }

    /**
     * Sets all pixels to the specified color.
     *
     * @param color the color to set for all pixels
     */
    @Override
    protected void setPixelsColor(Color color) {
        palette.add(color);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                indexesOfColors[x][y] = 0;
            }
        }
    }
}
