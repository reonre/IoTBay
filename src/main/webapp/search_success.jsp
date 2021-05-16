<%-- 
    Document   : search_success
    Created on : 16 May 2021, 01:13:39
    Author     : casio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <title> Search Success </title>
    <%
        PaymentHistory paymenth = (PaymentHistory) session.getAttribute("paymenth");
        User user = (User) session.getAttribute("user");
    %>
</head>
<body onload="startTime(); resetSearch();">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="index.jsp">IoTBay</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto topnav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about_us.jsp">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact_us.jsp">Contact</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link btn btn-primary text-white" type="button" href="main.jsp" data-toggle="modal" data-target="#myModal">Profile<span class="sr-only">(current)</a>                  
                </li>
            </ul>
        </div>
    </nav>
    <%
        if (user.getUSER_ID() == paymenth.getId()) {
    %>
    <div class="container-fluid">
        <table class="table table-responsive" id="users">
            <tr><td>User id:#</td><td><%= user.getUSER_ID()%></td></tr>
            <tr><td>Payment ID:</td><td><%= paymenth.getPaymentId()%></td></tr>
            <tr><td>Invoice ID:</td><td><%= paymenth.getOrderId()%></td></tr>
            <tr><td>Payment Method:</td><td><%= paymenth.getPaymentMethod()%></td></tr>
            <tr><td>Amount :$</td><td><%= paymenth.getPrice()%></td></tr>
            <tr><td>Card Number:</td><td><%= paymenth.getCardNumber()%></td></tr>
            <tr><td>Name On Card:</td><td><%= paymenth.getNameOnCard()%></td></tr>
            <tr><td>Date Paid:</td><td><%= paymenth.getDatePaid()%></td></tr>

        </table>   
    </div>
    <%
    } else {
    %>
    <h1> Payment not found </h1>
    <%
        }
    %>
    <form action="main.jsp">
        <input type="submit" value="Back" />
    </form>
</body>
</html>
