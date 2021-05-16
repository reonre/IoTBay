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
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Charl
 */
public class LoginServlet extends HttpServlet {

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
        //5- retrieve the manager instance from session    
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        validator.clear(session);
        
        //Validates the Email.
        if (!validator.validateEmail(email)){
            session.setAttribute("emailErr","Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request,response);
        }
        //if the email entered equals "admin@admin" then redirect to the admin_home.jsp.
        else if (email.equals("admin@admin") && password.equals("admin")) {
            session.setAttribute("admin", "admin");
            request.getRequestDispatcher("admin_home.jsp").include(request,response);
        } 
        else{
            try {
                user = manager.findUser(email, password); //The calls the findUser method which returns the user of the matched email and password.
                if (user != null){
                    session.setAttribute("user",user);
                    request.getRequestDispatcher("index.jsp").include(request,response);
                    manager.addLogLogin(user.getUSER_ID());//Calls the add log method to update the table.
                }
                else {
                    session.setAttribute("existErr","User does not exist in the Database!");
                    request.getRequestDispatcher("login.jsp").include(request,response);
                }
                
            } catch (SQLException | NullPointerException ex){
                request.getRequestDispatcher("login.jsp").include(request,response);
                System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");
            }
        }
    }
}
