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
    public Orders findOrder(int oID, int uID) throws SQLException {
        String fetch = "select * from IOTUSER.ORDERS where orderID = " + oID + " and userID='" + uID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        
        //reads data from Users Table, then stores them into ORDER
        while (rs.next()) {  
            int orderID = rs.getInt(1);
            int userID = rs.getInt(2);
            if (orderID == oID && userID == uID) {
                String DATE_ORDER_PLACED = rs.getString(3);
                double totalPrice = rs.getDouble(5);
                String Address = rs.getString(6);
                return new Orders(orderID, userID, DATE_ORDER_PLACED, totalPrice, Address);
                
            }
            
        }
        return null;
    }
    
    //adds order using order id and user id
    public void addOrder(int orderID, int userID) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.ORDERS VALUES ("+orderID+", '" +userID+"', null, null, null, null, null)");
              
       
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
            temp.add(new Orders(orderID, userID, orderDate, totalPrice, Address));
        }
        return temp;
    }
    
    
    
}