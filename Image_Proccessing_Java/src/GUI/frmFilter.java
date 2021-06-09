package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author ylmz
 */
public class frmFilter extends javax.swing.JFrame {

    public BufferedImage lastBufferedImage = null,bufferedImage = null;

    public frmFilter() {
        initComponents();
    }

    public frmFilter(BufferedImage bufferedImage) {
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
        jPanel2 = new javax.swing.JPanel();
        radioFilter2 = new javax.swing.JRadioButton();
        cmbFilter = new javax.swing.JComboBox();
        radioFilter1 = new javax.swing.JRadioButton();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(372, 180));

        buttonGroup1.add(radioFilter2);
        radioFilter2.setSelected(true);
        radioFilter2.setText("Filtreleme Uygulamak Istemiyorum");
        radioFilter2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioFilter2StateChanged(evt);
            }
        });

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filtre Menusu", "Bulanıklaştırma filtresi", "Keskinleştirme filtresi", "Kenar bulma filtresi" }));
        cmbFilter.setEnabled(false);
        cmbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilterActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioFilter1);
        radioFilter1.setText("Filtreleme Uygulamak Istiyorum");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFilter, 0, 346, Short.MAX_VALUE)
                            .addComponent(radioFilter2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(radioFilter1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioFilter2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        frmMorph frm = new frmMorph(lastBufferedImage);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        frmPreprocess frm = new frmPreprocess(bufferedImage);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void radioFilter2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioFilter2StateChanged
        // TODO add your handling code here:
        if (radioFilter1.isSelected()) {
            cmbFilter.setEnabled(true);
        } else {
            cmbFilter.setEnabled(false);

        }
    }//GEN-LAST:event_radioFilter2StateChanged

    private void cmbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilterActionPerformed
        // TODO add your handling code here:
        previewImage.setIcon(null);
        previewImage.setText("Acilacak resim burada gorunecektir");
        BufferedImage bi = null;
        if (cmbFilter.getSelectedIndex() == 1) {
            bi = new Filter().MeanFilter(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        } else if (cmbFilter.getSelectedIndex() == 2) {
            bi = new Filter().SharpeningFilter(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        } else if (cmbFilter.getSelectedIndex() == 3) {
            bi = new Filter().SobelFilter(lastBufferedImage);
            Image image = bi;
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(previewImage.getWidth(), previewImage.getHeight(), Image.SCALE_SMOOTH));
            previewImage.setText(null);
            previewImage.setIcon(imageIcon);
            lastBufferedImage = bi;
        }

    }//GEN-LAST:event_cmbFilterActionPerformed

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
            java.util.logging.Logger.getLogger(frmFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFilter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbFilter;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel previewImage;
    private javax.swing.JRadioButton radioFilter1;
    private javax.swing.JRadioButton radioFilter2;
    // End of variables declaration//GEN-END:variables
}
