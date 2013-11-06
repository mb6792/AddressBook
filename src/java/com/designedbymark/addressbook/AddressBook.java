/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.util.GregorianCalendar;

/**
 *
 * @author Mark
 */
public class AddressBook {
    public static void main (String[] args){
        Contact c = new Contact("Mark Bonnici", "Male", 1992,7,6);
        
        System.out.println(c.getFullName());
        System.out.println(c.getGender());
        System.out.println(c.getDOBString());
    }
}
