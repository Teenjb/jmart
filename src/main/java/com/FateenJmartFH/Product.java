package com.FateenJmartFH;


import com.FateenJmartFH.dbjson.Serializable;

/**
 * Products storing data about detail of products
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;


    /**
     * Creates a product.
     * @param accountId The account id of user creating this product.
     * @param name Product name.
     * @param weight Product weight.
     * @param conditionUsed Product condition. False if new, true if used.
     * @param price Product price.
     * @param discount Product discount.
     * @param category Product category
     * @param shipmentPlans Product shipment plan
     */
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.category = category;
        this.accountId = accountId;
        this.price = price;
        this.discount = discount;
        this.shipmentPlans = shipmentPlans;
    }

    public String toString(){
        return "name: " + (String)this.name + "\n" + "weight: " + (int)this.weight + "\n" + "conditionUsed: " +  (boolean)this.conditionUsed + "Discount: " + (Double)this.discount + "\n" + "Category: " + this.category + "\n" + "Price: " + (double)this.price + "\n" + "ShipmentPlans: " + this.shipmentPlans;
    }
    
}
