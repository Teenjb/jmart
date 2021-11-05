package FateenJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Recognizable implements Comparable<Recognizable>
{
    public final int id;

    public static <T> int setClosingId(Class<T> clazz){
        if(clazz.isAssignableFrom(Recognizable.class)){
            return 0;
        }else{
            return 1;
        }
    }

    public static <T> int getClosing(Class<T> clazz, int id){
        if(clazz.isAssignableFrom(Recognizable.class)){
            return 0;
        }else{
            return 1;
        }
    }

    protected Recognizable()
    {
        this.id = 1;
    }
    public boolean equals(Object other) {
        if(!(other instanceof Recognizable)){
            Recognizable checked = (Recognizable)other;
            if(checked.id == this.id){
                return true;
            }
        }
        return false;
    }
    public boolean equals(Recognizable other) {
        if(this.id == other.id){
            return true;
        }
        return false;
    }

    public int compareTo(Recognizable other) {
        return other.id/this.id;
    }
}
