package com.FateenJmartFH;

import com.FateenJmartFH.dbjson.Serializable;

import java.util.Date;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable
{
    public static enum Status{
        WAITING_CONFIRMATION,CANCELED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }

    public static enum Rating{
        NONE,BAD,NEUTRAL,GOOD;
    }

    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;

    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    public abstract double getTotalPay(Product product);
}
