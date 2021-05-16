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
import uts.isd.model.dao.PaymentManager;
import uts.isd.model.dao.DBConnector;

/**
 *
 * @author casio
 */
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentMethod = request.getParameter("paymentMethod");
        String cardNumber = request.getParameter("cardNumber");
        String cvv = request.getParameter("cvv");
        String nameOnCard = request.getParameter("nameOnCard");
        String expiryDate = request.getParameter("expiryDate");
        String datePaid = request.getParameter("datePaid");

        Payment payment = new Payment(paymentMethod, cardNumber, expiryDate, cvv, nameOnCard, datePaid);
        User user = (User) session.getAttribute("user");
        PaymentManager manager = (PaymentManager) session.getAttribute("manager");
        Orders orders = (Orders) session.getAttribute("order");
        validator.clear(session);

        try {

            //payment = manager.searchPayment(payment_Id, datePaid);
            //if (payment != null) {
            //request.getRequestDispatcher("confirm_payment.jsp").include(request, response);
            //} else {
            //int order_Id = manager.getOrderId();
            
            double orderPrice = orders.getTotalPrice();
            int order_Id = (int)session.getAttribute("orderId");
            //double orderPrice = manager.getPrice();
            System.out.println(order_Id);
            System.out.println(orderPrice);
            //session.setAttribute("INVOICE_ID", invoice_Id);
            //session.setAttribute("PAY_ID", payment_Id);
            manager.addPayment(order_Id, paymentMethod, orderPrice, cardNumber, expiryDate, cvv, nameOnCard, datePaid);
            int payment_Id = manager.getPaymentId(cardNumber);
            payment = manager.searchPayment(payment_Id, datePaid);
            manager.addHistory(user.getUSER_ID(), payment_Id, order_Id, paymentMethod, orderPrice, cardNumber, nameOnCard, datePaid);
            session.setAttribute("payment", payment);

            request.getRequestDispatcher("confirm_payment.jsp").include(request, response);
            //}
        } catch (SQLException | NullPointerException ex) {
            request.getRequestDispatcher("create_payment.jsp").include(request, response);

        }
    }
}
