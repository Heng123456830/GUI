/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author MATEBOOK D15
 */
public class CustomPanel extends JPanel {

    public CustomPanel(String btn1, String btn2) {
        setLayout(new GridLayout(1,2));
        add(new JButton(btn1));
        add(new JButton(btn2));
        
        
    }
    
}
