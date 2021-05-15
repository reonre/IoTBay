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
    private int ORDER_ID;
    private int USER_ID;
    private String ORDER_DATE;
    private String ORDER_DETAILS;
    private String ORDERER_NAME;
    private double TOTAL_PRICE;
    private int QUANTITY;
    private double PRICE;
    private String BILLING_ADDRESS;
    private String SHIPPING_ADDRESS;

    
    
//    public Orders() {
//    
//    }

    public Orders(int ORDER_ID, int USER_ID, String ORDER_DATE,String ORDER_DETAILS,String ORDERER_NAME, int QUANTITY, double PRICE,double TOTAL_PRICE, String BILLING_ADDRESS, String SHIPPING_ADDRESS) {
        this.ORDER_ID=ORDER_ID;
        this.USER_ID=USER_ID;
        this.ORDER_DATE=ORDER_DATE;
        this.ORDER_DETAILS=ORDER_DETAILS;
        this.ORDERER_NAME=ORDERER_NAME;
        this.TOTAL_PRICE=TOTAL_PRICE;
        this.QUANTITY=QUANTITY;
        this.PRICE=PRICE;
        this.BILLING_ADDRESS=BILLING_ADDRESS;
        this.SHIPPING_ADDRESS=SHIPPING_ADDRESS;   
    }
   
    public int getOrderID() {
        return ORDER_ID;
    }
    
    public void setOrderID(int ORDERID) {
        this.ORDER_ID = ORDERID;
    }
   

    public int getUserID() {
        return USER_ID;
    }

    public void setUserID(int USERID) {
        this.USER_ID= USERID;
    }

    public String getOrderDate() {
        return ORDER_DATE;
    }

    public void setOrderDate(String orderDate) {
        this.ORDER_DATE = orderDate;
        
        
    }
    
    public String getOrdererName(){
        return ORDERER_NAME;
    }

    public double getTotalPrice() {
        return TOTAL_PRICE;
    }

    public void setTotalPrice(double TOTAL_Price) {
        this.TOTAL_PRICE = TOTAL_Price;
    }

    public String getBillingAddress() {
        return BILLING_ADDRESS;
    }

    public void setBillingAddress(String BILLING_ADDRESS) {
        this.BILLING_ADDRESS = BILLING_ADDRESS;
    }
    
    public String getShippingAddress() {
        return SHIPPING_ADDRESS;
    }

    public void setShippingAddress(String SHIPPING_ADDRESS) {
        this.SHIPPING_ADDRESS = SHIPPING_ADDRESS;
    }
    
    public int getQuantity(){
        return QUANTITY;
    }
    
    public double getPrice(){
        return PRICE;
    }
    
//    public void updatePrice(double price, int quantity) {
//        this.totalPrice = this.totalPrice + (price*quantity);
//    }
//    
//    public void deleteOrderLine(double totalPrice) {
//        this.totalPrice = this.totalPrice - totalPrice;
//    }
//    
}
