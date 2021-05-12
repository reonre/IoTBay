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

<body>
    <%
        User user = (User) session.getAttribute("user");
        String updated = request.getParameter("updated");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
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

    <%
        if (user.getClass().getSimpleName().equals("Staff")){
    %>
    <div class="container-fluid">
        <h1> Edit student information <span><%= (updated != null) ?  "Update was successful":""%></span></h1>
        <form action="EditServlet" method="post">
            <table class="table table-responsive">
                <tr><td>Name</td><td><input type="text" name="name" value="${user.name}"/></td></tr>
                <tr><td>Email</td><td><input type="email" name="email" value="${user.email}"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value="${user.password}"/></td></tr>                
                <tr>
                    <td>
                        <select class="select" name="gender" value="${user.gender}">
                            <option value="empty">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>                                                                
                        </select>                                   
                    </td>
                    <td>
                        <input class="date" type="date" name="dob"value="${user.dob}"/>  
                    </td>
                </tr>
                <tr><td>Phone Number</td><td><input type="text" name="phone"value="${user.phone}"/></td></tr>
                <tr><td>Address</td><td><input type="text" name="address" value="${user.address}"/></td></tr>
                <tr><td>Position</td><td><input type="text" name="position" value="${user.position}"/></td></tr>

                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                        <input type="hidden" name="updated" value="updated">
                    </td></tr>
            </table>
        </form>>
    </div>
    <%
        else if (user.getClass().getSimpleName().equals("Customer")){
    %>
    <div class="container-fluid">
        <h1> Edit student information <span><%= (updated != null) ?  "Update was successful":""%></span></h1>
        <form action="EditServlet" method="post">
            <table class="table table-responsive">
                <tr><td>Name</td><td><input type="text" name="name" value="${user.name}"/></td></tr>
                <tr><td>Email</td><td><input type="email" name="email" value="${user.email}"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value="${user.password}"/></td></tr>                
                <tr>
                    <td>
                        <select class="select" name="gender" value="${user.gender}">
                            <option value="empty">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>                                                                
                        </select>                                   
                    </td>
                    <td>
                        <input class="date" type="date" name="dob"value="${user.dob}"/>  
                    </td>
                </tr>
                <tr><td>Phone Number</td><td><input type="text" name="phone"value="${user.phone}"/></td></tr>
                <tr><td>Address</td><td><input type="text" name="address" value="${user.address}"/></td></tr>
                <tr>
                    <td>
                        <select class="select" name="gender" value="${user.type}">
                            <option value="empty">Select</option>
                            <option value="individual">Individual</option>
                            <option value="company">Company</option>                                                           
                        </select>                                   
                    </td>
                </tr>


                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit">
                        <input type="hidden" name="updated" value="updated">
                    </td></tr>
            </table>
        </form>
    </div>
</body>
</html>
