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
    /**
     * The json table of Product class.
     * save locally in this path.
     */
    @JsonAutowired(value = Product.class, filepath = "product.json")
    public static JsonTable<Product> productTable;

    /**
     * For post request to creates product.
     * @param accountId account id.
     * @param name product name.
     * @param weight product weight.
     * @param conditionUsed product condition used. true if used, false if new.
     * @param price product price.
     * @param discount product discount.
     * @param category product category.
     * @param shipmentPlans shipment plan
     * @return the product that have been made
     */
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

    /**
     * For get request to collect product list of a store.
     * @param id account id of the store.
     * @param page page of product list.
     * @param pageSize page size of product list.
     * @return product list of a store.
     */
    @GetMapping("/{id}/store")
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }

    /**
     * For get request to get all product that have been filtered
     * @param page page of list.
     * @param pageSize page size of list.
     * @param accountId account id.
     * @param search product name.
     * @param minPrice minimum price.
     * @param maxPrice maximum price.
     * @param category product category.
     * @return all product that have been filtered with certain page and page size.
     */
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

    /**
     * Method to get product Json Table
     * @return product Json Table
     */
    @Override
    public JsonTable getJsonTable() {
        return productTable;
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}
