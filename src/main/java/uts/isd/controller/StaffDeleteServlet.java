/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;
import uts.isd.model.dao.StaffDBManager;

/**
 *
 * @author Charl
 */
public class StaffDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        StaffDBManager manager = (StaffDBManager) session.getAttribute("manager");
        try {
            manager.deleteStaff(id);
            request.getRequestDispatcher("admin_home.jsp").include(request,response);
        }
        catch (SQLException e) {
            System.out.println("yes");
        }
    }
}
