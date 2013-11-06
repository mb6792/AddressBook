/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class AddressBook {
    private static String FILEPATH = "C:/Users/Mark/Desktop/address-book-master/AddressBook";
    private static String SPLITBY = ",";
    
//    public static void main (String[] args){
//        testContact();
//        testFileReader();
//        testFunctions();
//    }
    
    public static void testContact(){
        Contact c = new Contact("Mark Bonnici", "Male", 1992,7,6);
        
        System.out.println(c.getFullName());
        System.out.println(c.getGender());
        System.out.println(c.getDOBString());
    }
    
    public static void testFileReader(){
        try {
            ABFileReader fr = new ABFileReader(FILEPATH, SPLITBY);
            fr.run(true);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testFunctions(){
        try {
            ABFileReader fr = new ABFileReader(FILEPATH, SPLITBY);
            fr.run(true);
            ArrayList<Contact>contactList = fr.getContacts();
            
            System.out.println("");
            System.out.println("");
            
            Functions functions = new Functions();
            
            int males = functions.getMales(contactList);
            System.out.println("Number of Males: " + males);
            
            System.out.println("");
            
            Contact oldest = functions.getOldest(contactList);
            System.out.println("Oldest:");
            System.out.println("Fullname: " + oldest.getFullName());
            System.out.println("Gender: " + oldest.getGender());
            System.out.println("DOB: " + oldest.getDOBString());
            
            System.out.println("");
            
            Long dayDif = functions.getDayDifference(contactList.get(1), contactList.get(0));
            System.out.println("Day Difference: " + dayDif);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
