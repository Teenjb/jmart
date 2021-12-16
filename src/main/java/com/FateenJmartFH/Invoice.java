package com.FateenJmartFH;

import com.FateenJmartFH.dbjson.Serializable;

import java.util.Date;

/**
 * Invoice is storing data related to history and payment system.
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public abstract class Invoice extends Serializable
{
    /**
     * Status represents the order status.
     */
    public static enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }

    /**
     * Rating represents the order rating from buyer.
     */
    public static enum Rating{
        NONE,BAD,NEUTRAL,GOOD;
    }

    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;

    /**
     * Creates invoice.
     * @param buyerId The buyer's id
     * @param productId The product's id
     */
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    /**
     * Method to get the total pay
     * @param product The product
     * @return the total pay
     */
    public abstract double getTotalPay(Product product);
}
