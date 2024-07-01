/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical.pkg4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MATEBOOK D15
 */
public class ProrgammeDataAccess {

    private String hostname = "jdbc:derby://localhost:1527/collegedb";
    private String username = "nbuser";
    private String password = "nbuser";
    private String tableName = "Programme";
    private Connection conn;
    private PreparedStatement stmt;

    public ProrgammeDataAccess() {
        createConnection();

    }

    public void addRecord(Programme Prog) {
        try{
             String sql = "INSERT INTO " + tableName + " VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, Prog.getCode());
        stmt.setString(2, Prog.getName());
        stmt.setString(3, Prog.getFaculty());
        stmt.executeUpdate();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
       
    }

    public Programme selectRecordByCode(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        ResultSet rs = null;
        Programme Prog = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return Prog;
    }

    public void updateRecord(Programme Prog) {

    }

    public void deleteRecord(String code) {

    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(hostname, username, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
