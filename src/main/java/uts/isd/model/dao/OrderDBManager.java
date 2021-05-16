/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.Orders;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author leon
 */
public class OrderDBManager {
    private final Statement st; //used to execute SQL queries within java code
    
    public OrderDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    
    //finds order with order id and userid
    public Orders findOrder(int orderID, int userID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDER_ID = " + orderID + " and USER_ID='" + userID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        
        //reads data from Users Table, then stores them into ORDERS
        while (rs.next()) {  
            int ORDER_ID = rs.getInt(1);
            int USER_ID = rs.getInt(2);
            int PROD_ID=rs.getInt(3);
            
        String ORDER_DATE = rs.getString(4);
        String ORDER_DETAILS=rs.getString(5);
        String ORDERER_NAME=rs.getString(6);
        int QUANTITY=rs.getInt(7);
        double PRICE=rs.getDouble(8);
        double TOTAL_PRICE=rs.getDouble(9);
        String BILLING_ADDRESS=rs.getString(10);
        String SHIPPING_ADDRESS=rs.getString(11);
        String STATUS=rs.getString(12);
  
                return new Orders(ORDER_ID,USER_ID,PROD_ID,ORDER_DATE,ORDER_DETAILS,ORDERER_NAME,QUANTITY,PRICE,TOTAL_PRICE,BILLING_ADDRESS, SHIPPING_ADDRESS,STATUS);
        }
        return null;
    }
    
    //adds order using order id and user id
    public void addOrder(Orders order) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.ORDERS VALUES (" +order.getUserID()+"," +order.getProdID()+",'" +order.getOrderDate()+"','" +order.getOrderDetails()+"','" +order.getOrdererName()+"'," +order.getQuantity()+"," +order.getPrice()+"," +order.getTotalPrice()+",'" +order.getBillingAddress()+"','" +order.getShippingAddress()+"','" +order.getStatus()+"')");
       
    }
    
    //updates order with all variables
    public void updateOrder(int orderID, int userID, String orderDate, double totalPrice, String Address) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.ORDERS SET ORDERDATE='"+orderDate+",TOTALPRICE="+totalPrice+",ADDRESS='"+
                Address+"' WHERE ORDERID="+orderID + " AND USERID='"+userID+"'");
    }
    
    //delete order using ORDERID from order table
    public void deleteOrder(int orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.ORDERS WHERE ORDERID=" +orderID+"");
    }
    //fetches order using userID
    public ArrayList<Orders> fetchOrder(int userID) throws SQLException {
        String fetch = "select * from ORDER where USERID='"+userID+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Orders> temp = new ArrayList();
        
        //reads data from user table, then stores into order. use controller and view to show order
        while (rs.next()) { 
            int orderID = rs.getInt(1);
            String orderDate = rs.getString(3);
            double totalPrice = rs.getDouble(4);
            String Address = rs.getString(5);
//            temp.add(new Orders(orderID, userID, orderDate, totalPrice, Address));
        }
        return temp;
    }
    
    
    
}