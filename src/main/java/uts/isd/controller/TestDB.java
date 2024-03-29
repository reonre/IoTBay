package uts.isd.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import uts.isd.model.User;
import uts.isd.model.dao.*;

/**
 *
 * @author Charl
 */
public class TestDB {

    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestDB().menu();
    }
    
    private DBConnector connector;
    private Connection conn;
    private DBManager manager;
    
    public TestDB() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new DBManager(conn);
    }

    private void testCreate() throws SQLException {
        System.out.println("Adding user to the database: ");
//        manager.addUser(read("Name"), read("Email"), read("Password"), read("Phone"), read("Gender"), read("Dob"), read("Address"), read("Role"));
        System.out.println("User added successfully ");
    }

    private void testRead() throws SQLException {
        String email = read("Email");
        String pass = read("Password");
        User user = manager.findUser(email, pass);
        String exist = (user != null) ? "User exists in the database" : "User does not exist!!!";
        System.out.println(exist);
    }

    private void testUpdate() throws SQLException {
        int ID = Integer.parseInt(read("ID"));
        String pass = read("Password");
//        manager.updateUser(ID, read("Name"), read("Email"), pass, read("Phone"), read("Gender"), read("Dob"), read("Address"));
        System.out.println("User details updated successfully ");
    }

    private void testDelete() throws SQLException{
        int ID = Integer.parseInt(read("ID"));
        String pass = read("Password");
        manager.deleteUser(ID, pass);
        System.out.println("User deleted successfully");
    }
    private void testFetch() throws SQLException {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s \n", "ID", "NAME", "EMAIL", "PASSWORD", "PHONE", "GENDER", "DOB", "ADDRESS");
        ArrayList<User> users = manager.fetchUsers();
        users.forEach(user -> System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s \n" 
                + "",user.getUSER_ID(),user.getName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getGender(),user.getDob(),user.getAddress()));
        System.out.println();
    }

    private String read(String prompt) {
        System.out.print(prompt+": ");
        return in.nextLine();
    }

    private void menu() throws SQLException {
        char c;
        help();
        while ((c = read("Command [c/r/u/d/f/x]").charAt(0)) != 'x') {
            switch (c) {
                case 'c':
                    testCreate();
                    break;
                case 'r':
                    testRead();
                    break;
                case 'u':
                    testUpdate();
                    break;
                case 'd':
                    testDelete();
                    break;
                case 'f':
                    testFetch();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("Database Operations: \n"
                + "c = Create User \n"
                + "r = Read User by ID-Password \n"
                + "u = Update User by ID \n"
                + "d = Delete User by ID\n"
                + "f = Fetch all Users\n");
    }
}
