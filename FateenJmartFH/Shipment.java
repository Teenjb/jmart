package FateenJmartFH;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
{
    public static class Duration{
        public static final Duration INSTANT = new Duration((byte)(1 << 0));    //1
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));   //2
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));   //4
        public static final Duration REGULER = new Duration((byte)(1 << 3));    //8
        public static final Duration KARGO = new Duration((byte)(1 << 4));      //16
        private byte bit;
    
        private Duration(byte bit)
        {
            this.bit = bit;
        }
        
        public boolean isDuration(Duration reference){
            if((reference.bit & this.bit) != 0){
                return true;
            }
            return false;
        }
    }
    public class MultiDuration{
        public byte bit;
        public MultiDuration(byte...bit_input){
            for(byte i:bit_input){
                this.bit = (byte)(this.bit|i);
            }
        }
        public boolean isDuration(Duration reference){
            if((reference.bit & this.bit) != 0){
                return true;
            }
            return false;
        } 
    }
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String recipt;

    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.recipt = receipt;
    }

    @Override
    public boolean read(String content){
        return false;
    }
}
