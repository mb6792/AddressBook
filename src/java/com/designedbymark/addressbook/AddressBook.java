/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class AddressBook {
    public static void main (String[] args){
//        testContact();
        testFileReader();
    }
    
    public static void testContact(){
        Contact c = new Contact("Mark Bonnici", "Male", 1992,7,6);
        
        System.out.println(c.getFullName());
        System.out.println(c.getGender());
        System.out.println(c.getDOBString());
    }
    
    public static void testFileReader(){
        try {
            ABFileReader fr = new ABFileReader("C:/Users/Mark/Desktop/address-book-master/AddressBook", ",");
            fr.run(true);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
