<%-- 
    Document   : addProduct
    Created on : 08/05/2021, 2:12:45 AM
    Author     : oneilrangiuira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>
<jsp:include page="/ConnServlet" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String productNameErr = (String)session.getAttribute("productNameErr");
            String productPriceErr = (String)session.getAttribute("productPriceErr");
            String productDescErr = (String)session.getAttribute("productDescErr");
            String productTypeErr = (String)session.getAttribute("productTypeErr");
            String productQuantityErr = (String)session.getAttribute("productQuantityErr");
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
                        <a class="nav-link btn btn-primary text-white" type="button" href="main.jsp" data-toggle="modal" data-target="#myModal">Profile</a>                  
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

        <div class="container-fluid col-4 mb">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center">Add Product</h1>
                   
                    <form action="AddProductServlet" method="post">
                        <div class="form-group">
                            <label for="PRODUCT_NAME">Name:</label>
                            <input placeholder="<%= productNameErr != null ? productNameErr : "" %>" type="text" class="form-control" id="PRODUCT_NAME" name="PRODUCT_NAME" required="">
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_PRICE">Price:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">$</div>
                                </div>
                                <input placeholder="<%= productPriceErr != null ? productPriceErr : "" %>" type="number" class="form-control" id="PRODUCT_PRICE" name="PRODUCT_PRICE" required="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_DESC">Description:</label>
                            <input placeholder="<%= productDescErr != null ? productDescErr : "" %>" type="text" class="form-control" id="PRODUCT_DESC" name="PRODUCT_DESC" required="">
                        </div>
                        <div class="form-group">
                            <label for="PRODUCT_TYPE">Type:</label>
                            <input placeholder="<%= productTypeErr != null ? productTypeErr : "" %>" type="text" class="form-control" id="PRODUCT_TYPE" name="PRODUCT_TYPE" required="">
                        </div>

                        <div class="form-group">
                            <label for="PRODUCT_QUANT">Quantity</label>
                            <input placeholder="<%= productQuantityErr != null ? productQuantityErr : "" %>" type="number" class="form-control" id="PRODUCT_QUANT" name="PRODUCT_QUANT" required="">
                        </div>
                        <div class="text-center">
                            <a href="ProductListServlet" class="btn btn-outline-danger">Cancel</a>
                            <input type="submit" value="Add" class="btn btn-outline-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>