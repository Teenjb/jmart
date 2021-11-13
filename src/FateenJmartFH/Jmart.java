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
        String filepath = "C:\\Users\\ASUS\\Documents\\Fateen\\Universitas Indonesia\\Teknik Komputer\\Semester 3\\Pemrograman Berorientasi Objek\\Praktikum\\Code\\Jmart\\src\\FateenJmartFH\\Account.Json";
        try{
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name","email","password"));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class,filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));
        }catch (Throwable t){
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

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        if (minPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice);
        }
        else if (maxPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price >= minPrice);
        }
        return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice && prod.price >= minPrice);
    }

    private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){
        return list.stream().filter(temp -> pred.predicate(temp)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }


}

