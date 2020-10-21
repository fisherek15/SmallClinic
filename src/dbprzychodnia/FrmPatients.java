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
public class FrmPatients extends javax.swing.JFrame {

    Connection cn = new Connection();    
    DefaultTableModel lista = new DefaultTableModel();
    
    //wyswietlanie tabeli w oknie
    public void TablePatients() {
        
        if(!"".equals(txtWyszukajPac.getText())) {
            
            lista.setColumnCount(0);
            lista.setRowCount(0);
            
            cn.connect();
            String sql = "SELECT * FROM pacjenci "
                    + "WHERE UPPER(imie) "
                    + "LIKE '%" + txtWyszukajPac.getText().toUpperCase() + "%' " 
                    + " OR UPPER(nazwisko) "
                    + "LIKE '%" + txtWyszukajPac.getText().toUpperCase() + "%' "
                    + " OR telefon "
                    + "LIKE '" + txtWyszukajPac.getText() + "' "
                    + " OR nr_ubezpieczenia "
                    + "LIKE '%" + txtWyszukajPac.getText() + "%' "
                    + " ORDER BY nazwisko";            
            cn.executeQuerying(sql);
            
            lista.addColumn("Nr ubezp.");
            lista.addColumn("Imie");
            lista.addColumn("Nazwisko");
            lista.addColumn("Adres");
            lista.addColumn("Telefon");
            
            try {
                while (cn.rs.next()) {
                    
                    lista.addRow(new String[]{cn.rs.getString("nr_ubezpieczenia"), cn.rs.getString("imie"), 
                        cn.rs.getString("nazwisko"), cn.rs.getString("adres"), cn.rs.getString("telefon")});
                }
            } catch (SQLException ex) {                
                JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
            }
            cn.disconnect();
            tabelaPac.setModel(lista);            
        } else {
            lista.setColumnCount(0);
            lista.setRowCount(0);
            
            cn.connect();
            String sql = "SELECT * FROM pacjenci ORDER BY nazwisko";            
            cn.executeQuerying(sql);
            
            lista.addColumn("Nr ubezp.");
            lista.addColumn("Imie");
            lista.addColumn("Nazwisko");
            lista.addColumn("Adres");
            lista.addColumn("Telefon");
            try {
                while (cn.rs.next()) {
                    
                    lista.addRow(new String[]{cn.rs.getString("nr_ubezpieczenia"),
                        cn.rs.getString("imie"), cn.rs.getString("nazwisko"),
                        cn.rs.getString("adres"), cn.rs.getString("telefon")});
                }
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
            }
            cn.disconnect();
            tabelaPac.setModel(lista);
        }
    }
    
    //uzupełnienie pól danymi wybranego pacjenta
    public void Selection() {
        
        int row = tabelaPac.getSelectedRow();
        
        txtIDPac.setText(tabelaPac.getValueAt(row, 0).toString());
        txtImiePac.setText(tabelaPac.getValueAt(row, 1).toString());
        txtNazwiskoPac.setText(tabelaPac.getValueAt(row, 2).toString());
        txtAdresPac.setText(tabelaPac.getValueAt(row, 3).toString());
        txtTelefonPac.setText(tabelaPac.getValueAt(row, 4).toString());        
    }
    
