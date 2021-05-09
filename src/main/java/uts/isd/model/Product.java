/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;



/**
 *
 * @author oneilrangiuira
 */
public class Product implements Serializable{
    //fields
    private int prod_id;
    private String product_name;
    private double product_price;
    private String product_desc;
    private String product_type;
    private int product_quant;

    public Product(int prod_id, String product_name, double product_price, String product_desc, String product_type, int product_quant) {
        this.prod_id = prod_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_desc = product_desc;
        this.product_type = product_type;
        this.product_quant = product_quant;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getProduct_quant() {
        return product_quant;
    }

    public void setProduct_quant(int product_quant) {
        this.product_quant = product_quant;
    }
}
