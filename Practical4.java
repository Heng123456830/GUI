/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical.pkg4;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class Practical4 extends JFrame {

    private String hostname = "jdbc:derby://localhost:1527/collegedb";
    private String username = "nbuser";
    private String password = "nbuser";
    private String tableName = "Programme";
    private Connection conn;
    private PreparedStatement stmt;
    private JTextField jtfCode = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public Practical4() {

        JPanel jpCenter = new JPanel(new GridLayout(3, 2));
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfCode);
        jpCenter.add(new JLabel("Programme Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Faculty"));
        jpCenter.add(jtfFaculty);
        add(jpCenter);
        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);
        jbtAdd.addActionListener(new CreateListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());

        setTitle("Programme CRUD");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        createConnection();
    }

    public ResultSet selectRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    private class CreateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String code = jtfCode.getText();
            String name = jtfName.getText();
            String faculty = jtfFaculty.getText();

            ResultSet rs = selectRecord(code);
            try {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Programme code already exist.", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    String sql = "INSERT INTO " + tableName + " VALUES (?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, code);
                    stmt.setString(2, name);
                    stmt.setString(3, faculty);
                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "The record is created successful", "success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            String name = jtfName.getText();
            String faculty = jtfFaculty.getText();

            ResultSet rs = selectRecord(code);
            try {
                if (rs.next()) {

                    String sql = "UPDATE " + tableName + " SET  name =? , faculty =? WHERE code = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setString(2, faculty);
                    stmt.setString(3, code);
                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "The record is updated successful", "success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Programme code does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();

            String sql = "DELETE FROM " + tableName + " WHERE CODE=? ";
            ResultSet rs = selectRecord(code);
            try {
               
                if (rs.next()) {
                    int option = JOptionPane.showConfirmDialog(null, "Are you sure to delete the record ?");
                    
                    if(option == JOptionPane.YES_OPTION){
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, code);
                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "The record is deleted successfully", "success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "The record does not exits", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String code = jtfCode.getText();

                ResultSet rs = selectRecord(code);
                if (rs.next()) {
                    jtfName.setText(rs.getString("Name"));
                    jtfFaculty.setText(rs.getString("Faculty"));

                } else {
                    JOptionPane.showMessageDialog(null, "No such programme code.",
                            "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(hostname, username, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null)
     try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Practical4();

    }
}
