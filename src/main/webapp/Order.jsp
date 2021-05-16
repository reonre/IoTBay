<%-- 
    Document   : Order
    Created on : 16/05/2021, 11:29:43 AM
    Author     : Typing Corpse
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Product"%>
<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Orders"%>
<%@page import="java.text.DecimalFormat"%>
<html>
    <%
        User user = (User)session.getAttribute("user");
        Product product = (Product)session.getAttribute("product");
        DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">IoTBay</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto topnav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ProductListServlet"><span class="sr-only">(current)</span>Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about_us.jsp">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact_us.jsp">Contact</a>
                </li>
                <% if (user != null) { %>
                    <li class="nav-item active">
                        <a class="nav-link btn btn-primary text-white" type="button" href="main.jsp" data-toggle="modal" data-target="#myModal">Profile<span class="sr-only">(current)</a>                  
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-danger text-white" type="button" href="LogoutServlet" data-toggle="modal" data-target="#myModal">Logout</a>
                    </li>
                <% } else { %>
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-white" type="button" href="login.jsp" data-toggle="modal" data-target="#myModal">Sign In</a>                  
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-danger text-white" type="button" href="register.jsp" data-toggle="modal" data-target="#myModal">Register</a>
                    </li>
                <% } %>
            </ul>
        </div>
        </nav>
         <div class="container">
            <form action="OrderProductServlet" method="post">
            <table class="table table-responsive">
                
                <tr><td><%= product.getProduct_name() %></td><td> 
                 <tr><td>Quantity</td><td><input type="number" name="quant"/></td></tr>
                        
                <tr><td>Customer Name</td><td><input type="text" name="name"/></td></tr>
                <tr><td>Billing Address</td><td><input type="text" name="billadd"/></td></tr>
                <tr><td>Shipping Address</td><td><input type="text" name="shipadd"/></td></tr>                
               
               
                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit" >
                    </td></tr>
            </table>
        </form>
             
             
             
             

            
        </div>
    </body>
</html>
