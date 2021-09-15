package FateenJmartFH;


/**
 * Write a description of class Jmart here.
 *
 * @author Fateen Najib Indramustika
 * @version (a version number or a date)
 */
public class Jmart
{
    public static void main(String[] args) {
        System.out.println(getPromo());
        System.out.println(getCustomer());
        System.out.println(getDiscountPercentage(900, 800));
        System.out.println(getDiscountedPrice(1000, 10.0f));
        System.out.println(getOriginalPrice(900, 10.0f));
        System.out.println(getAdjustedPrice(1000));
        System.out.println(getAdminFee(1000));


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
        return (((float)before - (float)after)/(float)before)*100;
    }

    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return 0;
        }
        return price - (int)(price * discountPercentage/100);
    }

    public static int getOriginalPrice(int DiscountedPrice, float discountPercentage){
       return (int)((float)DiscountedPrice / (1 - (discountPercentage / 100)));
    }

    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        return price + (int)((float)price * getCommissionMultiplier());
    }

    public static int getAdminFee(int price) {
        return (int)(price * getCommissionMultiplier());
    }
}
