package FateenJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Transaction implements FileParser
{
    public int productId;
    public ShipmentDuration shipmentDuration;

    // public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration){
    //     super(id, buyer,);
    //     this.shipmentDuration = shipmentDuration;
    // }
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration){
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipmentDuration = shipmentDuration;
        this.storeId = storeId;
        this.id = id;
    }
    public boolean read(String content){
        return false;
    }
    public Object write(){
        return null;
    }
    public Object newInstance(String content){
        return null;
    }
    public boolean validate(){
        return false;
    }
    public Transaction perform(){
        return null;
    }
}
