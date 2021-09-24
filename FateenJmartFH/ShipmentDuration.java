package FateenJmartFH;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{

    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);    //1
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);   //2
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);   //4
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);    //8
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);      //16
    private int bit;

    private ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
    public ShipmentDuration(int...bit_input){
        for(int i:bit_input){
            this.bit = this.bit|i;
        }
    }
    public boolean isDuration(ShipmentDuration reference){
        if((reference.bit & this.bit) != 0){
            return true;
        }
        return false;
    }
}
