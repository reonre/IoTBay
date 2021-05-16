
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
        // get session
        session = request.getSession();
        
        // get product manager
        productDBManager = (ProductDBManager)session.getAttribute("productDBManager");

        //Get query
        name = request.getParameter("nameSearch");
        type = request.getParameter("typeSearch");
        
        // create product array
        products = new ArrayList<>();


        try {
            // get products from the searches
            products = productDBManager.searchProducts(name, type);
            // if products are return then show
            if (products != null) {
                session.setAttribute("products", products);
                //keep the search search names when view loads
                session.setAttribute("nameSearch", name);
                session.setAttribute("typeSearch", type);
            } else {
                //show error that there are no products
                session.setAttribute("searchErr", "No Products exist");
            }
        } catch (SQLException ex) {           
            Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
        } finally {
            // show product list page
            request.getRequestDispatcher("productList.jsp").include(request, response);
            // refresh search error
            session.setAttribute("searchErr", null);
        }
    }
}
