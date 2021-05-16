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
    private int PROD_ID;
    private String ORDER_DATE;
    private String ORDER_DETAILS;
    private String ORDERER_NAME;
    private double TOTAL_PRICE;
    private int QUANTITY;
    private double PRICE;
    private String BILLING_ADDRESS;
    private String SHIPPING_ADDRESS;
    private String STATUS;

    
    
//    public Orders() {
//    
//    }

    public Orders(int ORDER_ID, int USER_ID,int PROD_ID,String ORDER_DATE,String ORDER_DETAILS,String ORDERER_NAME, int QUANTITY, double PRICE,double TOTAL_PRICE, String BILLING_ADDRESS, String SHIPPING_ADDRESS, String STATUS) {
        this.ORDER_ID=ORDER_ID;
        this.USER_ID=USER_ID;
        this.PROD_ID=PROD_ID;
        this.ORDER_DATE=ORDER_DATE;
        this.ORDER_DETAILS=ORDER_DETAILS;
        this.ORDERER_NAME=ORDERER_NAME;
        this.TOTAL_PRICE=TOTAL_PRICE;
        this.QUANTITY=QUANTITY;
        this.PRICE=PRICE;
        this.BILLING_ADDRESS=BILLING_ADDRESS;
        this.SHIPPING_ADDRESS=SHIPPING_ADDRESS;   
        this.STATUS=STATUS;
    }
    
//    public Orders(int ID){
//        this.USER_ID=ID;
//        
//    }
   
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
    
    public int getProdID(){
        return PROD_ID;
    }
    
//    public String getPRODNAME(int PROD_ID){
//        Product product = new Product();
//        String name= Product
//       return 
//    }
    
    public void setProdID(int PRODID){
        this.PROD_ID=PRODID;
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
    
    public String getOrderDetails(){
        return ORDER_DETAILS;
    }

    public double getTotalPrice() {
        double total= (double)PRICE*(double)QUANTITY;
        return total;
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
    
    public String getStatus(){
        return STATUS;
    }
    
}
    

