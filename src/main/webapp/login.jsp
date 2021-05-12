<%-- 
    Document   : login
    Created on : 15/03/2021, 3:55:11 PM
    Author     : team 43
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body onload = "startTime()">
        <div><span class="time" id="time"></span></div>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passwordErr = (String) session.getAttribute("passErr");
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
                        <a class="nav-link btn btn-primary text-white" type="button" href="login.jsp" data-toggle="modal" data-target="#myModal">Sign In <span class="sr-only">(current)</span></a>                  
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-danger text-white" type="button" href="register.jsp" data-toggle="modal" data-target="#myModal">Register</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1><span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
        <form action="LoginServlet" method="post">
            <table class="table table-responsive" id="form_table">
                <tr><td>Email</td><td><input type="email" name="email" id="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" id="password" placeholder="<%=(passwordErr != null ? passwordErr : "Enter password")%>" required/></td></tr>                
                <tr><td></td>
                    <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                    </td></tr>
            </table>
        </form>
        <!--
        <form action="LoginServlet" method="post">
            <table class="table table-responsive" id="form_table">
                <tr><td>Email</td><td><input type="email" name="email" id="email"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" id="password"/></td></tr>                
                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                    </td></tr>
            </table>
        </form>
        -->
        <jsp:include page="/ConnServlet" flush="true"/>
    </body>
</html>
