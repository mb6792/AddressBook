/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Mark
 */
public class Contact {
    private String fullName;
    private String gender;
    private GregorianCalendar dob;
    
    public Contact(){
        fullName = "";
        gender = "";
        dob = null;
    }
    
    public Contact(String fullName, String gender, GregorianCalendar dob){
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
    }
    
    public Contact(String fullName, String gender, int year, int month, int day){
        this.fullName = fullName;
        this.gender = gender;
        GregorianCalendar tempDOB = new GregorianCalendar(year, month-1, day);
        this.dob = tempDOB;
    }
    
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setDOB(GregorianCalendar dob){
        this.dob = dob;
    }
    
    public void setDOB(String dob){
        String[] dobString = dob.split("/");
        int date = Integer.parseInt(dobString[0].trim());
        int month = Integer.parseInt(dobString[1].trim());
        int year = Integer.parseInt(dobString[2].trim());
        setDOB(year, month, date);
    }
    
    public void setDOB(int year, int month, int day){
        GregorianCalendar tempDOB = new GregorianCalendar(year, month-1, day);
        this.dob = tempDOB;
    }
    
    public GregorianCalendar getDOB(){
        return dob;
    }
    
    public String getDOBString(){
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yy");
        return date_format.format(dob.getTime());
    }
}
