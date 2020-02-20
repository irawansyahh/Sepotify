/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author Irawansyah
 */
public class LoginSignupValidation {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate Birthday = LocalDate.of(1999,8,4);
        int years = Period.between(Birthday, today).getYears();
        System.out.println(years);
        
    }
}