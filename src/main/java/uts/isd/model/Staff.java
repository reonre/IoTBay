package uts.isd.model;
import java.io.*;

public class Staff extends User {
    
    private String position;
    
    public Staff(int USER_ID, String name, String email, String password, String phone, String gender, String dob, String address, String position) {
        super(USER_ID, name, email, password, phone, gender, dob, address);//Identifting the Super class of this class.
        this.position = position;//Instantiating postition witihn this constructor.
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
    
}