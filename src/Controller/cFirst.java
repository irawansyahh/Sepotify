/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import model.DataBase;

//import view.vSepotify;
import view.vFirst;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
/**
 *
 * @author Farhan
 */
public class cFirst implements ActionListener {
    private vFirst vfirst;
    
    public cFirst() {
        vfirst = new vFirst();
        vfirst.addActionListener(this);
        vfirst.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(vfirst.getbLogIn())){
            vfirst.dispose();
            new cLogin();
        }else if(source.equals(vfirst.getbSignUp())){
            vfirst.dispose();
            new cSignup();
        }
    }
}
