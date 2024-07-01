/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 *
 * @author MATEBOOK D15
 */
public class P1Q6 extends JFrame {

//    JPanel panel1 = new JPanel();
//    JPanel panel2 = new JPanel();

    public P1Q6() {
         //6
//        panel1.setLayout(new GridLayout(1, 2));
//        panel1.add(new JButton("ONE"));
//        panel1.add(new JButton("two"));
//        panel2.setLayout(new GridLayout(1, 2));
//        panel2.add(new JButton("three"));
//        panel2.add(new JButton("four"));
//
//        this.add(panel1, BorderLayout.CENTER);
//        this.add(panel2, BorderLayout.SOUTH);

         this.add( new CustomPanel("1","2"), BorderLayout.CENTER);
         this.add( new CustomPanel("3","4"), BorderLayout.SOUTH);
         

        this.setSize(500, 600);
        this.setTitle("Stduent Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame go to center on the screen
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new P1Q6();
    }

}
