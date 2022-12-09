/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author yukit
 */
public class Researcher {
 
    private int researcher_ID;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String institution;

    public Researcher(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Researcher() {
    }

    public Researcher(int researcher_ID) {
        this.researcher_ID = researcher_ID;
    }

    public Researcher(String username,String name,String lastname,String email,String password,String institution) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.lastname = lastname;
        this.password = password;
        this.institution = institution;
    }

    public Researcher(int researcher_ID,String username,String name,String lastname,String email,String password,String institution) {
        this.researcher_ID = researcher_ID;
        this.name = name;
        this.username = username;
        this.email = email;
        this.lastname = lastname;
        this.password = password;
        this.institution = institution;
    }

    public int getResearcher_ID() {
        return researcher_ID;
    }

    public void setResearcher_ID(int researcher_ID) {
        this.researcher_ID = researcher_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "Researcher{" + "researcher_ID=" + researcher_ID + ", username=" + username + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", institution=" + institution + '}';
    }
    
}
