/* An example demonstrating the usage of for loops,
   as well as some information about the ++ operator.
 */
public class ForLoopExample
{
  public static void main(String[] args)
  {
    //int i;
    
    // Three parts of the for loop declaration:
    // Initialization, condition, iteration
    for(int i = 0;      i < 10;     i++ )
    {
      // Put the code you want to repeat in here
      // This is called the body
      System.out.println(i);
    }
    
    /* The order of execution in a for loop is as follows:
        1. Initialization (int i = 0)
        2. Check the condition (i < 10). If true, continue to step 3.
           If false, end the loop.
        3. Body (code inside the curly brackets {})
        4. Iteration (i++)
        5. Return to step 2
     */
    
    
    // Side note:
    // i++ is the same thing as i = i+1
    // ++i can also be used, with slightly different behavior
    // i+=5 is the same as i = i + 5
    
    int x = 4;
    
    // x++ returns the original value of x, so y will be 4
    int y = x++;
    
    // ++x returns the value of x after it has been incremented, so z will be 6
    int z = ++x;
    
    // At the end, x has been incremented twice (first by x++ and then
    // by ++x), so x will equal 6.
    
    System.out.println("x: " + x);
    System.out.println("y: " + y);
    System.out.println("z: " + z);
    
    // The following code does the same thing as the 3 lines above:
    /*
    x = 4;
    
    // This is the y = x++; part
    y = x;
    x = x + 1;
    
    // This is the z = ++x; part
    x = x + 1;
    z = x;*/
    
    
    // Side note:
    // Technically, only the condition is required. But, if you only use
    // the condition, then the for loop becomes equivalent to a while loop,
    // so you should use a while loop instead.
    for(; x < 10;)
    {
      // Put the code you want to repeat in here
      System.out.println(x);
      
      // Make sure you're changing something each time or it may be infinite!
      x++;
    }
  }
}