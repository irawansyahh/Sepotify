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
import java.util.*;
import javax.swing.table.DefaultTableModel;
import view.vForgetPw;
/**
 *
 * @author irawan
 */
public class cForgetPw extends MouseAdapter implements ActionListener {
    private vForgetPw vforgetpw;
    private DataBase db;
    
    public cForgetPw(){
        vforgetpw = new vForgetPw();
        db = new DataBase();
        vforgetpw.addActionListener(this);
        vforgetpw.setVisible(true);
       }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        // Button Ganti Password
        if (source.equals(vforgetpw.getbChangePw())) {
            btnGantiPassActionPerformed();
        }

        //Button Log out
        else if (source.equals(vforgetpw.getbExit())){
            db.clearDataArray();
            vforgetpw.dispose();
            new cLogin();
        }
    }
    public void btnGantiPassActionPerformed(){
        String email = vforgetpw.getTfEmail();
        String password = vforgetpw.getPfOldPw();
        String newPassword = vforgetpw.getPfNewPw();
        String confirmPassword = vforgetpw.getPfConfirmPw();

        if(!db.checkDuplicateEmail(email)){
            vforgetpw.showMessage("Password Lama Salah", "Error", 0);
        }else if(!newPassword.equals(confirmPassword)){
                vforgetpw.showMessage("Password baru belum sama dengan konfirmasi", "Error", 0);
        }else{
            db.changePassword(email, newPassword);
            vforgetpw.showMessage("Password berhasil di ganti", "Success", 1);
            vforgetpw.dispose();
            new cLogin();
        }
    }
}
