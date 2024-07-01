/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical.pkg4;

/**
 *
 * @author MATEBOOK D15
 */
public class Programme {
    String code;
    String name;
    String faculty;

  
    public Programme() {
        
    }
    
     public Programme(String code, String name, String faculty) {
        this.code = code;
        this.name = name;
        this.faculty = faculty;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
     
     
}
