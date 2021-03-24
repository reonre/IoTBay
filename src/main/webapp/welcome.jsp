<%-- 
    Document   : welcome
    Created on : 15/03/2021, 5:09:16 PM
    Author     : team 43
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <div id="bar">
            ISD DEMO
            <span id="links"> <a href="profile.jsp">Profile</a> | <a href="logout.jsp">Logout</a></span>
        </div>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String tos = request.getParameter("tos");
        %>
        <%if(!(email.equals("")) && tos != null){%>
        <table class="table">
            <tr><td>Name:</td><td><%= name%></td></tr>
            <tr><td>Email:</td><td><%= email%></td></tr>
            <tr><td>Password:</td><td><%= password%></td></tr>
            <tr><td>Dob:</td><td><%= dob%></td></tr>
            <tr><td>Gender:</td><td><%= gender%></td></tr>
            <tr><td>Tos:</td><td><%= tos%></td></tr>
        </table>
        <%}else if (tos == null){%>
        <p>Sorry, you must agree to the Terms of Service. Click <a href="register.jsp">here</a> to go back.</p>
        <%}else{%>
        <p>Sorry unknown email click <a href="register.jsp">here</a> to go back</p>
        <%}%>
        <div id="clock" class="footer">
        </div>
    </body>
</html>
