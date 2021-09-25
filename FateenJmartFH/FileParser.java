package FateenJmartFH;


/**
 * Write a description of interface FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{
   public boolean read(String content);
   public Object write();
   public Object newInstance(String content);
}
