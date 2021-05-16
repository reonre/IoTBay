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
public class PaymentSearchServlet  extends HttpServlet {
    
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        String datePaid = request.getParameter("datePaid");
        
        PaymentManager manager = ( PaymentManager) session.getAttribute("manager");
        
        PaymentHistory paymenth = null;

        try{
            paymenth = manager.searchPaymentHistory( paymentId, datePaid);
      
            if(paymenth != null){
                session.setAttribute("paymenth", paymenth ); 
                request.getRequestDispatcher("search_success.jsp").include(request, response);
            } else {
                session.setAttribute("existErr","Payment does not exist in the Database!");
                request.getRequestDispatcher("payment_search.jsp").include(request, response);
            } 
        } catch (SQLException | NullPointerException ex) {
           request.getRequestDispatcher("payment_search.jsp").include(request,response);
           System.out.println(ex.getMessage() == null ? "Payment does not exist" : "Error");
        }
    }  
}