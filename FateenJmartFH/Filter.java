package FateenJmartFH;

import java.util.ArrayList;


/**
 * filter is used to select priceTag and Rating.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag (PriceTag[] list, Double value, boolean less){
        ArrayList<PriceTag> store = new ArrayList<PriceTag>();
        if(less){
            for(int x=0; x < list.length; x++){
                if(list[x].getAdjustedPrice() < value){
                    store.add(list[x]);
                }
            }
        }else{
            for(int x=0; x < list.length; x++){
                if(list[x].getAdjustedPrice() >= value){
                    store.add(list[x]);
                }
            }
        }
        return store;
    }

    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        if(less){
            for(int x=0; x < list.size(); x++){
                if(list.get(x).getAvarage() < value){
                    list.remove(x);
                }
            }
        }else{
            for(int x=0; x < list.size(); x++){
                if(list.get(x).getAvarage() >= value){
                    list.remove(x);
                }
            }
        }
    }
}
