package GUI;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ylmz
 */
public class Segmentation {

    static Color[] colors = new Color[256];
    int[][] imageMatrix = null;
    BufferedImage outputImage = null;

    public Segmentation() {
        FillColorArray();
    }

    public static int[] imageHistogram(BufferedImage input) {

        int[] histogram = new int[256];

        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = 0;
        }

        for (int i = 0; i < input.getWidth(); i++) {
            for (int j = 0; j < input.getHeight(); j++) {
                int red = new Color(input.getRGB(i, j)).getRed();
                histogram[red]++;
            }
        }

        return histogram;

    }

    private void FillColorArray() {
        for (int i = 0; i < colors.length; i++) {
            colors[i] = getRandomColor();
        }
    }

    public BufferedImage FourConnectivity(BufferedImage image) {
        BufferedImage thresholdedImage = Threshold(image);
        outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int width = image.getWidth();
        int height = image.getHeight();
        int label = 1;
        int[][] imageMatrix = new int[width][height];
        int[][] labeledMatrix = new int[width][height];
        Map<Integer, Integer> dictionary = new HashMap<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int p = thresholdedImage.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                if (r == 255) {
                    imageMatrix[x][y] = 1;
                } else {
                    imageMatrix[x][y] = 0;
                }
            }
        }
        // ilk gecis
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (imageMatrix[x][y] == 0) {
                    continue;
                }

                // Ust komsu veya alt komsu sinir disindaysa ve beyazsa
                if (x - 1 < 0 || y - 1 < 0) {
                    labeledMatrix[x][y] = label;
                    dictionary.put(label, label);
                    label++;
                    continue;
                }

                int left = imageMatrix[x - 1][y];
                int up = imageMatrix[x][y - 1];

                if (up == 0 && left == 0) {
                    labeledMatrix[x][y] = label;
                    dictionary.put(label, label);
                    label++;
                } else if (up == 0 && left == 1) {
                    labeledMatrix[x][y] = dictionary.get(labeledMatrix[x - 1][y]);
                } else if (up == 1 && left == 0) {
                    labeledMatrix[x][y] = dictionary.get(labeledMatrix[x][y - 1]);
                } else if (up == 1 && left == 1) {
                    int firstLabel = labeledMatrix[x][y - 1];
                    int secondLabel = labeledMatrix[x - 1][y];
                    if (firstLabel > secondLabel) {
                        dictionary.replace(firstLabel, secondLabel);
                        labeledMatrix[x][y] = dictionary.get(firstLabel);
                    } else if (firstLabel < secondLabel) {
                        dictionary.replace(secondLabel, firstLabel);
                        labeledMatrix[x][y] = dictionary.get(secondLabel);
                    } else {
                        labeledMatrix[x][y] = dictionary.get(secondLabel);
                    }
                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (imageMatrix[x][y] == 0) {
                    continue;
                }
                labeledMatrix[x][y] = dictionary.get(labeledMatrix[x][y]);

            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (labeledMatrix[x][y] != 0) {
                    outputImage.setRGB(x, y, getColor(labeledMatrix[x][y]).getRGB());
                } else {
                    outputImage.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        return outputImage;
    }

    private BufferedImage Threshold(BufferedImage image) {
        return binarize(image);
    }

    public BufferedImage UnionComponents(BufferedImage image) {
        BufferedImage thresholdedImage = Threshold(image);
        int width = image.getWidth();
        int height = image.getHeight();
        imageMatrix = new int[width][height];
        int[] component = new int[width * height];

        outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int p = thresholdedImage.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                outputImage.setRGB(x, y, Color.BLACK.getRGB());
                if (r == 255) {
                    imageMatrix[x][y] = r;
                } else {
                    imageMatrix[x][y] = 0;
                }
            }
        }

        for (int i = 0; i < width * height; i++) {
            component[i] = i;
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                unionCoords(x, y, x + 1, y, width, height, component);
                unionCoords(x, y, x, y + 1, width, height, component);
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int p = thresholdedImage.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                if (r == 0) {
                    continue;
                }
                int c = x * height + y;
                while (component[c] != c) {
                    c = component[c];
                }
                outputImage.setRGB(x, y, getColor(c).getRGB());
            }
        }

        return outputImage;

    }

    public <T> ArrayList<T> UnionLists(ArrayList<T> list1, ArrayList<T> list2) {
        Set<T> set = new HashSet<>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<>(set);
    }

    private  BufferedImage binarize(BufferedImage image) {
        
        int red;
        Color newPixel;
        int pixel;
        int threshold = otsuTreshold(image);
        
        BufferedImage binarized = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                red = new Color(image.getRGB(i, j)).getRed();
                int alpha = new Color(image.getRGB(i, j)).getAlpha();
                if (red > threshold) {
                    pixel = 255;
                } else {
                    pixel = 0;
                }
                newPixel = new Color(pixel, pixel, pixel, alpha);
                binarized.setRGB(i, j, newPixel.getRGB());
                
            }
        }
        
        return binarized;
        
    }

    private void doUnion(int a, int b, int[] component) {
        while (component[a] != a) {
            a = component[a];
        }
        while (component[b] != b) {
            b = component[b];
        }
        component[b] = a;
    }

    private Color getColor(int m) {
        return colors[m % colors.length];
    }

    private Color getRandomColor() {
        int r, g, b;
        r = new Random().nextInt(256);
        g = new Random().nextInt(256);
        b = new Random().nextInt(256);

        return new Color(r, g, b, 255);
    }

    private int otsuTreshold(BufferedImage image) {
        
        int[] histogram = imageHistogram(toGray(image));
        int total = image.getHeight() * image.getWidth();
        
        float sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * histogram[i];
        }
        
        float sumB = 0;
        int wB = 0;
        int wF = 0;
        
        float varMax = 0;
        int threshold = 0;
        
        for (int i = 0; i < 256; i++) {
            wB += histogram[i];
            if (wB == 0) {
                continue;
            }
            wF = total - wB;
            
            if (wF == 0) {
                break;
            }
            
            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;
            
            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);
            
            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }
        
        return threshold;
        
    }

    private BufferedImage toGray(BufferedImage image) {
        
        return new Preprocess().RGBtoGray(image);
    }

    private void unionCoords(int x, int y, int x2, int y2, int w, int h, int[] component) {
        if (y2 < h && x2 < w && imageMatrix[x][y] == 255 && imageMatrix[x2][y2] == 255) {
            doUnion(x * h + y, x2 * h + y2, component);
        }
    }

}
