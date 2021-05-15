/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.*;
/**
 *
 * @author leon
 */
public class Orders implements Serializable{
    private static int numberOfOrders = 0;
    private int orderID;
    private int userID;
    private double totalPrice;
    private String Address;
    private String DATE_ORDER_PLACED;
    
    
    public Orders() {
    
    }

    public Orders(int userID) {
        
        this.orderID = Orders.numberOfOrders;
        Orders.numberOfOrders++;
        this.userID = userID;
    }

    public Orders(int orderID, int userID, String DATE_ORDER_PLACED, double totalPrice, String Address) {
        this.orderID = orderID;
        this.userID = userID;
        this.DATE_ORDER_PLACED = DATE_ORDER_PLACED;
        this.totalPrice = totalPrice;
        this.Address = Address;
    }
    
    
    public int getOrderID() {
        return orderID;
    }
    
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getOrderDate() {
        return DATE_ORDER_PLACED;
    }

    public void setOrderDate(String orderDate) {
        this.DATE_ORDER_PLACED = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    
    public void updatePrice(double price, int quantity) {
        this.totalPrice = this.totalPrice + (price*quantity);
    }
    
    public void deleteOrderLine(double totalPrice) {
        this.totalPrice = this.totalPrice - totalPrice;
    }
    
}
