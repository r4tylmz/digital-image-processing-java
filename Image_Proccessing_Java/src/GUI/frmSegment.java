/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author ylmz
 */
public class frmSegment extends javax.swing.JFrame {

    public BufferedImage lastBufferedImage = null,bufferedImage = null;

    public frmSegment() {
        initComponents();
    }

    public frmSegment(BufferedImage bufferedImage) {
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
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        radioSegment2 = new javax.swing.JRadioButton();
        cmbSegment = new javax.swing.JComboBox();
        radioSegment1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHMED YILMAZ - 171213038");
        setMinimumSize(new java.awt.Dimension(969, 428));

        previewImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewImage.setText("Acilacak resim burada gorunecektir");
        previewImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        previewImage.setMaximumSize(new java.awt.Dimension(418, 304));
        previewImage.setMinimumSize(new java.awt.Dimension(418, 304));
        previewImage.setPreferredSize(new java.awt.Dimension(418, 304));

        btnNext.setLabel("ILERI");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setText("GERI");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(372, 180));

        buttonGroup1.add(radioSegment2);
        radioSegment2.setSelected(true);
        radioSegment2.setText("Segmentasyon Uygulamak Istemiyorum");
        radioSegment2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioSegment2StateChanged(evt);
            }
        });

        cmbSegment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segmentasyon Menusu", "Siyah beyaz resimde 4’lü komşuluk ile nesne bulma ve gösterme", "Gri seviye resimde istenilen bir yöntemle nesne bulma ve gösterme", "Renkli resimde istenilen bir yöntemle nesne bulma ve gösterme" }));
        cmbSegment.setEnabled(false);
        cmbSegment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSegmentActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioSegment1);
        radioSegment1.setText("Segmentasyon Uygulamak Istiyorum");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(radioSegment1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSegment, 0, 346, Short.MAX_VALUE)
                            .addComponent(radioSegment2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(radioSegment1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioSegment2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSegment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        frmSave frm = new frmSave(lastBufferedImage);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        frmMorph frm = new frmMorph(bufferedImage);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void radioSegment2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioSegment2StateChanged
        // TODO add your handling code here:
        if (radioSegment1.isSelected()) {
            cmbSegment.setEnabled(true);
        } else {
            cmbSegment.setEnabled(false);
        }
    }//GEN-LAST:event_radioSegment2StateChanged

    private void cmbSegmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSegmentActionPerformed
        // TODO add your handling code here:
        BufferedImage bi = null;
        if (cmbSegment.getSelectedIndex() == 1) {
            bi = new Segmentation().FourConnectivity(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        } else if (cmbSegment.getSelectedIndex() == 2) {
            bi = new Segmentation().UnionComponents(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        } else if (cmbSegment.getSelectedIndex() == 3) {
            bi = new Segmentation().UnionComponents(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        }
    }//GEN-LAST:event_cmbSegmentActionPerformed

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
            java.util.logging.Logger.getLogger(frmSegment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSegment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSegment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSegment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSegment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbSegment;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel previewImage;
    private javax.swing.JRadioButton radioSegment1;
    private javax.swing.JRadioButton radioSegment2;
    // End of variables declaration//GEN-END:variables
}
