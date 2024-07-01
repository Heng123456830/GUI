/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical1;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 *
 * @author MATEBOOK D15
 */
public class Practical1Q2 extends JFrame{
        
        
   private  JButton jbtHello= new JButton("Hello");
    public Practical1Q2() {
        this.add(jbtHello);
        
        this.setSize(500, 600);
        this.setTitle("One Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame go to center on the screen
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        new Practical1Q2();
      
    }
}
