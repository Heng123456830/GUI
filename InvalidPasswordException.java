/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

/**
 *
 * @author MATEBOOK D15
 */
public class InvalidPasswordException extends Exception{

    public InvalidPasswordException() {
        super("Invalid Password");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
    
}
