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
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";// read
                                                                                                                    // from
                                                                                                                    // where
                                                                                                                    // Emal
                                                                                                                    // =
                                                                                                                    // and
                                                                                                                    // password
                                                                                                                    // =

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
                        System.out.println("STAFFFFFFF");
                        String staffQu = "SELECT POSITION FROM IOTUSER.STAFF WHERE ID=" + userID + "";
                        ResultSet stff = st.executeQuery(staffQu);
                        stff.next();
                        String position = stff.getString(1);
                        return new Staff(userID, name, email, password, phone, gender, dob, address, position);
                    } else {
                        System.out.println("cuss");
                        String custQu = "SELECT TYPE FROM IOTUSER.CUSTOMER WHERE ID=" + userID + "";
                        ResultSet custt = st.executeQuery(custQu);
                        custt.next();
                        String type = custt.getString(1);
                        return new Customer(userID, name, email, password, phone, gender, dob, address, type);
                    }
                }
            }
        }
        return null;
    }

    public int findSC(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";// read
                                                                                                                    // from
                                                                                                                    // where
                                                                                                                    // Emal
                                                                                                                    // =
                                                                                                                    // and
                                                                                                                    // password
                                                                                                                    // =

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(3);
            String userPass = rs.getString(4);

            if (userEmail.equals(email) && userPass.equals(password)) {
                int staffID = Integer.parseInt(rs.getString(1));
                return staffID;
            }
        }
        return -1;
    }

    // public void addUser(String name, String email, String pass, String phone,
    // String gender, String dob, String address, String role) throws SQLException {
    // String columns = "INSERT INTO
    // IOTUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB,ADDRESS,\"ROLE\",ACTIVATED)";
    // String values = "VALUES('" + name + "','" + email + "','" + pass + "','" +
    // phone + "','" + gender + "','" + dob + "','" + address + "','" + role +
    // "',true)";
    // st.executeUpdate(columns + values);
    // }

    public void addStaff(String name, String email, String pass, String phone, String gender, String dob,
            String address, String role, String position) throws SQLException {
        String columns = "INSERT INTO IOTUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB,ADDRESS,\"ROLE\",ACTIVATED)";
        String values = "VALUES('" + name + "','" + email + "','" + pass + "','" + phone + "','" + gender + "','" + dob
                + "','" + address + "','" + role + "',true)";
        st.executeUpdate(columns + values);
        String staffColumn = "INSERT INTO IOTUSER.STAFF(ID,POSITION)";
        String staffValues = "VALUES(" + findSC(email, pass) + ",'" + position + "')";
        st.executeUpdate(staffColumn + staffValues);
    }

    public void addCustomer(String name, String email, String pass, String phone, String gender, String dob,
            String address, String role, String type) throws SQLException {
        String columns = "INSERT INTO IOTUSER.\"USER\"(\"NAME\",EMAIL,PASSWORD,PHONE,GENDER,DOB,ADDRESS,\"ROLE\",ACTIVATED)";
        String values = "VALUES('" + name + "','" + email + "','" + pass + "','" + phone + "','" + gender + "','" + dob
                + "','" + address + "','" + role + "',true)";
        st.executeUpdate(columns + values);
        String staffColumn = "INSERT INTO IOTUSER.CUSTOMER(ID,TYPE)";
        String staffValues = "VALUES(" + findSC(email, pass) + ",'" + type + "')";
        st.executeUpdate(staffColumn + staffValues);
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
    
    public void updateCustomer(int userId, String name, String email, String pass, String phone, String gender, String dob, String address, String type) throws SQLException {
        String update = "UPDATE IOTUSER.\"USER\" SET \"NAME\"='" + name + "',EMAIL='" + email + "',PASSWORD='" + pass + "',PHONE='" + phone + "',GENDER='" 
                + gender + "',DOB='" + dob + "' ,ADDRESS='" + address + "' WHERE ID=" + userId + " AND PASSWORD='" + pass + "'";
        st.executeUpdate(update);
        String Custup = "UPDATE IOTUSER.CUSTOMER SET TYPE='" + type + "' WHERE ID=" + userId + "";
        st.executeUpdate(Custup);
    }
    
    public void updateStaff(int userId, String name, String email, String pass, String phone, String gender, String dob, String address, String position) throws SQLException {
        String update = "UPDATE IOTUSER.\"USER\" SET \"NAME\"='" + name + "',EMAIL='" + email + "',PASSWORD='" + pass + "',PHONE='" + phone + "',GENDER='" 
                + gender + "',DOB='" + dob + "' ,ADDRESS='" + address + "' WHERE ID=" + userId + " AND PASSWORD='" + pass + "'";
        st.executeUpdate(update);
        String stffup = "UPDATE IOTUSER.STAFF SET POSITION='" + position + "' WHERE ID=" + userId + "";
        st.executeUpdate(stffup);
    }

    public void deleteUser(int USER_ID, String password) throws SQLException {
        String delete = "UPDATE IOTUSER.\"USER\" SET ACTIVATED=false WHERE ID=" + USER_ID + " AND PASSWORD='" + password
                + "'";
        st.executeUpdate(delete);
    }

    public boolean checkUser(int USER_ID, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.\"USER\" WHERE ID=" + USER_ID + " AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int userID = Integer.parseInt(rs.getString(1));
            String userPass = rs.getString(4);
            if (userID == USER_ID && userPass.equals(password)) {
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
            temp.add(new User(USER_ID, name, email, pass, phone, gender, dob, address));
        }
        return temp;
    }

    public ArrayList<AccessLog> fetchLogs(int userId) throws SQLException {
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
    
    
    

//    public void addUser(String name, String EMAIL, String ADDRESS, String PASSWORD, String GENDER, String PHONE,
//            String DOB) {
//        String query = "INSERT INTO uts.dbTableforUser.sql (NAME, EMAIL, ADDRESS, PASSWORD, GENDER, PHONE, DOB) VALUES ('"
//                + name + "', '" + EMAIL + "','" + ADDRESS + "', '" + PASSWORD + "', '" + GENDER + "', '" + PHONE
//                + "', '" + DOB + "')";
//    }

}

