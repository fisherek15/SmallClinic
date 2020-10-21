/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbprzychodnia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class Connection {
   
    //jesli zgloszony zostanie ktorys z ponizszych wyjatkow ustawia true
    private boolean fullSucced;
    
    private java.sql.Connection connection;
    private Statement st;
    public ResultSet rs;
    
    String url = "jdbc:firebirdsql:localhost/3050:C:/baza/PRZYCHODNIA_006.fdb";
    String driver = "org.firebirdsql.jdbc.FBDriver";
    String login = "SYSDBA";
    String password = "masterkey";
    
    //sprawdza czy wystapij jakikolwiek blad
    public boolean checkSucced() {
        return fullSucced;
    }
    
    //ustawia flage wyjatkow do stanu poczatkowego
    public void zerosSucced() {
        fullSucced = false;
    }
    
    public void connect(){
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            fullSucced = true;
            JOptionPane.showMessageDialog(null, "Sterownik nie został "
                    + "załadowany do bazy. " + ex);
        } catch (SQLException sqlEx) {
            fullSucced = true;
            JOptionPane.showMessageDialog(null, "Błąd połączenia z bazą danych." + sqlEx);
            
        }        
    }
    
    public void disconnect() {
        
        try {
            connection.close();
            
        } catch (SQLException sqlEx) {
            fullSucced = true;
            JOptionPane.showMessageDialog(null, "Nie udało się rozłączyć z bazą danych." + sqlEx);
        }
    }
    
    public void executeUpdating(String sql) {
        
        try {
            st = connection.createStatement();
            st.executeUpdate(sql);
            
        } catch (SQLException sqlEx) {
            fullSucced = true;
            JOptionPane.showMessageDialog(null, "Nie udało się wykonać " + sql + ". \nBłąd " + sqlEx);
        }
    }
    
        public void executeQuerying(String sql) {
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            
        } catch (SQLException sqlEx) {
            fullSucced = true;
            JOptionPane.showMessageDialog(null, "Nie udało się wykonać " + sql + ". \nBłąd " + sqlEx);
        }
    }  
            
}
