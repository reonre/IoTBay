/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.*;
/**
 *
 * @author Charl
 */
public class User implements Serializable {
    private int USER_ID;
    private String name, email, password, gender, dob, phone, address;
    private boolean active;

    public User(){}
    
    public User(String name, String email, String password, String gender, String dob, String phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }
    
    public User(int USER_ID, String name, String email, String password, String gender, String dob, String phone, String address) {
        this.USER_ID = USER_ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }
    
    public void updateInfo(String name, String email, String password, String gender, String dob, String phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }

    public int getUserId() {
        return USER_ID;
    }
    
    public void setUserId(int userId) {
        this.USER_ID = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public char getAccountType() {
        return this.getClass().getSimpleName().charAt(0);
    }

    // Used in sub classes
    public boolean isStaff() {
        return getAccountType() == 'S';
    }
    public boolean isCustomer() {
        return getAccountType() == 'C';
    }
}
