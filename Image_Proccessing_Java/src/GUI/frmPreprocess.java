/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ylmz
 */
public class frmPreprocess extends javax.swing.JFrame {

    public BufferedImage lastBufferedImage = null, bufferedImage = null;
    private boolean control = false;
    private Point first = new Point();
    private Point second = new Point();

    public frmPreprocess() {
        initComponents();
    }

    public frmPreprocess(BufferedImage bufferedImage) {
        initComponents();
        lastBufferedImage = bufferedImage;
        this.bufferedImage = Utils.deepCopy(bufferedImage);
        Image image = lastBufferedImage;
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
        previewImage.setText(null);
        previewImage.setIcon(imageIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        previewImage = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioPreprocess2 = new javax.swing.JRadioButton();
        cmbPreprocess = new javax.swing.JComboBox();
        radioPreprocess1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHMED YILMAZ - 171213038");
        setMinimumSize(new java.awt.Dimension(969, 428));

        previewImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewImage.setText("Acilacak resim burada gorunecektir");
        previewImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        previewImage.setMaximumSize(new java.awt.Dimension(418, 304));
        previewImage.setMinimumSize(new java.awt.Dimension(418, 304));
        previewImage.setPreferredSize(new java.awt.Dimension(418, 304));
        previewImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                previewImageMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                previewImageMouseReleased(evt);
            }
        });

        btnBack.setText("GERI");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setLabel("ILERI");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(372, 180));

        buttonGroup1.add(radioPreprocess2);
        radioPreprocess2.setSelected(true);
        radioPreprocess2.setText("On isleme Uygulamak Istemiyorum");
        radioPreprocess2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioPreprocess2StateChanged(evt);
            }
        });

        cmbPreprocess.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Onislem Menusu", "Renkli resmi gri seviyeye donusturme", "Resimden istenilen bölgenin kesilip alınması", "Histogram oluşturma" }));
        cmbPreprocess.setEnabled(false);
        cmbPreprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPreprocessActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioPreprocess1);
        radioPreprocess1.setText("On isleme Uygulamak Istiyorum");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioPreprocess1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPreprocess, 0, 346, Short.MAX_VALUE)
                            .addComponent(radioPreprocess2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(radioPreprocess1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioPreprocess2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPreprocess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(btnNext))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        frmMain frm = new frmMain();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        frmFilter frm = new frmFilter(lastBufferedImage);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNextActionPerformed

    private void radioPreprocess2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioPreprocess2StateChanged
        // TODO add your handling code here:
        if (radioPreprocess1.isSelected()) {
            cmbPreprocess.setEnabled(true);
        } else {
            cmbPreprocess.setEnabled(false);

        }
    }//GEN-LAST:event_radioPreprocess2StateChanged

    private void cmbPreprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPreprocessActionPerformed
        // TODO add your handling code here:
        BufferedImage bi = null;
        HistogramFrame hf = new HistogramFrame(lastBufferedImage);
        if (cmbPreprocess.getSelectedIndex() == 1) {
            bi = new Preprocess().RGBtoGray(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        } else if (cmbPreprocess.getSelectedIndex() == 2) {
            JOptionPane.showMessageDialog(null, "Resim üzerine gelip ilk nokta için sol tıklama yapınız ve elinizi sol tuştan kaldırmayınız\n"
                    + "ardından belirlediğiniz ikinci noktaya kadar sol tuşa basılı "
                    + "götürünüz ve sol tuştan parmağınızı kaldırınız.", "KULLANIM TALIMATLARI", JOptionPane.WARNING_MESSAGE);
            control = true;
            this.setCursor(Cursor.HAND_CURSOR);
        } else if (cmbPreprocess.getSelectedIndex() == 3) {
            hf.setMaximumSize(new Dimension(256 * 5 + 15, 620));
            hf.setMinimumSize(new Dimension(256 * 5 + 15, 620));
            hf.setVisible(true);
        }
    }//GEN-LAST:event_cmbPreprocessActionPerformed

    private void previewImageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewImageMousePressed
        // TODO add your handling code here:
        first.x = evt.getX();
        first.y = evt.getY();
    }//GEN-LAST:event_previewImageMousePressed

    private void previewImageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewImageMouseReleased
        // TODO add your handling code here:
        second.x = evt.getX();
        second.y = evt.getY();
        if (control) {
            Image scaledImage = lastBufferedImage.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), BufferedImage.SCALE_SMOOTH);
            BufferedImage bimage = new BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D bGr = bimage.createGraphics();
            bGr.drawImage(scaledImage, 0, 0, null);
            bGr.dispose();
            BufferedImage bi = bimage.getSubimage(first.x, first.y, second.x - first.x, second.y - first.y);

            previewImage.setText(null);
            previewImage.setIcon(new ImageIcon(bi.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), BufferedImage.SCALE_SMOOTH)));
            lastBufferedImage = Utils.LabelIconToBufferedImage(previewImage);
            this.setCursor(Cursor.DEFAULT_CURSOR);
            control = false;
        }
    }//GEN-LAST:event_previewImageMouseReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmPreprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPreprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPreprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPreprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPreprocess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbPreprocess;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel previewImage;
    private javax.swing.JRadioButton radioPreprocess1;
    private javax.swing.JRadioButton radioPreprocess2;
    // End of variables declaration//GEN-END:variables
}
