/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

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
import uts.isd.model.Product;
import uts.isd.model.*;
import uts.isd.model.dao.OrderDBManager;


/**
 *
 * @author leon
 */

//Servlet for creating an order with products.
public class OrderProductServlet extends HttpServlet {
    HttpSession session;
    OrderDBManager OrderDBManager;
    Product product;
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        OrderDBManager = (OrderDBManager)session.getAttribute("orderDBManager");
       String name= request.getParameter("name");
      String billAddress= request.getParameter("billadd");
      String shipAddress=request.getParameter("shipadd");
      int quantity=Integer.parseInt(request.getParameter("quant"));
      User user= (User)session.getAttribute("user");
      Product product=(Product)session.getAttribute("product");
      java.util.Date date= new java.util.Date();

        //Get ID from request
//        int id = Integer.parseInt(request.getParameter("id"));

//        System.out.println(user.get);
        try {
            Orders order= new Orders(0,user.getUSER_ID(),product.getProd_id(),date.toString(),"",name,quantity,product.getProduct_price(),0.0,billAddress,shipAddress,"In-Progress");
            OrderDBManager.addOrder(order);
            session.setAttribute("order", order);

//            response.sendRedirect("OrderHistoryServlet");
            
            request.getRequestDispatcher("viewOrder.jsp").include(request, response);
           
          
//            OrderDBManager= OrderDBManager.findProduct(PROD_ID);
//            if (product != null) {
//                session.setAttribute("product", product);
//                request.getRequestDispatcher("product.jsp").include(request, response);
//            } else {
//                session.setAttribute("productErr", "Product doesn't exist");
//                response.sendRedirect("ProductListServlet");
//            }
            
        } catch (SQLException ex) {           
              Logger.getLogger(OrderProductServlet.class.getName()).log(Level.SEVERE, null, ex); 
              System.out.println("sajbndkhsanbdksadbnsakdbsakasnjdsa");
        }
//     }
    }
}
