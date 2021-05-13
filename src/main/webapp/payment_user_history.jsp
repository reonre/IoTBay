<%-- 
    Document   : PaymentUserHistory
    Created on : 12 May 2021, 12:49:20
    Author     : casio
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%
        ArrayList<String> rs = (ArrayList<String>) session.getAttribute("paymentList");
        String fetchMessage = (String) session.getAttribute("fetchMessage");
     %>
        
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment User View History Page</title>
    </head>
        <p style="text-align: right; color: black; font-size:20px"> <a class = button href = "payment_order.jsp"> <i>Go to HomePage</i></a>
        <a class = button href = "Payment1_LogoutServlet"> <i>Logout</i></a></p>
    <Body>
        <p> You are user number : ${userId}
               <table>
                <tr>
                    <td><b>Payment Id</b></td>
                    <td><b>Order Id</b></td>
                    <td><b>Payment Method</b></td>
                    <td><b>Card Number</b></td>
                    <td><b>Expiry Date</b></td>
                    <td><b>CVV</b></td>
                    <td><b>Name On Card</b></td>
                    <td><b>Date paid</b></td>
               </tr>
                 <%  if(rs != null){
                    for(int i = 0; i < rs.size(); i=i+8){
                 %>
               <td><p> <%=rs.get(0+i)%> </p></td>
                    <td><p> <%=rs.get(1+i)%> </p></td>
                    <td><p> <%=rs.get(2+i)%> </p></td>
                    <td><p> <%=rs.get(3+i)%> </p></td>
                    <td><p> <%=rs.get(4+i)%>  </p></td>
                    <td><p> <%=rs.get(5+i)%>  </p></td>
                    <td><p> <%=rs.get(6+i)%>  </p></td>
                    <td><p> <%=rs.get(7+i)%> </p></td>
                </tr><% } } else { %> 
            </table>
             <span class="warning"><%=fetchMessage != null ? fetchMessage : ""%></span>
            <% } %>
                   
    </body>
</html>
