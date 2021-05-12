/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.User;
import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.Customer;
import uts.isd.model.Staff;


/**
 *
 * @author clarence
 */

public class StaffDBManager {
    
    private Statement st;
    
    public StaffDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public int findUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";//read from where Emal = and password = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPass = rs.getString(4);

            if (userEmail.equals(email) && userPass.equals(password)) {
                int userID = Integer.parseInt(rs.getString(1));
                return userID;
            }
        }
        return -1;
    }
    
    public User readAdmin(int Admin_ID, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"ADMIN\" WHERE ID=" + Admin_ID + " AND PASSWORD='" + password + "'";//read from where ID = and password = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = Integer.parseInt(rs.getString(1));
            String userPass = rs.getString(4);

            if (userID == Admin_ID && userPass.equals(password)) {
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(5);
                String gender = rs.getString(6);
                String dob = rs.getString(7);
                String address = rs.getString(8);

                return new User(Admin_ID, name, email, password, phone, gender, dob, address);
            }
        }
        return null;
    }
    
    public void addStaff(String name, String email, String pass, String phone, String gender, String dob, String address, String position) throws SQLException {
        String columns = "INSERT INTO IOTUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB,ADDRESS)";
        String values = "VALUES('" + name + "','" + email + "','" + pass + "','" + phone + "','" + gender + "','" + dob + "','" + address + "')";
        st.executeUpdate(columns + values);
        columns = "INSERT INTO IOTUSER.STAFF(ID, POSITION)";
        values = "VALUES(" + findUser(email, pass) + ",'" + position + "')"; 
        st.executeUpdate(columns + values);
    }
    
    public ArrayList<Staff> fetchStaff() throws SQLException{
        String fetch = "SELECT a.*, b.POSITION from IOTUSER.\"USER\", IOTUSER.STAFF;";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();

        while (rs.next()) {
            int Admin_ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String pass = rs.getString(4);
            String phone = rs.getString(5);
            String gender = rs.getString(6);
            String dob = rs.getString(7);
            String address = rs.getString(8);
            String position = rs.getString(9);
            temp.add(new Staff(Admin_ID,email,name,pass,phone,gender,dob,address));
        }
        return temp;
    }
    
    public ArrayList<Staff> searchStaff(String staffname, String staffposition) throws SQLException{
        String fetch = "SELECT a.*, b.POSITION from IOTUSER.\"USER\", IOTUSER.STAFF WHERE a.\"NAME\"='" + staffname + "'AND b.POSITION='" + staffposition + "';";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();

        while (rs.next()) {
            int Admin_ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String pass = rs.getString(4);
            String phone = rs.getString(5);
            String gender = rs.getString(6);
            String dob = rs.getString(7);
            String address = rs.getString(8);
            String position = rs.getString(9);
            temp.add(new Staff(Admin_ID,email,name,pass,phone,gender,dob,address));
        }
        return temp;
    }
    
    public void updateStaff(int userId, String name, String email, String pass, String phone, String gender, String dob, String address, String position) throws SQLException {
        String update = "UPDATE IOTUSER.\"USER\" SET \"NAME\"='" + name + "',EMAIL='" + email + "',PASSWORD='" + pass + "',PHONE='" + phone + "',GENDER='" + gender + "',DOB='" + dob + "' ,ADDRESS='" + address + "' WHERE ID=" + userId + " AND PASSWORD='" + pass + "'";
        st.executeUpdate(update);
        update = "UPDATE IOTUSER.STAFF SET POSITION='" + position + "' WHERE ID='" + userId + "';";
        st.executeUpdate(update);
    }
    
    public void deleteStaff(int userId, String password) throws SQLException {
        String delete = "DELETE FROM IOTUSER.\"USER\" WHERE ID=" + userId + " AND PASSWORD='" + password + "'";
        st.executeUpdate(delete);
    }
    
    public void deactivateStaff(int userId) throws SQLException{
        String deactivate = "UPDATE IOTUSER.\"USER\" SET ACTIVATED=false WHERE ID=" + userId + "";
        st.executeUpdate(deactivate);
    }
    
    public void activateStaff(int userId) throws SQLException{
        String activate = "UPDATE IOTUSER.\"USER\" SET ACTIVATED=true WHERE ID=" + userId + "";
        st.executeUpdate(activate);
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
            int Admin_ID = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String email = rs.getString(3);
            String pass = rs.getString(4);
            String phone = rs.getString(5);
            String gender = rs.getString(6);
            String dob = rs.getString(7);
            String address = rs.getString(8);
            temp.add(new User(Admin_ID,email,name,pass,phone,gender,dob,address));
        }
        return temp;
    }
    
}
