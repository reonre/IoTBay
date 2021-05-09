<%-- 
    Document   : createCustomer
    Created on : 08/05/2021, 10:08:01 AM
    Author     : ben's pc
--%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<div class="main-component">
<div class="dashboard-form-container with-bg has-subheading">
</head>

<link rel="stylesheet" href="./css/customer.css">
<link rel="stylesheet" href="./css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<body>                

      <h1 class="title">Create Customer</h1>


      <form action="Create_Customer_Servlet" method="POST">



      <table>



      <tr>
              <td><p class="subtitle"><label for="firstname">Firstname </label></p></td>
          <td><p>&nbsp;</p></td>
          <td><p><input type="firstname" name="FNAME"required="True"</p></td>
      </tr>
      <tr>
              <td><p class="subtitle"><label for="username">Lastname </label></p></td>
          <td>&nbsp;</td>
          <td><p><input type="lastname" name="LNAME"required="True"</p></td>
      </tr>
      <tr>
              <td><p class="subtitle"><label for="Address">Address </label></p></td>
          <td>&nbsp;</td> 
          <td><p><input type="address" name="ADDRESS"required="True"</p></td>
      </tr>
      <tr>
              <td><p class="subtitle"><label for="Email">Email address </label></p></td>
          <td>&nbsp;</td> 
          <td><p><input type="email" name="EMAIL"required="True"</p></td>
      </tr>
      <tr><td><p>&nbsp;</p></td></tr>
      <tr>
              <td><p class="subtitle"><label for="username">Username </label></p></td>
          <td>&nbsp;</td>
          <td><p><input type="username" name="USERNAME"required="True"</p></td>
      </tr>
      <tr>
              <td><p class="subtitle"><label for="password">Password </label></p></td>
          <td>&nbsp;</td>
          <td><p><input type="password" name="PASSWORD"required="True"</p></td>
      </tr>
      </table>  	

        <p><button type="submit" class ="btn"><h2>Register<h2></button><p>

      
      <a href="AdminHome.jsp"> admin home page link!</a>
          </div>
      </div>
      </body>
</html>
