/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;
import MyLibs.Address;
/**
 *
 * @author Maglasang
 */
public class Publisher {
    private String name;
    private Address address;

    /**
     * Constructor to initialize Publisher object with name and address.
     * 
     * @param name The name of the publisher
     * @param address The address of the publisher
     */
    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
    
