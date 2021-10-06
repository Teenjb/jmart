package FateenJmartFH;


/**
 * Abstract class that include validate and perform
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Transactor
{
    public abstract boolean validate();
    public abstract Invoice perform();
}
