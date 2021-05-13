/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.Payment;
import uts.isd.model.dao.PaymentManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author casio
 */
public class PaymentUpdateServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         String paymentMethod = request.getParameter("paymentMethod");
         String cardNumber = request.getParameter("cardNumber");
         String cvv = request.getParameter("cvv");
         String nameOnCard = request.getParameter("nameOnCard");
         String expiryDate = request.getParameter("expiryDate");
         String datePaid = request.getParameter("datePaid");    

         Payment payment = new Payment(paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid);
         PaymentManager manager = (PaymentManager) session.getAttribute("manager");

         try{
             if(payment != null){
                 session.setAttribute("payment", payment);
                 manager.updatePayment(manager.getPaymentId(cardNumber), paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid);
                 request.getRequestDispatcher("update_payment.jsp").include(request, response);
                 response.sendRedirect("confirm_payment.jsp");
                 
             } else {
                 request.getRequestDispatcher("update_payment.jsp").include(request, response);
             }
         } catch ( SQLException ex){
             Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}