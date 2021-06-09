package GUI;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
/**
 *
 * @author ylmz
 */
public class Filter {


    public BufferedImage MeanFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Color color;
        int filterBounds = 7, x, y, i, j, totalR = 0, totalG = 0, totalB = 0, meanR, meanG, meanB;
        for (x = (filterBounds - 1) / 2; x < width - (filterBounds - 1) / 2; x++) {
            for (y = (filterBounds - 1) / 2; y < height - (filterBounds - 1) / 2; y++) {
                totalR = 0;
                totalG = 0;
                totalB = 0;
                for (i = -((filterBounds - 1) / 2); i <= (filterBounds - 1) / 2; i++) {
                    for (j = -((filterBounds - 1) / 2); j <= (filterBounds - 1) / 2; j++) {
                        int p = image.getRGB(x + i, y + j);
                        int r = (p >> 16) & 0xff;
                        int g = (p >> 8) & 0xff;
                        int b = p & 0xff;
                        totalR = totalR + r;
                        totalG = totalG + g;
                        totalB = totalG + b;
                    }
                }
                meanR = totalR / (filterBounds * filterBounds);
                meanG = totalG / (filterBounds * filterBounds);
                meanB = totalB / (filterBounds * filterBounds);
                if (meanR > 255) {
                    meanR = 255;
                }
                if (meanG > 255) {
                    meanG = 255;
                }
                if (meanB > 255) {
                    meanB = 255;
                }

                color = new Color(meanR, meanG, meanB, 255);
                outputImage.setRGB(x, y, color.getRGB());
            }

        }
        return outputImage;
    }

    public BufferedImage SharpeningFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int[] filterMatrix = new int[]{-1, -1, -1, -1, 8, -1, -1, -1, -1};
        int filterBounds = 3, x, y, i, j, totalR, totalG, totalB, R, G, B, k = 0;

        for (x = (filterBounds - 1) / 2; x < width - (filterBounds - 1) / 2; x++) {
            for (y = (filterBounds - 1) / 2; y < height - (filterBounds - 1) / 2; y++) {
                totalR = 0;
                totalG = 0;
                totalB = 0;
                k = 0;
                for (i = -((filterBounds - 1) / 2); i <= (filterBounds - 1) / 2; i++) {
                    for (j = -((filterBounds - 1) / 2); j <= (filterBounds - 1) / 2; j++) {
                        int p = image.getRGB(x + i, y + j);
                        int r = (p >> 16) & 0xff;
                        int g = (p >> 8) & 0xff;
                        int b = p & 0xff;
                        totalR = totalR + (r * filterMatrix[k]);
                        totalG = totalG + (g * filterMatrix[k]);
                        totalB = totalB + (b * filterMatrix[k]);
                        R = totalR;
                        G = totalG;
                        B = totalB;

                        if (R > 255) {
                            R = 255;
                        }
                        if (G > 255) {
                            G = 255;
                        }
                        if (B > 255) {
                            B = 255;
                        }
                        if (R < 0) {
                            R = 0;
                        }
                        if (G < 0) {
                            G = 0;
                        }
                        if (B < 0) {
                            B = 0;
                        }

                        outputImage.setRGB(x, y, new Color(R, G, B, 255).getRGB());
                        k++;
                    }
                }

            }

        }
        return ImageConcatenation(image, outputImage);

    }

    public BufferedImage SobelFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Color color;
        int filterBounds = 3, x, y, i, j, totalR = 0, totalG = 0, totalB = 0, meanR, meanG, meanB;
        for (x = (filterBounds - 1) / 2; x < width - (filterBounds - 1) / 2; x++) {
            for (y = (filterBounds - 1) / 2; y < height - (filterBounds - 1) / 2; y++) {
                int p1, p2, p3, p4, p5, p6, p7, p8, p9;
                color = new Color(image.getRGB(x - 1, y - 1));
                p1 = color.getRed();

                color = new Color(image.getRGB(x, y - 1));
                p2 = color.getRed();

                color = new Color(image.getRGB(x + 1, y - 1));
                p3 = color.getRed();

                color = new Color(image.getRGB(x - 1, y));
                p4 = color.getRed();

                color = new Color(image.getRGB(x, y));
                p5 = color.getRed();

                color = new Color(image.getRGB(x + 1, y));
                p6 = color.getRed();

                color = new Color(image.getRGB(x - 1, y + 1));
                p7 = color.getRed();

                color = new Color(image.getRGB(x, y + 1));
                p8 = color.getRed();

                color = new Color(image.getRGB(x + 1, y + 1));
                p9 = color.getRed();

                int c = Math.abs((p1 + 2 * p2 + p3) - (p7 + 2 * p8 + p9)) + Math.abs((p3 + 2 * p6 + p9) - (p1 + 2 * p4 + p7));
                if (c > 255) {
                    c = 255;
                }
                outputImage.setRGB(x, y, new Color(c, c, c, 255).getRGB());
            }
            
        }
        return outputImage;
    }

    private BufferedImage ImageConcatenation(BufferedImage org, BufferedImage sharpened) {
        Color orgColor, sharpedColor;
        int R, G, B;
        int width = sharpened.getWidth();
        int height = sharpened.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                orgColor = new Color(org.getRGB(x, y));
                sharpedColor = new Color(sharpened.getRGB(x, y));
                R = orgColor.getRed() + sharpedColor.getRed();
                G = orgColor.getGreen() + sharpedColor.getGreen();
                B = orgColor.getBlue() + sharpedColor.getBlue();
                
                if (R > 255) {
                    R = 255;
                }
                if (G > 255) {
                    G = 255;
                }
                if (B > 255) {
                    B = 255;
                }
                if (R < 0) {
                    R = 0;
                }
                if (G < 0) {
                    G = 0;
                }
                if (B < 0) {
                    B = 0;
                }
                outputImage.setRGB(x, y, new Color(R, G, B, 255).getRGB());
            }
        }
        return outputImage;
        
    }
}
