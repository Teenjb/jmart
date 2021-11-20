package com.FateenJmartFH.controller;
import com.FateenJmartFH.Invoice;
import com.FateenJmartFH.dbjson.JsonTable;
import com.FateenJmartFH.ObjectPoolThread;
import com.FateenJmartFH.Payment;
import com.FateenJmartFH.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/{id}/accept")
    public boolean accept(int id) {
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(int id) {
        return false;
    }

    @PostMapping("/create")
    public Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        return null;
    }

    @PostMapping("/submit")
    public boolean submit(int id, String receipt) {
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
