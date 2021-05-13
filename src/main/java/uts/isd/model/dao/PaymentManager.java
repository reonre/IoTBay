/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Payment;

/**
 *
 * @author casio
 */
public class PaymentManager {
    private Statement st;

    public PaymentManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }


public int getPaymentId(String cardNumber) throws SQLException {
       int PAY_ID;
       String fetch = "select PAY_ID FROM IOTUSER.PAYMENT WHERE CREDIT_CARD_NO =  '"+ cardNumber +"'" ;
       ResultSet rs = st.executeQuery(fetch);
       if (rs.next()) {
            PAY_ID = rs.getInt(1);
            return PAY_ID;
       } else {
           return 0;
       }
    }
    
     //Find the paymentId in database -- used in Payment_DeleteServlet and Payment_EditServlet
     public Payment foundedPaymentId(int PAY_ID) throws SQLException {       
       String fetch = "select * from IOTUSER.PAYMENT WHERE PAY_ID = "+PAY_ID+" ";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           int payment_Id = rs.getInt(1);
           if(payment_Id == PAY_ID){
                String paymentMethod  = rs.getString(3);
                String cardNumber = rs.getString(4);
                String cvv = rs.getString(5);
                String nameOnCard = rs.getString(6);
                String expiryDate = rs.getString(7);
                String datePaid = rs.getString(8);
                return new Payment(paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid );
                }
           }
       return null;   
    }
     
    //Search paymnet by ID and datepaid in the database - Read one row in the database table - used in Payment_SearchServlet
    public Payment searchPayment(int PAY_ID, String datePaid) throws SQLException {       
       String fetch = "select * from IOTUSER.PAYMENT WHERE PAY_ID= " + PAY_ID + " AND DATE_PAID='" + datePaid + "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           int payment_Id = rs.getInt(1);
           String date_Paid = rs.getString(8);
           if(payment_Id == PAY_ID && date_Paid.equals(datePaid)){
                int invoice_Id = Integer.parseInt(rs.getString(2));
                String paymentMethod  = rs.getString(3);
                String cardNumber = rs.getString(4);
                String cvv = rs.getString(6);
                String expiryDate = rs.getString(5);
                String nameOnCard = rs.getString(7);
                return new Payment(paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid );
                }
           }
       return null;   
    }
    
    //Add a payment-data into the database - used in Payment_CreateServlet
    public void addPayment( int InvoiceId, String paymentMethod, String cardNumber, String expiryDate, String cvv, String nameOnCard, String datePaid) throws SQLException {
        String columns = "INSERT INTO IOTUSER.PAYMENT(INVOICE_ID, PAYMENT_METHOD, CREDIT_CARD_NO, EXPIRY_DATE, SECURITY_NO, OWNER_NAME, DATE_PAID)";
        String values = "VALUES (" + InvoiceId + ",'" + paymentMethod + "','" + cardNumber + "','" + expiryDate + "','" + cvv + "','" + nameOnCard + "','" + datePaid +"')";
        st.executeUpdate(columns + values);
    }
    
    //Update a payment details in the database - used in Payment_UpdateServlet
    public void updatePayment(int PAY_ID, String paymentMethod, String cardNumber, String expiryDate, 
            String cvv, String nameOnCard, String datePaid) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.PAYMENT SET paymentMethod='" + paymentMethod + "', cardNumber=" + 
                cardNumber + "', expiryDate='" + expiryDate +", cvv =" + cvv + ",  nameOnCard='" + nameOnCard + "',  datePaid='" + datePaid + "' WHERE PAY_ID = " + PAY_ID +" ");
    }
    
    //delete a payment from database - used in Payment_DeleteServlet
    public void deletePayment (int paymentId) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.PAYMENT WHERE PAY_ID = " + paymentId + " ");
    }

    //shows the list of payment based on userId -- Used in Payment_ShowHistoryServlet
    public ArrayList<String> fetchPayment(int userId) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"PAYMENT\"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<String> temp = new ArrayList();
        while(rs.next()) {
            temp.add(Integer.toString(rs.getInt(1)));
            temp.add(Integer.toString(rs.getInt(2)));
            temp.add(rs.getString(3));
            temp.add(rs.getString(4));
            temp.add(rs.getString(5));
            temp.add(rs.getString(6));
            temp.add(rs.getString(7));
            temp.add(rs.getString(8));
        }
        return temp;
    }
     
  //====This part belong to PAYMENT MANAGEMENT(DESY LIUNARDI 13411576). Contains dummy function of order and user to get the IDs==============//
 
    //get the last orderId from database - used in Payment1_CreateOrderServlet, Payment_CreateServlet
    public int getOrderId() throws SQLException {
       int orderId;
       String fetch = "select max(INVOICE_ID) FROM IOTUSER.ORDER" ;
       ResultSet rs = st.executeQuery(fetch);
       if (rs.next()) {
            orderId = rs.getInt(1);
            return orderId;
       } else {
           return 0;
       }
    }
}