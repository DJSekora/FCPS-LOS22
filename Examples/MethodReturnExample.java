/* This class contains examples of how to write methods that have a return
   value.
   
   Remember that a method can have only one return value and return type!
 */
public class MethodReturnExample
{
  public static void main(String[] args)
  {
    // A method that returns an int can be used anywhere an int can
    // Think of it as a function in math
    int y = timesTwo(7) + 3;
    
    // You can call methods inside of methods
    System.out.println(y + " " + timesTwo(timesTwo(y)));
    
    // This line appears not to do anything! That's because timesTwo
    // doesn't print anything - it's sole purpose is to return a value
    // for use in further computation.
    // Consider writing '5;' as a line of code. Equally ridiculous!
    timesTwo(3);
  }
  
  // The slot that we have previously been filling with the 'void' keyword
  // is for the return type (the type of the output of the function). Here,
  // the return type is 'int'.
  // A function can only have ONE return type!
  public static int timesTwo(int x)
  {
    return x*2;
    
    // A return statement immediately ends execution of the method. So,
    // we can't put any code right after a return statement.
    //System.out.println("This is unreachable!");
  }
  
  // If we want to return more than one piece of information, we need
  // to use a data structure such as an array.
  // Note the square brackets [] in the return type!
  // (This particular example converts polar coordinates to rectangular
  //  coordinates, a common need in trigonometry and graphics)
  public static double[] getRectCoordinates(double r, double theta)
  {
    double x = r*Math.sin(theta);
    double y = r*Math.cos(theta);
    
    return new double[]{x,y};
    
    // These two options would also work to accomplish the same result:
    
    //Option 1:
    /*double[] ret = new double[2];
    double[0] = x;
    double[1] = y;
    return ret;
    */
    
    // Option 2 (only one line, but possibly harder to read):
    // return new double[]{r*Math.sin(theta), r*Math.cos(theta)};
  }
}