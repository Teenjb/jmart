package com.FateenJmartFH;


/**
 * used to check price of product
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public class Treasury
{
    
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;

    public static double getAdjustedPrice(double price, double discount){
        return getAdminFee(price, discount) + getDiscountedPrice(price, discount);
    }

    public static double getAdminFee(double price, double discount){
        double temp = getDiscountedPrice(price, discount);
        if(temp < BOTTOM_PRICE){
            temp = BOTTOM_FEE;
        }
        return temp * COMMISSION_MULTIPLIER;
        
    }
    public static double getDiscountedPrice(double price, double discount){
        if(discount == 100.0){
            return 0.0;
        }else{
            return price * (1-(discount)/100);
        }
    }
}
