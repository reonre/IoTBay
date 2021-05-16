
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
import uts.isd.model.User;
import uts.isd.model.dao.ProductDBManager;

/**
 *
 * @author oneilrangiuira
 */
public class UpdateProductServlet extends HttpServlet {
    ProductDBManager productDBManager;
    HttpSession session;
    Validator validator;
    User user;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        productDBManager = (ProductDBManager)session.getAttribute("productDBManager");
        user = (User)session.getAttribute("user");
        
        if (user != null && user.getClass().getSimpleName().equals("Staff")) {
            int id = (int)session.getAttribute("PROD_ID");
            String name = request.getParameter("PRODUCT_NAME");
            String price = request.getParameter("PRODUCT_PRICE");
            String desc = request.getParameter("PRODUCT_DESC");
            String type = request.getParameter("PRODUCT_TYPE"); 
            String quantity = request.getParameter("PRODUCT_QUANT");

            validator = new Validator();
            validator.clear(session);

            // Validate if inputs are in the correct format
            if (!validator.validateName(name)){
                session.setAttribute("productNameErr", "Incorrect name");
                session.setAttribute("productUpdate", "Update Unsuccessful");
                request.getRequestDispatcher("updateProduct.jsp").include(request, response);
            } else if (!validator.validateProductPrice(price)) {
                session.setAttribute("productPriceErr", "Incorrect price");
                session.setAttribute("productUpdate", "Update Unsuccessful");
                request.getRequestDispatcher("editProduct.jsp").include(request, response);
            } else if (!validator.validateProductDesc(desc)) {
                session.setAttribute("productDescErr", "Incorrect description");
                session.setAttribute("productUpdate", "Update Unsuccessful");
                request.getRequestDispatcher("editProduct.jsp").include(request, response);
            } else if (!validator.validateProductType(type)) {
                session.setAttribute("productTypeErr", "Incorrect type");
                session.setAttribute("productUpdate", "Update Unsuccessful");
                request.getRequestDispatcher("editProduct.jsp").include(request, response);
            } else if (!validator.validateProductQuantity(quantity)) {
                session.setAttribute("productQuantityErr", "Incorrect quantity");
                session.setAttribute("productUpdate", "Update Unsuccessful");
                request.getRequestDispatcher("editProduct.jsp").include(request, response);
            } else {
                try {
                    productDBManager.updateProduct(id, name, price, desc, type, quantity);
                    session.setAttribute("productUpdate", "Update was Successful");
                    response.sendRedirect("EditProductServlet?id=" + id);
                } catch (SQLException ex) {
                    Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                    session.setAttribute("productUpdate", "Update was Unsuccessful");
                }
            }
        } else {
            response.sendRedirect("ProductListServlet");
        }
    }

}
