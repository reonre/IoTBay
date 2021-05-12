<%-- 
    Document   : UpdateSaff
    Created on : 08/05/2021, 10:19:59 AM
    Author     : ben's pc
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@page import ="IoTBay.mvp.model.*"%> --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Staff Portal</title>
        <link rel="stylesheet" href="./css/admin_update_staff.css">
    </head>
    <body>
        <%--    <%
            Staff staff = (Staff) session.getAttribute("staff");
            String updated = (String) session.getAttribute("updated");
            String oldUsername = (String) session.getAttribute("oldUsername");
        %> --%>
     <div class="main-component">
       <div class="dashboard-form-container with-bg has-subheading">
         <h1 class="form-title">Update Staff Details</h1>
         <form action = "UpdateStaffServlet" method="post">
            <table>
                        <input type ="hidden" id="oldUsername" name="oldUsername" required value="${oldUsername}"><br>
                <tr>
                    <td>
                        <label for="first-name" class="subtitle"> Name</label>
                    </td>
                    <td>
                        <input type ="text" id="name" name="name" required value="${staff.getStaffFName()}"><br>
                    </td>
                </tr>
            
                <tr>
                    <td>
                        <label for name="address" class="subtitle">Address</label>                     
                    </td>
                    <td>
                        <input type="text" id="address" name="address"  value="${staff.getStaffAddress()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Email</label>                     
                    </td>
                    <td>
                        <input type="email" id="email" name="email"  value="${staff.getStaffEmail()}">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="email" class="subtitle">Position</label>                     
                    </td>
                    <td>
                        <select id="position"  name="position" value="${staff.getStaffPosition()}">
                            <option value="Staff">Staff</option>
                            <option value="Admin">Admin</option>
                           
                        </select>
                    </td>
                </tr>
                <tr class="break"><td colspan=2></td></tr>
           
                  
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" required value="${staff.getStaffPassword()}">
                    </td>
                </tr>
           
                <tr class="break"><td colspan=2></td></tr>
            </table>
            <input type="submit" value="Update" >
        </form>
           <div class="button-container">
                <p><a href="AdminHome.jsp">go to admin home page</a></p>
           </div>
                        <%--  <span><%=(updated != null ? updated : "")%></span>  --%>
       </div>
     </div>
    </body>
</html>


