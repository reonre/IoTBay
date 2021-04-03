<%-- 
    Document   : about us page
    Created on : 25/03/2021, 1:12:38 PM
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
    </head>
        <title> Contact Us </title>
        <%
            User user = (User)session.getAttribute("user");
        %>
          
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
                <li class="nav-item active">
                    <a class="nav-link btn btn-primary text-white" type="button" href="profile.jsp" data-toggle="modal" data-target="#myModal">Profile<span class="sr-only">(current)</a>                  
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" type="button" href="logout.jsp" data-toggle="modal" data-target="#myModal">Logout</a>
                </li>
            </ul>
        </div>
        </nav>
        
         

        <div class="container-fluid" style="margin-top:60px">
            <table id="users">
            <tr>
                <th>User</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Date of Birth</th>
            </tr>
            <tr>
                <td><%=user.getName()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getGender()%></td>
                <td><%=user.getDob()%></td>
            </tr>
        </table>
        </div>
        
         
        
 

        
    </body>
</html>
