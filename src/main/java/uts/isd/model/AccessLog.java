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
public class AccessLog implements Serializable {
    private String dateTime, type;
    private int id;
    public AccessLog(int id, String dateTime, String type) {
        this.id = id;
        this.dateTime = dateTime;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public String getDateTime() {
        return dateTime;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return dateTime + " " + type;
    }
}
