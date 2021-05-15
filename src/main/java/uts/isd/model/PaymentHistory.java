/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.*;
/**
 *
 * @author casio
 */
public class PaymentHistory implements Serializable {
    private String paymentMethod, cardNumber, nameOnCard, datePaid;
    private int id, paymentId, invoiceId;
    public PaymentHistory(int id, int paymentId, int invoiceId, String paymentMethod, String cardNumber, String nameOnCard, String datePaid) {
        this.id = id;
        this.paymentId = paymentId;
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.datePaid = datePaid;
    }
    public int getId() {
        return id;
    }
    public Integer getPaymentId() {
        return paymentId;
    }
    public Integer getInvoiceId() {
        return invoiceId;
    } 
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getNameOnCard() {
        return nameOnCard;
    }
    public String getDatePaid() {
        return datePaid;
    }
    @Override
    public String toString() {
        return paymentMethod + " " + cardNumber + " " + nameOnCard + " " + datePaid;
    }
}
