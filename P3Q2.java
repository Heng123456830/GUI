/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
public class P3Q2 extends JFrame {

    private int[] intArray = new int[100];
    private JLabel labelArray = new JLabel("Array Index");
    private JLabel labelElement = new JLabel("Array Element");
    private JButton btnElement = new JButton("Show Element");
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    public P3Q2() {
        initializeArray();
        panel1.setLayout(new GridLayout(2, 2));
        panel2.setLayout(new GridLayout(1, 1));

        btnElement.addActionListener(new showElementListener());
        panel1.add(labelArray);
        panel1.add(tf1);
        panel1.add(labelElement);
        panel1.add(tf2);
        panel2.add(btnElement);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        setTitle("Display:Show Bounds Error");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeArray() {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 1000);
        }
    }

    private class showElementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int index = Integer.parseInt(tf1.getText());
                tf2.setText("" + intArray[index]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                tf2.setText("OUT OF BOUNDS!");

            }catch(NumberFormatException ex){
                tf2.setText("please input the number Only!");
            }

        }
    }

    public static void main(String[] args) {
        new P3Q2();

    }
}
