package GUI;


import java.awt.image.BufferedImage;
/**
 *
 * @author ylmz
 */
public class Preprocess {

    public BufferedImage RGBtoGray(BufferedImage image) {
     
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                outputImage.setRGB(x, y, p);
            }
        }
        return outputImage;
    }



}
