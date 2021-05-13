<%-- 
    Document   : about us page
    Created on : 25/03/2021, 1:12:38 PM
    Author     : team 43
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
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
     <%
        int id = Integer.parseInt(request.getParameter("id"));
        StaffDBManager manager = (StaffDBManager) session.getAttribute("manager");
        Staff staff = manager.getStaff(id);
        boolean activated = true;
        if (staff != null) {
            session.setAttribute("staff", staff);
            activated = manager.isActivated(id);
        }
    %>
   <div class="container-fluid">
       <% if (staff != null) { %>
           <form action="StaffEditServlet" method="post">
            <table class="table table-responsive">
                <tr><td>Name</td><td><input type="text" name="name" value="${staff.name}"/></td></tr>
                <tr><td>Email</td><td><input type="email" name="email" value="${staff.email}"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value="${staff.password}"/></td></tr>                
                <tr>
                    <td>
                        <select class="select" name="gender" value="${staff.gender}">
                            <option value="empty">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>                                                                
                        </select>                                   
                    </td>
                    <td>
                        <input class="date" type="date" name="dob"value="${staff.dob}"/>  
                    </td>
                </tr>
                <tr><td>Phone Number</td><td><input type="text" name="phone"value="${staff.phone}"/></td></tr>
                <tr><td>Address</td><td><input type="text" name="address" value="${staff.address}"/></td></tr>
                <tr><td>Position</td><td><input type="text" name="position" value="${staff.position}"/></td></tr>
                <%if (activated) {%>
                <tr><td>Activated</td><td><input type="checkbox" name="activated" checked="true"/></td></tr>
                <%}
                else {%>
                <tr><td>Activated</td><td><input type="checkbox" name="activated""/></td></tr>
                <%}%>
                
                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                        <input type="hidden" name="updated" value="updated">
                    </td></tr>
                
            </table>
        </form>
       <%} else { %>
       <h1>There was no user with that ID</h1>
        <%}%>
    </div>
    <jsp:include page="/StaffConnServlet" flush="true"/>
</body>
</html>
