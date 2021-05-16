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
        session = request.getSession();
        
        // get user from session
        user = (User)session.getAttribute("user");
        
        // Check if user is Staff
        // Else then to ProductList page
        if (user != null && user.getClass().getSimpleName().equals("Staff")) {
            //get product manager
            productDBManager = (ProductDBManager)session.getAttribute("productDBManager");
            
            //Get ID from request
            int id = Integer.parseInt(request.getParameter("id"));
            
            // clear validator
            validator = new Validator();
            validator.clear(session);

            try {
                //find product by product id
                product = productDBManager.findProduct(id);
                
                //if product is not empty, then return editProduct page with product information
                if (product != null) {
                    //get product attributes and place them in session
                    session.setAttribute("product", product);
                    //go to edit page
                    request.getRequestDispatcher("editProduct.jsp").include(request, response);
                } else {  // else return to productList page
                    session.setAttribute("productErr", "Product doesn't exist");
                    response.sendRedirect("ProductListServlet");
                }
            } catch (SQLException ex) {           
                  Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
            }
        } else {
            //if user is not staff, then go to page
            session.setAttribute("productErr", "You are not staff member");
            response.sendRedirect("ProductListServlet");
        }
     }

}
