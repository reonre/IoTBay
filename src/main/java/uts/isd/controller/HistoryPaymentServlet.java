/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.PaymentManager;
import java.util.*;


/**
 *
 * @author casio
 */
public class HistoryPaymentServlet extends HttpServlet {
    
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       //1- retrieve the current session
        HttpSession session = request.getSession();
        //5- retrieve the manager instance from session    
        PaymentManager manager = (PaymentManager) session.getAttribute("manager");
        int id = ((User)session.getAttribute("user")).getUSER_ID();
        try {
            if (session.getAttribute("history") != null) {
                ArrayList<PaymentHistory> history = (ArrayList<PaymentHistory>)session.getAttribute("history");
                Collections.reverse(history);
                session.setAttribute("history", history);
                request.getRequestDispatcher("payment_user_history.jsp").include(request,response);
            }
            else {
                ArrayList<PaymentHistory> history = manager.fetchHistory(id);
                session.setAttribute("history", history);
                request.getRequestDispatcher("payment_user_history.jsp").include(request,response);
            }
        }
        catch (SQLException e) {
            
        }
    }  
}
