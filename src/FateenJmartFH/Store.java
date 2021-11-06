package FateenJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Serializable
{
    public static final String REGEX_PHONE = "^(/d{9,12})$";
    public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
    public String name;
    public String address;
    public double balance;
    public String phoneNumber;

    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String toString(){
        return "name: " + (String)this.name + "\n" + "address: " + (String)this.address + "\n" + "Phone Number" + (String)this.phoneNumber;
    }
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(this.phoneNumber);
        Pattern pattern1 = Pattern.compile(REGEX_NAME);
        Matcher matcher1 = pattern1.matcher(this.name);
        return matcher.find() && matcher1.find();
    }
}
