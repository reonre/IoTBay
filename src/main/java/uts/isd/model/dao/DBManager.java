/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.User;
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
    
    public User readUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL=" + email + " AND PASSWORD='" + password + "'";//read from where Emal = and password = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPass = rs.getString(4);

            if (userEmail == email && userPass.equals(password)) {
                String name = rs.getString(2);
                int ID = Integer.parseInt(rs.getString(1));
                String phone = rs.getString(5);
                String gender = rs.getString(6);
                String dob = rs.getString(7);
                String address = rs.getString(8);

                return new User(ID, name, email, password, phone, gender, dob, address);
            }
        }
        return null;
    }
    
    public void addUser(String name, String email, String pass, String phone, String gender, String dob, String address) throws SQLException {
        String columns = "INSERT INTO IOTUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB,ADDRESS)";
        String values = "VALUES('" + name + "','" + email + "','" + pass + "','" + phone + "','" + gender + "','" + dob + "','" + address + "')";
        st.executeUpdate(columns + values);
    }
    
    public void updateUser(int USER_ID, String name, String email, String pass, String phone, String gender, String dob, String address) throws SQLException {
        String update = "UPDATE IOTUSER.\"USER\" SET \"NAME\"='" + name + "',EMAIL='" + email + "',PASSWORD='" + pass + "',PHONE='" + phone + "',GENDER='" + gender + "',DOB='" + dob + "' ,ADDRESS='" + address + "' WHERE ID=" + USER_ID + " AND PASSWORD='" + pass + "'";
        st.executeUpdate(update);
    }
    
    public void deleteUser(int USER_ID, String password) throws SQLException {
        String delete = "DELETE FROM IOTUSER.\"USER\" WHERE ID=" + USER_ID + " AND PASSWORD='" + password + "'";
        st.executeUpdate(delete);
    }
    
    public boolean checkUser(int USER_ID, String password) throws SQLException{
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE ID='"+USER_ID+"' and PASSWORD='"+password+"'";
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
        String fetch = "select * from IOTUSER.\"USER\"";
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
            temp.add(new User(USER_ID,email,name,pass,phone,gender,dob,address));
        }
        return temp;
    }
    
}
