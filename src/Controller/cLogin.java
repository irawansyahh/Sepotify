/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import model.DataBase;
import model.*;
import view.*;
import java.awt.HeadlessException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Farhan
 */
public class cLogin extends MouseAdapter implements ActionListener{
    
    private vLogin vlogin;
    private DataBase db;
    private SignUp s;
    private LogIn l;
    public static String email ;
        
    public cLogin(){
        vlogin = new vLogin();
        db = new DataBase();
        vlogin.addActionListener(this);
        vlogin.setVisible(true);
       }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        // Button Log In
        if (source.equals(vlogin.getbLogin())){
            bLoginActionPerformed();
            vlogin.dispose();
        }
        // Button Sign Up
        else if (source.equals(vlogin.getbSignup())){
            vlogin.dispose();
            new cSignup();
                
        }else if (source.equals(vlogin.getbForget())){
            vlogin.dispose();
            new cForgetPw();
        }
    }
    
    
    public void  bLoginActionPerformed(){
        String email = vlogin.getTfEmail();
        String password = vlogin.getPfPassword();
        if (email.isEmpty() && password.isEmpty()){
            vlogin.showMessage("Anda Belum memasukkan Email dan Password", "Error", 0);
            vlogin.dispose();
            new cLogin();
        }else if (email.isEmpty() ){
                vlogin.showMessage("Anda Belum memasukkan Email", "Error", 0);
                vlogin.dispose();
                new cLogin();
        }else if (password.isEmpty() ){
                vlogin.showMessage("Anda Belum memasukkan Password", "Error", 0);
                vlogin.dispose();
                new cLogin();
        }else{
            if (!db.checkDuplicateEmail(email)){
                vlogin.showMessage("Email Salah atau Belum Terdaftar","Error", 0);
                vlogin.dispose();
                new cLogin();
            }else{
                if(!db.checkDuplicatePassword(email,password)){
                vlogin.showMessage("Password Salah atau Belum Terdaftar","Error", 0);
                vlogin.dispose();
                new cLogin();
                }else {
                    cLogin.email = email;
                    vlogin.showMessage("Login Berhasil","Success", 1);
                    vlogin.dispose();
                    new cSepotify();
                }
            }
        }  
    }
}

