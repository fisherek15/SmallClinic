/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprzychodnia;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class FrmDisease extends javax.swing.JFrame {

    Connection cn = new Connection();        
    DefaultTableModel lista = new DefaultTableModel();
    
    //obsluga tabeli
    public void TableDiseases() {
        
        if(!"".equals(txtWyszukajChorobe.getText())) {
            
            lista.setColumnCount(0);
            lista.setRowCount(0);
            cn.connect();
            String sql = "SELECT * FROM choroby "
                    + "WHERE UPPER(nazwa_choroby) "
                    + "LIKE '%" + txtWyszukajChorobe.getText().toUpperCase() + "%' " 
                    + " OR UPPER(objawy) "
                    + "LIKE '%" + txtWyszukajChorobe.getText().toUpperCase() + "%' "
                    + " ORDER BY nazwa_choroby";
            
            cn.executeQuerying(sql);
            
            lista.addColumn("ID");
            lista.addColumn("Nazwa");
            lista.addColumn("Objawy");
            lista.addColumn("Leczenie");
            
            try {
                while (cn.rs.next()) {
                    
                    lista.addRow(new String[]{cn.rs.getString("id_choroby"), cn.rs.getString("nazwa_choroby"),
                        cn.rs.getString("objawy"), cn.rs.getString("leczenie")});
                }
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
            }
            cn.disconnect();
            tabelaChorob.setModel(lista);            
        } else {
            lista.setColumnCount(0);
            lista.setRowCount(0);
            cn.connect();
            String sql = "SELECT * FROM choroby ORDER BY nazwa_choroby";
            
            cn.executeQuerying(sql);
            
            lista.addColumn("ID");
            lista.addColumn("Nazwa");
            lista.addColumn("Objawy");
            lista.addColumn("Leczenie");
            
            try {
                while (cn.rs.next()) {
                    
                    lista.addRow(new String[]{cn.rs.getString("id_choroby"), cn.rs.getString("nazwa_choroby"),
                        cn.rs.getString("objawy"), cn.rs.getString("leczenie")});
                }
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
            }
            cn.disconnect();
            tabelaChorob.setModel(lista);
        }
    }
    
    //wybor choroby poprzez klikniecie - uzupelnienie pustych pol
    public void Selection() {
        
        int column = tabelaChorob.getSelectedRow();
        
        txtIDChoroby.setText(tabelaChorob.getValueAt(column, 0).toString());
        txtNazwaChoroby.setText(tabelaChorob.getValueAt(column, 1).toString());
        txtObjawyChoroby.setText(tabelaChorob.getValueAt(column, 2).toString());
        txtLeczenieChoroby.setText(tabelaChorob.getValueAt(column, 3).toString());        
    }
    
    public FrmDisease() {
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

        jLabel1 = new javax.swing.JLabel();
        txtWyszukajChorobe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDChoroby = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaChorob = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObjawyChoroby = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLeczenieChoroby = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtNazwaChoroby = new javax.swing.JTextField();
        btnOKChoroby = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("KATALOG JEDNOSTEK CHOROBOWYCH");

        txtWyszukajChorobe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtWyszukajChorobeMouseClicked(evt);
            }
        });
        txtWyszukajChorobe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWyszukajChorobeKeyReleased(evt);
            }
        });

        jLabel3.setText("ID choroby");

        jLabel4.setText("Objawy");

        tabelaChorob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaChorob.setCellSelectionEnabled(true);
        tabelaChorob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaChorobMouseClicked(evt);
            }
        });
        tabelaChorob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaChorobKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaChorob);

        jLabel6.setText("Wyszukaj");

        jScrollPane2.setEnabled(false);

        txtObjawyChoroby.setColumns(20);
        txtObjawyChoroby.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtObjawyChoroby.setLineWrap(true);
        txtObjawyChoroby.setRows(5);
        txtObjawyChoroby.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtObjawyChoroby);

        jLabel7.setText("Leczenie");

        jScrollPane3.setEnabled(false);

        txtLeczenieChoroby.setColumns(20);
        txtLeczenieChoroby.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtLeczenieChoroby.setLineWrap(true);
        txtLeczenieChoroby.setRows(5);
        txtLeczenieChoroby.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtLeczenieChoroby);

        jLabel2.setText("Nazwa");

        btnOKChoroby.setText("OK");
        btnOKChoroby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKChorobyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(txtWyszukajChorobe)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtIDChoroby, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNazwaChoroby, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOKChoroby, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWyszukajChorobe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIDChoroby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNazwaChoroby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnOKChoroby)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtWyszukajChorobeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWyszukajChorobeKeyReleased
        
        TableDiseases();
    }//GEN-LAST:event_txtWyszukajChorobeKeyReleased

    private void tabelaChorobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaChorobKeyReleased
        
        Selection();
    }//GEN-LAST:event_tabelaChorobKeyReleased

    private void tabelaChorobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaChorobMouseClicked
        
        Selection();
    }//GEN-LAST:event_tabelaChorobMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.setTitle("Katalog jednostek chorobowych");
    }//GEN-LAST:event_formWindowOpened

    private void txtWyszukajChorobeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtWyszukajChorobeMouseClicked
        TableDiseases();
    }//GEN-LAST:event_txtWyszukajChorobeMouseClicked

    private void btnOKChorobyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKChorobyActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_btnOKChorobyActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDisease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDisease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDisease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDisease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDisease().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOKChoroby;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaChorob;
    private javax.swing.JTextField txtIDChoroby;
    private javax.swing.JTextArea txtLeczenieChoroby;
    private javax.swing.JTextField txtNazwaChoroby;
    private javax.swing.JTextArea txtObjawyChoroby;
    private javax.swing.JTextField txtWyszukajChorobe;
    // End of variables declaration//GEN-END:variables
}
