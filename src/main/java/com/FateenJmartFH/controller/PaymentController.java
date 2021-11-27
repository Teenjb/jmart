package com.FateenJmartFH.controller;
import com.FateenJmartFH.*;
import com.FateenJmartFH.dbjson.JsonTable;
import com.FateenJmartFH.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(" /{id}/accept ")
    boolean accept
            (
                    @RequestParam int id
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

    @PostMapping("/{id}/cancel")
    public boolean cancel(int id) {
        for (Payment iterate : paymentTable) {
            if (iterate.id == id) {
                if (iterate.history.get(iterate.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
                    iterate.history.add(new Payment.Record(Invoice.Status.CANCELED, null));
                    return true;
                }
            }
        }
        return false;
    }

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
        for (Account account : AccountController.accountTable){
            for (Product product : ProductController.productTable){
                if(account.id == buyerId && product.id == productId){
                    Payment payment = new Payment(buyerId,productId,productCount,new Shipment(shipmentAddress,0,shipmentPlan,null));
                    if(payment.getTotalPay(product) > account.balance){
                        return null;
                    }else {
                        account.balance -= payment.getTotalPay(product);
                        paymentTable.add(payment);
                        return payment;
                    }
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    @PostMapping(" /{id}/submit ")
    boolean submit
            (
                    @RequestParam int id,
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
