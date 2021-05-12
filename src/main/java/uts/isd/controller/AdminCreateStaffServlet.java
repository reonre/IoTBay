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
import uts.isd.model.dao.StaffDBManager;

/**
 *
 * @author Charl
 */
public class AdminCreateStaffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        //3- capture the posted email
        String email = request.getParameter("email");
        //4- capture the posted password
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        String position = request.getParameter("position");
               
        //5- retrieve the manager instance from session    
        StaffDBManager manager = (StaffDBManager) session.getAttribute("manager");
        User user;
        validator.clear(session);
        
        if (!validator.validateEmail(email)){
            session.setAttribute("emailErr","Error: Email format incorrect");
            request.getRequestDispatcher("create_staff.jsp").include(request,response);
        }
        else if (!validator.validatePassword(password)){
            session.setAttribute("passErr","Error: Password format incorrect");
            request.getRequestDispatcher("create_staff.jsp").include(request,response);
        }
        else{
            try {
                manager.addStaff(name, email, password, phone, gender, dob, address, position);
                request.getRequestDispatcher("admin_home.jsp").include(request,response);
            } 
            catch (SQLException | NullPointerException ex){
                System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcomelaksjdflkjasdf");
            }
        }
    }
}
