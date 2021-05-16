/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.PaymentManager;

/**
 *
 * @author casio
 */
public class DeletePaymentServlet extends HttpServlet {
    
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // session 
        HttpSession session = request.getSession();
        Payment payment = (Payment) session.getAttribute("payment");
        PaymentManager manager = ( PaymentManager) session.getAttribute("manager");
        String cardNumber = payment.getCardNumber();
        
        
        
        try{
            int paymentId = manager.getPaymentId(cardNumber);
            System.out.print(paymentId);
            manager.deletePayment(paymentId);
            //request.getRequestDispatcher("create_payment.jsp").include(request,response);
            response.sendRedirect("create_payment.jsp");
        } catch (SQLException  ex) {
           System.out.println("error");
        }
    }  
}