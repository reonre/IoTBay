<%-- 
    Document   : adminLogin
    Created on : 09/05/2021, 1:20:05 PM
    Author     : ben's pc
--%>


<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Page</title>
    </head>
    
        <link rel="stylesheet" type="text/css" href="./css/main.css">
        
    <body>
        <div class="main-component">
            <div class="dashboard-form-container with-bg has-subheading">
           <h1 class="form-title">Login</h1>
           <form method="post" action="checkLogin">
               <table>
                   <tr>
                       <td>
                           <label for="username">username</label>
                       </td>

                       <td>
                           <input type ="text" id="username" name="username" required><br>
                       </td>
                   <tr>
                       <td>
                            <label for="password">Password</label>                     
                       </td>

                       <td>
                           <input type="password" id="password" name="password" required>
                       </td>
                   </tr>
               </table>

               <input type="submit" value="Submit" class = "btn btn-blue" : blue button>
               
           </div> 
       </div> 
        
   </body>
</html>
