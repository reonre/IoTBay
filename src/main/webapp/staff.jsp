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
        <table class="table table-responsive" id="users">
            <form action="create_staff.jsp">
                <input type="submit" value="Create Staff">
            </form>
            <form action="StaffViewServlet" method="post">
                <input type="submit" value="View Staff">
            </form>
            <tr><td>
                    <form action="StaffEditServlet" method="post">
                        Staff ID <input type="text" name="id"value=""/>
                        <input type="submit" value="Edit Staff">
                    </form>
                </td></tr>
            <tr><td>
                    <form action="StaffDeleteServlet" method="post">
                        Staff ID <input type="text" name="id"value=""/>
                        <input type="submit" value="Delete Staff">
                    </form>
                </td></tr>
        </table>

    </div>
    <jsp:include page="/StaffConnServlet" flush="true"/>
</body>
</html>
