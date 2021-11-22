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

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class, filepath = "coupon.json")
    public static JsonTable<Coupon> couponTable;

    @GetMapping("/{id}/canApply")
    boolean canApply(@RequestParam int id, @RequestParam double price, @RequestParam double discount) {
        for (Coupon data : couponTable) {
            if (data.id == id) {
                return data.canApply(price, discount);
            }
        }
        return false;
    }

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

    @GetMapping("/getAvailable")

    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.paginate(couponTable, page, pageSize, pred -> !pred.isUsed());
    }


    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

}