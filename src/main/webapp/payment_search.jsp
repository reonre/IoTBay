<%-- 
    Document   : payment_search
    Created on : 16 May 2021, 00:55:20
    Author     : casio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Search</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body onload = "startTime()">
        <div><span class="time" id="time"></span></div>
            <%
                String existErr = (String) session.getAttribute("existErr");
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
        <h1><span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
        <form action="PaymentSearchServlet" method="post">
            <table class="table table-responsive" id="form_table">
                <tr><td>Payment ID</td><td><input type="paymentId" name="paymentId" id="paymentId" placeholder="payment id" required/></td></tr>
                <tr><td>Date Paid</td><td><input type="datePaid" name="datePaid" id="datePaid" placeholder="date paid" required/></td></tr>                
                <tr><td></td>
                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                    </td></tr>
            </table>
        </form>
        <jsp:include page="/PaymentConnServlet" flush="true"/>
    </body>
</html>
