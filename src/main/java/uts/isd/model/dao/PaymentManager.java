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
import uts.isd.model.PaymentHistory;

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
        String fetch = "select PAY_ID FROM IOTUSER.PAYMENT WHERE CREDIT_CARD_NO =  '" + cardNumber + "'";
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
        String fetch = "select * from IOTUSER.PAYMENT WHERE PAY_ID = " + PAY_ID + " ";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int payment_Id = rs.getInt(1);
            if (payment_Id == PAY_ID) {
                String paymentMethod = rs.getString(3);
                String cardNumber = rs.getString(4);
                String cvv = rs.getString(5);
                String nameOnCard = rs.getString(6);
                String expiryDate = rs.getString(7);
                String datePaid = rs.getString(8);
                return new Payment(paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid);
            }
        }
        return null;
    }

    //Search paymnet by ID and datepaid in the database - Read one row in the database table - used in Payment_SearchServlet
    public PaymentHistory searchPaymentHistory(int PAY_ID, String datePaid) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PAYMENT_HISTORY WHERE PAY_ID= " + PAY_ID + " AND DATE_PAID='" + datePaid + "' ";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userId = rs.getInt(1);
            int paymentId = rs.getInt(2);
            String date_Paid = rs.getString(8);
            if (paymentId == PAY_ID && date_Paid.equals(datePaid)) {
                int orderId = Integer.parseInt(rs.getString(3));
                String paymentMethod = rs.getString(4);
                double orderPrice = Double.parseDouble(rs.getString(5));
                String cardNumber = rs.getString(6);
                String nameOnCard = rs.getString(7);
                return new PaymentHistory(userId, paymentId, orderId, paymentMethod, orderPrice, cardNumber, nameOnCard, date_Paid);
            }
        }
        return null;
    }
    
    public Payment searchPayment(int PAY_ID, String datePaid) throws SQLException {       
       String fetch = "select * from IOTUSER.PAYMENT WHERE PAY_ID= " + PAY_ID + " AND DATE_PAID='" + datePaid + "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           int payment_Id = rs.getInt(1);
           String date_Paid = rs.getString(9);
           if(payment_Id == PAY_ID && date_Paid.equals(datePaid)){
                String paymentMethod  = rs.getString(3);
                
                String cardNumber = rs.getString(5);
                String cvv = rs.getString(7);
                String expiryDate = rs.getString(6);
                String nameOnCard = rs.getString(8);
                return new Payment(paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid );
                }
           }
       return null;   
    }

    //Add a payment-data into the database - used in Payment_CreateServlet
    public void addPayment(int OrderId, String paymentMethod, double OrderPrice, String cardNumber, String expiryDate, String cvv, String nameOnCard, String datePaid) throws SQLException {
        String columns = "INSERT INTO IOTUSER.PAYMENT(ORDER_ID, PAYMENT_METHOD, ORDER_LINE_PRICE, CREDIT_CARD_NO, EXPIRY_DATE, SECURITY_NO, OWNER_NAME, DATE_PAID)";
        String values = "VALUES (" + OrderId + ",'" + paymentMethod + "'," + OrderPrice + ",'" + cardNumber + "','" + expiryDate + "','" + cvv + "','" + nameOnCard + "','" + datePaid + "')";
        st.executeUpdate(columns + values);
    }

    //Update a payment details in the database - used in Payment_UpdateServlet
    public void updatePayment(int PAY_ID,  String paymentMethod, String cardNumber, String expiryDate, String cvv, String nameOnCard, String datePaid) throws SQLException {
        String update = "UPDATE IOTUSER.PAYMENT SET PAYMENT_METHOD='" + paymentMethod + "', CREDIT_CARD_NO='"
                + cardNumber + "', EXPIRY_DATE='" + expiryDate + "', SECURITY_NO ='" + cvv + "',  OWNER_NAME='" + nameOnCard + "',  DATE_PAID='" + datePaid + "' WHERE PAY_ID = " + PAY_ID + "";
        st.executeUpdate(update);
    }
    
    public void updatePaymentHistory(int PAY_ID, String paymentMethod, String cardNumber, String nameOnCard, String datePaid) throws SQLException {
        String update = "UPDATE IOTUSER.PAYMENT_HISTORY SET PAYMENT_METHOD='" + paymentMethod + "', CREDIT_CARD_NO='"
                + cardNumber + "',  OWNER_NAME='" + nameOnCard + "',  DATE_PAID='" + datePaid + "' WHERE PAY_ID = " + PAY_ID + "";
        st.executeUpdate(update);
    }

    //delete a payment from database - used in Payment_DeleteServlet
    public void deletePayment(int PAY_ID) throws SQLException {
        String delete1 = "DELETE FROM IOTUSER.PAYMENT WHERE PAY_ID=" + PAY_ID + "";
        String delete2 = "DELETE FROM IOTUSER.PAYMENT_HISTORY WHERE PAY_ID=" + PAY_ID + "";
        st.executeUpdate(delete1);
        st.executeUpdate(delete2);
    }

    //shows the list of payment based on userId -- Used in Payment_ShowHistoryServlet
    public ArrayList<PaymentHistory> fetchHistory(int userId) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PAYMENT_HISTORY WHERE USER_ID = " + userId + "";
        ArrayList<PaymentHistory> temp = new ArrayList();
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            int paymentId = Integer.parseInt(rs.getString(2));
            int orderId = Integer.parseInt(rs.getString(3));
            String paymentMethod = rs.getString(4);
            double orderPrice = Double.parseDouble(rs.getString(5));
            String cardNumber = rs.getString(6);
            String nameOnCard = rs.getString(7);
            String datePaid = rs.getString(8);
            temp.add(new PaymentHistory(userId, paymentId, orderId, paymentMethod, orderPrice, cardNumber, nameOnCard, datePaid));
        }
        return temp;
    }
    
    public void addHistory(int userId, int paymentId, int orderId, String paymentMethod, double orderPrice,  String cardNumber, String nameOnCard, String datePaid) throws SQLException {
        String columns = "INSERT INTO IOTUSER.PAYMENT_HISTORY(USER_ID, PAY_ID, ORDER_ID, PAYMENT_METHOD, ORDER_LINE_PRICE, CREDIT_CARD_NO, OWNER_NAME, DATE_PAID)";
        String values = "VALUES (" + userId + ","  + paymentId + "," + orderId + ",'" + paymentMethod + "'," + orderPrice + ",'" + cardNumber + "','" + nameOnCard + "','" + datePaid + "')";
        st.executeUpdate(columns + values);
    }

    public double getPrice() throws SQLException {
        double orderPrice;
        String fetch = "select MAX(ORDER_LINE_PRICE) FROM IOTUSER.ORDER_LINE";
        ResultSet rs = st.executeQuery(fetch);
        if (rs.next()) {
            orderPrice = rs.getDouble(4);
            return orderPrice;
        } else {
            return 0;
        }
    }


    public int getOrderId() throws SQLException {
        int orderId;
        String fetch = "select MAX(ORDER_ID) FROM IOTUSER.ORDER_LINE";
        ResultSet rs = st.executeQuery(fetch);
        if (rs.next()) {
            orderId = Integer.parseInt(rs.getString(3));
            return orderId;
        } else {
            return 0;
        }
    }
    
}
