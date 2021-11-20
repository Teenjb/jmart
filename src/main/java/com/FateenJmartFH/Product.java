package com.FateenJmartFH;


import com.FateenJmartFH.dbjson.Serializable;

/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
