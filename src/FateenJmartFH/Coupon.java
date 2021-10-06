package FateenJmartFH;


/**
 * Class to access coupon
 * 
 * @author fateen
 * @version 1.0
 */
public class Coupon extends Recognizable implements FileParser
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

    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {
        super(id);
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
        if(priceTag.getAdjustedPrice() >= this.minimum && !this.used){
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

    @Override
    public boolean read(String content){
        return false;
    }
}
