package com.FateenJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for store complaint data
 *
 * @author Fateen najib Indramustika
 * @version 1.0
 */
public class Complaint extends Serializable
{
    public Date date;
    public String desc;

    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }


    public boolean validate(){
        return false;
    }

    public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + ", desc = '" + this.desc + "'}";
    }

}
