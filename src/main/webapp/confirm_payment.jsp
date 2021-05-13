<%-- 
    Document   : confirm_payment
    Created on : 12 May 2021, 12:11:54
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
    <title> Payment Confirmation</title>
    <%
        Payment payment = (Payment) session.getAttribute("payment");
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
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" type="button" href="LogoutServlet" data-toggle="modal" data-target="#myModal">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
        <table class="table table-responsive" id="users">
            <p> userid #${userId}</p>
            <tr><td>Payment Method:</td><td><%= payment.getPaymentMethod()%></td></tr>
            <tr><td>Date Paid:</td><td><%= payment.getDatePaid()%></td></tr>
            <tr><td>Card Number:</td><td><%= payment.getCardNumber()%></td></tr>
            <tr><td>Expiry Date:</td><td><%= payment.getExpiryDate()%></td></tr>
            <tr><td>CVV:</td><td><%= payment.getCvv()%></td></tr>
            <tr><td>Name On Card:</td><td><%= payment.getNameOnCard()%></td></tr>
        </table>
        <form action="payment_success.jsp">
            <input type="submit" value="Confirm" />
        </form>
        <form action="DeletePaymentServlet" method="post">
            <input type="submit" value="Cancel" />
        </form>
        <form action="EditPaymentServlet" method="post">
            <input type="submit" value="Exit"/>
        </form>

    </div>        

</body>
</html>
