<%-- 
    Document   : payment_success
    Created on : 12 May 2021, 12:13:36
    Author     : casio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<jsp:include page="/ConnServlet"/>
<!DOCTYPE html>
<html>
    <%
    Payment payment = (Payment) session.getAttribute("payment");
    PaymentManager manager = (PaymentManager) session.getAttribute("manager");
    User user = (User) session.getAttribute("user");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <title> Payment Success</title>
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
                    <a class="nav-link" href="ProductListServlet">Products</a>
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
        <div class="container-fluid">
        <tr><td>User Id:#</td><td><%= user.getUSER_ID()%></td></tr>   
        <tr><td>Payment Id:#</td><td><%= manager.getPaymentId(payment.getCardNumber())%></td></tr>                                                    
        <tr><td>Your order and payment are confirmed!</td></tr>                                  
        <tr><td> We will let you know when your order is ready for collection through your email address.</td></tr>        
        <form action="HistoryPaymentServlet" method="post">
            <input type="submit" value="Show Payment History" />
        </form>
        <form action="payment_search.jsp">
            <input type="submit" value="Search Payment" />
        </form>    
    </div>
    </body>
</html>
