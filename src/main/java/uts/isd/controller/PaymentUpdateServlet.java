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

/**
 *
 * @author casio
 */
public class PaymentUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderId = ((Payment) session.getAttribute("payment")).getOrderId();
        double orderPrice = ((Payment) session.getAttribute("payment")).getPrice();
        Payment payment = (Payment) session.getAttribute("payment");
        String paymentMethod = request.getParameter("paymentMethod");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");
        String nameOnCard = request.getParameter("nameOnCard");
        String datePaid = request.getParameter("datePaid");
        PaymentManager manager = (PaymentManager) session.getAttribute("manager");

        try {
            int paymentId = manager.getPaymentId(cardNumber);
            //int orderId = manager.getOrderId();
            //double orderPrice = manager.getPrice();
            System.out.println(paymentId);
            System.out.println(datePaid);
            manager.updatePayment(paymentId, paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid);
            manager.updatePaymentHistory(paymentId, paymentMethod, cardNumber, nameOnCard, datePaid);
            System.out.print("updated Payment");
            session.setAttribute("payment", new Payment(paymentId, orderId, paymentMethod, orderPrice, cardNumber, expiryDate, cvv, nameOnCard, datePaid));
            request.getRequestDispatcher("confirm_payment.jsp").include(request, response);

        } catch (SQLException ex) {
            System.out.println("Error in PaymentUpdateServlet");
        }
    }
}
