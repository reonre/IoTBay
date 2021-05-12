<%-- 
    Document   : createCustomer
    Created on : 08/05/2021, 10:08:01 AM
    Author     : ben's pc
--%>

<!DOCTYPE html>
<html>
<head>
<title>Create Customer</title>
<div class="main-component">
<div class="dashboard-form-container with-bg has-subheading">
</head>

<link rel="stylesheet" href="./css/customer.css">
<link rel="stylesheet" href="./css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<body>                

      <h1 class="title">Create Customer</h1>
      <form action="Admin_create_cust" method="POST">
                <table>
                    <tr>
                        <td><p class="subtitle"><label for="name">name</label></p></td>
                        <td><p><input type="name" name="NAME" required="True" </p></td>
                    </tr>

                    <tr>
                        <td><p class="subtitle"><label for="Address">Address </label></p></td>
                        <td><p><input type="address" name="ADDRESS" required="True"</p></td>
                    </tr>
                    
                    <tr>
                        <td><p class="subtitle"><label for="Email">Email</label></p></td>
                        <td><p><input type="email" name="EMAIL"required="True"</p></td>
                    </tr>

                    <tr>
                        <td><p class="subtitle"><label for="username">password </label></p></td>
                        <td><p><input type="password" name="PASSWORD" required="True"</p></td>
                    </tr>
                    
                    <tr>
                        <td><p class="subtitle"><label for="gender">Gender </label></p></td>
                        <td><p><input type="Gender" name="PASSWORD" required="True"</p></td>
                    </tr>
                    
                     <tr>
                        <td><p class="DOB"><label for="gender">DOB </label></p></td>
                        <td><p><input type="DOV" name="DOB" required="True"</p></td>
                    </tr>
                    
                </table>  	

                <p><button type="submit" class ="btn"><h1>add customer<h1></button><p>
                <a href="AdminHome.jsp"> admin home page link!</a>
                
            </div>
         </div>
      </body>
</html>
