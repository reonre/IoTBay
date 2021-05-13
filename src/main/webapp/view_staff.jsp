<%-- 
    Document   : about us page
    Created on : 25/03/2021, 1:12:38 PM
    Author     : team 43
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <title> Contact Us </title>
</head>
<body onload="startTime(); resetSearch();">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="admin_home.jsp">IoTBay</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto topnav">
                <li class="nav-item active">
                    <a class="nav-link btn btn-primary text-white" type="button" href="admin_home.jsp" data-toggle="modal" data-target="#myModal">Home<span class="sr-only">(current)</a>                  
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" type="button" href="AdminLogoutServlet" data-toggle="modal" data-target="#myModal">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
        <table class="table table-bordered">
            <th>Staff ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Gender</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Position</th>
                <c:forEach items="${staff}" var="obj">
                <tr>
                    <td>${obj.USER_ID}</td>
                    <td>${obj.name}</td>
                    <td>${obj.email}</td>
                    <td>${obj.password}</td>
                    <td>${obj.phone}</td>
                    <td>${obj.gender}</td>
                    <td>${obj.dob}</td>
                    <td>${obj.address}</td>
                    <td>${obj.position}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="StaffSearchServlet" method="post">
            <table class="table table-responsive">
                <tr><td>Name</td><td><input type="text" name="name"/></td></tr>
                <tr><td>Position</td><td><input type="text" name="position"/></td></tr>
                <tr><td>
                        <input type="submit" value="Search" class="button" name = "submit" id="submit">
                    </td></tr>
            </table>
        </form>
    </div>
    <jsp:include page="/StaffConnServlet" flush="true"/>
</body>
</html>
