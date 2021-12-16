package com.FateenJmartFH;


/**
 * Payment extend invoice is a detail data of invoice that contains any data about payments
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;

public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    /**
     * Store all the record of the order track in the payment.
     */
    public ArrayList<Record> history = new ArrayList<Record>();

    /**
     * Creates payment.
     * @param buyerId The buyer's id.
     * @param productId The product's id.
     * @param productCount The product's quantity.
     * @param shipment The order shipment
     */
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.shipment = shipment;
        this.productCount = productCount;
    }

    /**
     * Method to get total pay from product price, quantity, discount, and shipment cost.
     * @param product The product
     * @return total pay from product price, quantity, discount, and shipment cost.
     */
    @Override
    public double getTotalPay(Product product) {
        return (product.price*this.productCount)*(1 - product.discount/100);
    }

    /**
     * This is a class representing an order history record.
     */
    public  static class Record {
        public final Date date;
        public String massage;
        public Status status;

        /**
         * Creates a record of the order history.
         * @param status status of order
         * @param massage the message
         */
        public Record( Status status, String massage) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = status;
            this.massage = massage;
        }

    }
}
