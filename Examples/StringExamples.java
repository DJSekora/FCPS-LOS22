/* Description: More String examples and features!
 *
 * Written by: David Sekora
 */

public class StringExamples
{
  public static void main(String[] args)
  {
    // We can print new lines with additional print statments
    System.out.println("I like pie");
    System.out.println(); // no input = blank line
    System.out.println("Cake is ok too");
    
    // Or we can do it like this with an escape character
    System.out.println("I like pie\n\nCake is ok too");
    
    // To print a backslash, you need TWO
    System.out.println("\\");
    
    // This waits 1000ms = 1s
    try
    {
      Thread.sleep(1000);
    }
    catch(Exception e){}
    
    System.out.println("This will print after 1 second");
  }
}