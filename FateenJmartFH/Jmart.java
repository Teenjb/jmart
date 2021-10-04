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
        Account akun1 = akun();
        System.out.println(akun1.validate());
        System.out.println(akun1.id);
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

    public static Product create(){
        return null;
    }
    public static Product createProduct(){
        return null;
    }
    public static Coupon Coupon(){
        return null;
    }
    public static Shipment.Duration ShipmentDuration(){
        return null;
    }

    public static Account akun(){
        Account akun1 = new Account(10, "Fateen", "FateenNajib@gmail.com", "Fateen1najib");
        return akun1;
    }
}
