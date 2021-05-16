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
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        //3- capture the session ID.
        int id = ((User)session.getAttribute("user")).getUSER_ID();
        //4- capture the session password.
        String password = ((User)session.getAttribute("user")).getPassword();
        //5- retrieve the manager instance from session    
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try {
            //Test Cases.
            System.out.println(id);
            System.out.println(password);
            //Call the DeleteUser function from the instanced DBmanger and add asigne 2 parameters of id and password.
            manager.deleteUser(id, password);
            //Invalidate the session after deleting (deactivating) the account.
            session.invalidate();
            //getRequest dispatcher methods takes the index.jsp argument.
            //Wraps the link with a RequestDispatcher object, and returns the resulting object.
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
        catch (SQLException ex) {
            System.out.println("Error in Delete Servlet");
        }
        
        
    }
}
