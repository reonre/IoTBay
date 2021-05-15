<%-- 
    Document   : PaymentUserHistory
    Created on : 12 May 2021, 12:49:20
    Author     : casio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <title> Contact Us </title>
    <%
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
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" type="button" href="LogoutServlet" data-toggle="modal" data-target="#myModal">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
        <table class="table table-bordered">
            <th>Payment Id</th>
            <th>Order Id</th>
            <th>Payment Method</th>
            <th>Card Number</th>
            <th>Name On Card</th>
            <th>Date paid</th>
            <c:forEach items="${history}" var="obj">
                <tr>
                    <td>${obj.paymentId}</td>
                    <td>${obj.invoiceId}</td>
                    <td>${obj.paymentMethod}</td>
                    <td>${obj.cardNumber}</td>
                    <td>${obj.nameOnCard}</td>
                    <td>${obj.datePaid}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
