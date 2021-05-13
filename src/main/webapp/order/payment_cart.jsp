<%-- 
    Document   : payment_cart
    Created on : 12 May 2021, 12:36:09
    Author     : casio
--%>

<%@page import="uts.isd.model.Payment_Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <%
            Payment_Order order = (Payment_Order) session.getAttribute("order");
            String INVOICE_ID = (String) session.getAttribute("INVOICE_ID");
            String USER_ID = (String) session.getAttribute("USER_ID");
            %>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment-Order Cart Page</title>
    </head>
    <body>
        #${userId}
         <h1>In the Order Cart where customer have their product listed and Total Amount</h1>
         <p>Click on check out to finalize your order! </p>
         <h1>Total Amount is ${order.getAmount()}</h1>
         <a  class =" button" href="create_payment.jsp?USER_ID=<%=USER_ID %>&INVOICE_ID=<%=INVOICE_ID %>&amount=<%= order.getAmount()%>">Checkout</a>
    </body>   
</html>
