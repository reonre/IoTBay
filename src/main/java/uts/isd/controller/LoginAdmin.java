/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.Admin;
import uts.isd.model.dao.DBManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Ben
 */

public class LoginAdmin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        
      //  DBManager manager = (DBManager) session.getAttribute("manager");
       // LoginAdmin manager = (LoginAdmin) session.getAttribute("adminManager");
        Admin admin = null;
        validator.clear(session);
            if username =admin
   }
