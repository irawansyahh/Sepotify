/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
/**
 *
 * @author Farhan
 */
public abstract class User {
    private String email;
    private String password;
    private String tgl_lahir;
    private String jns_klmn;
    private String nama;

    public User(String email, String password, String tgl_lahir, String jns_klmn, String nama) {
        this.email = email;
        this.password = password;
        this.tgl_lahir = tgl_lahir;
        this.jns_klmn = jns_klmn;
        this.nama = nama;
    }

    public User(String email, String password) {
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

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getJns_klmn() {
        return jns_klmn;
    }

    public void setJns_klmn(String jns_klmn) {
        this.jns_klmn = jns_klmn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
    
    
