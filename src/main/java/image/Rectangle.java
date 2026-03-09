package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;

    /**
     * Constructs a rectangle with the top-left corner at (x, y) with the specified width, height, and color.
     *
     * @param x the x coordinate of the top-left corner
     * @param y the y coordinate of the top-left corner
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param color the color of the rectangle
     */
    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Tests if a specified Point is inside the boundary of the Rectangle.
     *
     * @param point the point to test
     * @return true if the point is inside the rectangle and false otherwise
     */
    @Override
    public boolean contains(Point point) {
        return point.x >= x && point.x < x + width &&
               point.y >= y && point.y < y + height;
    }

    /**
     * Returns the color of the interior of the Rectangle.
     *
     * @return the color of the rectangle
     */
    @Override
    public Color getColor() {
        return color;
    }
}
