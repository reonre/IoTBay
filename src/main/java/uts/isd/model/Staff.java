package uts.isd.model;
import java.io.*;

public class Staff extends User {
    
    private String position;
    
    public Staff(int USER_ID, String name, String email, String password, String phone, String gender, String dob, String address, String position) {
        super(USER_ID, name, email, password, phone, gender, dob, address);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
    
    
}