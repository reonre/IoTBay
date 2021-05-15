<%-- 
    Document   : update_payment
    Created on : 12 May 2021, 14:15:32
    Author     : casio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Payment Update Page</title>
    </head>
    <body>
        
         <form action = "PaymentUpdateServlet" method="post">
        
        <h1> Order #${orderId} </h1>
        <h2> Total Amount A$${order.getAmount()} </h2>
        
        <div class="body-text"> 
            <h3><label for name="paymentMethod">Payment Method</label></h3>
                <select id="paymentMethod" name="paymentMethod"  value="${payment.getPaymentMethod()}" required>
                <option value="Credit Card">Credit Card</option></select></div>
 
            <b><label for name="datePaid">Date Paid</label></b>
                <input type="date" id="coloumn-left" name="datePaid" value="${payment.getDatePaid()}" placeholder="Date Paid" required/> 
             
                <div class="form-container">
                <div class="personal-information">
                <h1>Payment Information</h1></div> 
                    
                     <input type="number" id="input-field" name="cardNumber" placeholder="Card Number" value="${payment.getCardNumber()}" required/> 
                     <input type="text" id="input-field" name="expiryDate" placeholder="MM/YY" value="${payment.getExpiryDate()}" required/> 
                     <input type="number" id="input-field" name="cvv" placeholder="CVV" value="${payment.getCvv()}" required/> 
                     <input type="text" id="input-field" name="nameOnCard" placeholder="Name on Card" value="${payment.getNameOnCard()}" required/> 

                     <input type="submit" value="Update">
            </form>
                    
                     <p><a class= "button" style="center" href="confirm_payment.jsp">Cancel</a></p>
            
    </body>
</html>