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

/**
 *
 * @author Charl
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        //3- capture the posted email
        int id = ((User)session.getAttribute("user")).getUSER_ID();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
         String type = request.getParameter("type");
        String position = request.getParameter("position");
        //4- capture the posted password
        String password = request.getParameter("password");
        
        //5- retrieve the manager instance from session    
        String role = ((User)session.getAttribute("user")).getClass().getSimpleName();
//        String role = (String)request.getSession().getAttribute("role");
        

        if (role.equals("Staff")) {
            role = "S";
        }
        else {
            role = "C";
        }
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user;
        
        if (!validator.validateEmail(email)){
            session.setAttribute("emailErr","Error: Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        }
        else if (!validator.validatePassword(password)){
            session.setAttribute("passErr","Error: Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        } else {
            try {
                if (role.equals("S")) {
                    System.out.print("Before");
                    manager.updateStaff(id, name, email, password, phone, gender, dob, address, position);
                    System.out.print("updatedStaff");
                    session.setAttribute("user", new Staff(id, name, email, password, phone, gender, dob, address, position));
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    System.out.print("After");
                    manager.updateCustomer(id, name, email, password, phone, gender, dob, address, type);
                    System.out.print("updatedCustomer");
                    session.setAttribute("user", new Customer(id, name, email, password, phone, gender, dob, address, type));
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                System.out.println("Error in EditServlet");
            }
        }
    }
}
