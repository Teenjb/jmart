package com.FateenJmartFH;


import com.FateenJmartFH.dbjson.Serializable;

/**
 * Class to store coupon information and could be used when someone has a payment.
 * 
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public class Coupon extends Serializable {

    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;

    /**
     * The type of coupon. DISCOUNT type is percentage type in range 0-100. REBATE type is the rebate.
     */
    public static enum Type {
        DISCOUNT, REBATE
    }

    /**
     * Creates a coupon with the specified information.
     * @param name Coupon's name.
     * @param code Coupon's code.
     * @param type Coupon's type.
     * @param cut Coupon's cut.
     * @param minimum Coupon's minimum.
     */
    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean isUsed() {
        return this.used;
    }

    /**
     * Method to validate if the coupon can be applied or not.
     * @param price Product's price
     * @param discount The product's discount
     * @return true if coupon can be applied, false otherwise.
     */
    public boolean canApply(double price, double discount){
        if (Treasury.getAdjustedPrice(price, discount) >= minimum && !used){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method to apply the coupon
     * @param treasury all about product price
     * @return the total pay after the coupon is applied.
     */
    public double Apply(Treasury treasury) {
        this.used = true;
        switch (type) {
            case REBATE:
                return (treasury.getAdjustedPrice(this.minimum, this.cut) - cut);
            default:
                return (treasury.getAdjustedPrice(this.minimum, this.cut) * (1 - (cut / 100)));
        }
    }
}