    public FrmPatients() {
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
        txtWyszukajPac = new javax.swing.JTextField();
        btnDodajPacjentaPac = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDPac = new javax.swing.JTextField();
        txtImiePac = new javax.swing.JTextField();
        txtNazwiskoPac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefonPac = new javax.swing.JTextField();
        btnZapiszImiePac = new javax.swing.JButton();
        btnZapiszNazwiskoPac = new javax.swing.JButton();
        btnZapiszTelefonPac = new javax.swing.JButton();
        btnEdytujImiePac = new javax.swing.JButton();
        btnEdytujNazwiskoPac = new javax.swing.JButton();
        btnEdytujTelefonPac = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPac = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAdresPac = new javax.swing.JTextField();
        btnZapiszAdresPac = new javax.swing.JButton();
        btnEdytujAdresPac = new javax.swing.JButton();
        btnOKPacjenci = new javax.swing.JButton();
        btnUsunPacjentaPac = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("PACJENCI");

        txtWyszukajPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtWyszukajPacMouseClicked(evt);
            }
        });
        txtWyszukajPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWyszukajPacKeyReleased(evt);
            }
        });

        btnDodajPacjentaPac.setText("Dodaj pacjenta");
        btnDodajPacjentaPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPacjentaPacActionPerformed(evt);
            }
        });

        jLabel2.setText("Nr ubezp.");

        jLabel3.setText("Imię");

        jLabel4.setText("Nazwisko");

        txtIDPac.setEnabled(false);

        txtImiePac.setEnabled(false);

        txtNazwiskoPac.setEnabled(false);

        jLabel5.setText("Telefon");

        txtTelefonPac.setEnabled(false);

        btnZapiszImiePac.setText("Zapisz");
        btnZapiszImiePac.setEnabled(false);
        btnZapiszImiePac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapiszImiePacActionPerformed(evt);
            }
        });

        btnZapiszNazwiskoPac.setText("Zapisz");
        btnZapiszNazwiskoPac.setEnabled(false);
        btnZapiszNazwiskoPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapiszNazwiskoPacActionPerformed(evt);
            }
        });

        btnZapiszTelefonPac.setText("Zapisz");
        btnZapiszTelefonPac.setEnabled(false);
        btnZapiszTelefonPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapiszTelefonPacActionPerformed(evt);
            }
        });

        btnEdytujImiePac.setText("Edytuj");
        btnEdytujImiePac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdytujImiePacActionPerformed(evt);
            }
        });

        btnEdytujNazwiskoPac.setText("Edytuj");
        btnEdytujNazwiskoPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdytujNazwiskoPacActionPerformed(evt);
            }
        });

        btnEdytujTelefonPac.setText("Edytuj");
        btnEdytujTelefonPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdytujTelefonPacActionPerformed(evt);
            }
        });

        tabelaPac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPac.setCellSelectionEnabled(true);
        tabelaPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPacMouseClicked(evt);
            }
        });
        tabelaPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaPacKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPac);

        jLabel6.setText("Wyszukaj");

        jLabel7.setText("Adres");

        txtAdresPac.setEnabled(false);

        btnZapiszAdresPac.setText("Zapisz");
        btnZapiszAdresPac.setEnabled(false);
        btnZapiszAdresPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapiszAdresPacActionPerformed(evt);
            }
        });

        btnEdytujAdresPac.setText("Edytuj");
        btnEdytujAdresPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdytujAdresPacActionPerformed(evt);
            }
        });

        btnOKPacjenci.setText("OK");
        btnOKPacjenci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKPacjenciActionPerformed(evt);
            }
        });

        btnUsunPacjentaPac.setText("Usuń pacjenta");
        btnUsunPacjentaPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsunPacjentaPacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtWyszukajPac)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDodajPacjentaPac, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIDPac, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUsunPacjentaPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtImiePac)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdytujImiePac)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnZapiszImiePac))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTelefonPac, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNazwiskoPac, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAdresPac, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnEdytujNazwiskoPac)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnZapiszNazwiskoPac))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnEdytujAdresPac)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnZapiszAdresPac))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(btnEdytujTelefonPac)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnZapiszTelefonPac))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnOKPacjenci, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWyszukajPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajPacjentaPac)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsunPacjentaPac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtImiePac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZapiszImiePac)
                    .addComponent(btnEdytujImiePac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNazwiskoPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZapiszNazwiskoPac)
                    .addComponent(btnEdytujNazwiskoPac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAdresPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZapiszAdresPac)
                    .addComponent(btnEdytujAdresPac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefonPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdytujTelefonPac)
                    .addComponent(btnZapiszTelefonPac))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOKPacjenci)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajPacjentaPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPacjentaPacActionPerformed
        
        FrmAddPatient form = new FrmAddPatient();         
        form.setVisible(true);
    }//GEN-LAST:event_btnDodajPacjentaPacActionPerformed

    private void txtWyszukajPacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWyszukajPacKeyReleased
        
        TablePatients();
    }//GEN-LAST:event_txtWyszukajPacKeyReleased

    private void tabelaPacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaPacKeyReleased
        
        Selection();
    }//GEN-LAST:event_tabelaPacKeyReleased

    private void tabelaPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPacMouseClicked
        
        Selection();
    }//GEN-LAST:event_tabelaPacMouseClicked

    private void btnZapiszImiePacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapiszImiePacActionPerformed
        
        cn.connect();
        String sql = "UPDATE pacjenci "
                + "SET imie = '" + txtImiePac.getText()
                + "'WHERE nr_ubezpieczenia = " + Integer.parseInt(txtIDPac.getText());
        cn.executeUpdating(sql);
        cn.disconnect();
        
        txtImiePac.setEnabled(false);
        btnEdytujImiePac.setEnabled(true);
        btnZapiszImiePac.setEnabled(false);
        TablePatients();
    }//GEN-LAST:event_btnZapiszImiePacActionPerformed

    private void btnEdytujImiePacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdytujImiePacActionPerformed
        
        txtImiePac.setEnabled(true);
        btnZapiszImiePac.setEnabled(true);
        btnEdytujImiePac.setEnabled(false);
    }//GEN-LAST:event_btnEdytujImiePacActionPerformed

    private void btnZapiszNazwiskoPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapiszNazwiskoPacActionPerformed
        
        cn.connect();
        String sql = "UPDATE pacjenci "
                + "SET nazwisko = '" + txtNazwiskoPac.getText()
                + "'WHERE nr_ubezpieczenia = " + Integer.parseInt(txtIDPac.getText());
        cn.executeUpdating(sql);
        cn.disconnect();
        txtNazwiskoPac.setEnabled(false);
        btnEdytujNazwiskoPac.setEnabled(true);
        btnZapiszNazwiskoPac.setEnabled(false);
        TablePatients();
    }//GEN-LAST:event_btnZapiszNazwiskoPacActionPerformed

    private void btnEdytujNazwiskoPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdytujNazwiskoPacActionPerformed
        
        txtNazwiskoPac.setEnabled(true);
        btnZapiszNazwiskoPac.setEnabled(true);
        btnEdytujNazwiskoPac.setEnabled(false);
    }//GEN-LAST:event_btnEdytujNazwiskoPacActionPerformed

    private void btnZapiszTelefonPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapiszTelefonPacActionPerformed
        
        cn.connect();
        String sql = "UPDATE pacjenci "
                + "SET telefon = '" + txtTelefonPac.getText()
                + "'WHERE nr_ubezpieczenia = " + Integer.parseInt(txtIDPac.getText());
        cn.executeUpdating(sql);
        cn.disconnect();
        txtTelefonPac.setEnabled(false);
        btnEdytujTelefonPac.setEnabled(true);
        btnZapiszTelefonPac.setEnabled(false);
        TablePatients();
    }//GEN-LAST:event_btnZapiszTelefonPacActionPerformed

    private void btnEdytujTelefonPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdytujTelefonPacActionPerformed
        
        txtTelefonPac.setEnabled(true);
        btnZapiszTelefonPac.setEnabled(true);
        btnEdytujTelefonPac.setEnabled(false);
    }//GEN-LAST:event_btnEdytujTelefonPacActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.setTitle("Pacjenci");
    }//GEN-LAST:event_formWindowOpened

    private void btnZapiszAdresPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapiszAdresPacActionPerformed
        
        cn.connect();
        String sql = "UPDATE pacjenci "
                + "SET adres = '" + txtAdresPac.getText()
                + "'WHERE nr_ubezpieczenia = " + Integer.parseInt(txtIDPac.getText());
        cn.executeUpdating(sql);
        cn.disconnect();
        txtAdresPac.setEnabled(false);
        btnEdytujAdresPac.setEnabled(true);
        btnZapiszAdresPac.setEnabled(false);
        TablePatients();
    }//GEN-LAST:event_btnZapiszAdresPacActionPerformed

    private void btnEdytujAdresPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdytujAdresPacActionPerformed
        
        txtAdresPac.setEnabled(true);
        btnZapiszAdresPac.setEnabled(true);
        btnEdytujAdresPac.setEnabled(false);
    }//GEN-LAST:event_btnEdytujAdresPacActionPerformed

    private void txtWyszukajPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtWyszukajPacMouseClicked
        
        TablePatients();
    }//GEN-LAST:event_txtWyszukajPacMouseClicked

    private void btnOKPacjenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKPacjenciActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_btnOKPacjenciActionPerformed

    private void btnUsunPacjentaPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsunPacjentaPacActionPerformed
        
        if(!"".equals(txtIDPac.getText())) {
            cn.connect();
            String sql = "SELECT * FROM pacjenci "
                    + "WHERE nr_ubezpieczenia = " + Integer.parseInt(txtIDPac.getText());
            cn.executeQuerying(sql);
            int resp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć "
                    + "pacjenta o numerze ubezpieczenia '"+txtIDPac.getText()+"' ?");

            if(resp == JOptionPane.YES_OPTION) {
                sql = "DELETE FROM pacjenci "
                        + " WHERE nr_ubezpieczenia = " + Integer.parseInt(txtIDPac.getText());
                cn.executeUpdating(sql);
                cn.disconnect();
                txtIDPac.setText("");
                txtImiePac.setText("");
                txtNazwiskoPac.setText("");
                txtAdresPac.setText("");
                txtTelefonPac.setText("");
                TablePatients();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Najpierw wybierz pacjenta.");
        }
    }//GEN-LAST:event_btnUsunPacjentaPacActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPatients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPacjentaPac;
    private javax.swing.JButton btnEdytujAdresPac;
    private javax.swing.JButton btnEdytujImiePac;
    private javax.swing.JButton btnEdytujNazwiskoPac;
    private javax.swing.JButton btnEdytujTelefonPac;
    private javax.swing.JButton btnOKPacjenci;
    private javax.swing.JButton btnUsunPacjentaPac;
    private javax.swing.JButton btnZapiszAdresPac;
    private javax.swing.JButton btnZapiszImiePac;
    private javax.swing.JButton btnZapiszNazwiskoPac;
    private javax.swing.JButton btnZapiszTelefonPac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPac;
    private javax.swing.JTextField txtAdresPac;
    private javax.swing.JTextField txtIDPac;
    private javax.swing.JTextField txtImiePac;
    private javax.swing.JTextField txtNazwiskoPac;
    private javax.swing.JTextField txtTelefonPac;
    private javax.swing.JTextField txtWyszukajPac;
    // End of variables declaration//GEN-END:variables
}