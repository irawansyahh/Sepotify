/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
import Model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farhan
 */
public class DataBase {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<LogIn> login = new ArrayList<>();
    private ArrayList<SignUp> signup = new ArrayList<>();
    
    public DataBase() {
        loadUser();
    }
    
    public void clearDataArray(){
        login.clear();
        signup.clear();
    }
    
    public void connect(){
        try {
            String url = "jdbc:mysql://localhost/sepotify";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    
    public void loadUser() {
        connect();
        try {
            String query = "SELECT * FROM user";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                signup.add(new SignUp(rs.getString("email"), 
                    rs.getString("password"), 
                    rs.getString("tgl_lahir"), 
                    rs.getString("jns_klmn"), 
                    rs.getString("nama"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<LogIn> getLogin() {
        return login;
    }

    public ArrayList<SignUp> getSignup() {
        return signup;
    }
    
    public void addUser(SignUp s) {
        connect();
        
        String query = "INSERT INTO user VALUES (";
            query += "'" + s.getEmail() + "',";
            query += "'" + s.getPassword() + "',";
            query += "'" + s.getTgl_lahir() + "',";
            query += "'" + s.getJns_klmn() + "',";
            query += "'" + s.getNama() + "'";
            query += ")";
        
        if (manipulate(query)) signup.add(s);
            disconnect();
    }
     
    public boolean checkDuplicateEmail(String email){
        boolean check = false;
        for (SignUp sgnp : signup) {
            if (sgnp.getEmail().equals(email)){
                check = true;
                break;
            }
        }
        return check;
    }
    
    public boolean checkDuplicatePassword(String email, String password){
        boolean check = false;
        for (SignUp sgnp : signup) {
            if (sgnp.getEmail().equals(email) && sgnp.getPassword().equals(password)){
                check = true;
                break;
            }
        }
        return check;
    }
    
    
    public void changePassword(String email,String password) {
        connect();
        String query = "UPDATE user SET password = '"+password+"' WHERE email ='"+email+"';";
        manipulate(query);
        disconnect();
        
    }
    
}


