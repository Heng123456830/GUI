/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical2;

/**
 *
 * @author MATEBOOK D15
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P2Q3 extends JFrame {

    private JLabel lblColor = new JLabel("COLOR");
    private JButton RedButton = new JButton("Red");
    private JButton GreenButton = new JButton("Green");
    private JButton BlueButton = new JButton("Blue");
    JPanel panel1 = new JPanel();

    public P2Q3() {
        lblColor.setHorizontalAlignment(JLabel.CENTER);
        lblColor.setFont(new Font("Calibri", Font.BOLD, 20));
        lblColor.setForeground(Color.BLUE);

        RedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblColor.setForeground(Color.red);
            }
        });
        GreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblColor.setForeground(Color.green);
            }
        });
        BlueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblColor.setForeground(Color.BLUE);
            }

        });

        this.add(lblColor, BorderLayout.CENTER);
        panel1.add(RedButton);
        panel1.add(GreenButton);
        panel1.add(BlueButton);
        add(panel1, BorderLayout.SOUTH);

        setTitle("Primary Color");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new P2Q3();
    }

}
