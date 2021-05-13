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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author casio
 */
public class DeletePaymentServlet extends HttpServlet {
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // session 
        HttpSession session = request.getSession();
        Integer paymentId = Integer.parseInt(request.getParameter("paymentId")); 
        PaymentManager manager = ( PaymentManager) session.getAttribute("manager");
        
        Payment payment = null;
        try{
            //delete the payment from database based from the paymentId
            payment = manager.foundedPaymentId(paymentId);
            if(payment != null){
                manager.deletePayment(paymentId);
                session.setAttribute("fetchMessage", "Payment is deleted successfully!");
            } else {
                session.setAttribute("fetchMessage", "Payment is not deleted!");
            }
            response.sendRedirect("payment_cart.jsp");
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
       request.getRequestDispatcher("payment_cart.jsp").include(request, response);
    }  
}