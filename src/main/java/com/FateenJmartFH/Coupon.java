package com.FateenJmartFH;


import com.FateenJmartFH.dbjson.Serializable;

/**
 * Class to access coupon
 * 
 * @author fateen
 * @version 1.0
 */
public class Coupon extends Serializable {

    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;

    public static enum Type {
        DISCOUNT, REBATE
    }

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

    public boolean canApply(Treasury treasury) {
        if (treasury.getAdjustedPrice(this.minimum, this.cut) >= this.minimum && !this.used) {
            return true;
        }
        return false;
    }

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
