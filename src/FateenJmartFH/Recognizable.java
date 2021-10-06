package FateenJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Recognizable
{
    public final int id;


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

}
