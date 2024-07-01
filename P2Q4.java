/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package P2;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author limju
 */
public class P2Q4 extends JFrame{

    private ArrayList<String> studentList = new ArrayList<String>();
    private JButton createBtn = new JButton("Create");
    private JButton retrieveBtn = new JButton("Retrieve");
    private JButton updateBtn = new JButton("Update");
    private JButton deleteBtn = new JButton("Delete");
    
    public P2Q4() {
        setLayout(new FlowLayout());
        add(createBtn);
        add(retrieveBtn);
        add(updateBtn);
        add(deleteBtn);
        
        setSize(400, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        createBtn.addActionListener(new CreateButtonListener());
        retrieveBtn.addActionListener(new RetrieveButtonListener());
        updateBtn.addActionListener(new UpdateButtonListener());
        deleteBtn.addActionListener(new DeleteButtonListener());
    }
    
    public String listStud() {
        StringBuilder studentStr = new StringBuilder();

        for (int i = 0; i < studentList.size(); i++) {
            String studentLn = String.format("%d.   %s\n", i+1, studentList.get(i));
            studentStr.append(studentLn);
        }

        return studentStr.toString();
    }
    
    private class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog("Enter new student's name:");
            
            if (input.length() > 0) {
                studentList.add(input);
                JOptionPane.showMessageDialog(null, listStud(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid name !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class RetrieveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, listStud(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int studNum = Integer.parseInt(JOptionPane.showInputDialog(listStud() + "\nPlease enter the number of student that you want to update:"));
            
            if (studNum > 0 && studNum < studentList.size()) {
                String newName = JOptionPane.showInputDialog(null, "Current student name is " + studentList.get(studNum - 1) + ". Enter updated name:", "Update Student", JOptionPane.INFORMATION_MESSAGE);
                
                if (!newName.isEmpty()) {
                    studentList.set(studNum - 1, newName);
                    JOptionPane.showMessageDialog(null, listStud(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid name !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int studNum = Integer.parseInt(JOptionPane.showInputDialog(listStud() + "\nPlease enter the number of student that you want to delete:"));
            
            if (studNum > 0 && studNum < studentList.size()) {
                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure to delete this student named \"" + studentList.get(studNum - 1) + "\"?", "Delete Student", JOptionPane.YES_NO_OPTION);
                
                if (confirmation == 0) {
                    String deletedStud = studentList.get(studNum - 1);
                    
                    studentList.remove(studNum - 1);
                    JOptionPane.showMessageDialog(null, "Student " + deletedStud + " has been deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, listStud(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete Process cancelled.", "Process Cancelled", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new P2Q4();
    }
}