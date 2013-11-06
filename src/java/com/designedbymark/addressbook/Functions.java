/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Mark
 */
public class Functions {
    public int getMales(ArrayList<Contact> contactList){
        int i = 0;
        for(Contact c : contactList){
            if(c.getGender().equalsIgnoreCase("Male")){
                i++;
            }
        }
        return i;
    }
    
    public Contact getOldest(ArrayList<Contact> contactList){
        Contact oldest = contactList.get(0);
        for(Contact c : contactList){
            if(c.getDOB().before(oldest.getDOB())){
                oldest = c;
            }
        }
        return oldest;
    }
    
    public long getDayDifference(Contact c1, Contact c2){
        GregorianCalendar c1_dob = c1.getDOB();
        GregorianCalendar c2_dob = c2.getDOB();
        
        Date c1_dob_date = c1_dob.getTime();
        Date c2_dob_date = c2_dob.getTime();
        
        long c1_dob_time = c1_dob_date.getTime();
        long c2_dob_time = c2_dob_date.getTime();
        
        long difference_inTime = c1_dob_time - c2_dob_time;
        long difference_inDays = difference_inTime / (1000 * 60 * 60 * 24);
        
        return difference_inDays;
    }
}
