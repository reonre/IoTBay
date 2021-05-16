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
        //3- capture the posted data from the jsp.
        int id = ((User)session.getAttribute("user")).getUSER_ID();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
         String type = request.getParameter("type");
        String position = request.getParameter("position");
        String password = request.getParameter("password");
        //5- retrieve the role from the current user session.  
        String role = ((User)session.getAttribute("user")).getClass().getSimpleName();
        
        //If statement for identifying the role.
        if (role.equals("Staff")) {
            role = "S";
        }
        else {
            role = "C";
        }
        //Instancing the DBManager.
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user;
        
        //Calling the validator methods to check the email and password.
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
                    manager.updateStaff(id, name, email, password, phone, gender, dob, address, position);
                    System.out.print("updatedStaff");//Console test.
                    //Binds the object with a name and stores the name/value pair as an attribute of the HttpSession object. 
                    session.setAttribute("user", new Staff(id, name, email, password, phone, gender, dob, address, position));
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    manager.updateCustomer(id, name, email, password, phone, gender, dob, address, type);//calls the updateCustomer function from the DBmanager.
                    System.out.print("updatedCustomer");//Console Test
                    //Binds the object with a name and stores the name/value pair as an attribute of the HttpSession object. 
                    session.setAttribute("user", new Customer(id, name, email, password, phone, gender, dob, address, type));//Sets the 
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                System.out.println("Error in EditServlet");
            }
        }
    }
}
