package image;

import javafx.scene.paint.Color;

public interface Image {
    Color getPixelColor(int x, int y);
    int getWidth();
    int getHeight();
}
