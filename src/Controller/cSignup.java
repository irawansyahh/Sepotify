/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
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
import java.text.DateFormat;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Farhan
 */
public class cSignup extends MouseAdapter implements ActionListener{
    
    
    
    private vSignup vsignup;
    private DataBase db;
    private SignUp s;
    private LogIn l;
    private static String nama;
    
    
    public cSignup(){
        vsignup = new vSignup();
        db = new DataBase();
        vsignup.addActionListener(this);
        vsignup.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(vsignup.getbSignup())){
            bSignupActionPerformed();
            vsignup.dispose();
        }else if (source.equals(vsignup.getbLogin())){
            vsignup.dispose();
            new cLogin();
        }
    }

    private void bSignupActionPerformed() {
        String email = vsignup.getTfEmail();
        String password = vsignup.getPfPassword();
        String tgl_lhr = vsignup.getCbTglLhr()+" "+vsignup.getCbBlnLhr()+" "+vsignup.getCbThnLhr();
        String gender = vsignup.get_BgMaleFemale();
        
        String nama = vsignup.getTfName();
        
        
        if(email.isEmpty() || password.isEmpty() || nama.isEmpty() || 
        tgl_lhr.isEmpty() || gender.isEmpty() ||
        nama.isEmpty()){
            vsignup.showMessage("Semua Data Masih Kosong ", "Error", 0);
            vsignup.dispose();
            new cSignup();
        }else if (email.isEmpty()){
                vsignup.showMessage("email Masih Kosong ", "Error", 0);
                vsignup.dispose();
                new cSignup();
        }else if (password.isEmpty()){
                vsignup.showMessage("Password Masih Kosong ", "Error", 0);
                vsignup.dispose();
                new cSignup();
        }else if (tgl_lhr.isEmpty()){
                vsignup.showMessage("Tanggal Lahir Masih Kosong ", "Error", 0);
                vsignup.dispose();
                new cSignup();
        }else if (gender.isEmpty()){
                vsignup.showMessage("Gender Masih Kosong ", "Error", 0);
                vsignup.dispose();
                new cSignup();
        }else if (nama.isEmpty()){
                vsignup.showMessage("Nama Masih Kosong ", "Error", 0);
                vsignup.dispose();
                new cSignup();
        }else{
            if (db.checkDuplicateEmail(email)){
                vsignup.showMessage("email Sudah Terdaftar", "Error", 0); 
                vsignup.dispose();
                new cSignup();
            }else {
                db.addUser(new SignUp(email,password,tgl_lhr,gender,nama));
                vsignup.reset();
                vsignup.showMessage("email Terdaftar", "Success", 1);
                vsignup.dispose();
                new cLogin();
            }
        }
    }

}
