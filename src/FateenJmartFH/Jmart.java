package FateenJmartFH;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;


/**
 * Write a description of class Jmart here.
 *
 * @author Fateen Najib Indramustika
 * @version (a version number or a date)
 */
public class Jmart
{
    public static void main(String[] args) {
//        String filepath = "C:/Users/ASUS/Documents/Fateen/Universitas Indonesia/Teknik Komputer/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Code/Jmart/src/city.json";
//        Gson gson = new Gson();
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name : " + input.name);
//            System.out.println("population : " + input.population);
//            System.out.println("states : ");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);    }

    static List<Product> read (String filePath){
        Gson gson = new Gson();
        List<Product> Data = new ArrayList<Product>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            Product input = gson.fromJson(br,Product.class);
            System.out.println(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        return Data;
    }

    public static List<Product> filterByCategory (List<Product> list, ProductCategory category){
        return null;
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

}
