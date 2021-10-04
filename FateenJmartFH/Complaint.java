package FateenJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for store complaint data
 *
 * @author Fateen najib Indramustika
 * @version 1.0
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

    public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + "desc = '" + this.desc + "'}"; 
    }
}
