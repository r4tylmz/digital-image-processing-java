package GUI;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 *
 * @author ylmz
 */
public class HistogramFrame extends javax.swing.JFrame {

    public HistogramFrame() {
        initComponents();
    }
    BufferedImage image;

    public HistogramFrame(BufferedImage histoimage) {
        this.image = histoimage;
    }

    public void CreateHistogram(BufferedImage image) {

    }

    public static void drawRotate(Graphics2D g2d, double x, double y, int angle, String text) {
        g2d.translate((float) x, (float) y);
        g2d.rotate(Math.toRadians(angle));
        g2d.setFont(new Font("Arial", Font.PLAIN, 8)); 
        g2d.drawString(text, 0, 0);
        g2d.rotate(-Math.toRadians(angle));
        g2d.translate(-(float) x, -(float) y);
    }

    @Override
    public void paint(Graphics g) {
        int GAP_BETWEEN_LINES = 5;
        int width = image.getWidth();
        int height = image.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        int[] matrixR = new int[256];
        int[] matrixG = new int[256];
        int[] matrixB = new int[256];
        for (int i = 0; i < 256; i++) {
            matrixR[i] = 0;
            matrixG[i] = 0;
            matrixR[i] = 0;
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int p = image.getRGB(x, y);

                int red = (p >> 16) & 0xff;
                int green = (p >> 8) & 0xff;
                int blue = p & 0xff;

                matrixR[red] += 1;
                matrixG[green] += 1;
                matrixB[blue] += 1;

            }
        }

        int maxRedValue = 0;
        for (int value : matrixR) {
            maxRedValue = Math.max(maxRedValue, value);
        }

        int maxGreenValue = 0;
        for (int value : matrixG) {
            maxGreenValue = Math.max(maxGreenValue, value);
        }

        int maxBlueValue = 0;
        for (int value : matrixB) {
            maxBlueValue = Math.max(maxBlueValue, value);
        }

        for (int i = 0; i < 256; i++) {
            int redBarHeight = Math.round(((float) matrixR[i] / (float) maxRedValue) * height);
            int greenBarHeight = Math.round(((float) matrixG[i] / (float) maxGreenValue) * height);
            int blueBarHeight = Math.round(((float) matrixB[i] / (float) maxBlueValue) * height);
            g.setColor(new Color(255,0,0,240));
            g.fillRect(GAP_BETWEEN_LINES, (600 - redBarHeight), 4, redBarHeight);
            g.setColor(new Color(0,255,0,200));
            g.fillRect(GAP_BETWEEN_LINES, (600 - greenBarHeight), 4, greenBarHeight);
            g.setColor(new Color(0,0,255,150));
            g.fillRect(GAP_BETWEEN_LINES, (600 - blueBarHeight), 4, blueBarHeight);
            GAP_BETWEEN_LINES += 5;
            if(i%5==0){
                g.setColor(Color.RED);
                drawRotate(g2d, GAP_BETWEEN_LINES-5,600.0,90,Integer.toString(i));
            }
                
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 902, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistogramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistogramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistogramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistogramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistogramFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
