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

/**
 *
 * @author MATEBOOK D15
 */
public class StudentInfoFrame extends JFrame {
    JButton submitButton= new JButton("Button");
    JLabel jlblRegNo = new JLabel("Regsitration number");
    JTextField jtxtFRegNo = new JTextField();
    JLabel jlblName = new JLabel("Name");
    JTextField jtxtName = new JTextField();
    JLabel jlblProgrammeCode = new JLabel("Programme code");
    JTextField jtxtProgrammeCode = new JTextField();
    

    public StudentInfoFrame() {
        this.setLayout(new GridLayout(4,2));
        this.add(new JLabel("Regsitration number"));
        this.add(jtxtFRegNo);
        this.add(jlblName);
        this.add(jtxtName);
        this.add(jlblProgrammeCode);
        this.add(jtxtProgrammeCode);
        this.add(submitButton);

      
        this.setSize(500, 600);
        this.setTitle("Stduent Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame go to center on the screen
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentInfoFrame();
    }
}
