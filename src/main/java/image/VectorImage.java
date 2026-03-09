package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image {
    private final List<Shape> shapes;
    private int width;
    private int height;

    /**
     * Constructs an image of the specified size with the given shapes.
     *
     * @param shapes the list of shapes
     * @param width the width of the image
     * @param height the height of the image
     */
    public VectorImage(List<Shape> shapes, int width, int height) {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the color of a pixel.
     * The color is the color of the first shape in the list that contains the point,
     * or white if the point is not contained in any shape.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the color of the pixel
     */
    @Override
    public Color getPixelColor(int x, int y) {
        Point point = new Point(x, y);
        for (Shape shape : shapes) {
            if (shape.contains(point)) {
                return shape.getColor();
            }
        }
        return Color.WHITE;
    }

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
