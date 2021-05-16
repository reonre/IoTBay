/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Product;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class ProductListServlet extends HttpServlet {
    ArrayList<Product> productList;
    HttpSession session;
    ProductDBManager productDBManager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = new ArrayList<>();
        session = request.getSession();
        productDBManager = (ProductDBManager)session.getAttribute("productDBManager");
        
        try { 
            productList = productDBManager.listAllProducts();
            
            if (!productList.isEmpty()) {
                session.setAttribute("products", productList);
            }
        } catch (SQLException ex) {           
            Logger.getLogger(ProductListServlet.class.getName()).log(Level.SEVERE, null, ex);  
        } finally {
            request.getRequestDispatcher("productList.jsp").include(request, response);
        }
        
    }

}
