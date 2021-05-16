<%-- 
    Document   : editProduct
    Created on : 15/05/2021, 3:43:44 PM
    Author     : oneilrangiuira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User" %>
<%@page import="uts.isd.model.Product" %>
<!DOCTYPE html>
<html>
    <%
        User user = (User)session.getAttribute("user");
        Product product = (Product)session.getAttribute("product");
        String update = (String)session.getAttribute("productUpdate");
        String productNameErr = (String)session.getAttribute("productNameErr");
        String productPriceErr = (String)session.getAttribute("productPriceErr");
        String productDescErr = (String)session.getAttribute("productDescErr");
        String productTypeErr = (String)session.getAttribute("productTypeErr");
        String productQuantityErr = (String)session.getAttribute("productQuantityErr");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product - <%= product.getProduct_name() %></title>
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
        <p class="text-center"><%= (update != null ? update : "") %></p>
        <div class="container-fluid col-4 mb">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center">Edit Product</h1>
                   
                    <form action="UpdateProductServlet" method="post">
                        <div class="form-group">
                            <label for="PROD_ID">ID: </label>
                            <input value="${product.id}" type="text" class="form-control-plaintext" id="PROD_ID" name="PROD_ID" readonly>
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_NAME">Name:</label>
                            <input placeholder="<%= productNameErr != null ? productNameErr : "" %>" value="<%= product.getProduct_name() %>" type="text" class="form-control" id="PRODUCT_NAME" name="PRODUCT_NAME" required="">
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_PRICE">Price:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">$</div>
                                </div>
                                <input placeholder="<%= productPriceErr != null ? productPriceErr : "" %>" value="<%= product.getProduct_price() %>" type="number" class="form-control" id="PRODUCT_PRICE" name="PRODUCT_PRICE" required="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_DESC">Description:</label>
                            <textarea placeholder="<%= productDescErr != null ? productDescErr : "" %>" type="text" class="form-control" id="PRODUCT_DESC" name="PRODUCT_DESC" rows="4" required=""><%= product.getProduct_desc() %></textarea>
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_TYPE">Type:</label>
                            <input placeholder="<%= productTypeErr != null ? productTypeErr : "" %>" value="<%= product.getProduct_type() %>" type="text" class="form-control" id="PRODUCT_TYPE" name="PRODUCT_TYPE" required="">
                        </div>

                        <div class="form-group">
                            <label for="PRODUCT_QUANT">Quantity</label>
                            <input placeholder="<%= productQuantityErr != null ? productQuantityErr : "" %>" value="<%= product.getProduct_quant() %>" type="number" class="form-control" id="PRODUCT_QUANT" name="PRODUCT_QUANT" required="">
                        </div>
                        <div class="text-center">
                            <a href="ProductListServlet" class="btn btn-outline-danger">Back</a>
                            <input type="submit" value="Update" class="btn btn-outline-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
