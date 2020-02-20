/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 *
 * @author Farhan
 */
public class LogIn extends User implements Serializable{
    private String email;
    private String password;
    public LogIn(String email, String password) {
        super(email, password);
        this.email = email;
        this.password = password;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
