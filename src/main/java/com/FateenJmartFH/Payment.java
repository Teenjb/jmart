package com.FateenJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Date;

public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    public ArrayList<Record> history;

    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.shipment = shipment;
        this.productCount = productCount;
    }

    @Override
    public double getTotalPay(Product product) {
        return (product.price*this.productCount)*product.discount;
    }

    public  static class Record {
        public final Date date;
        public String massage;
        public Status status;


        public Record( Status status, String massage) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = Status.WAITING_CONFIRMATION;
            this.massage = massage;
        }

    }
}
