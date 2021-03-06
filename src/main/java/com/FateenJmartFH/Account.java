package com.FateenJmartFH;

import com.FateenJmartFH.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class as an account that store every data related to account information
 *
 * @author Fateen Najib Indramutsika
 * @version 1.0
 */
public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public double balance;
    public String name;
    public String email;
    public String password;
    public Store store;

    /** Creates an account with the specified information.
     * @param name The account's name.
     * @param email The account's email address.
     * @param password The account's password.
     * @param balance The account's balance.
     */
    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Method to validate account's email and password with certain regex
     * @return true if email and password is matched from the regex, otherwise false.
     */
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(this.email);
        Pattern pattern1 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher1 = pattern1.matcher(this.password);
        return matcher.find() && matcher1.find();
    }
}
