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
    
    
    //finds order using orderid and userid
    public Orders findOrder(int orderID, int userID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDER_ID = " + orderID + " and USER_ID='" + userID + "'";
        ResultSet rs = st.executeQuery(fetch);
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
    
    //add order to assigned USER
    public void addOrder(Orders order) throws SQLException {
        String a = "INSERT INTO IOTUSER.\"ORDER\" (ID,PROD_ID,ORDER_DATE,ORDER_DETAILS,ORDERER_NAME,QUANTITY,PRICE,TOTAL_PRICE,BILLING_ADDRESS,SHIPPING_ADDRESS,STATUS)";
        String b=  "VALUES (" +order.getUserID()+"," +order.getProdID()+",'" +order.getOrderDate()+"','" +order.getOrderDetails()+"','" +order.getOrdererName()+"'," +order.getQuantity()+"," +order.getPrice()+"," +order.getTotalPrice()+",'" +order.getBillingAddress()+"','" +order.getShippingAddress()+"','" +order.getStatus()+"')";
        st.executeUpdate(a +b);

    }
    
    //use all values to update order
    public void updateOrder(int ORDER_ID, int ID, String ORDER_DATE, String ORDER_DETAILS, String ORDERER_NAME, int QUANTITY, double PRICE,double TOTAL_PRICE,String BILLING_ADDRESS,String SHIPPING_ADDRESS, String STATUS) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.\"ORDER\" SET ORDERDATE='"+ORDER_ID+"',ID="+ID+",ORDER_DATE="+ORDER_DATE+",ORDER_DETAILS='"+
                ORDER_DETAILS+",ORDERER_NAME='"+ORDERER_NAME+"',QUANTITY="+QUANTITY+",PRICE="+PRICE+",TOTALPRICE="+TOTAL_PRICE+",BILLING_ADDRESS='"+BILLING_ADDRESS+"',SHIPPING_ADDRESS='"+SHIPPING_ADDRESS+"',STATUS='"+STATUS+"' WHERE ORDER_ID="+ORDER_ID+" AND ID="+ID+"");
    }
    
  
    //set order to cancelled
    public void cancelOrder(int ORDER_ID) throws SQLException{
        st.executeUpdate("UPDATE IOTUSER.\"ORDER\" SET STATUS='Cancelled' WHERE ORDER_ID=" +ORDER_ID+"");
    }
    
    //fetch product name from product table
    public String fetchProductName(int PROD_ID) throws SQLException{
       ResultSet rs = st.executeQuery("SELECT PRODUCT_NAME FROM IOTUSER.PRODUCT WHERE PROD_ID = "+PROD_ID+"");
       rs.next();
       return rs.getString(1);
    }
    
    
    
    //fetching order using USERID
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