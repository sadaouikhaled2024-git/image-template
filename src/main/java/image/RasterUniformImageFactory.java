package image;

import javafx.scene.paint.Color;

public class RasterUniformImageFactory implements ImageFactory {
    private final int width;
    private final int height;
    private final Color color;
    private final RasterImageType rasterImageType;

    public RasterUniformImageFactory(int width, int height, Color color, RasterImageType rasterImageType) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.rasterImageType = rasterImageType;
    }

    @Override
    public Image makeImage() {
        switch (rasterImageType) {
            case BRUTE:
                return new BruteRasterImage(color, width, height);
            case PALETTE:
                return new PaletteRasterImage(color, width, height);
            case SPARSE:
                return new SparseRasterImage(color, width, height);
            default:
                throw new NotSupportedException("Image type not supported: " + rasterImageType);
        }
    }
}
