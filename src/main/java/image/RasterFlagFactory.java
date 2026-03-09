package image;

import javafx.scene.paint.Color;

public class RasterFlagFactory implements ImageFactory {
    private final int width;
    private final int height;
    private final Color leftColor;
    private final Color centerColor;
    private final Color rightColor;
    private final RasterImageType rasterImageType;

    public RasterFlagFactory(int width, int height, Color leftColor, Color centerColor, Color rightColor, RasterImageType rasterImageType) {
        this.width = width;
        this.height = height;
        this.leftColor = leftColor;
        this.centerColor = centerColor;
        this.rightColor = rightColor;
        this.rasterImageType = rasterImageType;
    }

    @Override
    public Image makeImage() {
        Color[][] colors = new Color[width][height];
        
        int thirdWidth = width / 3;
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x < thirdWidth) {
                    colors[x][y] = leftColor;
                } else if (x < 2 * thirdWidth) {
                    colors[x][y] = centerColor;
                } else {
                    colors[x][y] = rightColor;
                }
            }
        }
        
        switch (rasterImageType) {
            case BRUTE:
                return new BruteRasterImage(colors);
            case PALETTE:
                return new PaletteRasterImage(colors);
            case SPARSE:
                return new SparseRasterImage(colors);
            default:
                throw new NotSupportedException("Image type not supported: " + rasterImageType);
        }
    }
}
