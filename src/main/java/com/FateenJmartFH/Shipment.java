package com.FateenJmartFH;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * shipment is storing type of shipment based on byte
 *
 * @author Fateen Najib Indramustika
 * @version 1.0
 */
public class Shipment
{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1 << 0));    //1
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));   //2
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));   //4
    public static final Plan REGULER = new Plan((byte)(1 << 3));    //8
    public static final Plan KARGO = new Plan((byte)(1 << 4));      //16
    public int cost;
    public String address;
    public String receipt;
    private byte plan;

    /**
     * a Class to store bit of plans
     */
    public static class Plan{

        public final byte bit;

        private Plan(byte bit){
            this.bit = bit;
        }
    }

    /**
     * Creates a shipment.
     * @param address The address of destination.
     * @param cost The cost of shipment.
     * @param plan The shipment plan.
     * @param receipt The shipment receipt
     */
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.plan = plan;
        this.cost = cost;
        this.receipt = receipt;
    }

    /**
     * Method to get estimated date arrival
     * @param reference Date reference
     * @return a String of date estimated.
     */
    public String getEstimatedArrival(Date reference){
        Calendar temp = Calendar.getInstance();
        if(this.plan == 1<<0|| this.plan == 1<<1){
            return ESTIMATION_FORMAT.format(reference.getTime());
        }else if(this.plan == 1<<2){
            temp.setTime(reference);
            temp.add(Calendar.DATE,1);
            return ESTIMATION_FORMAT.format(temp);
        }else if(this.plan == 1<<3){
            temp.setTime(reference);
            temp.add(Calendar.DATE,2);
            return ESTIMATION_FORMAT.format(temp);
        }else{
            temp.setTime(reference);
            temp.add(Calendar.DATE,5);
            return ESTIMATION_FORMAT.format(temp);
        }
    }

    /**
     * Method to check if there is minimum 1 plan match the reference.
     * @param reference plan reference
     * @return true if there is match plan, otherwise false.
     */
    public boolean isDuration(Plan reference){
        if((reference.bit & this.plan) != 0){
            return true;
        }
        return false;
    }

    /**
     * Method to check if there is bit in object that match the reference.
     * @param object object to compare
     * @param reference plan referance
     * @return true if there is match plan, otherwise false.
     */
    public boolean isDuration(byte object,Plan reference){
        if((reference.bit & object) != 0){
            return true;
        }
        return false;
    }
}
