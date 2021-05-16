<%-- 
    Document   : product
    Created on : 15/05/2021, 1:41:43 PM
    Author     : oneilrangiuira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Product"%>
<%@page import="uts.isd.model.User"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User)session.getAttribute("user");
        Product product = (Product)session.getAttribute("product");
        DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product - <%= product.getProduct_name() %></title>
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
            <h1><%= product.getProduct_name() %></h1>
            <% if (user != null && user.getClass().getSimpleName().equals("Staff")) { %>
            <h4>ID: <%= product.getProd_id()%></h4>
            <% } %>
            <h5><%= product.getProduct_type()%></h5>
            <p><%= product.getProduct_desc()%></p>
            <p><%= priceFormatter.format(product.getProduct_price()) %></p>
            
            <form class="form-inline" action="Order.jsp" method="post">
                <div class="mr-2">
                    <input type="submit" value="Order" class="btn btn-outline-success">
                    <a href="ProductListServlet" class="btn btn-outline-warning">Back</a>
                </div>
            </form>
            <% if (user != null && user.getClass().getSimpleName().equals("Staff")) { %>
            <div class="card mt-2 float-right" style="width: 16rem;">
                <div class="card-body m-auto">
                    <h4>Admin controls</h4>
                    <a class="btn btn-outline-info" href="EditProductServlet?id=<%= product.getProd_id()%>">Edit</a>
                    <a class="btn btn-outline-danger" href="DeleteProductServlet?id=<%= product.getProd_id()%>">Delete</a>
                </div>
            </div>
            <% } %>
            
        </div>
    </body>
</html>
