/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designedbymark.webservice;

import com.designedbymark.addressbook.AddressBook;
import com.designedbymark.addressbook.Contact;
import com.designedbymark.addressbook.Functions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Mark
 */
@Path("service")
public class ServiceResource {

    @Context
    private UriInfo context;
    
    private ArrayList<Contact> contactList = null;
    Functions functions = new Functions();

    /**
     * Creates a new instance of ServiceResource
     */
    public ServiceResource() {
        try {
            contactList = AddressBook.getContactsFromFIle();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex);
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("/males")
    @Produces("text/html")
    public String getMales() {
        int males = functions.getMales(contactList);
        return males + "";
    }

    @GET
    @Path("/oldest")
    @Produces("text/html")
    public String getOldest() {
        Contact c = functions.getOldest(contactList);
        return c.getFullName() + ", " + c.getGender() + ", " + c.getDOBString();
    }
    
    @GET
    @Path("/daydif/{a}/{b}")
    @Produces("text/html")
    public String getDayDif(@PathParam("a") double a, @PathParam("b") double b){
        long days = functions.getDayDifference(contactList.get((int) a), contactList.get((int) b));
        return days + "";
    }
}
