/* This file contains 3 method-related examples:
   
   1. How to access a method in another file (requires MethodIntro.class in the
      same folder to work)
   2. How to access methods from libraries that have been imported (the Math,
      String, and System libraries are always imported by default so we can
      use their methods freely)
   3. How to write and call methods with parameters/arguments (think of these
      as inputs to a function)
 */
public class MethodsExample
{
  public static void main(String[] args)
  {
    // To access a method in another file, use Filename.methodName
    // The method must be static for this to work, and the .class file
    // containing the method must be accessible by the file from which you
    // want to call it (for now, this means that the two files need to be
    // in the same folder, or the method's file must be imported).
    MethodIntro.aMethod();
    
    // This is how we can access methods from the math library
    System.out.println(Math.sqrt(12)); // square root
    System.out.println(Math.pow(12,3)); // exponents
    
    // Example of calling the same method with two different arguments
    printPlusTwo(2);
    printPlusTwo(5);
    
    // Calling a method with 2 arguments. Order matters! Matches method
    printExponent(5, 3);
  }
  
  // Example of a method with a parameter
  // x is the parameter
  public static void printPlusTwo(int x)
  {
    System.out.println(x + 2);
  }
  
  // Separate multiple parameters with a comma
  // This prints out 'base' raised to the exponent 'power'
  public static void printExponent(int base, int power)
  {
    // 'total' stores the running computation
    // VERY common paradigm - use a loop to accumulate computation
    int total = base; // initial value for computation
    for(int i = 1; i < power; i++)
    {
      total = total*base; // modify value with each loop iteration
    }
    System.out.println(total);
  }
}