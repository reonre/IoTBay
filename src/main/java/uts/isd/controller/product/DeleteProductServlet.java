
package uts.isd.controller.product;

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
public class DeleteProductServlet extends HttpServlet {
    HttpSession session;
    ProductDBManager productDBManager;
    User user;
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = (User)session.getAttribute("user");
        
        if (user != null && user.getClass().getSimpleName().equals("Staff")) {
            session = request.getSession();
            productDBManager = (ProductDBManager)session.getAttribute("productDBManager");

            //Get ID from request
            String id = request.getParameter("id");

            try {
                productDBManager.deleteProduct(id);
            } catch (SQLException ex) {           
                  Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
            }
        }

        response.sendRedirect("ProductListServlet");
     }
}
