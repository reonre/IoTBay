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
public class EditPaymentServlet extends HttpServlet {
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // session 
        HttpSession session = request.getSession();
        Integer PAY_ID = Integer.parseInt(request.getParameter("paymentId"));
        PaymentManager manager = ( PaymentManager) session.getAttribute("manager");
        
        Payment payment = null;
        try{
            //find the paymnetId to edit the details
            payment = manager.foundedPaymentId(PAY_ID);
            System.out.println(PAY_ID);
            if(payment != null){
                session.setAttribute("payment", payment);
                request.getRequestDispatcher("confirm_payment.jsp").include(request, response);
                response.sendRedirect("update_payment.jsp");
            } else {
                session.setAttribute("existErr", "Payment does not exist in database");
                request.getRequestDispatcher("update_payment.jsp").include(request, response);
            }
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }  
}
