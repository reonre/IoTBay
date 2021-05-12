
package uts.isd.model;
import java.io.*;
/**
 *
 * @author Team
 */
public class Customer extends User {
//    add linkedlist or arraylist here for orders 
//    private LinkedList<Order> orders;
//    add paymentinfo here for payment
//    private PaymentClass paymentInfo;
  
    
    public Customer(int USER_ID, String name, String email, String password, String phone, String gender, String dob, String address) {
        super(USER_ID, name, email, password, phone, gender, dob, address);
    }
    
//    public LinkedList<Order> getOrders() {
//        return orders;
//    }
//    public void setOrders(LinkedList<Order> orders) {
//        this.orders = orders;
//    }
}
