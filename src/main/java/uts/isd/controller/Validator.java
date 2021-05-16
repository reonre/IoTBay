package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {

    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String passwordPattern = "[a-zA-Z0-9]{4,}";

    // Product Patterns
    private String prod_NamePattern = "[^\'\"]+";
    private String prod_PricePattern = "^[0-9]{1,10}(.[0-9]{1,2})?$";
    private String prod_DescPattern = "[^\'\"]+";
    private String prod_TypePattern = "^[a-zA-Z\\s]+$";
    private String prod_quantPattern = "^[0-9]{1,10}$";
    
    //Payment Patterns
    private String pay_cardNo = "^[0-9]{13,16}$";
    private String pay_cvv = "^[0-9]{3}$";
    private String pay_expiryDate = "^(0[1-9]|1[0-2]|[1-9])/(1[4-9]|[2-9][0-9]|20[1-9][1-9])$";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }

    // Validate Product
    public boolean validateProductName(String name) {
        return validate(prod_NamePattern, name);
    }
    
    public boolean validateProductPrice(String price) {
        return validate(prod_PricePattern, price);
    }
    
    public boolean validateProductDesc(String desc) {
        return validate(prod_DescPattern, desc);
    }

    public boolean validateProductType(String type) {
        return validate(prod_TypePattern, type);
    }

    public boolean validateProductQuantity(String quantity) {
        return validate(prod_quantPattern, quantity);
    }
    
    public boolean validateAdminUsername(String username) {
       return validate(prod_NamePattern, username);
    }
    
    //Validate Payment
    public boolean validateCardNo(String cardNo) {
        return validate(pay_cardNo, cardNo);
    }
    
    public boolean validateCvv(String cvv) {
        return validate(pay_cvv, cvv);
    }
    public boolean validateExpiryDate(String expiryDate) {
        return validate(pay_expiryDate, expiryDate);
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("exitErr", "");
        session.setAttribute("nameErr", "Enter name");
        
        // Product session
        session.setAttribute("productNameErr", "Enter Product Name");
        session.setAttribute("productPriceErr", "Enter Price");
        session.setAttribute("productDescErr", "Enter Description");
        session.setAttribute("productTypeErr", "Enter Type");
        session.setAttribute("productQuantityErr", "Enter Quantity");
        
        //Payment session
        session.setAttribute("creditCardNoErr", "Enter Card Number");
        session.setAttribute("cvvErr", "Enter Cvv Number");
        session.setAttribute("expiryDateErr", "Enter Expiry Date");

    }
}
