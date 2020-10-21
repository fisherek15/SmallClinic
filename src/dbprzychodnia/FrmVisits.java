/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprzychodnia;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class FrmVisits extends javax.swing.JFrame {

    Connection cn = new Connection();
        
    DefaultTableModel lista = new DefaultTableModel();
    DefaultTableModel lista2 = new DefaultTableModel();
    
    public void InsertDisease(int nrField) {
        
        lista2.setColumnCount(0);
        lista2.setRowCount(0);
        
        cn.connect();
        
        // automatycznie uzupełnia pole nazwy choroby na podstawie wpisanego id choroby
        if(!"".equals(txtRozpoznanieIDDodWiz1.getText()) && nrField == 1) {
                String sql = "SELECT nazwa_choroby FROM choroby WHERE id_choroby "
                    + "LIKE '" + txtRozpoznanieIDDodWiz1.getText() + "'";
                cn.executeQuerying(sql);
                
                try {
                    while (cn.rs.next()) {
                        String dis = cn.rs.getString("nazwa_choroby");
                        txtChorobaDodWiz1.setText(dis);                
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
                }
                
            } else            
                if(!"".equals(txtRozpoznanieIDDodWiz2.getText()) && nrField == 2) {
                    String sql = "SELECT nazwa_choroby FROM choroby WHERE id_choroby "
                        + "LIKE '" + txtRozpoznanieIDDodWiz2.getText() + "'";
                    cn.executeQuerying(sql);
                    
                    try {
                        while (cn.rs.next()) {
                            String dis = cn.rs.getString("nazwa_choroby");
                            txtChorobaDodWiz2.setText(dis);                    
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
                    }
                    
                } else            
                    if(!"".equals(txtRozpoznanieIDDodWiz3.getText()) && nrField == 3) {
                        String sql = "SELECT nazwa_choroby FROM choroby WHERE id_choroby "
                            + "LIKE '" + txtRozpoznanieIDDodWiz3.getText() + "'";
                        cn.executeQuerying(sql);
                        
                        try {
                            while (cn.rs.next()) {
                                String dis = cn.rs.getString("nazwa_choroby");
                                txtChorobaDodWiz3.setText(dis);                     
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
                        }
                        
                    } else {
                        if(nrField == 1) {
                           txtChorobaDodWiz1.setText(""); 
                        } else
                        if(nrField == 2) {
                           txtChorobaDodWiz2.setText(""); 
                        } else
                        if(nrField == 3) {
                           txtChorobaDodWiz3.setText("");
                        }
                    }
        
            cn.disconnect();            
    }
    
    //wyświetlanie lekarstw w tabeli
    public void TableVisits(int nrField) {
        
        cn.connect();
        
        if(!"".equals(txtRozpoznanieIDDodWiz1.getText()) && nrField == 1) {
                String sql = "SELECT leczenie_choroby.id_lekarstwa, lekarstwa.nazwa_lekarstwa, leczenie_choroby.typowa_dawka, "
                        + "leczenie_choroby.typowe_dawkowanie, leczenie_choroby.typowy_okres "
                        + "FROM leczenie_choroby, lekarstwa "
                        + "WHERE leczenie_choroby.id_lekarstwa=lekarstwa.id_lekarstwa and leczenie_choroby.id_choroby "
                        + "LIKE '" + txtRozpoznanieIDDodWiz1.getText() + "'"
                        + " ORDER BY lekarstwa.nazwa_lekarstwa";
                cn.executeQuerying(sql);
        } else              
            if(!"".equals(txtRozpoznanieIDDodWiz2.getText()) && nrField == 2) {
                String sql = "SELECT leczenie_choroby.id_lekarstwa, lekarstwa.nazwa_lekarstwa, leczenie_choroby.typowa_dawka, "
                        + "leczenie_choroby.typowe_dawkowanie, leczenie_choroby.typowy_okres "
                        + "FROM leczenie_choroby, lekarstwa "
                        + "WHERE leczenie_choroby.id_lekarstwa=lekarstwa.id_lekarstwa and leczenie_choroby.id_choroby "
                        + "LIKE '" + txtRozpoznanieIDDodWiz2.getText() + "'"
                        + " ORDER BY lekarstwa.nazwa_lekarstwa";
                cn.executeQuerying(sql);
            } else            
                if(!"".equals(txtRozpoznanieIDDodWiz3.getText()) && nrField == 3) {
                    String sql = "SELECT leczenie_choroby.id_lekarstwa, lekarstwa.nazwa_lekarstwa, leczenie_choroby.typowa_dawka, "
                            + "leczenie_choroby.typowe_dawkowanie, leczenie_choroby.typowy_okres "
                            + "FROM leczenie_choroby, lekarstwa "
                            + "WHERE leczenie_choroby.id_lekarstwa=lekarstwa.id_lekarstwa and leczenie_choroby.id_choroby "
                            + "LIKE '" + txtRozpoznanieIDDodWiz3.getText() + "'"
                            + " ORDER BY lekarstwa.nazwa_lekarstwa";
                    cn.executeQuerying(sql);
                } else {
                    String sql = "SELECT leczenie_choroby.id_lekarstwa, lekarstwa.nazwa_lekarstwa, leczenie_choroby.typowa_dawka, "
                            + "leczenie_choroby.typowe_dawkowanie, leczenie_choroby.typowy_okres "
                            + "FROM leczenie_choroby, lekarstwa "
                            + "WHERE leczenie_choroby.id_lekarstwa=lekarstwa.id_lekarstwa"
                            + " ORDER BY lekarstwa.nazwa_lekarstwa";
                    cn.executeQuerying(sql);
                }
        
        lista.setColumnCount(0);
        lista.setRowCount(0);
        cn.connect();

        lista.addColumn("ID lekarstwa");
        lista.addColumn("Nazwa");
        lista.addColumn("Dawka");
        lista.addColumn("Dawkowanie");
        lista.addColumn("Okres przyjmowania");
        try {
            while (cn.rs.next()) {

                lista.addRow(new String[]{cn.rs.getString("id_lekarstwa"), cn.rs.getString("nazwa_lekarstwa"), 
                    cn.rs.getString("typowa_dawka"), cn.rs.getString("typowe_dawkowanie"), cn.rs.getString("typowy_okres")});
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
        }
        cn.disconnect();
        tabelaDodWiz.setModel(lista);
    }
    
    //automatyczne uzupełnianie pól lekarstwa po kliknięciu na wiersz w tabeli lekarstw
    //oraz sprawdzenie czy dodawany lek jest konfliktowy, jesli tak - wybor dodania 
    //do listy przepisanych lekarst pozostawia lekarzowi
    public void Selection() {
        
        int column = tabelaDodWiz.getSelectedRow();
        
        if("".equals(txtIDLekarstwaDodWiz1.getText())) {
            txtNazwaDodWiz1.setText(tabelaDodWiz.getValueAt(column, 1).toString());
            txtDawkaDodWiz1.setText(tabelaDodWiz.getValueAt(column, 2).toString());
            txtDawkowanieDodWiz1.setText(tabelaDodWiz.getValueAt(column, 3).toString());
            txtOkresDodWiz1.setText(tabelaDodWiz.getValueAt(column, 4).toString());
            txtIDLekarstwaDodWiz1.setText(tabelaDodWiz.getValueAt(column, 0).toString());
            boolean resp = checkConflict(Integer.parseInt(txtIDLekarstwaDodWiz1.getText()), 0);
            if(!resp) {
                cleanMedField(1);
            }
        } else 
        if("".equals(txtIDLekarstwaDodWiz2.getText())){
            txtNazwaDodWiz2.setText(tabelaDodWiz.getValueAt(column, 1).toString());
            txtDawkaDodWiz2.setText(tabelaDodWiz.getValueAt(column, 2).toString());
            txtDawkowanieDodWiz2.setText(tabelaDodWiz.getValueAt(column, 3).toString());
            txtOkresDodWiz2.setText(tabelaDodWiz.getValueAt(column, 4).toString());
            txtIDLekarstwaDodWiz2.setText(tabelaDodWiz.getValueAt(column, 0).toString());
            boolean resp = checkConflict(Integer.parseInt(txtIDLekarstwaDodWiz2.getText()), 1);
            if(!resp) {
                cleanMedField(2);
            }
        } else 
        if("".equals(txtIDLekarstwaDodWiz3.getText())){
            txtNazwaDodWiz3.setText(tabelaDodWiz.getValueAt(column, 1).toString());
            txtDawkaDodWiz3.setText(tabelaDodWiz.getValueAt(column, 2).toString());
            txtDawkowanieDodWiz3.setText(tabelaDodWiz.getValueAt(column, 3).toString());
            txtOkresDodWiz3.setText(tabelaDodWiz.getValueAt(column, 4).toString());
            txtIDLekarstwaDodWiz3.setText(tabelaDodWiz.getValueAt(column, 0).toString());
            boolean resp = checkConflict(Integer.parseInt(txtIDLekarstwaDodWiz3.getText()), 2);
            if(!resp) {
                cleanMedField(3);
            }
        } else 
        if("".equals(txtIDLekarstwaDodWiz4.getText())){
            txtNazwaDodWiz4.setText(tabelaDodWiz.getValueAt(column, 1).toString());
            txtDawkaDodWiz4.setText(tabelaDodWiz.getValueAt(column, 2).toString());
            txtDawkowanieDodWiz4.setText(tabelaDodWiz.getValueAt(column, 3).toString());
            txtOkresDodWiz4.setText(tabelaDodWiz.getValueAt(column, 4).toString());
            txtIDLekarstwaDodWiz4.setText(tabelaDodWiz.getValueAt(column, 0).toString());
            boolean resp = checkConflict(Integer.parseInt(txtIDLekarstwaDodWiz4.getText()), 3);
            if(!resp) {
                cleanMedField(4);
            }
        } else 
        if("".equals(txtIDLekarstwaDodWiz5.getText())){
            txtNazwaDodWiz5.setText(tabelaDodWiz.getValueAt(column, 1).toString());
            txtDawkaDodWiz5.setText(tabelaDodWiz.getValueAt(column, 2).toString());
            txtDawkowanieDodWiz5.setText(tabelaDodWiz.getValueAt(column, 3).toString());
            txtOkresDodWiz5.setText(tabelaDodWiz.getValueAt(column, 4).toString());
            txtIDLekarstwaDodWiz5.setText(tabelaDodWiz.getValueAt(column, 0).toString());
            boolean resp = checkConflict(Integer.parseInt(txtIDLekarstwaDodWiz5.getText()), 4);
            if(!resp) {
                cleanMedField(5);
            }
        } 
    }  
    
    //dokonuje konwersji wybranej z kalendarza daty do odpowiedniego formatu
    public String getDateValue(JDateChooser date) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date.getDate());
    }
   
    //zwraca aktualny czas w określonym formacie
    private String getTime() {
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        return dateFormat.format(time);
    }
    
    //czyszczenie pol lekarstw
    public void cleanMedField(int row) {
        
        if(row == 1) { 
            txtNazwaDodWiz1.setText("");
            txtDawkaDodWiz1.setText("");
            txtDawkowanieDodWiz1.setText("");
            txtOkresDodWiz1.setText("");
            txtIDLekarstwaDodWiz1.setText("");
        }
        if(row == 2) {
            txtNazwaDodWiz2.setText("");
            txtDawkaDodWiz2.setText("");
            txtDawkowanieDodWiz2.setText("");
            txtOkresDodWiz2.setText("");
            txtIDLekarstwaDodWiz2.setText("");
        }        
        if(row == 3) {
            txtNazwaDodWiz3.setText("");
            txtDawkaDodWiz3.setText("");
            txtDawkowanieDodWiz3.setText("");
            txtOkresDodWiz3.setText("");
            txtIDLekarstwaDodWiz3.setText("");
        }
        if(row == 4) {
            txtNazwaDodWiz4.setText("");
            txtDawkaDodWiz4.setText("");
            txtDawkowanieDodWiz4.setText("");
            txtOkresDodWiz4.setText("");
            txtIDLekarstwaDodWiz4.setText("");
        }
        if(row == 5) {
            txtNazwaDodWiz5.setText("");
            txtDawkaDodWiz5.setText("");
            txtDawkowanieDodWiz5.setText("");
            txtOkresDodWiz5.setText("");
            txtIDLekarstwaDodWiz5.setText("");
        }  
    }    
    
    public FrmVisits() {
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

        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNrUbezpDodWiz = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIDLekarzaDodWiz = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObjawyDodWiz = new javax.swing.JTextArea();
        txtRozpoznanieIDDodWiz1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnWyszukajWizyteDodWiz = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnDodajWizyteDodWiz = new javax.swing.JButton();
        btnAnulujDodWiz = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtGodzinaDodWiz = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNotatkaDodWiz = new javax.swing.JTextField();
        txtChorobaDodWiz1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDodWiz = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIDLekarstwaDodWiz1 = new javax.swing.JTextField();
        txtIDLekarstwaDodWiz2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtIDLekarstwaDodWiz3 = new javax.swing.JTextField();
        txtIDLekarstwaDodWiz4 = new javax.swing.JTextField();
        txtIDLekarstwaDodWiz5 = new javax.swing.JTextField();
        txtNazwaDodWiz1 = new javax.swing.JTextField();
        txtNazwaDodWiz2 = new javax.swing.JTextField();
        txtNazwaDodWiz3 = new javax.swing.JTextField();
        txtNazwaDodWiz4 = new javax.swing.JTextField();
        txtNazwaDodWiz5 = new javax.swing.JTextField();
        txtDawkowanieDodWiz1 = new javax.swing.JTextField();
        txtOkresDodWiz1 = new javax.swing.JTextField();
        txtDawkowanieDodWiz2 = new javax.swing.JTextField();
        txtDawkowanieDodWiz3 = new javax.swing.JTextField();
        txtDawkowanieDodWiz4 = new javax.swing.JTextField();
        txtDawkowanieDodWiz5 = new javax.swing.JTextField();
        txtOkresDodWiz2 = new javax.swing.JTextField();
        txtOkresDodWiz3 = new javax.swing.JTextField();
        txtOkresDodWiz4 = new javax.swing.JTextField();
        txtOkresDodWiz5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDawkaDodWiz1 = new javax.swing.JTextField();
        txtDawkaDodWiz2 = new javax.swing.JTextField();
        txtDawkaDodWiz3 = new javax.swing.JTextField();
        txtDawkaDodWiz4 = new javax.swing.JTextField();
        txtDawkaDodWiz5 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtRozpoznanieIDDodWiz2 = new javax.swing.JTextField();
        txtChorobaDodWiz2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtRozpoznanieIDDodWiz3 = new javax.swing.JTextField();
        txtChorobaDodWiz3 = new javax.swing.JTextField();
        btnDrukujRecepteDodWiz = new javax.swing.JButton();
        btnDrukujPodsumowanieDodWiz = new javax.swing.JButton();
        txtDataDodWiz = new com.toedter.calendar.JDateChooser();
        btnUsun1DodWiz = new javax.swing.JButton();
        btnUsun2DodWiz = new javax.swing.JButton();
        btnUsun3DodWiz = new javax.swing.JButton();
        btnUsun4DodWiz = new javax.swing.JButton();
        btnUsun5DodWiz = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel22.setText("jLabel22");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("DODAWANIE WIZYTY");

        jLabel2.setText("Nr ubezp. pacjenta*");

        jLabel3.setText("ID lekarza*");

        jLabel6.setText("Objawy*");

        txtObjawyDodWiz.setColumns(20);
        txtObjawyDodWiz.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtObjawyDodWiz.setLineWrap(true);
        txtObjawyDodWiz.setRows(5);
        txtObjawyDodWiz.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtObjawyDodWiz);

        txtRozpoznanieIDDodWiz1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRozpoznanieIDDodWiz1MouseClicked(evt);
            }
        });
        txtRozpoznanieIDDodWiz1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRozpoznanieIDDodWiz1KeyReleased(evt);
            }
        });

        jLabel8.setText("Rozpoznanie (ID)*");

        btnWyszukajWizyteDodWiz.setText("Wyszukaj wizytę");
        btnWyszukajWizyteDodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWyszukajWizyteDodWizActionPerformed(evt);
            }
        });

        jLabel12.setText("ID lek.");

        jLabel13.setText("Dawka");

        jLabel15.setText("Dawkowanie");

        jLabel16.setText("Okres przyjmowania");

        btnDodajWizyteDodWiz.setText("Dodaj");
        btnDodajWizyteDodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajWizyteDodWizActionPerformed(evt);
            }
        });

        btnAnulujDodWiz.setText("Anuluj");
        btnAnulujDodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnulujDodWizActionPerformed(evt);
            }
        });

        jLabel9.setText("Data*");

        jLabel20.setText("Godzina*");

        txtGodzinaDodWiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGodzinaDodWizMouseClicked(evt);
            }
        });

        jLabel4.setText("Notatka");

        txtChorobaDodWiz1.setEnabled(false);

        tabelaDodWiz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaDodWiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDodWizMouseClicked(evt);
            }
        });
        tabelaDodWiz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaDodWizKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaDodWiz);

        jLabel5.setText("Proponowane lekarstwa");

        jLabel11.setText("Lp.");

        jLabel17.setText("1.");

        jLabel18.setText("2.");

        jLabel19.setText("3.");

        jLabel21.setText("4.");

        txtIDLekarstwaDodWiz1.setEnabled(false);

        txtIDLekarstwaDodWiz2.setEnabled(false);

        jLabel23.setText("5.");

        txtIDLekarstwaDodWiz3.setEnabled(false);

        txtIDLekarstwaDodWiz4.setEnabled(false);

        txtIDLekarstwaDodWiz5.setEnabled(false);

        txtNazwaDodWiz1.setEnabled(false);

        txtNazwaDodWiz2.setEnabled(false);

        txtNazwaDodWiz3.setEnabled(false);

        txtNazwaDodWiz4.setEnabled(false);

        txtNazwaDodWiz5.setEnabled(false);

        jLabel10.setText("Nazwa");

        jLabel24.setText("1.*");

        jLabel25.setText("2.");

        txtRozpoznanieIDDodWiz2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRozpoznanieIDDodWiz2MouseClicked(evt);
            }
        });
        txtRozpoznanieIDDodWiz2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRozpoznanieIDDodWiz2KeyReleased(evt);
            }
        });

        txtChorobaDodWiz2.setEnabled(false);

        jLabel26.setText("3.");

        txtRozpoznanieIDDodWiz3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRozpoznanieIDDodWiz3MouseClicked(evt);
            }
        });
        txtRozpoznanieIDDodWiz3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRozpoznanieIDDodWiz3KeyReleased(evt);
            }
        });

        txtChorobaDodWiz3.setEnabled(false);

        btnDrukujRecepteDodWiz.setText("Drukuj receptę");
        btnDrukujRecepteDodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrukujRecepteDodWizActionPerformed(evt);
            }
        });

        btnDrukujPodsumowanieDodWiz.setText("Drukuj podsumowanie");
        btnDrukujPodsumowanieDodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrukujPodsumowanieDodWizActionPerformed(evt);
            }
        });

        btnUsun1DodWiz.setText("Usuń");
        btnUsun1DodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsun1DodWizActionPerformed(evt);
            }
        });

        btnUsun2DodWiz.setText("Usuń");
        btnUsun2DodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsun2DodWizActionPerformed(evt);
            }
        });

        btnUsun3DodWiz.setText("Usuń");
        btnUsun3DodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsun3DodWizActionPerformed(evt);
            }
        });

        btnUsun4DodWiz.setText("Usuń");
        btnUsun4DodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsun4DodWizActionPerformed(evt);
            }
        });

        btnUsun5DodWiz.setText("Usuń");
        btnUsun5DodWiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsun5DodWizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNotatkaDodWiz, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRozpoznanieIDDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChorobaDodWiz1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRozpoznanieIDDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChorobaDodWiz2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRozpoznanieIDDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChorobaDodWiz3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNrUbezpDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDLekarzaDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGodzinaDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWyszukajWizyteDodWiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDrukujPodsumowanieDodWiz)
                        .addGap(18, 18, 18)
                        .addComponent(btnDrukujRecepteDodWiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnulujDodWiz)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajWizyteDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDLekarstwaDodWiz4)
                                    .addComponent(txtIDLekarstwaDodWiz5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDLekarstwaDodWiz1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(txtIDLekarstwaDodWiz2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDLekarstwaDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(23, 23, 23)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNazwaDodWiz2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(txtNazwaDodWiz1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel10)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDawkaDodWiz1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                            .addComponent(txtDawkaDodWiz2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel13))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNazwaDodWiz4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(txtNazwaDodWiz5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNazwaDodWiz3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDawkaDodWiz5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(txtDawkaDodWiz4)
                                    .addComponent(txtDawkaDodWiz3))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(130, 130, 130))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDawkowanieDodWiz5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                    .addComponent(txtDawkowanieDodWiz4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDawkowanieDodWiz3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDawkowanieDodWiz2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDawkowanieDodWiz1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtOkresDodWiz4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOkresDodWiz3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOkresDodWiz2)
                                    .addComponent(txtOkresDodWiz5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUsun2DodWiz, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUsun3DodWiz, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUsun5DodWiz, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUsun4DodWiz, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtOkresDodWiz1)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsun1DodWiz))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(90, 90, 90)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNrUbezpDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnWyszukajWizyteDodWiz)
                        .addComponent(jLabel9)
                        .addComponent(jLabel20)
                        .addComponent(txtGodzinaDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtIDLekarzaDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDataDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRozpoznanieIDDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtChorobaDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(txtRozpoznanieIDDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChorobaDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtRozpoznanieIDDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChorobaDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNotatkaDodWiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtIDLekarstwaDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazwaDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkaDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkowanieDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOkresDodWiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsun1DodWiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtIDLekarstwaDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazwaDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkaDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkowanieDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOkresDodWiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsun2DodWiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDLekarstwaDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazwaDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkaDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkowanieDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOkresDodWiz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsun3DodWiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtIDLekarstwaDodWiz4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazwaDodWiz4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkaDodWiz4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkowanieDodWiz4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOkresDodWiz4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsun4DodWiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtIDLekarstwaDodWiz5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazwaDodWiz5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkaDodWiz5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDawkowanieDodWiz5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOkresDodWiz5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsun5DodWiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnulujDodWiz)
                    .addComponent(btnDodajWizyteDodWiz)
                    .addComponent(btnDrukujRecepteDodWiz)
                    .addComponent(btnDrukujPodsumowanieDodWiz))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRozpoznanieIDDodWiz1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRozpoznanieIDDodWiz1KeyReleased
        
        TableVisits(1);
        InsertDisease(1);
    }//GEN-LAST:event_txtRozpoznanieIDDodWiz1KeyReleased

    private void txtRozpoznanieIDDodWiz1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRozpoznanieIDDodWiz1MouseClicked
        
        TableVisits(1);
    }//GEN-LAST:event_txtRozpoznanieIDDodWiz1MouseClicked

    private void tabelaDodWizKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaDodWizKeyReleased
        
        Selection();
    }//GEN-LAST:event_tabelaDodWizKeyReleased

    private void tabelaDodWizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDodWizMouseClicked
        
        Selection();
    }//GEN-LAST:event_tabelaDodWizMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        this.setTitle("Wizyta");
    }//GEN-LAST:event_formWindowOpened

    private void btnWyszukajWizyteDodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWyszukajWizyteDodWizActionPerformed
        
        FrmSearchVisit form = new FrmSearchVisit();         
        form.setVisible(true);
    }//GEN-LAST:event_btnWyszukajWizyteDodWizActionPerformed
   
    
    private void btnDodajWizyteDodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajWizyteDodWizActionPerformed
        
        //ustawianie stanu poczatkowego flagi bledow
        cn.zerosSucced();
        
        if(!"".equals(txtNrUbezpDodWiz.getText()) && !"".equals(txtIDLekarzaDodWiz.getText()) 
                && txtDataDodWiz.getDate() != null && !"".equals(txtGodzinaDodWiz.getText()) 
                && !"".equals(txtObjawyDodWiz.getText()) && !"".equals(txtRozpoznanieIDDodWiz1.getText())) {            
            
                int nrInsurance = Integer.parseInt(txtNrUbezpDodWiz.getText());
                int IDDoctor = Integer.parseInt(txtIDLekarzaDodWiz.getText());
                String IDDisease1 = txtRozpoznanieIDDodWiz1.getText();
                String IDDisease2 = txtRozpoznanieIDDodWiz2.getText();
                String IDDisease3 = txtRozpoznanieIDDodWiz3.getText();
                String date = getDateValue(txtDataDodWiz);
                String time = txtGodzinaDodWiz.getText();
                String symptoms = txtObjawyDodWiz.getText();
                String note = txtNotatkaDodWiz.getText();
                
                cn.connect();
                cn.executeUpdating("INSERT INTO wizyty "
                        + "(nr_ubezpieczenia, id_lekarza, data_wizyty, czas_wizyty, objawy, notatka) "
                        + "VALUES ('" + nrInsurance + "','" + IDDoctor + "','" + date + "',"
                        + "'" + time + "','" + symptoms + "','" + note + "')");
                
                if(!"".equals(txtRozpoznanieIDDodWiz1.getText())) {
                    cn.executeUpdating("INSERT INTO rozpoznanie_choroby "
                            + "(id_choroby) "
                            + "VALUES ('" + Integer.parseInt(IDDisease1) + "')");
                }
                
                if(!"".equals(txtRozpoznanieIDDodWiz2.getText())) {
                    cn.executeUpdating("INSERT INTO rozpoznanie_choroby "
                            + "(id_choroby) "
                            + "VALUES ('" + Integer.parseInt(IDDisease2) + "')");
                }
                
                if(!"".equals(txtRozpoznanieIDDodWiz3.getText())) {
                    cn.executeUpdating("INSERT INTO rozpoznanie_choroby "
                            + "(id_choroby) "
                            + "VALUES ('" + Integer.parseInt(IDDisease3) + "')");
                }
                cn.disconnect();
                
                if(!"".equals(txtIDLekarstwaDodWiz1.getText()) && !"".equals(txtNazwaDodWiz1.getText())
                        && !"".equals(txtDawkaDodWiz1.getText()) && !"".equals(txtDawkowanieDodWiz1.getText())
                        && !"".equals(txtOkresDodWiz1.getText())) {
                    
                    String IDMed1 = txtIDLekarstwaDodWiz1.getText();
                    String dose1 = txtDawkaDodWiz1.getText();
                    String dosage1 = txtDawkowanieDodWiz1.getText();
                    String period1 = txtOkresDodWiz1.getText();
                    
                    cn.connect();
                    cn.executeUpdating("INSERT INTO przepisane_lekarstwa "
                            + "(id_lekarstwa, dawka, dawkowanie, okres) "
                            + "VALUES ('" + Integer.parseInt(IDMed1) + "','" + dose1 + "',"
                            + "'" + dosage1 + "','" + period1 + "')");
                    cn.disconnect(); 
                }                
                
                if(!"".equals(txtIDLekarstwaDodWiz2.getText()) && !"".equals(txtNazwaDodWiz2.getText())
                        && !"".equals(txtDawkaDodWiz2.getText()) && !"".equals(txtDawkowanieDodWiz2.getText())
                        && !"".equals(txtOkresDodWiz2.getText())) {
                    
                    String IDMed2 = txtIDLekarstwaDodWiz2.getText();
                    String dose2 = txtDawkaDodWiz2.getText();
                    String dosage2 = txtDawkowanieDodWiz2.getText();
                    String period2 = txtOkresDodWiz2.getText();
                    
                    cn.connect();
                    cn.executeUpdating("INSERT INTO przepisane_lekarstwa "
                            + "(id_lekarstwa, dawka, dawkowanie, okres) "
                            + "VALUES ('" + Integer.parseInt(IDMed2) + "','" + dose2 + "',"
                            + "'" + dosage2 + "','" + period2 + "')");
                    cn.disconnect();
                }
                
                if(!"".equals(txtIDLekarstwaDodWiz3.getText()) && !"".equals(txtNazwaDodWiz3.getText())
                        && !"".equals(txtDawkaDodWiz3.getText()) && !"".equals(txtDawkowanieDodWiz3.getText())
                        && !"".equals(txtOkresDodWiz3.getText())) {
                    
                    String IDMed3 = txtIDLekarstwaDodWiz3.getText();
                    String dose3 = txtDawkaDodWiz3.getText();
                    String dosage3 = txtDawkowanieDodWiz3.getText();
                    String period3 = txtOkresDodWiz3.getText();
                    
                    cn.connect();
                    cn.executeUpdating("INSERT INTO przepisane_lekarstwa "
                            + "(id_lekarstwa, dawka, dawkowanie, okres) "
                            + "VALUES ('" + Integer.parseInt(IDMed3) + "','" + dose3 + "',"
                            + "'" + dosage3 + "','" + period3 + "')");
                    cn.disconnect();
                }
                
                if(!"".equals(txtIDLekarstwaDodWiz4.getText()) && !"".equals(txtNazwaDodWiz4.getText())
                        && !"".equals(txtDawkaDodWiz4.getText()) && !"".equals(txtDawkowanieDodWiz4.getText())
                        && !"".equals(txtOkresDodWiz4.getText())) {
                    
                    String IDMed4 = txtIDLekarstwaDodWiz4.getText();
                    String dose4 = txtDawkaDodWiz4.getText();
                    String dosage4 = txtDawkowanieDodWiz4.getText();
                    String period4 = txtOkresDodWiz4.getText();
                    
                    cn.connect();
                    cn.executeUpdating("INSERT INTO przepisane_lekarstwa "
                            + "(id_lekarstwa, dawka, dawkowanie, okres) "
                            + "VALUES ('" + Integer.parseInt(IDMed4) + "','" + dose4 + "',"
                            + "'" + dosage4 + "','" + period4 + "')");
                    cn.disconnect();
                }
                
                if(!"".equals(txtIDLekarstwaDodWiz5.getText()) && !"".equals(txtNazwaDodWiz5.getText())
                        && !"".equals(txtDawkaDodWiz5.getText()) && !"".equals(txtDawkowanieDodWiz5.getText())
                        && !"".equals(txtOkresDodWiz5.getText())) {
                    
                    String IDMed5 = txtIDLekarstwaDodWiz5.getText();
                    String dose5 = txtDawkaDodWiz5.getText();
                    String dosage5 = txtDawkowanieDodWiz5.getText();
                    String period5 = txtOkresDodWiz5.getText();
                    
                    cn.connect();
                    cn.executeUpdating("INSERT INTO przepisane_lekarstwa "
                            + "(id_lekarstwa, dawka, dawkowanie, okres) "
                            + "VALUES ('" + Integer.parseInt(IDMed5) + "','" + dose5 + "',"
                            + "'" + dosage5 + "','" + period5 + "')");
                    cn.disconnect();
                }
                
                if(!cn.checkSucced()) {
                    
                    JOptionPane.showMessageDialog(null, "Wizyta została dodana.");                    
                    txtNrUbezpDodWiz.setText("");
                    txtIDLekarzaDodWiz.setText("");
                    txtGodzinaDodWiz.setText("");
                    txtObjawyDodWiz.setText("");
                    txtRozpoznanieIDDodWiz1.setText("");
                    txtRozpoznanieIDDodWiz2.setText("");
                    txtRozpoznanieIDDodWiz3.setText("");
                    txtChorobaDodWiz1.setText("");
                    txtNotatkaDodWiz.setText("");
                    txtDataDodWiz.setDate(null);
                    lista.setRowCount(0);
                    
                    cleanMedField(1);
                    cleanMedField(2);
                    cleanMedField(3);
                    cleanMedField(4);
                    cleanMedField(5);
                    
                    txtNrUbezpDodWiz.setFocusable(true);
                }
            
        } else {
            JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie pola oznaczone '*' (gwiazdką).");
        }        
    }//GEN-LAST:event_btnDodajWizyteDodWizActionPerformed

    private void btnAnulujDodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnulujDodWizActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_btnAnulujDodWizActionPerformed

    private void txtGodzinaDodWizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGodzinaDodWizMouseClicked
        
        txtGodzinaDodWiz.setText(getTime());
    }//GEN-LAST:event_txtGodzinaDodWizMouseClicked

    private void txtRozpoznanieIDDodWiz2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRozpoznanieIDDodWiz2KeyReleased
        
        TableVisits(2);
        InsertDisease(2);
    }//GEN-LAST:event_txtRozpoznanieIDDodWiz2KeyReleased

    private void txtRozpoznanieIDDodWiz2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRozpoznanieIDDodWiz2MouseClicked
        
        TableVisits(2);
    }//GEN-LAST:event_txtRozpoznanieIDDodWiz2MouseClicked

    private void txtRozpoznanieIDDodWiz3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRozpoznanieIDDodWiz3KeyReleased
        
        TableVisits(3);
        InsertDisease(3);
    }//GEN-LAST:event_txtRozpoznanieIDDodWiz3KeyReleased

    private void txtRozpoznanieIDDodWiz3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRozpoznanieIDDodWiz3MouseClicked
        
        TableVisits(3);
    }//GEN-LAST:event_txtRozpoznanieIDDodWiz3MouseClicked
    
    //pobiera z tabeli imie i nazwisko pacjenta na podst. nr_ubezp w celu 
    //wygenerowania recepty i podsumowania wizyty
    public String[] getPatientName(){
        
        String namePatient = "";
        String lastNamePatient = "";

            lista2.setColumnCount(0);
            lista2.setRowCount(0);

            cn.connect();

            String sql = "SELECT imie, nazwisko FROM pacjenci WHERE nr_ubezpieczenia "
                + "LIKE '" + txtNrUbezpDodWiz.getText() + "'";
            cn.executeQuerying(sql);

            try {
                while (cn.rs.next()) {                
                    namePatient = cn.rs.getString("imie");
                    lastNamePatient = cn.rs.getString("nazwisko"); 
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
            }
        
        return new String[] {namePatient, lastNamePatient};
    }
   
    //pobiera z tabeli imie i nazwisko lekarza na podst. id_lekarza w celu 
    //wygenerowania recepty i podsumowania wizyty
    public String[] getDoctorName(){
        
        String nameDoctor = "";
        String lastNameDoctor = "";

        lista2.setColumnCount(0);
        lista2.setRowCount(0);

        cn.connect();
        
        String sql = "SELECT imie, nazwisko FROM lekarze WHERE id_lekarza "
            + "LIKE '" + txtIDLekarzaDodWiz.getText() + "'";
        cn.executeQuerying(sql);

        try {
            while (cn.rs.next()) {                
                nameDoctor = cn.rs.getString("imie");
                lastNameDoctor = cn.rs.getString("nazwisko");                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
        }
        
        return new String[] {nameDoctor, lastNameDoctor};
    }

    
    private void btnDrukujRecepteDodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrukujRecepteDodWizActionPerformed
                
        //ustawia parametry tekstu oraz polskie znaki w czcionce!
        com.itextpdf.text.Font f = null;
        com.itextpdf.text.Font f2 = null;
        try {
            BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.EMBEDDED);
            f = new com.itextpdf.text.Font(bf, 16, com.itextpdf.text.Font.NORMAL);
            f2 = new com.itextpdf.text.Font(bf, 12, com.itextpdf.text.Font.NORMAL);
        } catch (DocumentException ex) {
            Logger.getLogger(FrmVisits.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVisits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!"".equals(txtIDLekarstwaDodWiz1.getText())) {
            if(!"".equals(txtNrUbezpDodWiz.getText()) && !"".equals(txtIDLekarzaDodWiz.getText()) 
                    && !"".equals(txtDataDodWiz.getDateFormatString()) && !"".equals(txtGodzinaDodWiz.getText()) 
                    && !"".equals(txtObjawyDodWiz.getText()) && !"".equals(txtRozpoznanieIDDodWiz1.getText())) {

                String tabPatient[] = getPatientName();
                String tabDoctor[] = getDoctorName();
                String namePatient = tabPatient[0];
                String lastNamePatient = tabPatient[1];
                String nameDoctor = tabDoctor[0];
                String lastNameDoctor = tabDoctor[1];

                String RESULT = "Recepta.pdf";

                Document document = new Document();

                try {
                    PdfWriter.getInstance(document, new FileOutputStream(RESULT));        
                    document.open();

                    PdfPTable table = new PdfPTable(2);

                    PdfPCell cellTitle;
                    table.setWidthPercentage(40);
                    cellTitle = new PdfPCell(new Paragraph("Recepta", FontFactory.getFont(FontFactory.TIMES_BOLD, BaseFont.CP1250, 18, Font.BOLD, BaseColor.DARK_GRAY)));
                    cellTitle.setColspan(2);
                    cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTitle.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    cellTitle.setPadding(10.0f);
                    table.addCell(cellTitle);

                    PdfPCell cell;
                    cell = new PdfPCell(new Phrase(" ",f));
                    cell.setColspan(2);
                    table.addCell(cell);

                    String dataPatient = "Nr ubezp.:     "
                            +txtNrUbezpDodWiz.getText()+"\nImię:              "
                            +namePatient+"\nNazwisko:     "
                            + ""+lastNamePatient+"";

                    cell = new PdfPCell(new Phrase(dataPatient, f));
                    cell.setColspan(2);
                    table.addCell(cell);

                    String medicines = "\n"
                            +"    "+txtNazwaDodWiz1.getText()+"\n\n"
                            +"    "+txtNazwaDodWiz2.getText()+"\n\n"
                            +"    "+txtNazwaDodWiz3.getText()+"\n\n"
                            +"    "+txtNazwaDodWiz4.getText()+"\n\n"
                            +"    "+txtNazwaDodWiz5.getText()+"\n\n\n";
                    cell = new PdfPCell(new Phrase(medicines, f));
                    cell.setColspan(2);
                    table.addCell(cell);

                    String date = "Data wystawienia:\n"+getDateValue(txtDataDodWiz)+"";
                    cell = new PdfPCell(new Phrase(date, f2));            
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    table.addCell(cell);

                    String dataDoctor = "lek. "+nameDoctor+" "+lastNameDoctor+"\nID  "
                            +txtIDLekarzaDodWiz.getText()+"";
                    cell = new PdfPCell(new Phrase(dataDoctor, f2));
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    table.addCell(cell);

                    document.add(table);
                    document.close();
                }
                catch(FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Plik nie został odnaleziony. Sprawdź ścieżkę pliku. " + ex);
                }
                catch(DocumentException ex) {
                    JOptionPane.showMessageDialog(null, "Błąd pliku. " + ex);
                }

                if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File("D:/INFORMATICS/Projects Java/DBPrzychodnia2/recepta.pdf");
                        Desktop.getDesktop().open(myFile);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Błąd podczas uruchamiania pliku. Sprawdź ścieżkę pliku." + ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie pola oznaczone '*' (gwiazdką).");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Przynajmniej jedno lekarstwo musi zostać przepisane.");
        }
    }//GEN-LAST:event_btnDrukujRecepteDodWizActionPerformed

    private void btnDrukujPodsumowanieDodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrukujPodsumowanieDodWizActionPerformed
        
        com.itextpdf.text.Font f = null;
        try {
            BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.EMBEDDED);
            f = new com.itextpdf.text.Font(bf, 16, com.itextpdf.text.Font.NORMAL);
        } catch (DocumentException ex) {
            Logger.getLogger(FrmVisits.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmVisits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!"".equals(txtNrUbezpDodWiz.getText()) && !"".equals(txtIDLekarzaDodWiz.getText()) 
                && !"".equals(txtDataDodWiz.getDateFormatString()) && !"".equals(txtGodzinaDodWiz.getText()) 
                && !"".equals(txtObjawyDodWiz.getText()) && !"".equals(txtRozpoznanieIDDodWiz1.getText())) {
            
            String tabPatient[] = getPatientName();
            String tabDoctor[] = getDoctorName();
            String namePatient = tabPatient[0];
            String lastNamePatient = tabPatient[1];
            String nameDoctor = tabDoctor[0];
            String lastNameDoctor = tabDoctor[1];

            String RESULT = "podsumowanie_wizyty.pdf";

            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(RESULT));        
                document.open();
                document.add(new Paragraph("Podsumowanie wizyty", FontFactory.getFont(FontFactory.TIMES_BOLD, BaseFont.CP1250, 18, Font.BOLD, BaseColor.DARK_GRAY)));        
                document.add(new Paragraph("-------------------------------------"
                        + "-----------------------------------------------------"
                        + "--------",f));
               
                document.add(new Paragraph(" ",f));                
                String txt = "------- Pacjent: "
                        +namePatient+" "
                        +lastNamePatient+"";
                document.add(new Paragraph(txt,f));
                
                txt = "------- Nr ubezpieczenia:  "
                        +txtNrUbezpDodWiz.getText()+"";
                document.add(new Paragraph(txt,f));
                
                document.add(new Paragraph(" ",f));
                
                txt = "------- Rozpoznane choroby: "
                        +txtChorobaDodWiz1.getText()+", "
                        +txtChorobaDodWiz2.getText()+", "
                        +txtChorobaDodWiz3.getText()+"";
                document.add(new Paragraph(txt,f));
                
                document.add(new Paragraph("\n",f));
                document.add(new Paragraph("------- Dawkowanie lekarstw:\n\n",f));

                PdfPTable table = new PdfPTable(3);

                PdfPCell cellTitle;
                table.setWidthPercentage(100);
                cellTitle = new PdfPCell(new Phrase("Nazwa", FontFactory.getFont(FontFactory.HELVETICA_BOLD, BaseFont.CP1250, 14, Font.BOLD, BaseColor.DARK_GRAY)));
                cellTitle.setPadding(15.0f);
                cellTitle.setBorder(Rectangle.NO_BORDER);
                table.addCell(cellTitle);
                
                cellTitle = new PdfPCell(new Phrase("Dawkowanie", FontFactory.getFont(FontFactory.HELVETICA_BOLD, BaseFont.CP1250, 14, Font.BOLD, BaseColor.DARK_GRAY)));
                cellTitle.setPadding(15.0f);
                cellTitle.setBorder(Rectangle.NO_BORDER);
                table.addCell(cellTitle);
                
                cellTitle = new PdfPCell(new Phrase("Okres przyjmowania", FontFactory.getFont(FontFactory.HELVETICA_BOLD, BaseFont.CP1250, 14, Font.BOLD, BaseColor.DARK_GRAY)));
                cellTitle.setPadding(15.0f);
                cellTitle.setBorder(Rectangle.NO_BORDER);
                table.addCell(cellTitle);

                PdfPCell cell;
                
                cell = new PdfPCell(new Phrase(txtNazwaDodWiz1.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);                
                cell = new PdfPCell(new Phrase(txtDawkowanieDodWiz1.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtOkresDodWiz1.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(txtNazwaDodWiz2.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtDawkowanieDodWiz2.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtOkresDodWiz2.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(txtNazwaDodWiz3.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtDawkowanieDodWiz3.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtOkresDodWiz3.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(txtNazwaDodWiz4.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtDawkowanieDodWiz4.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtOkresDodWiz4.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(txtNazwaDodWiz5.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtDawkowanieDodWiz5.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(txtOkresDodWiz5.getText(),f));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setPadding(10.0f);
                table.addCell(cell);

                document.add(table);                
                
                document.add(new Paragraph("\n\n",f));
                
                txt = "------- Lekarz: "
                        +nameDoctor+" "
                        +lastNameDoctor+" ";
                document.add(new Paragraph(txt,f));
                
                txt = "------- Data wystawienia: "
                        +getDateValue(txtDataDodWiz)+"";
                document.add(new Paragraph(txt,f));
                
                document.add(new Paragraph(" ",f));
                document.add(new Paragraph("-------------------------------------"
                        + "-----------------------------------------------------"
                        + "--------",f));

                document.close();
            }
            catch(FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Plik nie został odnaleziony. Sprawdź ścieżkę pliku. " + ex);
            }
            catch(DocumentException ex) {
                JOptionPane.showMessageDialog(null, "Błąd pliku. " + ex);
            }

            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("D:/INFORMATICS/Projects Java/DBPrzychodnia2/podsumowanie_wizyty.pdf");
                    Desktop.getDesktop().open(myFile);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Błąd podczas uruchamiania pliku. Sprawdź ścieżkę pliku." + ex);
                }
            }
        } else {
                JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie pola oznaczone '*' (gwiazdką).");
        }
    }//GEN-LAST:event_btnDrukujPodsumowanieDodWizActionPerformed

    //tablica zawiera ID przepisanych lekarstw
    int[] medicineList = new int[5];
    
    //porownuje ID nowo przepisanego leku z ID lekarstw w tablicy 
    //szuka konfliktowej pary i zglasza komunikat gdy znajdzie taka pare
    public boolean checkConflict(int newMedicineID, int IDList) {
        
        // flaga okreslajaca czy dodac lek do listy jesli nie bedzie konfliktowy
        int flag = 1; 
        
        for(int medicineID : medicineList ) {
            
            lista2.setColumnCount(0);
            lista2.setRowCount(0);

            cn.connect();
            String sql = "SELECT * FROM lekarstwa_konfliktowe "
                    + "WHERE (id_lekarstwa1 =  '" + medicineID + "' AND id_lekarstwa2 =  '" + newMedicineID + "') "
                    + "OR (id_lekarstwa1 = '" + newMedicineID + "' AND id_lekarstwa2 =  '" + medicineID + "') " ;
            cn.executeQuerying(sql);

            try {
                while(cn.rs.next()) {  
                    String description = cn.rs.getString("opis");
                    int resp = JOptionPane.showConfirmDialog(null, "Lekarstwa '"+ description +"' nie mogą być łączone!\n"
                            + "Czy mimo to dodać do listy przepisanych lekarstw?");
                    
                    if(resp == JOptionPane.YES_OPTION) {
                        flag = 1; //dodac do listy
                    } else {
                        flag = 0; 
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Błąd podczas przeglądania bazy danych: " + ex);
            }
        }        
        
        if(flag == 0) {
            return false; //zwraca polecenie wyczyszczenia pol
        } else {    
            medicineList[IDList] = newMedicineID; //dodanie do listy
            return true; //pozostawia lek w polach
        }
    }
/*    */
    private void btnUsun1DodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsun1DodWizActionPerformed
        
        //jesli wyczyszcze pola wybranego lekarstwa musze rowniez usunac go 
        //z listy wybranych lekarstw
        medicineList[0] = 0;
        cleanMedField(1);
    }//GEN-LAST:event_btnUsun1DodWizActionPerformed

    private void btnUsun2DodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsun2DodWizActionPerformed
        
        medicineList[1] = 0;
        cleanMedField(2);
    }//GEN-LAST:event_btnUsun2DodWizActionPerformed

    private void btnUsun3DodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsun3DodWizActionPerformed
        
        medicineList[2] = 0;
        cleanMedField(3);
    }//GEN-LAST:event_btnUsun3DodWizActionPerformed

    private void btnUsun4DodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsun4DodWizActionPerformed
        
        medicineList[3] = 0;
        cleanMedField(4);
    }//GEN-LAST:event_btnUsun4DodWizActionPerformed

    private void btnUsun5DodWizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsun5DodWizActionPerformed
        
        medicineList[4] = 0;
        cleanMedField(5);
    }//GEN-LAST:event_btnUsun5DodWizActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVisits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnulujDodWiz;
    private javax.swing.JButton btnDodajWizyteDodWiz;
    private javax.swing.JButton btnDrukujPodsumowanieDodWiz;
    private javax.swing.JButton btnDrukujRecepteDodWiz;
    private javax.swing.JButton btnUsun1DodWiz;
    private javax.swing.JButton btnUsun2DodWiz;
    private javax.swing.JButton btnUsun3DodWiz;
    private javax.swing.JButton btnUsun4DodWiz;
    private javax.swing.JButton btnUsun5DodWiz;
    private javax.swing.JButton btnWyszukajWizyteDodWiz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelaDodWiz;
    private javax.swing.JTextField txtChorobaDodWiz1;
    private javax.swing.JTextField txtChorobaDodWiz2;
    private javax.swing.JTextField txtChorobaDodWiz3;
    private com.toedter.calendar.JDateChooser txtDataDodWiz;
    private javax.swing.JTextField txtDawkaDodWiz1;
    private javax.swing.JTextField txtDawkaDodWiz2;
    private javax.swing.JTextField txtDawkaDodWiz3;
    private javax.swing.JTextField txtDawkaDodWiz4;
    private javax.swing.JTextField txtDawkaDodWiz5;
    private javax.swing.JTextField txtDawkowanieDodWiz1;
    private javax.swing.JTextField txtDawkowanieDodWiz2;
    private javax.swing.JTextField txtDawkowanieDodWiz3;
    private javax.swing.JTextField txtDawkowanieDodWiz4;
    private javax.swing.JTextField txtDawkowanieDodWiz5;
    private javax.swing.JTextField txtGodzinaDodWiz;
    private javax.swing.JTextField txtIDLekarstwaDodWiz1;
    private javax.swing.JTextField txtIDLekarstwaDodWiz2;
    private javax.swing.JTextField txtIDLekarstwaDodWiz3;
    private javax.swing.JTextField txtIDLekarstwaDodWiz4;
    private javax.swing.JTextField txtIDLekarstwaDodWiz5;
    private javax.swing.JTextField txtIDLekarzaDodWiz;
    private javax.swing.JTextField txtNazwaDodWiz1;
    private javax.swing.JTextField txtNazwaDodWiz2;
    private javax.swing.JTextField txtNazwaDodWiz3;
    private javax.swing.JTextField txtNazwaDodWiz4;
    private javax.swing.JTextField txtNazwaDodWiz5;
    private javax.swing.JTextField txtNotatkaDodWiz;
    private javax.swing.JTextField txtNrUbezpDodWiz;
    private javax.swing.JTextArea txtObjawyDodWiz;
    private javax.swing.JTextField txtOkresDodWiz1;
    private javax.swing.JTextField txtOkresDodWiz2;
    private javax.swing.JTextField txtOkresDodWiz3;
    private javax.swing.JTextField txtOkresDodWiz4;
    private javax.swing.JTextField txtOkresDodWiz5;
    private javax.swing.JTextField txtRozpoznanieIDDodWiz1;
    private javax.swing.JTextField txtRozpoznanieIDDodWiz2;
    private javax.swing.JTextField txtRozpoznanieIDDodWiz3;
    // End of variables declaration//GEN-END:variables
}
