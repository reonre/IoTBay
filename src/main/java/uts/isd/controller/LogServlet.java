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
import uts.isd.model.dao.DBManager;
import java.util.*;

/**
 *
 * @author Charl
 */
public class LogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //5- retrieve the manager instance from session    
        DBManager manager = (DBManager) session.getAttribute("manager");
        int id = ((User)session.getAttribute("user")).getUSER_ID();
        try {
            if (session.getAttribute("log") != null) {
                ArrayList<AccessLog> log = (ArrayList<AccessLog>)session.getAttribute("log");
                Collections.reverse(log);
                session.setAttribute("log", log);
                request.getRequestDispatcher("log.jsp").include(request,response);
            }
            else {
                ArrayList<AccessLog> log = manager.fetchLogs(id);
                session.setAttribute("log", log);
                request.getRequestDispatcher("log.jsp").include(request,response);
            }
        }
        catch (SQLException e) {
            
        }
    }
}
