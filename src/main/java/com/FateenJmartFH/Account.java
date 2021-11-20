package com.FateenJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for store account data
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
    
    
    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }


    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(this.email);
        Pattern pattern1 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher1 = pattern1.matcher(this.password );
        return matcher.find() && matcher1.find();
    }
}
