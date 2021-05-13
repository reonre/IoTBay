/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author casio
 */
import java.io.Serializable;

public class Payment implements Serializable{
    private int PAY_ID;
    private int INVOICE_ID;
    private String paymentMethod;
    private String cardNumber;
    private String cvv;
    private String nameOnCard;
    private String expiryDate;
    private String datePaid;
    
    
    
    
    public Payment(){}
 
    
    public Payment(int paymentId, int invoiceId, String paymentMethod, String cardNumber, String expiryDate, String cvv, String nameOnCard, String datePaid) {
        this.PAY_ID = paymentId;
        this.INVOICE_ID = invoiceId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.datePaid = datePaid;
    }
    
    // insert a constructor that initialies the fields
    public Payment(String paymentMethod, String cardNumber, String expiryDate, String cvv, String nameOnCard, String datePaid) {
        //this.paymentId = paymentId;
        //this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.datePaid = datePaid;
    }
    
    
    public Integer getPaymentId() {
        return PAY_ID;
    }
    
    public void setPaymentId(Integer PAY_ID) {
        this.PAY_ID = PAY_ID;
    }
     
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
    
    public String getNameOnCard() {
        return nameOnCard;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public String getDatePaid() {
        return datePaid;
    }
    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }
}
