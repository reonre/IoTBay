
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
import uts.isd.model.Product;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class ProductServlet extends HttpServlet {
    HttpSession session;
    ProductDBManager productDBManager;
    Product product;
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get session
        session = request.getSession();
        
        //get product manager
        productDBManager = (ProductDBManager)session.getAttribute("productDBManager");

        //Get ID from request
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            //find product by id
            product = productDBManager.findProduct(id);
            
            //if product is returned
            if (product != null) {
                //get product and set in session
                session.setAttribute("product", product);
                //go to product page
                request.getRequestDispatcher("product.jsp").include(request, response);
            } else {
                //show error that product does not exit
                session.setAttribute("productErr", "Product doesn't exist");
                //to to product list page
                response.sendRedirect("ProductListServlet");
            }
            
        } catch (SQLException ex) {           
              Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
     }

}
