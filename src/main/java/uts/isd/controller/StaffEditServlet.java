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
public class StaffEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        int id = ((Staff)session.getAttribute("staff")).getUSER_ID();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String password = request.getParameter("password");
        StaffDBManager manager = (StaffDBManager) session.getAttribute("manager");
        String activated = request.getParameter("activated");
        boolean activate;
        if (activated != null) {
            activate = true;
        }
        else {
            activate = false;
        }
        try {
            manager.updateStaff(id, name, email, password, phone, gender, dob, address, position);
            if (activate) {
                manager.activateStaff(id);
            }
            else {
                manager.deactivateStaff(id);
            }
            session.removeAttribute("staff");
            request.getRequestDispatcher("admin_home.jsp").include(request,response);
        }
        catch (SQLException e) {
            System.out.println("yes");
        }
    }
}
