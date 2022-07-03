/* This class contains two examples of public static void methods, the
   simplest type of method.
   
   Other types of methods allow inputs or produce outputs that can be passed
   back into the rest of the program, but public static void methods are
   merely code blocks with names that can be re-used by writing their name
   followed by parentheses.
 */
public class MethodIntro
{
  // Note the formatting here - main is a method!
  public static void main(String[] args)
  {
    // Some example method calls
    aMethod();
    aMethod();
    somethingElse();
    aMethod();
    aMethod();
  }
  
  // Method declaration (sometimes called definition)
  // 'aMethod' is the name of the method
  public static void aMethod()
  {
    // Method body
    System.out.println("Hi!");
    System.out.println("How are you!");
    System.out.println("I hope you have a great day!");
  }
  
  public static void somethingElse()
  {
    System.out.println("Bye!");
    System.out.println("I don't care how you are!");
    System.out.println("I hope you have a terrible day!");
  }
}