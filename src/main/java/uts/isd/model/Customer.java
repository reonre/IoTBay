
package uts.isd.model;
import java.io.*;
/**
 *
 * @author Team
 */
public class Customer extends User {
    private String address;
//    add linkedlist or arraylist here for orders 
//    private LinkedList<Order> orders;
//    add paymentinfo here for payment
//    private PaymentClass paymentInfo;
  
    
    public Customer() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
//    public LinkedList<Order> getOrders() {
//        return orders;
//    }
//    public void setOrders(LinkedList<Order> orders) {
//        this.orders = orders;
//    }
}
