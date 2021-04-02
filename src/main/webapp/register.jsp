<%-- 
    Document   : register
    Created on : 15/03/2021, 3:55:19 PM
    Author     : team 43
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Register</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            Register
            <span id="links"> <a href = "index.jsp"> Home Page </a> | <a href = "about_us.jsp"> About Us </a> | <a href = "contact_us.jsp"> Contact Us </a> | <a href="login.jsp"> Login</a> | <a href="register.jsp">Register </a></span>
        </div>

        <form action="welcome.jsp" method="post">
            <table class="table">
                <tr><td>Name</td><td><input type="text" name="name"/></td></tr>
                <tr><td>Email</td><td><input type="text" name="email"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password"/></td></tr>                
                <tr>
    
                    <td>
                        <select class="select" name="gender">
                            <option value="empty">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>                                                                
                        </select>
                        <input class="date" type="date" name="dob"/>                                     
                    </td>
                </tr>
  
                <tr><td>Agree to Terms of Service</td><td><input type="checkbox" name="tos" id="tos"/></td></tr>
                <tr><td>
                            <input type="submit" value="Submit" class="button" name = "submit" id="submit" disabled>
                    </td></tr>
            </table>
        </form>
        <script>
                                var checker = document.getElementById("tos");
                                var send = document.getElementById("submit")
                                this.onchange = function() {
                                    if (checker.checked) {
                                        send.disabled = false;
                                    }
                                    else {
                                        send.disabled = true;
                                    }
                                }
                                </script>

        <div id="clock" class="footer"></div>

    </body>
</html>