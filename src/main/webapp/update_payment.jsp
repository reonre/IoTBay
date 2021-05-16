<%-- 
    Document   : update_payment
    Created on : 12 May 2021, 14:15:32
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
    <title> Payment Update Page</title>
</head>
<body>
    <%
        Payment payment = (Payment) session.getAttribute("payment");
        User user = (User) session.getAttribute("user");
        String updated = request.getParameter("updated");
        String paymentMethod = request.getParameter("paymentMethod");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("password");
        String cvv = request.getParameter("dob");
        String nameOnCard = request.getParameter("gender");
    %>
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
        <h1> Edit payment information <span><%= (updated != null) ? "Update was successful" : ""%></span></h1>
        <form action = "PaymentUpdateServlet" method="post">
            <table class="table table-responsive">
                <tr>
                    <td>
                        <select class="select" name="paymentMethod" value="${payment.paymentMethod}">
                            <option value="empty">Payment Method</option>
                            <option value="card">Credit Card</option>
                            <option value="cash">Cash</option>
                            <option value="other">Other</option>                                                                
                        </select>                                   
                    </td>
                    <td>
                        <input class="date" type="date" name="datePaid" value="${payment.datePaid}"/>  
                    </td>
                </tr>
                <tr><td>Card Number</td><td><input type="text" name="cardNumber" value="${payment.cardNumber}"/></td></tr>
                <tr><td>Expiry Date</td><td><input type="text" name="expiryDate" value="${payment.expiryDate}"/></td></tr>
                <tr><td>CVV</td><td><input type="text" name="cvv" value="${payment.cvv}"/></td></tr>
                <tr><td>Name On Card</td><td><input type="text" name="nameOnCard" value="${payment.nameOnCard}"/></td></tr>

                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                        <input type="hidden" name="updated" value="updated">
                    </td></tr>
            </table>
        </form>
    </div>
                <jsp:include page="/PaymentConnServlet" flush="true"/>
</body>
</html>