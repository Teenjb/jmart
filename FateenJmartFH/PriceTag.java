package FateenJmartFH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;

   
    public PriceTag(double price)
    {
        this.price = price;
        this.discount = 0.0;
    }
    
    public PriceTag(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
        if (this.discount>100.0){
            this.discount = 100.0;
        }
    }
    public double getAdjustedPrice(){
        return getAdminFee() + getDiscountedPrice();
    }
    
    public double getAdminFee(){
        double temp = getDiscountedPrice();
        if(temp < BOTTOM_PRICE){
            temp = BOTTOM_FEE;
        }
        return temp * COMMISSION_MULTIPLIER;
        
    }
    private double getDiscountedPrice(){
        if(this.discount == 100.0){
            return 0.0;
        }else{
            return this.price * (1-(this.discount)/100);
        }
    }
}
