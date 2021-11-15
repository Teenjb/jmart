package FateenJmartFH;
import com.google.gson.*;

/**
 * Write a description of class Jmart here.
 *
 * @author Fateen Najib Indramustika
 * @version (a version number or a date)
 */
public class Jmart
{
    public static long DELIVERED_LIMIT_MS = 1;
    public static long ON_DELIVERY_LIMIT_MS = 1;
    public static long ON_PROGRESS_LIMIT_MS = 1;
    public static long WAITING_CONF_LIMIT_MS = 1;

    public static void main (String[] args){
        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class,"C:\\Users\\ASUS\\Documents\\Fateen\\Universitas Indonesia\\Teknik Komputer\\Semester 3\\Pemrograman Berorientasi Objek\\Praktikum\\Code\\Jmart\\src\\randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimeKeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add((Payment) payment));
            while (paymentPool.size() != 0);
            paymentPool.exit();
            while (paymentPool.isAlive());
            System.out.println("Thread exit successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment);
                System.out.println(history);
            });
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static boolean paymentTimeKeeper(Payment payment){
        long startTime = System.currentTimeMillis();
        if(System.currentTimeMillis() - startTime > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
        }
        else if(System.currentTimeMillis() - startTime > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
            return true;
        }
        return false;
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

}

