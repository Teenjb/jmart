package FateenJmartFH;


/**
 * interface FileParser is used to access file.
 *
 * @author fateen
 * @version 1.0A
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
