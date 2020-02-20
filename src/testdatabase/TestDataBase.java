/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdatabase;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DataBase;
import model.SignUp;


public class TestDataBase {
    public static void main(String[] args){
        System.out.println("Running database test");
        DataBase db = new DataBase();
        /*try {
            db.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        */
        SignUp sgnp = new SignUp("farhanarrahman44@gmail.com","fa44","4 April 1999","Male","Farhan Arrahman");
        db.addUser(sgnp);

    }
}
