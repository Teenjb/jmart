package FateenJmartFH;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
abstract class Transaction extends Recognizable
{
    public enum Rating{
        NONE,BAD,NEUTRAL,GOOD;
    }
    public String time = "TIME";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    public Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
        
    }
    public Transaction(int id, Account buyer, Store store){
        super(id);
        
    }
    public abstract boolean validate();
    public abstract Transaction perform();
}
