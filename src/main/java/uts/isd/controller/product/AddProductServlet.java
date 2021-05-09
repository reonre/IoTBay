package uts.isd.controller.product;

import uts.isd.controller.Validator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class AddProductServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Create instance for Validator
        Validator validator = new Validator();
        
        //Retrieve current session
        HttpSession session = request.getSession();
        
        //Retrieve ProductDBManager instance for session
        ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
        
        
        //Capture product attributes from request
        String name = request.getParameter("name");
        String price = request.getParameter("price");
    }
}
