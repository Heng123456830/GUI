/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

/**
 *
 * @author MATEBOOK D15
 */
public class Password {

    private String passwordStr;

    public Password(String passwordStr) throws InvalidPasswordException {
        this.passwordStr = passwordStr;

        if (passwordStr == null || passwordStr.isEmpty()) {
            throw new InvalidPasswordException("Password can not be null or empty");
        } else {
            int digitCount = 0, letterCount = 0;

            for (int i = 0; i < passwordStr.length(); i++) {
                char ch = passwordStr.charAt(i);
                if (Character.isDigit(ch)) {
                    digitCount++;
                } else if (Character.isLetter(ch)) {
                    letterCount++;
                }

            }
            int alphaNumeric = digitCount + letterCount;

            String errMsg = "";
            if (letterCount == 0) {
                errMsg += "Your password should have at least 1 letter\n";
            }
            if (digitCount == 0) {
                errMsg += "Your password should have at least 1 digit\n";

            }
            if (alphaNumeric < 7) {
                errMsg += "Your password should have at least 7 alpha-numeric character\n";

            }
            
            if(!errMsg.equals("")){
                throw new InvalidPasswordException(errMsg);
            }
        }
    }

}
