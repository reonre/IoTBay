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
    private int id, paymentId, orderId;
    private double price;
    public PaymentHistory(int id, int paymentId, int invoiceId, String paymentMethod, double price, String cardNumber, String nameOnCard, String datePaid) {
        this.id = id;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.price = price;
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
    public Integer getOrderId() {
        return orderId;
    } 
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public double getPrice() {
        return price;
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
