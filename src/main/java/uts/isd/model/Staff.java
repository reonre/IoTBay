package uts.isd.model;
import java.io.*;

public class Staff extends User {
    
    public Staff(int USER_ID, String name, String email, String password, String phone, String gender, String dob, String address) {
        super(USER_ID, name, email, password, phone, gender, dob, address);
    }
    
    
}