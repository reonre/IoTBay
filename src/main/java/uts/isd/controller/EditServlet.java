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
        //4- capture the posted password
        String password = request.getParameter("password");
        
        //5- retrieve the manager instance from session    
        String role = ((User)session.getAttribute("user")).getClass().getSimpleName();
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user;
        if (role.equals("Staff")) {
            String position = request.getParameter("position");
            user = new Staff(id, name, email, password, phone, gender, dob, address, position);
        }
        else {
            String type = request.getParameter("type");
            user = new Customer(id, name, email, password, phone, gender, dob, address, type);
        }
        
        try {
            session.setAttribute("user",user);
            manager.updateUser(id, name, email, password, phone, gender, dob, address);
            request.getRequestDispatcher("main.jsp").include(request,response);
        }
        catch (SQLException ex) {
            System.out.println("fk");
        }
        
        
    }
}
