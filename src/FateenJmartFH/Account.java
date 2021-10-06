package FateenJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for store account data
 *
 * @author Fateen Najib Indramutsika
 * @version 1.0
 */
public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public boolean read(String content){
        return false;
    }

    public String toString(){
        return "name: " + this.name + "\n" + "email: " + this.email + "\n" + "password: " + this.password;
    }

    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(this.email);
        Pattern pattern1 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher1 = pattern1.matcher(this.password );
        if(matcher.find() && matcher1.find()){
            return true;
        }else{
            return false;
        }
    }
}
