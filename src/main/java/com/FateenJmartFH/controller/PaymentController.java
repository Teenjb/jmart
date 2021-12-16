package com.FateenJmartFH.controller;
import com.FateenJmartFH.*;
import com.FateenJmartFH.dbjson.JsonTable;
import com.FateenJmartFH.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Payment controller is used to handle request Payment class
 * @author Fateen Najib Indramustika
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERIY_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;
    @JsonAutowired(value = Payment.class,filepath = "payment.json")
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @Override
    public Payment getById(int id) {
        return BasicGetController.super.getById(id);
    }

    @Override
    public List<Payment> getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }

    /**
     * For post request to accept a buyer's payment.
     * Used by the store to continue the order.
     * if the store doesn't accept the payment until
     * exceeds the time limit, the order will be failed.
     * @param id payment id.
     * @return true if success, otherwise false.
     */
    @PostMapping("/{id}/accept")
    public boolean accept
            (
                    @PathVariable Integer id
            )
    {
        for(Payment each : paymentTable){
            if(each.id == id){
                if(each.history.get(each.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION){
                    each.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, null));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * For post request to cancel payment when the last
     * history status is "waiting confirmation".
     * This can be done by store or buyer.
     * @param id payment id.
     * @return true if success, otherwise false.
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel(
           @PathVariable int id
        )
    {
        for (Payment iterate : paymentTable) {
            if (iterate.id == id) {
                if (iterate.history.get(iterate.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
                    iterate.history.add(new Payment.Record(Invoice.Status.CANCELLED, null));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * For post request to make a payment.
     * @param buyerId buyer id.
     * @param productId product id.
     * @param productCount product count.
     * @param shipmentAddress buyer's shipment address
     * @param shipmentPlan shipment plan.
     * @return payment after created.
     */
    @PostMapping("/create")
    public Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan
            )
    {
        Product product1 = Algorithm.<Product>find(ProductController.productTable,e -> e.id == productId);
        Account account1 = Algorithm.<Account>find(AccountController.accountTable,e -> e.id == buyerId);
        if(product1 != null && account1 != null ){
            Payment payment = new Payment(buyerId,productId,productCount,new Shipment(shipmentAddress,0,shipmentPlan,null));
            if(payment.getTotalPay(product1) > account1.balance){
                return null;
            }else {
                account1.balance -= payment.getTotalPay(product1);
                payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION," "));
                paymentTable.add(payment);
                return payment;
            }
        }else {
            return null;
        }
    }

    /**
     * For post request to submit receipt if the product has
     * just been in the courier.
     * This can be done by the store after accept the buyer's payment.
     * @param id payment id.
     * @param receipt the receipt.
     * @return true if success, otherwise false.
     */
    @PostMapping("/{id}/submit")
    public boolean submit
            (
                    @PathVariable int id,
                    @RequestParam String receipt
            )
    {
        for(Payment each : paymentTable){
            if(each.id == id){
                if(each.history.get(each.history.size()-1).status == Invoice.Status.ON_PROGRESS){
                    if(!receipt.isBlank()){
                        each.shipment.receipt = receipt;
                        each.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, null));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Time keeper of order track.
     * Automatically add new order history if
     * the last one exceeds the specified time limit
     * @param payment the payment to check.
     * @return false after add new "delivered" status in history, otherwise false.
     */
    private static boolean timekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = System.currentTimeMillis() - record.date.getTime();
        if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
            record.status = Invoice.Status.FAILED;
            return true;
        } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
            record.status = Invoice.Status.FAILED;
            return true;
        } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
            record.status = Invoice.Status.FINISHED;
            return true;
        } else if (record.status.equals(Invoice.Status.FINISHED) && (elapsed > DELIVERED_LIMIT_MS)) {
            record.status = Invoice.Status.FINISHED;
            return true;
        } else {
            return false;
        }
    }
}
