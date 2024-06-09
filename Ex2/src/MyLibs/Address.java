/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

/**
 * Address class representing the address of a location.
 * 
 * @author Maglasang
 */
public class Address {
    private int number;
    private String city;
    private String country;

    /**
     * Constructor to initialize Address object with number, city, and country.
     * 
     * @param number The number of the address
     * @param city The city of the address
     * @param country The country of the address
     */
    public Address(int number, String city, String country) {
        this.number = number;
        this.city = city;
        this.country = country;
    }

    /**
     * Getter method to retrieve the number of the address.
     * 
     * @return The number of the address
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter method to retrieve the city of the address.
     * 
     * @return The city of the address
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter method to retrieve the country of the address.
     * 
     * @return The country of the address
     */
    public String getCountry() {
        return country;
    }
}

