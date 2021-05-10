/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Charl
 */
public class DBManager {
    
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public User findUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";//read from where Emal = and password = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPass = rs.getString(4);

            if (userEmail.equals(email) && userPass.equals(password)) {
                String name = rs.getString(2);
                int userID = Integer.parseInt(rs.getString(1));
                String phone = rs.getString(5);
                String gender = rs.getString(6);
                String dob = rs.getString(7);
                String address = rs.getString(8);
                String role = rs.getString(9);
                boolean activated = rs.getBoolean(10);
                if (activated) {
                    if (role.equals("S")) {
                        return new Staff(userID, name, email, password, phone, gender, dob, address);
                    }
                    else {
                        return new Customer(userID, name, email, password, phone, gender, dob, address);
                    }
                }
                
                
            }
        }
        return null;
    }
    
    public void addUser(String name, String email, String pass, String phone, String gender, String dob, String address, String role) throws SQLException {
        String columns = "INSERT INTO IOTUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB,ADDRESS,\"ROLE\",ACTIVATED)";
        String values = "VALUES('" + name + "','" + email + "','" + pass + "','" + phone + "','" + gender + "','" + dob + "','" + address + "','" + role + "',true)";
        st.executeUpdate(columns + values);
    }
    
    public void addLogLogin(int userId) throws SQLException {
        java.util.Date date = new java.util.Date();
        String columns = "INSERT INTO IOTUSER.ACCESS_LOG(DATE, USER_ID, TYPE)";
        String values = "VALUES('" + date.toString() + "'," + userId + ",'" + "LOGIN" + "')";
        st.executeUpdate(columns + values);
    }
    
    public void addLogLogout(int userId) throws SQLException {
        java.util.Date date = new java.util.Date();
        String columns = "INSERT INTO IOTUSER.ACCESS_LOG(DATE, USER_ID, TYPE)";
        String values = "VALUES('" + date.toString() + "'," + userId + ",'" + "LOGOUT" + "')";
        st.executeUpdate(columns + values);
    }
    
    public void updateUser(int USER_ID, String name, String email, String pass, String phone, String gender, String dob, String address) throws SQLException {
        String update = "UPDATE IOTUSER.\"USER\" SET \"NAME\"='" + name + "',EMAIL='" + email + "',PASSWORD='" + pass + "',PHONE='" + phone + "',GENDER='" + gender + "',DOB='" + dob + "' ,ADDRESS='" + address + "' WHERE ID=" + USER_ID + " AND PASSWORD='" + pass + "'";
        st.executeUpdate(update);
    }
    
    public void deleteUser(int USER_ID, String password) throws SQLException {
        String delete = "UPDATE IOTUSER.\"USER\" SET ACTIVATED=false WHERE ID=" + USER_ID + " AND PASSWORD='" + password + "'";
        st.executeUpdate(delete);
    }
    
    public boolean checkUser(int USER_ID, String password) throws SQLException{
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE ID="+ USER_ID +" AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            int userID = Integer.parseInt(rs.getString(1));
            String userPass = rs.getString(4);
            if(userID == USER_ID && userPass.equals(password)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();

        while (rs.next()) {
            int USER_ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String pass = rs.getString(4);
            String phone = rs.getString(5);
            String gender = rs.getString(6);
            String dob = rs.getString(7);
            String address = rs.getString(8);
            temp.add(new User(USER_ID,name,email,pass,phone,gender,dob,address));
        }
        return temp;
    }
    
    public ArrayList<AccessLog> fetchLogs(int userId) throws SQLException{
        String fetch = "SELECT * FROM IOTUSER.ACCESS_LOG WHERE USER_ID = " + userId + "";
        ArrayList<AccessLog> temp = new ArrayList();
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String date = rs.getString(1);
            String type = rs.getString(3);
            temp.add(new AccessLog(userId, date, type));
        }
        return temp;
        
    }
    
}
