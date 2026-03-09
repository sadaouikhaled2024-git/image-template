package image;

import javafx.scene.paint.Color;

public class BlankImage implements Image{
  private final int width;
  private final int height;

  public BlankImage(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    return Color.WHITE;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }
}
