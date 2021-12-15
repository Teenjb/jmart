package com.FateenJmartFH.controller;

import com.FateenJmartFH.Account;
import com.FateenJmartFH.Algorithm;
import com.FateenJmartFH.Product;
import com.FateenJmartFH.ProductCategory;
import com.FateenJmartFH.dbjson.JsonAutowired;
import com.FateenJmartFH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Product Controller is used to handle product class
 * @author Fateen Najib Indramustika
 */

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
    @JsonAutowired(value = Product.class, filepath = "product.json")
    public static JsonTable<Product> productTable;

    @PostMapping("/create")
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        for(Account each : AccountController.accountTable) {
            if (each.id == accountId && each.store != null){
                Product product =  new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }
    @GetMapping("/getFiltered")
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category,
                    @RequestParam boolean conditionUsed
            )
    {
        ArrayList<Product> filtered = new ArrayList<Product>();
        for(Product item : productTable){
            if(item.name.contains(search) && item.price <= maxPrice && item.price >= minPrice && item.category == category && item.conditionUsed == conditionUsed){
                filtered.add(item);
            }
        }
        return Algorithm.<Product>paginate(filtered,page, pageSize, e -> {return true;});
    }
    @Override
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return BasicGetController.super.getById(id);
    }

    @Override
    public JsonTable getJsonTable() {
        return productTable;
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}
