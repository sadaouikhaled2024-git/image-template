package image;

public class BlankImageFactory implements ImageFactory {
  @Override
  public Image makeImage() {
    return new BlankImage(1000, 800);
  }
}
