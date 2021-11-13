package FateenJmartFH;


import java.util.HashMap;

/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    public static <T> int setClosingId(Class<T> clazz){
        return 0;
    }

    public static <T> int getClosing(Class<T> clazz, int id){
        return id;
    }

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            mapCounter.put(getClass(),0);
            this.id = 0;
        }else{
            mapCounter.put(getClass(),counter + 1);
            this.id = counter+1;
        }
    }
    public boolean equals(Object other) {
        return (other instanceof Serializable) && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other) {
        return this.id == other.id;
    }

    @Override
    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }

    public static <T> Integer setClosingId(Class<T> clazz, int id)
    {
        return mapCounter.put(clazz, id);
    }

    public static <T> Integer getClosingId(Class<T> clazz)
    {
        return mapCounter.get(clazz);
    }
}
