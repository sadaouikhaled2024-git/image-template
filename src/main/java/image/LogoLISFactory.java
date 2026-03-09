package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LogoLISFactory implements ImageFactory {
    
    @Override
    public Image makeImage() {
        List<Shape> shapes = new ArrayList<>();
        
        // Create the LIS logo using rectangles
        // Background
        shapes.add(new Rectangle(0, 0, 800, 600, Color.WHITE));
        
        // Large blue rectangle (background for LIS)
        shapes.add(new Rectangle(100, 100, 600, 400, Color.BLUE));
        
        // L letter (in white)
        shapes.add(new Rectangle(150, 150, 80, 300, Color.WHITE));
        shapes.add(new Rectangle(150, 400, 150, 50, Color.WHITE));
        
        // I letter (in white)
        shapes.add(new Rectangle(350, 150, 80, 300, Color.WHITE));
        
        // S letter (in white) - simplified as rectangles
        shapes.add(new Rectangle(480, 150, 170, 80, Color.WHITE));
        shapes.add(new Rectangle(480, 150, 80, 150, Color.WHITE));
        shapes.add(new Rectangle(480, 260, 170, 80, Color.WHITE));
        shapes.add(new Rectangle(570, 300, 80, 150, Color.WHITE));
        shapes.add(new Rectangle(480, 400, 170, 50, Color.WHITE));
        
        return new VectorImage(shapes, 800, 600);
    }
}
