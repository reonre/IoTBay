<%-- 
    Document   : createStaff
    Created on : 07/05/2021, 11:46:19 AM
    Author     : ben's pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Staff </title>
       
        <%
          String created = (String) session.getAttribute("created");  
        %>
    </head>
    <body>
     <div class="main-component">
       <div class="dashboard-form-container with-bg has-subheading">
         <h1 class="form-title">Create Staff </h1>
         <form action="CreateStaffServlet" method="post">
            <table>
                <tr>
                    <td>
                        <label for="first-name" class="subtitle">First Name</label>
                    </td>
                    <td>
                        <input type ="text" id="name" name="firstName" required><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="last-name" class="subtitle">Last Name</label>
                    </td>
                    <td>
                        <input type="text" id="name" name="lastName">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="address" class="subtitle">Address</label>                     
                    </td>
                    <td>
                        <input type="text" id="address" name="address" >
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Email</label>                     
                    </td>
                    <td>
                        <input type="email" id="email" name="email"  required>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="position" class="subtitle">Position</label>                     
                    </td>
                    <td>
                        <select id="position" name="position">
                            <option value="Staff">staff</option>
                            <option value="Admin">Admin</option>
                            
                        </select>
                    </td>
                </tr>
                <tr class="break"><td colspan=2></td></tr>
                <tr>
                    <td>
                        <label for name="username" class="subtitle">Username</label>                     
                    </td>
                    <td>
                        <input type="text" id="username" name="username" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="password" class="subtitle">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" required>
                    </td>
                </tr>
                <tr class="break"><td colspan=2></td></tr>
            </table>
            <input type="submit" value="Create" >
        </form>
           <div class="button-container">
                <p><a href="AdminHome.jsp">back to admin home</a></p>
           </div>
         <span><%= created != null ? created : "" %></span>
       </div>
     </div>
    </body>
</html>

