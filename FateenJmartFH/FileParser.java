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

   default Object write(){
       return null;
   }
   
   static Object newInstance(String content){
       return null;
   }
}
