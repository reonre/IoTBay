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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <title>Staff Register</title>
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
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about_us.jsp">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact_us.jsp">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-white" type="button" href="login.jsp" data-toggle="modal" data-target="#myModal">Sign In</a>                  
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link btn btn-danger text-white" type="button" href="register.jsp" data-toggle="modal" data-target="#myModal">Register</a>
                    </li>
                </ul>
            </div>
        </nav>

        <form action="RegisterServlet" method="post">
            <table class="table table-responsive">
                <tr><td>Name</td><td><input type="text" name="name"/></td></tr>
                <tr><td>Email</td><td><input type="email" name="email"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password"/></td></tr>                
                <tr>

                    <td>
                        <select class="select" name="gender">
                            <option value="empty">Gender</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>                                                                
                        </select>                                   
                    </td>
                    <td>
                        <input class="date" type="date" name="dob"/>  
                    </td>
                </tr>
                <tr><td>Phone Number</td><td><input type="text" name="phone"/></td></tr>
                <tr><td>Address</td><td><input type="text" name="address"/></td></tr>
                <tr><td>Role:</td><td>Staff<text value="Staff" name="role" /></td></tr>
                <tr><td>Position</td><td><input type="text" name="position"/></td></tr>
                <tr><td>Agree to Terms of Service</td><td><input type="checkbox" name="tos" id="tos"/></td></tr>
                <tr><td>
                        <input type="submit" value="Submit" class="button" name = "submit" id="submit" disabled>
                    </td></tr>
            </table>
        </form>
        <form action="register.jsp">
            <input type="submit" value="Back"/>
        </form>
        <script>
            var checker = document.getElementById("tos");
            var send = document.getElementById("submit")
            this.onchange = function () {
                if (checker.checked) {
                    send.disabled = false;
                } else {
                    send.disabled = true;
                }
            }
        </script>
    </body>
</html>