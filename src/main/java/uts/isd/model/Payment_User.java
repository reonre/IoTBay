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


public class Payment_User implements Serializable{
    public String username;
    public String password;
   
    
    // insert a constructor that initialies the fields
    public Payment_User( String username, String password) {
       this.username = username;
       this.password = password;
    }
    
    
    public Payment_User() {}
    // insert getters/setters
 
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
