/* null is a special value in Java. It is the 0 of the Object world.
   For example, when you make an int array, the slots are initially filled
   with 0. When you make a String array (or an array of any other Object),
   the slots are instead filled with null.
   
   You can't call any methods on null. That is, if variable has the value null,
   and you try 'variable.method()', it will give you a NullPointerException.
 */
public class NullExample
{
  public static void main(String[] args)
  {
    int[] intArray = new int[1]; // 1 slot, holds a 0
    String[] stringArray = new String[2]; // 2 slots, each one holds null
    
    System.out.println(intArray[0]); // prints 0
    System.out.println(stringArray[0]); // prints null
    
    // To check if an object is null, we use == (this is one of the few times
    // we want to use == instead of .equals with objects)
    System.out.println(stringArray[0] == stringArray[1]); // prints true
    System.out.println(stringArray[0] == null);           // prints true
    
    // This will throw an exception because you can't call methods with null
    //System.out.println(stringArray[0].toUpperCase());
  }
}