/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprzychodnia;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class FrmAddMedicine extends javax.swing.JFrame {
    
    Connection cn = new Connection();

    /**
     * Creates new form windowAddDoctor
     */
    public FrmAddMedicine() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNazwaDodMed = new javax.swing.JTextField();
        btnDodajDodMed = new javax.swing.JButton();
        btnOkDodMed = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSkladDodMed = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPrzeciwwskazaniaDodMed = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSkutkiUboczneDodMed = new javax.swing.JTextArea();

        jButton2.setText("jButton2");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DODAWANIE LEKARSTWA");

        jLabel2.setText("Nazwa");

        btnDodajDodMed.setText("Dodaj");
        btnDodajDodMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajDodMedActionPerformed(evt);
            }
        });

        btnOkDodMed.setText("Anuluj");
        btnOkDodMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkDodMedActionPerformed(evt);
            }
        });

        jLabel5.setText("Skład");

        txtSkladDodMed.setColumns(20);
        txtSkladDodMed.setLineWrap(true);
        txtSkladDodMed.setRows(5);
        txtSkladDodMed.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtSkladDodMed);

        jLabel6.setText("Przeciwwskazania");

        txtPrzeciwwskazaniaDodMed.setColumns(20);
        txtPrzeciwwskazaniaDodMed.setLineWrap(true);
        txtPrzeciwwskazaniaDodMed.setRows(5);
        txtPrzeciwwskazaniaDodMed.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtPrzeciwwskazaniaDodMed);

        jLabel7.setText("Skutki uboczne");

        txtSkutkiUboczneDodMed.setColumns(20);
        txtSkutkiUboczneDodMed.setLineWrap(true);
        txtSkutkiUboczneDodMed.setRows(5);
        txtSkutkiUboczneDodMed.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtSkutkiUboczneDodMed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNazwaDodMed, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnDodajDodMed, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOkDodMed, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNazwaDodMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajDodMed)
                    .addComponent(btnOkDodMed))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkDodMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkDodMedActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_btnOkDodMedActionPerformed

    private void btnDodajDodMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajDodMedActionPerformed
        
        cn.zerosSucced();
        
        if(!"".equals(txtNazwaDodMed.getText()) 
                && !"".equals(txtSkladDodMed.getText()) 
                && !"".equals(txtPrzeciwwskazaniaDodMed.getText()) 
                && !"".equals(txtSkutkiUboczneDodMed.getText())) {
            
            String name = txtNazwaDodMed.getText();
            String comp = txtSkladDodMed.getText();
            String cont = txtPrzeciwwskazaniaDodMed.getText();
            String side_effect = txtSkutkiUboczneDodMed.getText();
          
            cn.connect();
            cn.executeUpdating("INSERT INTO lekarstwa "
                    + "(nazwa_lekarstwa, sklad, przeciwwskazania, skutki_uboczne)"
                    + " VALUES ('" + name + "','" + comp + "','" + cont + "','" + side_effect + "')");
            cn.disconnect();
            
            if(!cn.checkSucced()) {                    
                JOptionPane.showMessageDialog(null, "Lekarstwo zostało dodane do bazy.");
                txtNazwaDodMed.setText("");
                txtSkladDodMed.setText("");
                txtPrzeciwwskazaniaDodMed.setText("");
                txtSkutkiUboczneDodMed.setText("");
                txtNazwaDodMed.setFocusable(true);
            }
        }
    }//GEN-LAST:event_btnDodajDodMedActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.setTitle("Dodawanie lekarstwa");
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(FrmAddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajDodMed;
    private javax.swing.JButton btnOkDodMed;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtNazwaDodMed;
    private javax.swing.JTextArea txtPrzeciwwskazaniaDodMed;
    private javax.swing.JTextArea txtSkladDodMed;
    private javax.swing.JTextArea txtSkutkiUboczneDodMed;
    // End of variables declaration//GEN-END:variables
}
