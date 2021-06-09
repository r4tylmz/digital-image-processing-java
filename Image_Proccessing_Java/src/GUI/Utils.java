/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author ylmz
 */
public class Utils {

    public static BufferedImage LabelIconToBufferedImage(JLabel label) {
        Icon ico = label.getIcon();
        BufferedImage bimg = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bimg.createGraphics();
        ico.paintIcon(null, g, 0, 0);
        g.dispose();
        return bimg;
    }

    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
