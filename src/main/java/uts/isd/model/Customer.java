
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
    
    private String type;
    
    public Customer(int USER_ID, String name, String email, String password, String phone, String gender, String dob, String address, String type) {
        super(USER_ID, name, email, password, phone, gender, dob, address);
        this.type = type;
    }
    
    

//    public LinkedList<Order> getOrders() {
//        return orders;
//    }
//    public void setOrders(LinkedList<Order> orders) {
//        this.orders = orders;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
