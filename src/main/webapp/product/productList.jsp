<%-- 
    Document   : productList
    Created on : 15/05/2021, 12:36:39 PM
    Author     : oneilrangiuira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Product" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.DecimalFormat"%>
<jsp:include page="/ConnServlet"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
            String productSearch = (String)session.getAttribute("productSearch");
            DecimalFormat priceFormat = new DecimalFormat("$#0.00");
        %>
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

        <h1 class="text-center">Products</h1>
        <div class="flex-row d-flex justify-content-center mb-4"> 
            <% if (user != null && user.getClass().getSimpleName().equals("Staff")) { %>
            <a class="btn btn-outline-primary mr-sm-2" href="addProduct.jsp">Add Product</a>
            <% } %>
            <a class="btn btn-outline-primary mr-sm-5" href="ProductListServlet">List All Products</a>
        </div>

        <div class="row text-center">   
        <% for (Product product: products){ %>
            <div class="col-xl-3 col-md-4 col-sm-6 mb-4"> 
                <div class="card h-100 box-shadow">
                    <h6 class="card-header text-muted"><%= product.getProduct_type()%></h6>
                    <div class="card-body">
                        <h5 class="card-title"><%= product.getProduct_name()%></h5>
                        <p class="card-text">Price: <%= priceFormat.format(product.getProduct_price())%></p>
                        <p class="card-text"><%= product.getProduct_desc()%></p>
                        <p class="card-text">Quantity: <%= product.getProduct_quant()%></p>
                    </div>
                </div>
            </div>        
        <% } %>
        </div>
    </body>
</html>