<%-- 
    Document   : viewOrder
    Created on : 16/05/2021, 4:17:35 PM
    Author     : Typing Corpse
--%>

<%@page import="uts.isd.model.dao.OrderDBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Product"%>
<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Orders"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/ConnServlet"/>
<html>
    <%
        User user = (User) session.getAttribute("user");
        Product product = (Product) session.getAttribute("product");
        int id = ((User) session.getAttribute("user")).getUSER_ID();
        OrderDBManager ordManager = (OrderDBManager) session.getAttribute("orderDBManager");
//        System.out.println(ordManager==null);
        session.setAttribute("orders", ordManager.fetchOrders(id));
//        ArrayList<Orders> orders = ordManager.fetchOrders(id);
//        DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
//        session.setAttribute("orders", orders);
//        request.setAttribute("orders", orders);
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
                    <% }%>
                </ul>
            </div>
        </nav>
        <div class="container">
            <table class="table table-responsive">


                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Customer Name</th>
                            <th scope="col">Product Name</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Price</th>
                            <th scope="col">Total Price</th>
                            <th scope="col">Status</th>
                            <th scope="col">Billing Address</th>
                            <th scope="col">Shipping Address</th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <td>${order.getOrdererName()}</td>
                            <td>${product.getProduct_name()}</td>
                            <td>${order.getQuantity()}</td>
                            <td>${order.getPrice()}</td>
                            <td>${order.getTotalPrice()}</td>
                            <td>${order.getStatus()}</td>
                            <td>${order.getBillingAddress()}</td>
                            <td>${order.getShippingAddress()}</td>
                        </tr>

                    </tbody > 

                </table>
                <tr><td>
                        <input type="submit" value="Edit Order" class="button" name = "submit" id="submit">
                    </td></tr>
                
                <tr><td>
                <input type="submit" value="Cancel Order" class="button" name = "submit" id="submit">
                </td></tr>
                <form action="create_payment.jsp">
                            <input type="submit" value="Make Payment" />
                        </form>
            </table>

        </div>
    </body>
</html>
