/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author MATEBOOK D15
 */
public class P3Q3 extends JFrame {

    private JLabel lblInterestRate = new JLabel("Annual Interest Rate");
    private JLabel lblYears = new JLabel("Numbers of Years");
    private JLabel lblLoan = new JLabel("Loan Amount");
    private JLabel lblPayment = new JLabel("Monthly Payment");
    private JLabel lblTotalPayment = new JLabel("Total Payment");
    private JTextField txt1Field = new JTextField();
    private JTextField txt2Field = new JTextField();
    private JTextField txt3Field = new JTextField();
    private JTextField txt4Field = new JTextField();
    private JTextField txt5Field = new JTextField();
    private JButton btn = new JButton("Compute Payment");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    public P3Q3() {
       panel1.setBorder(new TitledBorder("Enter loan amount , interest rate , and year"));
       //panel1.setBorder(new LineBorder(Color.GREEN,20));
       
        panel1.setLayout(new GridLayout(5, 2));
        //panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.setLayout(new GridLayout(1,2));


        btn.addActionListener(new buttonListener());
        panel1.add(lblInterestRate);
        panel1.add(txt1Field);
        panel1.add(lblYears);
        panel1.add(txt2Field);
        panel1.add(lblLoan);
        panel1.add(txt3Field);
        panel1.add(lblPayment);
        txt4Field.setEditable(false);
        panel1.add(txt4Field);
        panel1.add(lblTotalPayment);
        txt5Field.setEditable(false);
        panel1.add(txt5Field);
        panel2.add(new JLabel());
        panel2.add(btn);

        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        setTitle("LoanCalculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double interest = 0;
            int year = 0;
            double loanAmount = 0;

            try {
                interest = Double.parseDouble(txt1Field.getText());
                year = Integer.parseInt(txt2Field.getText());
                loanAmount = Double.parseDouble(txt3Field.getText());
                
                Loan loan=new Loan(interest,year,loanAmount);
                txt4Field.setText(String.format("%.2f" , loan.getMonthlyPayment()));
                txt5Field.setText(String.format("%.2f" + loan.getTotalPayment()));

            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please input number Only", "Error", JOptionPane.ERROR_MESSAGE);
            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, "Please input correct inerestRate , year and loanAoumt", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public static void main(String[] args) {
        new P3Q3();
    }

}
