package com.FateenJmartFH;

import com.FateenJmartFH.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is class for representing a store
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public class Store
{
    public static final String REGEX_PHONE = "^(/d{9,12})$";
    public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
    public String name;
    public String address;
    public double balance;
    public String phoneNumber;

    /**
     * Creates a store.
     * @param name Store name
     * @param address Store address
     * @param phoneNumber Store phone number
     */
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String toString(){
        return "name: " + (String)this.name + "\n" + "address: " + (String)this.address + "\n" + "Phone Number" + (String)this.phoneNumber;
    }

    /**
     * Method to validate store's phone number and name with certain regex
     * @return true if phone number and name is matched from the regex, otherwise false.
     */
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(this.phoneNumber);
        Pattern pattern1 = Pattern.compile(REGEX_NAME);
        Matcher matcher1 = pattern1.matcher(this.name);
        return matcher.find() && matcher1.find();
    }
}
