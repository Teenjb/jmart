package FateenJmartFH;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
    public static void main(String[] args) {
        System.out.println(getPromo());
        System.out.println(getCustomer());
        System.out.println(getDiscountPercentage(1000, 900));
        System.out.println(getDiscountedPrice(1000, 10.0f));
    }
    public static int getPromo(){
        return 0;
    }

    public static String getCustomer(){
        return "oop";
    }

    public static float getDiscountPercentage(int before, int after){
        if(before < after){
            return 0;
        }
        return (before - after)/10;
    }

    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage>100){
            return 0;
        }
        return price - (int)(price * discountPercentage);
    }

    public static int getOriginalPrice(int DiscountedPrice, float discountPercentage){
       return DiscountedPrice / (int)(1 - discountPercentage);
    }

    public static float getCommissionMultiplier(){
        return (float)0.05;
    }
    
    public static int getAdjustedPrice(int price){
        return price + (int)((float)price * getCommissionMultiplier());
    }

    public static int getAdminFee(int price) {
        return (int)((float)price * getCommissionMultiplier());
    }
}
