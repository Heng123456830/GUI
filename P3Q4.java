/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;


/**
 *
 * @author MATEBOOK D15
 */
public class P3Q4 extends JFrame {

    private JLabel labelPass = new JLabel("Enter your password");
    private JPasswordField PassField = new JPasswordField(15);
    private JLabel emptyLabel = new JLabel();
    private JButton btnSub = new JButton("Submit");
    private JTextArea textArea = new JTextArea(5,10);
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    public P3Q4() {
        panel1.setLayout(new GridLayout(2, 2));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnSub.addActionListener(new buttonListener());
        panel1.add(labelPass);
        panel1.add(PassField);
        panel1.add(emptyLabel);
        panel1.add(btnSub);
        panel2.add(textArea);
        panel2.setBackground(Color.WHITE);
        add(panel1, BorderLayout.CENTER);
        //specify the word in the textfield or textArea to next line if the sentence is too long
        //textArea.setLineWrap(true);
        textArea.setEditable(false);
        //make the whole word go down to next line together 
       // textArea.setWrapStyleWord(true);
        add(panel2, BorderLayout.SOUTH);

        setTitle("Set Password");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String inputPassword = PassField.getText();
            try{
                Password pw = new Password(inputPassword);
                textArea.setText("Congratulation ! Your password is valid!");
                textArea.setForeground(Color.BLUE);
                
            }catch(InvalidPasswordException ex){
                textArea.setText(ex.getMessage());
                textArea.setForeground(Color.red);
                //make the cursor to stay in the  textField after displaying error message
                PassField.grabFocus();
                
            }
            
        }
    }

   
    
    public static void main(String[] args) {
        new P3Q4();
    }

}
