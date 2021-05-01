package uts.isd.model;
import java.io.*;

/**
 *
 * @author oneilrangiuira
 */
public class Staff extends User implements Serializable {
    private String staffid;
    private String role;

    public Staff(String name, String email, String password, String gender, String dob, String phone, String address) {
        super(name, email, password, gender, dob, phone, address);
    }
    
    public String getStaffid() {
        return staffid;
    }  
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}