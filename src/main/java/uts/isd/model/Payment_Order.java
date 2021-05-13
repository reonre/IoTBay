/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;
/**
 *
 * @author casio
 */    
public class Payment_Order implements Serializable{
    private Double amount;
    //private String username;
   
    
    // insert a constructor that initialies the fields
    public Payment_Order(Double amount) {
        this.amount = amount;
        //this.username = username;
    }
    
    
    public Payment_Order() {}
    // insert getters/setters
 
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
//    public String getUsername() {
//        return username;
//    }
//    public void setUsername(String username) {
//        this.username = username;
//    }

    
}
