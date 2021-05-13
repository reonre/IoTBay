<%-- 
    Document   : payment_order
    Created on : 12 May 2021, 12:50:58
    Author     : casio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    Integer userId = (Integer) session.getAttribute("userId");
    %>
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment-Order Page</title>
        
    </head>
    <body>
        <h1>In the Order Page. The Registered User/ unRegistered select products and have the total Amount.</h1>
        
        <form action = "PaymentCreateOrderServlet" method="post">
            <p hidden> <input type= "text" name="username" value="<%=username%>">  </p>
            <p hidden> <input type= "text" name="password" value="<%=password%>">  </p>
            <p hidden> <input type= "text" name="USER_ID" value="<%=userId%>"> </p>
                 <tr>
                    <td> <label for name="amount" class="subtitle">Amount</label> </td>
                    <td><input type ="number" id="amount" name="amount" placeholder="150.0" required></td>
                 </tr>
                
                 <input class= button type="submit" value="Add to Cart">
        </form>
        
    </body>
</html>
