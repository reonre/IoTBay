/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.*;

/**
 *
 * @author ben's pc
 *
 */
 public class Admin extends User implements Serializable {

 public Admin(String name, String email, String password, String gender, String dob, String phone, String address) {
        super(name, email, password, gender, dob, phone, address);
    }
 }
