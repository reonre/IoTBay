<%-- 
    Document   : create_payment
    Created on : 12 May 2021, 12:06:28
    Author     : casio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
        <title> Payment Create Page</title>
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

        <form action="PaymentServlet" method="post">
            <table class="table table-responsive">          
                <tr><td>Order #${invoiceId}</td><td>
                <tr><td>Total Amount A$${order.getAmount()}</td><td>
                <tr>
                    <td>
                        <select class="select" name="paymentMethod">
                            <option value="empty">Payment Method</option>
                            <option value="card">Credit Card</option>
                            <option value="cash">Cash</option>
                            <option value="other">Other</option>                                                                
                        </select>                                   
                    </td>
                    <td>
                        <input class="date" type="date" name="datePaid"/>  
                    </td>
                </tr>
                <tr><td>Card Number</td><td><input type="text" name="cardNumber"/></td></tr>
                <tr><td>Expiry Date</td><td><input type="text" name="expiryDate"/></td></tr>
                <tr><td>CVV</td><td><input type="text" name="cvv"/></td></tr>
                <tr><td>Name On Card</td><td><input type="text" name="nameOnCard"/></td></tr>
                <tr><td>Agree to Terms of Service</td><td><input type="checkbox" name="tos" id="tos"/></td></tr>
                <tr><td>
                        <input type="submit" value="Pay" class="button" name = "submit" id="submit" disabled>
                    </td></tr>
            </table>
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
        <jsp:include page="/PaymentConnServlet" flush="true"/>
    </body>
</html>





