/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MATEBOOK D15
 */
public class P3Q1 extends JFrame {

    private JLabel lblNum1 = new JLabel("Num1");
    private JLabel lblNum2 = new JLabel("Num2");
    private JLabel result = new JLabel("result");
    private JButton btnAdd = new JButton("ADD");
    private JButton btnSub = new JButton("SUB");
    private JButton btnMultiply = new JButton("MUL");
    private JButton btnDivide = new JButton("DIV");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();
    private JTextField resultTextField = new JTextField();

    public P3Q1() {
        panel1.setLayout(new GridLayout(3, 2));

        btnAdd.addActionListener(new ButtonListener());
        btnSub.addActionListener(new ButtonListener());
        btnMultiply.addActionListener(new ButtonListener());
        btnDivide.addActionListener(new ButtonListener());
        panel1.add(lblNum1);
        panel1.add(textField1);
        panel1.add(lblNum2);
        panel1.add(textField2);
        panel1.add(result);
        panel1.add(resultTextField);
        resultTextField.setEditable(false);
        panel2.add(btnAdd);
        panel2.add(btnSub);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        setTitle("Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAdd) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    // Perform addition
                    double resultValue = num1 + num2;
                    // Display result
                    resultTextField.setText(Double.toString(resultValue));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input number Only", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (e.getSource() == btnSub) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    // Perform subtraction
                    double resultValue = num1 - num2;
                    resultTextField.setText(Double.toString(resultValue));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input number Only", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (e.getSource() == btnMultiply) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    // Perform multiplication
                    double resultValue = num1 * num2;
                    // Display result
                    resultTextField.setText(Double.toString(resultValue));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input number Only", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    // Check if the second number is not zero to avoid division by zero error
                    if (num2 != 0) {
                        // Perform division
                        double resultValue = num1 / num2;
                        // Display result
                        resultTextField.setText(Double.toString(resultValue));
                    } else {
                        // Display error message if dividing by zero
                        resultTextField.setText("Error: Cannot divide by zero");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input number Only", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    public static void main(String[] args) {
        new P3Q1();
    }

}
