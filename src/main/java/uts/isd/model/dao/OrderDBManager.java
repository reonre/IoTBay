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
        String a = "INSERT INTO IOTUSER.\"ORDER\" (ID,PROD_ID,ORDER_DATE,ORDER_DETAILS,ORDERER_NAME,QUANTITY,PRICE,TOTAL_PRICE,BILLING_ADDRESS,SHIPPING_ADDRESS,STATUS)";
        String b=  "VALUES (" +order.getUserID()+"," +order.getProdID()+",'" +order.getOrderDate()+"','" +order.getOrderDetails()+"','" +order.getOrdererName()+"'," +order.getQuantity()+"," +order.getPrice()+"," +order.getTotalPrice()+",'" +order.getBillingAddress()+"','" +order.getShippingAddress()+"','" +order.getStatus()+"')";
        st.executeUpdate(a +b);
//        st.executeUpdate("INSERT INTO IOTUSER.ORDER VALUES (" +order.getUserID()+"," +order.getProdID()+",'" +order.getOrderDate()+"','" +order.getOrderDetails()+"','" +order.getOrdererName()+"'," +order.getQuantity()+"," +order.getPrice()+"," +order.getTotalPrice()+",'" +order.getBillingAddress()+"','" +order.getShippingAddress()+"','" +order.getStatus()+"')");

    }
    
//    public void addOrder(int ID, int PROD_ID, int ORDER_DATE, int productID, String productName, double totalPrice, double price) throws SQLException {
//        st.executeUpdate("INSERT INTO IOTBAY.ORDERLINE " + "VALUES (" +orderLineID+", " +orderID+", "+quantity+", "+productID+", '"+productName+"', "+totalPrice+", "+ price+")");
//    }
    
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
   public ArrayList<Orders> fetchOrders(int userID) throws SQLException {
        String fetch = "select * from IOTUSER.\"ORDER\" where ID="+userID+"";
         ArrayList<Orders> temp = new ArrayList();
        ResultSet rs = st.executeQuery(fetch);
 
        
        while (rs.next()) {
            int ORDER_ID=Integer.parseInt(rs.getString(1));
            int PROD_ID=Integer.parseInt(rs.getString(3));
            String ORDER_DATE = rs.getString(4);
            String ORDER_DETAILS=rs.getString(5);
            String ORDERER_NAME=rs.getString(6);
            int QUANTITY=rs.getInt(9);
            double PRICE=rs.getDouble(10);
            double TOTAL_PRICE=rs.getDouble(11);
            String BILLING_ADDRESS=rs.getString(7);
            String SHIPPING_ADDRESS=rs.getString(8);
            String STATUS=rs.getString(12);
            temp.add(new Orders(ORDER_ID,userID,PROD_ID,ORDER_DATE,ORDER_DETAILS,ORDERER_NAME,QUANTITY,PRICE,TOTAL_PRICE,BILLING_ADDRESS,SHIPPING_ADDRESS,STATUS));
        }
        return temp;
    }
   
   
    
   
    
}