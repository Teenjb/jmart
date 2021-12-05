package com.FateenJmartFH.controller;

import com.FateenJmartFH.Account;
import com.FateenJmartFH.Algorithm;
import com.FateenJmartFH.Product;
import com.FateenJmartFH.ProductCategory;
import com.FateenJmartFH.dbjson.JsonAutowired;
import com.FateenJmartFH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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
                    @RequestParam ProductCategory category
            )
    {
        List<Product> tempProduct = new ArrayList<Product>();
        for (Product each : productTable) {
            if (each.accountId == accountId)
                if (each.name.contains(search))
                    if (minPrice <= each.price)
                        if (maxPrice >= each.price)
                            if (each.category == category)
                                tempProduct.add(each);
        }
        return tempProduct;
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
