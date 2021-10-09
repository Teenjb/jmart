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

    public static <T> int setClosingId(Class<T> clazz,int id){
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

    protected Recognizable(int id)
    {
        this.id = id;
    }
    public boolean equals(Object check) {
        if(!(check instanceof Recognizable)){
            Recognizable checked = (Recognizable)check;
            if(checked.id == this.id){
                return true;
            }
        }
        return false;
    }
    public boolean equals(Recognizable check) {
        if(this.id == check.id){
            return true;
        }
        return false;
    }

    public int compareTo(Recognizable check) {
        return check.id/this.id;
    }
}
