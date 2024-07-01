/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import javax.swing.JPanel;

/**
 *
 * @author MATEBOOK D15
 */
public class Practical1Q5 extends JFrame {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    public Practical1Q5() {
        this.setLayout(new FlowLayout());
        panel1.add(new JButton("ONE"));
        panel1.add(new JButton("two"));
        panel2.add(new JButton("three"));
        panel2.add(new JButton("four"));
        
        this.add(panel1);
        this.add(panel2);

        this.setSize(500, 600);
        this.setTitle("Stduent Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame go to center on the screen
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Practical1Q5();
    }

}
