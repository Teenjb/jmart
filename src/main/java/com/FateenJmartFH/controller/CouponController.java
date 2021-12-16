package com.FateenJmartFH.controller;

import com.FateenJmartFH.Algorithm;
import com.FateenJmartFH.Coupon;
import com.FateenJmartFH.dbjson.JsonAutowired;
import com.FateenJmartFH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Coupon controller is used to handle request about Coupon class
 * @author Fateen Najib Indramustika
 */

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {

    @JsonAutowired(value = Coupon.class, filepath = "coupon.json")
    public static JsonTable<Coupon> couponTable;

    /**
     * For get request to know if the coupon can be applied or not.
     * @param id coupon id.
     * @param price product price.
     * @param discount product discount.
     * @return true if coupon can be applied, false otherwise.
     */
    @GetMapping("/{id}/canApply")
    boolean canApply(@RequestParam int id, @RequestParam double price, @RequestParam double discount) {
        for (Coupon data : couponTable) {
            if (data.id == id) {
                return data.canApply(price, discount);
            }
        }
        return false;
    }

    /**
     * For get request to know if the coupon is already used or not
     * @param id coupon id.
     * @return the condition of coupon. true means used, otherwise false.
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed
            (
                    @RequestParam int id
            ) {
        for (Coupon each : couponTable) {
            if (each.id == id) {
                return each.isUsed();
            }
        }
        return false;
    }

    /**
     * For get request to get list of coupon which available.
     * @param page page of list
     * @param pageSize page size of list
     * @return list of coupon which available.
     */
    @GetMapping("/getAvailable")

    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.paginate(couponTable, page, pageSize, pred -> !pred.isUsed());
    }

    /**
     * Method to get coupon Json Table
     * @return account Json Table
     */
    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

}