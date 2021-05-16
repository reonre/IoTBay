/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.controller.Validator;
import uts.isd.model.Product;
import uts.isd.model.User;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class EditProductServlet extends HttpServlet {

    HttpSession session;
    ProductDBManager productDBManager;
    Product product;
    Validator validator;
    User user;
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = (User)session.getAttribute("user");
        
        if (user != null && user.getClass().getSimpleName().equals("Staff")) {
            session = request.getSession();
            productDBManager = (ProductDBManager)session.getAttribute("productDBManager");

            //Get ID from request
            int id = Integer.parseInt(request.getParameter("id"));
            validator = new Validator();
            validator.clear(session);

            try {
                product = productDBManager.findProduct(id);
                if (product != null) {
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("editProduct.jsp").include(request, response);
                } else {
                    session.setAttribute("productErr", "Product doesn't exist");
                    response.sendRedirect("ProductListServlet");
                }
            } catch (SQLException ex) {           
                  Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
            }
        } else {
            response.sendRedirect("ProductListServlet");
        }
     }

}
