package FateenJmartFH;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Write a description of class Jmart here.
 *
 * @author Fateen Najib Indramustika
 * @version (a version number or a date)
 */
public class Jmart
{
    public static void main(String[] args) {
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        try{
            List<Product> list = read("C:/Users/ASUS/Documents/Fateen/Universitas Indonesia/Teknik Komputer/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Code/Jmart/src/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 1000.0, 20000.0);
            filtered.forEach(Product -> System.out.println(Product.price));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
    }

    public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> predicate = temporary -> (temporary.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        List<Product> result = gson.fromJson(br, userListType);
        return result;
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        List<Product> result = new ArrayList<Product>();
        for (Product prod : list) {
            if (prod.category.equals(category)) {
                result.add(prod);
            }
        }
        return result;
    }

    public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize){
        Predicate<Product> predicate = temp -> (temp.name.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT)));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByPrice (List<Product> list, double minPrice, double maxPrice){
        List<Product> result = new ArrayList<Product>();
        for (Product product : list)
        {
            if (minPrice <= 0.0 && product.price < minPrice)
            {
                continue;
            }
            if (maxPrice <= 0.0 && product.price > maxPrice)
            {
                continue;
            }
            result.add(product);
        }
        return result;
    }

    private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){
        return list.stream().filter(temp -> pred.predicate(temp)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }


}

