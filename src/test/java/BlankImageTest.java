import image.BlankImage;
import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BlankImageTest {
  @Test
  public void testBlankImageGetWidth(){
    BlankImage blankImage = new BlankImage(200, 300);
    assertThat(blankImage.getWidth()).isEqualTo(200);
  }

  @Test
  public void testBlankImageGetHeight(){
    BlankImage blankImage = new BlankImage(200, 300);
    assertThat(blankImage.getHeight()).isEqualTo(300);
  }

  @Test
  public void testBlankImageGetPixelColor(){
    BlankImage blankImage = new BlankImage(200, 300);
    assertThat(blankImage.getPixelColor(0,0)).isEqualTo(Color.WHITE);
    assertThat(blankImage.getPixelColor(100,100)).isEqualTo(Color.WHITE);
    assertThat(blankImage.getPixelColor(199,299)).isEqualTo(Color.WHITE);
  }

}
