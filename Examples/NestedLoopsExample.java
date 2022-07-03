/* This file contains an example of putting one for loop inside of another to
   get 2 dimensional (gridlike) behavior. In this case, we are using nested
   loops to produce a multiplication table. Our table will not be aligned in
   the prettiest way, but there are ways to add appropriate amounts of space
   to make all the columns align properly.
 */
public class NestedLoopsExample
{
  public static void main(String[] args)
  {
    int size = 5;
    // i controls which row we are on
    for(int i = 0; i<size; i++)
    {
      // j controls where we are in the row
      for(int j = 0; j<=i; j++)
      {
        System.out.print(i * j + " ");
      }
      System.out.println(); // advance to next line
    }
  }
}