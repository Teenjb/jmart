package FateenJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable
{
    private static int idCounter = 0;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;

    public Product(int id, int storeId,String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.id = idCounter++;
        rating = new ProductRating();
    }
    public Product(int id, Store store,String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.id = idCounter++;
        rating = new ProductRating();
    }
    public boolean read(String content){
        return false;
    }
}
