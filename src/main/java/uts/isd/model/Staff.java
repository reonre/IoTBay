package uts.isd.model;
import java.io.*;

public class Staff extends User {
    private String role;
    
    public Staff() {}
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}