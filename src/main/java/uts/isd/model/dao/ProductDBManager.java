/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author oneilrangiuira
 */
public class ProductDBManager {
    private Statement st;

    public ProductDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
   
    // Create - add a new product
    public void addProduct(String name, double price, String desc, String type, int quant) throws SQLException{
        String query = 
                "INSERT INTO IOTUSER.PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DESC, PRODUCT_TYPE, PRODUCT_QUANT) " +
                "VALUES('" + name + "', " + price + ", '" + desc + "', '" + type + "', " + quant + ")";
        st.execute(query);
    }
    
    // Read - list all products
    public ArrayList<Product> listAllProducts() throws SQLException {
        String query = "SELECT * FROM IOTUSER.PRODUCT ORDER BY PROD_ID";
        ResultSet rs = st.executeQuery(query);
        ArrayList<Product> list = new ArrayList<>();
        
        while(rs.next()) {
            int id = rs.getInt("PROD_ID");
            String name = rs.getString("PRODUCT_NAME");
            double price = rs.getDouble("PRODUCT_PRICE");
            String desc = rs.getString("PRODUCT_DESC");
            String type = rs.getString("PRODUCT_TYPE");
            int quant = rs.getInt("PRODUCT_QUANT");
            
            list.add(new Product(id, name, price, desc, type, quant));
        }
        return list;
    }
    
    // Read - Search & List Product by NAME
    public ArrayList<Product> searchProductsbyName(String search) throws SQLException {
        String query = "SELECT * FROM IOTUSER.PRODUCT WHERE PRODUCT_NAME LIKE " + "%" + search + "%";
        ResultSet rs = st.executeQuery(query);
        ArrayList<Product> list = new ArrayList<>();
        
        while(rs.next()) {
            int id = rs.getInt("PROD_ID");
            String name = rs.getString("PRODUCT_NAME");
            double price = rs.getDouble("PRODUCT_PRICE");
            String desc = rs.getString("PRODUCT_DESC");
            String type = rs.getString("PRODUCT_TYPE");
            int quant = rs.getInt("PRODUCT_QUANT");
            
            list.add(new Product(id, name, price, desc, type, quant));
        }
        return list;
    }
        
    // Read - Search & List Product by TYPE
    public ArrayList<Product> searchProductsbyType(String search) throws SQLException {
        String query = "SELECT * FROM IOTUSER.PRODUCT WHERE PRODUCT_TYPE LIKE " + "%" + search + "%";
        ResultSet rs = st.executeQuery(query);
        ArrayList<Product> list = new ArrayList<>();
        
        while(rs.next()) {
            int id = rs.getInt("PROD_ID");
            String name = rs.getString("PRODUCT_NAME");
            double price = rs.getDouble("PRODUCT_PRICE");
            String desc = rs.getString("PRODUCT_DESC");
            String type = rs.getString("PRODUCT_TYPE");
            int quant = rs.getInt("PRODUCT_QUANT");
            
            list.add(new Product(id, name, price, desc, type, quant));
        }
        return list;
    }
        
    // Read - Search & List Product by NAME and TYPE
    public ArrayList<Product> searchProducts(String searchName, String searchType) throws SQLException {
        
        // Set defaults if search name and/or type is empty
        if (searchName == null) {
            searchName = "";
        }
        if (searchType == null) {
            searchType = "";
        }
         
        String query = 
                "SELECT * FROM IOTUSER.PRODUCT " +
                "WHERE PRODUCT_NAME LIKE " + "%" + searchName + "%" +
                "AND PRODUCT_TYPE LIKE " + "%" + searchType + "%";
        ResultSet rs = st.executeQuery(query);
        ArrayList<Product> list = new ArrayList<>();
        
        while(rs.next()) {
            int id = rs.getInt("PROD_ID");
            String name = rs.getString("PRODUCT_NAME");
            double price = rs.getDouble("PRODUCT_PRICE");
            String desc = rs.getString("PRODUCT_DESC");
            String type = rs.getString("PRODUCT_TYPE");
            int quant = rs.getInt("PRODUCT_QUANT");
            
            list.add(new Product(id, name, price, desc, type, quant));
        }
        return list;
    }

    // Update - Update a single product
    public void updateProduct(String id, String name, double price, String desc, String type, int quant) throws SQLException {
        String query = 
                "UPDATE IOTUSER.PRODUCT SET " +
                "PRODUCT_NAME = '" + name + "', " +
                "PRODUCT_PRICE = " + price + ", " +
                "PRODUCT_DESC = '" + desc + "', " +
                "PRODUCT_TYPE = '" + type + "', " +
                "PRODUCT_QUANT = " + quant + ", " +
                "WHERE PROD_ID = " + id;
        
        st.execute(query);
    }
    
    // Delete - Delete a single product
    public void deleteProduct(String id) throws SQLException {
        String query = "DELETE FROM IOTUSER.PRODUCT WHERE PROD_ID =" + id;
        st.execute(query);
    }
}
