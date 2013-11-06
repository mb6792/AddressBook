/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.util.ArrayList;

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
}
