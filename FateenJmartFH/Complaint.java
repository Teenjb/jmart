package FateenJmartFH;
import java.util.Date;

/**
 * Write a description of class complain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;

    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }

    @Override
    public boolean read(String content){
        return false;
    }

    public boolean validate(){
        return false;
    }

    public Transactor perform(){
        return null;
    }

}
