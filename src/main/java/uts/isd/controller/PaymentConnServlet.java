/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;

/**
 *
 * @author Charl
 */
public class PaymentConnServlet extends HttpServlet {

    private DBConnector db;
    private PaymentManager manager;
    private Connection conn;

    @Override //Create and instance of DBConnector for the deployment session

    public void init() {
        try {
            db = new DBConnector(); //Create a database wen the application.
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaymentConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override //Add the DBManager instance to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();

        try {
            manager = new PaymentManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //export the DB manager to the view-session (JSPs)
        session.setAttribute("manager", manager);
    }

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}