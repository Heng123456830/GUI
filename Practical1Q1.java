/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical1;

import javax.swing.JOptionPane;

/**
 *
 * @author MATEBOOK D15
 */
public class Practical1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //a
        String userInput = JOptionPane.showInputDialog("please input Fahrenheit");
        double fahrenheit = Double.parseDouble(userInput);

        double celsius = (5.0 / 9.0) * (fahrenheit - 32);

        JOptionPane.showMessageDialog(null, "Temperature in Celsiues : " + celsius);

        //b  
        int option=JOptionPane.YES_OPTION;
         while(option==JOptionPane.YES_OPTION){
        String userInput1 = JOptionPane.showInputDialog("Please input Fahrenheit");
        double fahrenheit1 = Double.parseDouble(userInput1);
        double celsius1 = 5.0/9.0 * (fahrenheit1-32);
        JOptionPane.showMessageDialog(null,"Temperature in Celsius are:  "+ celsius1);
        
        //Show Confirm Dialog,ask user to continue or not
       option = JOptionPane.showConfirmDialog(null, "DO you want to continue?");
         }

    }

}
