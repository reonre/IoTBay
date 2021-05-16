
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
import uts.isd.model.User;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class SearchProductServlet extends HttpServlet {
    HttpSession session;
    ProductDBManager productDBManager;
    ArrayList<Product> products;
    User user;
    String name, type;

    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        productDBManager = (ProductDBManager)session.getAttribute("productDBManager");

        //Get query
        name = request.getParameter("nameSearch");
        type = request.getParameter("typeSearch");
        products = new ArrayList<>();


        try {
            products = productDBManager.searchProducts(name, type);
        } catch (SQLException ex) {           
            Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        
        if (products != null) {
            session.setAttribute("products", products);
            session.setAttribute("nameSearch", name);
            session.setAttribute("typeSearch", type);
        } else {
            session.setAttribute("searchErr", "No Products exist");
        }
        request.getRequestDispatcher("productList.jsp").include(request, response);
    }
}
