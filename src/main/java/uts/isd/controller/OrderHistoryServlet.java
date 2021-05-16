/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.OrderDBManager;
import uts.isd.model.Orders;
import uts.isd.model.User;


/**
 *
 * @author Typing Corpse
 */


public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = ((User) session.getAttribute("user")).getUSER_ID();
        OrderDBManager ordManager = (OrderDBManager) session.getAttribute("ordManager");
        System.out.print(id);
        
        try {
            ArrayList<Orders> orders = ordManager.fetchOrders(id);
            session.setAttribute("orders", orders);
            request.getRequestDispatcher("viewOrder.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
