package com.FateenJmartFH;


/**
 * Product rating is storing rate of a product
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public class ProductRating
{
    private long total;
    private long count;


    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }
    /**
     * Method to add rating of the product
     * @param rating The rating
     */
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    /**
     * Method to count the average rating of the product.
     * @return rating number of the product.
     */
    public double getAvarage() {
        if(count <= 0){
            return 0;
        }else{
            return total/count;
        }
    }
    /**
     * Method to get how much time the product rating were added
     * @return number of count.
     */
    public long getCount() {
        return count;
    }
    /**
     * Method to get the total sum of product rating
     * @return the total sum of product rating
     */
    public long getTotal() {
        return total;
    }
}
