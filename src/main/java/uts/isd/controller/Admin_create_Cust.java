/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ben's Pc
 */

package uts.isd.controller;
import uts.isd.model.dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Create_Customer_Servlet", urlPatterns = {"/Create_Customer_Servlet"})
public class Admin_create_Cust extends HttpServlet {
    private DBConnector Connector;
    private DBManager Query;
    
    
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response){
          // retrieves the parameters
        String NAME = request.getParameter("NAME");
        String EMAIL = request.getParameter("EMAIL");
        String ADDRESS = request.getParameter("ADDRESS");
        String PASSWORD = request.getParameter("PASSWORD");
        String GENDER = request.getParameter("GENDER");
        String PHONE = request.getParameter("PHONE");
        String DOB = request.getParameter("DOB");
   
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            Connector = new DBConnector();// this creates a new connector
            Query = new DBManager(Connector.openConnection()); //This code opens connection 
        }
        catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }


            Query.addUser("NAME",EMAIL,ADDRESS,PASSWORD,GENDER,PHONE,DOB);
        //Connector.closeConnection();
        }
    }
