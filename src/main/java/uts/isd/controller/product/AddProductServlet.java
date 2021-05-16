package uts.isd.controller.product;

import uts.isd.controller.Validator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class AddProductServlet extends HttpServlet {
    ProductDBManager productDBManager;
    HttpSession session;
    Validator validator;
    User user;
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        // get user session
        user = (User)session.getAttribute("user");
        
        // Check if user is Staff
        // Else then to ProductList page
        if (user != null && user.getClass().getSimpleName().equals("Staff")) {
            //call manager
            productDBManager = (ProductDBManager)session.getAttribute("productDBManager");
            
            //get product parameters for view
            String name = request.getParameter("PRODUCT_NAME");
            String price = request.getParameter("PRODUCT_PRICE");
            String desc = request.getParameter("PRODUCT_DESC");
            String type = request.getParameter("PRODUCT_TYPE"); 
            String quantity = request.getParameter("PRODUCT_QUANT");
            
            // clear validator
            validator = new Validator();
            validator.clear(session);
        
            // Validate if inputs are in the correct format
            if (!validator.validateProductName(name)){
                session.setAttribute("productNameErr", "Incorrect name");
                request.getRequestDispatcher("addProduct.jsp").include(request, response);
            } else if (!validator.validateProductPrice(price)) {
                session.setAttribute("productPriceErr", "Incorrect price");
                request.getRequestDispatcher("addProduct.jsp").include(request, response);
            } else if (!validator.validateProductDesc(desc)) {
                session.setAttribute("productDescErr", "Incorrect description");
                request.getRequestDispatcher("addProduct.jsp").include(request, response);
            } else if (!validator.validateProductType(type)) {
                session.setAttribute("productTypeErr", "Incorrect type");
                request.getRequestDispatcher("addProduct.jsp").include(request, response);
            } else if (!validator.validateProductQuantity(quantity)) {
                session.setAttribute("productQuantityErr", "Incorrect quantity");
                request.getRequestDispatcher("addProduct.jsp").include(request, response);
            } else { 
                try {
                    //add product
                    productDBManager.addProduct(name, price, desc, type, quantity);
                    //show that product is added
                    session.setAttribute("productErr", "Product added");
                    // go to product list page
                    response.sendRedirect("ProductListServlet");
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        } else {
            //show that user is not a staff member
            session.setAttribute("productErr", "You are not a staff user");
            response.sendRedirect("ProductListServlet");
        }
    }
}
