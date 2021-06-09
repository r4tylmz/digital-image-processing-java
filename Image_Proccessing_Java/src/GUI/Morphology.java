package GUI;


import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author ylmz
 */
public class Morphology {

    public BufferedImage Dilate(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        int filterBounds = 3, x, y, i, j;
        int[][] imageMatrix = new int[width][height];
        int[][] kernel = new int[filterBounds][filterBounds];
        for (int k = 0; k < filterBounds; k++) {
            for (int l = 0; l < filterBounds; l++) {
                kernel[k][l] = 255;
            }
        }

        for (x = 0; x < width; x++) {
            for (y = 0; y < height; y++) {
                int p = image.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                if (r == 255) {
                    imageMatrix[x][y] = r;
                } else {
                    imageMatrix[x][y] = 0;
                }
            }
        }

        for (x = 0; x < width; x++) {
            for (y = 0; y < height; y++) {
                if (imageMatrix[x][y] == 0) {
                    continue;
                }

                for (i = 0; i < filterBounds; i++) {
                    for (j = 0; j < filterBounds; j++) {
                        for (int m = -1; m <= 1; m++) {
                            for (int p = -1; p <= 1; p++) {
                                if (x + m < 0 || y + p < 0 || x + m > width-1 || y + p > height-1) {
                                    continue;
                                } else {
                                    outputImage.setRGB(x + m, y + p, Color.WHITE.getRGB());
                                }
                            }
                        }

                    }
                }

            }

        }
        return outputImage;
    }

    public BufferedImage Erode(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        int filterBounds = 3, x, y, i, j;
        boolean control = true;
        int[][] imageMatrix = new int[width][height];
        int[][] kernel = new int[filterBounds][filterBounds];
        for (int k = 0; k < filterBounds; k++) {
            for (int l = 0; l < filterBounds; l++) {
                kernel[k][l] = 255;
            }
        }

        for (x = 0; x < width; x++) {
            for (y = 0; y < height; y++) {
                int p = image.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                if (r == 255) {
                    imageMatrix[x][y] = r;
                } else {
                    imageMatrix[x][y] = 0;
                }
            }
        }

        for (x = 0; x < width; x++) {
            for (y = 0; y < height; y++) {
                if (imageMatrix[x][y] == 0) {
                    continue;
                }
                control = true;

                for (i = 0; i < filterBounds; i++) {
                    for (j = 0; j < filterBounds; j++) {
                        for (int m = -1; m <= 1; m++) {
                            for (int p = -1; p <= 1; p++) {
                                if (x + m < 0 || y + p < 0 || x + m > width-1 || y + p > height-1) {
                                    continue;
                                }
                                if (imageMatrix[x + m][y + p] != 255) {
                                    control = false;
                                }

                            }
                        }
                    }
                }
                if (control) {
                    outputImage.setRGB(x, y, Color.WHITE.getRGB());
                }

            }

        }
        return outputImage;
    }
}
