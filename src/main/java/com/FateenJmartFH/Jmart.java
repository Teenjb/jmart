package com.FateenJmartFH;

/**
 * Write a description of class Jmart here.
 *
 * @author Fateen Najib Indramustika
 * @version (a version number or a date)
 */
import com.FateenJmartFH.dbjson.JsonDBEngine;
import com.google.gson.*;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class Jmart
{
    public static long DELIVERED_LIMIT_MS = 1;
    public static long ON_DELIVERY_LIMIT_MS = 1;
    public static long ON_PROGRESS_LIMIT_MS = 1;
    public static long WAITING_CONF_LIMIT_MS = 1;
    private static Object Payment;

    public static void main (String[] args){
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
//        try{
//            JsonTable<Payment> table = new JsonTable<>(Payment.class,"C:\\Users\\ASUS\\Documents\\Fateen\\Universitas Indonesia\\Teknik Komputer\\Semester 3\\Pemrograman Berorientasi Objek\\Praktikum\\source\\randomPaymentList.json");
//            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
//            paymentPool.start();
//            table.forEach(payment -> paymentPool.add((Payment) Payment));
//            while (paymentPool.size() != 0);
//            paymentPool.exit();
//            while (paymentPool.isAlive());
//            System.out.println("Thread exit successfully");
//            Gson gson = new Gson();
//            table.forEach(payment -> {
//                String history = gson.toJson(payment);
//                System.out.println(history);
//            });
//        }
//        catch (Throwable t){
//            t.printStackTrace();
//        }
    }

    public static boolean paymentTimekeeper(Payment payment) {
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

//    public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize){
//        Predicate<Product> predicate = temporary -> (temporary.accountId == accountId);
//        return paginate(list, page, pageSize, predicate);
//    }
//
//    public static List<Product> read(String filepath) throws FileNotFoundException {
//        Gson gson = new Gson();
//        Type userListType = new TypeToken<ArrayList<Product>>() {
//        }.getType();
//        BufferedReader br = new BufferedReader(new FileReader(filepath));
//        List<Product> result = gson.fromJson(br, userListType);
//        return result;
//    }
//
//    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
//        List<Product> result = new ArrayList<Product>();
//        for (Product prod : list) {
//            if (prod.category.equals(category)) {
//                result.add(prod);
//            }
//        }
//        return result;
//    }
//
//    public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize){
//        Predicate<Product> predicate = temp -> (temp.name.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT)));
//        return paginate(list, page, pageSize, predicate);
//    }
//
//    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
//        if (minPrice <= 0) {
//            return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice);
//        }
//        else if (maxPrice <= 0) {
//            return Algorithm.<Product>collect(list, prod -> prod.price >= minPrice);
//        }
//        return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice && prod.price >= minPrice);
//    }
//
//    public static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){
//        return list.stream().filter(temp -> pred.predicate(temp)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
//    }

