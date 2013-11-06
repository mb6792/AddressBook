/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class ABFileReader {
    private String filePath;
    private String splitBy;
    private ArrayList<Contact> contacts;
    
    public ABFileReader(){
        filePath = "";
        splitBy = "";
        contacts = new ArrayList<Contact>();
    }
    
    public ABFileReader(String filePath, String splitBy){
        this.filePath = filePath;
        this.splitBy = splitBy;
        contacts = new ArrayList<Contact>();
    }
    
    public ABFileReader(String filePath, String splitBy, ArrayList<Contact> contacts){
        this.filePath = filePath;
        this.splitBy = splitBy;
        this.contacts = contacts;
    }
    
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    
    public String getFilePath(){
        return filePath;
    }
    
    public void setSplitBy(String splitBy){
        this.splitBy = splitBy;
    }
    
    public String getSplitBy(){
        return splitBy;
    }
    
    public void setContacts(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }
    
    public ArrayList<Contact> getContacts(){
        return contacts;
    }
    
    public void run(Boolean output) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));;
        String line = "";
        
        while((line = br.readLine()) != null){
            String[] contact = line.split(splitBy);
            
            Contact c = new Contact();
            c.setFullName(contact[0].trim());
            c.setGender(contact[1].trim());
            c.setDOB(contact[2].trim());
            
            contacts.add(c);
            
            if(output == true){
                System.out.println("\n\nJUST ADDED-----------------");
                System.out.println("Fullname: " + c.getFullName());
                System.out.println("Gender: " + c.getGender());
                System.out.println("DOB: " + c.getDOBString());
                System.out.println("-------------------------------");
            }
        }
    }
}
