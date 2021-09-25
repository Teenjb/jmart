package FateenJmartFH;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
    
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public static enum Type{
        DISCOUNT, REBATE
    }

    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        // super(id);
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean isUsed(){
        return this.used;
    }

    public boolean canApply(PriceTag priceTag){
        if(priceTag.getAdjustedPrice() >= this.minimum && this.used == false){
            return true;
        }
        return false;
    }

    public double Apply(PriceTag priceTag){
        this.used = true;
        switch(type){
            case REBATE:
                return (priceTag.getAdjustedPrice() - cut);
            default:
                return (priceTag.getAdjustedPrice() * (1-(cut/100)));
        }
    }

}
