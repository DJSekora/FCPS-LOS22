/* An example demonstrating the usage of for loops */
public class ForLoopExample
{
  public static void main(String[] args)
  {
    //int i;
    
    // Three steps of for loop:
    // Initialization, condition, iteration
    for(int i = 0;      i < 10;     i++ )
    {
      // Put the code you want to repeat in here
      System.out.println(i);
    }
    
    // i++ is the same thing as i = i+1
    // ++i can also be used, with slightly different behavior
    // i+=5 is the same as i = i + 5
    
    int x = 4;

    int y = x++;
    int z = ++x;
    
    System.out.println("x: " + x);
    System.out.println("y: " + y);
    System.out.println("z: " + z);
    
    // The following code does the same thing as the 3 lines above:
    /*
    x = 4;
    y = x;
    x = x + 1;
    x = x + 1;
    z = x;*/
    
    
    // Only the condition is required
    for(; x < 10;)
    {
      // Put the code you want to repeat in here
      System.out.println(x);
      
      // Make sure you're changing something each time or it may be infinite!
      x++;
    }
  }
}