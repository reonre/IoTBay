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
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        //3- capture the posted data from the jsp.
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String role = (String)request.getSession().getAttribute("role");
        String type = request.getParameter("type");
        String position = request.getParameter("position");
               
        if (role.equals("Staff")) {
            role = "S";
        }
        else {
            role = "C";
        }
        //5- retrieve the manager instance from session    
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user;
        validator.clear(session);
        //Validate the email and password.
        if (!validator.validateEmail(email)){
            session.setAttribute("emailErr","Error: Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        }
        else if (!validator.validatePassword(password)){
            session.setAttribute("passErr","Error: Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        }
        else{
            try {
                user = manager.findUser(email, password);//The calls the findUser method which returns the user of the matched email and password.
                if (user != null){
                    request.getRequestDispatcher("main.jsp").include(request,response);
                }
                else if (role.equals("S")){
                    //The calls the addStaff function which adds the captured data from the current session into the database.
                    manager.addStaff(name, email, password, phone, gender, dob, address, role, position);
                    user = manager.findUser(email, password);
                    manager.addLogLogin(user.getUSER_ID());//Adds to the log.
                    //Binds the object with a name and stores the name/value pair as an attribute of the HttpSession object. 
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request,response);
                }
                else {
                    //The calls the addCustomer function which adds the captured data from the current session into the database.
                    manager.addCustomer(name, email, password, phone, gender, dob, address, role, type);
                    user = manager.findUser(email, password);
                    manager.addLogLogin(user.getUSER_ID());
                    //Binds the object with a name and stores the name/value pair as an attribute of the HttpSession object. 
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request,response);
                }
                
            } catch (SQLException | NullPointerException ex){
                if (role.equals("S")){
                    request.getRequestDispatcher("staff_register.jsp").include(request,response);
                }
                else {
                    request.getRequestDispatcher("customer_register.jsp").include(request,response);
                }
                System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcomelaksjdflkjasdf");
            }
        }
    }
}
