/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.*;
/**
 *
 * @author Clare
 */
public class Customer extends User implements Serializable {
    private String customerId;

    public Customer(String name, String email, String password, String gender, String dob, String phone, String address) {
        super(name, email, password, gender, dob, phone, address);
    }

    public String getCustomerId() {
        return customerId;
    }
}
