<%-- 
    Document   : welcome
    Created on : 15/03/2021, 5:09:16 PM
    Author     : team 43
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <title>Welcome</title>
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
                        <a class="nav-link" href="index.jsp">Home</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about_us.jsp">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact_us.jsp">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-white" type="button" href="main.jsp" data-toggle="modal" data-target="#myModal">Profile</a>                  
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-danger text-white" type="button" href="LogoutServlet" data-toggle="modal" data-target="#myModal">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>  
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String tos = request.getParameter("tos");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
        %>
        <%if (!(email.equals("")) && tos != null) {%>
        <%
            User user = new User(name, email, password, gender, dob, phone, address);
            session.setAttribute("user", user);
        %>
        <div class="container-fluid">
            <p>
                Welcome <%= name%>! Your account has been created!
            </p>
        </div>
        <%} else if (tos == null) {%>
        <p>Sorry, you must agree to the Terms of Service. Click <a href="register.jsp">here</a> to go back.</p>
        <%} else {%>
        <p>Sorry unknown email click <a href="register.jsp">here</a> to go back</p>
        <%}%>
    </body>
</html>
