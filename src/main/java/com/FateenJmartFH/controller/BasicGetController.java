package com.FateenJmartFH.controller;

import com.FateenJmartFH.Algorithm;
import com.FateenJmartFH.dbjson.JsonTable;
import com.FateenJmartFH.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BasicGetController is used as a universal get by id, get by page
 * @param <T> generic can be used with all type of data.
 * @author Fateen Najib Indramustika
 *
 */

@RestController
public interface BasicGetController <T extends Serializable> {

    /**
     * get the object with certain id
     * @param id the id
     * @return the object with certain id
     */
    @GetMapping("/{id}")
    public default T getById (@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(),e -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable ();

    /**
     * get the page in certain page size of json table.
     * @param page the page.
     * @param pageSize the page size.
     * @return list of all item in the page.
     */
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page,@RequestParam int pageSize){
        final JsonTable<T> table = getJsonTable();
        return Algorithm.paginate(table,page,pageSize,o->true);
    }

}
