<%-- 
    Document   : about us page
    Created on : 25/03/2021, 1:12:38 PM
    Author     : team 43
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<jsp:include page="/ConnServlet" flush="true"/>
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
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" type="button" href="LogoutServlet" data-toggle="modal" data-target="#myModal">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
        <table class="table table-responsive" id="users">
            <tr><td>Name:</td><td><%= user.getName()%></td></tr>
            <tr><td>Email:</td><td><%= user.getEmail()%></td></tr>
            <tr><td>Password:</td><td><%= user.getPassword()%></td></tr>
            <tr><td>Dob:</td><td><%= user.getDob()%></td></tr>
            <tr><td>Gender:</td><td><%= user.getGender()%></td></tr>
            <tr><td>Phone Number:</td><td><%= user.getPhone()%></td></tr>
            <tr><td>Address:</td><td><%= user.getAddress()%></td></tr>
            <tr><td>Account Type:</td><td><%= user.getClass().getSimpleName()%></td></tr>
            <%
                if (user.getClass().getSimpleName().equals("Staff")) {
            %>
            <tr><td>Position:</td><td>${user.position}</td></tr>
            <%
                }
                else if (user.getClass().getSimpleName().equals("Customer")){
            %> 
            <tr><td>Type:</td><td>${user.type}</td></tr>
            <%
                }
            %>

        </table>
        <form action="edit.jsp">
            <input type="submit" value="Edit Account" />
        </form>
        <form action="DeleteServlet" method="post">
            <input type="submit" value="Delete Account" />
        </form>
        <form action="LogServlet" method="post">
            <input type="submit" value="Access Logs"/>
        </form>

    </div>

</body>
</html>
