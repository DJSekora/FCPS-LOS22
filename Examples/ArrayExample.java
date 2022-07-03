/* This file contains basic examples of how to create and fill arrays.

 */
public class ArrayExample
{
  public static void main(String[] args)
  {
    // Often, we want to store a lot of pieces of the same type of information
    // that are related. This is the way we would need to do it if we were
    // using individual variables
    /*String name1 = "TJ";
    String name2 = "Jayden";
    String name3 = "Daniel";
    String name4 = "Aidan";
    
    System.out.println(name1);
    System.out.println(name2);
    System.out.println(name3);
    System.out.println(name4);*/
    
    // That's very inefficient! It also doesn't provide us with a way to loop
    // over all of these pieces of information, so we'll have to copy and paste
    // a lot of code. Instead, we can use arrays!
    
    
    
    // Declares the variable names of type String array
    String[] names;
    
    // Filling the array: option 1 (all at once)
    names = new String[]{"TJ", "Jayden", "Daniel", "Aidan"};
    
    // To access the data at a certain slot, the syntax is 
    // arrayName[slotNumber]
    // The slots begin with slot 0, so this should print "Daniel"
    System.out.println(names[2]);
    
    // We can change individual entries with this syntax:
    names[2] = "David";
    
    // The printout here should be "David"
    System.out.println(names[2]);
    
    // Instead of filling in all the data right away, we can instead
    // initialize the array with the number of slots we want
    int[] squares = new int[100];
    
    // Filling the array: option 2 (one by one)
    // (often done using a loop, but you could write 100 lines if you need to)
    for(int i = 0; i < 100; i++)
    {
      // In this example, we are putting all the perfect squares from 1 to
      // 10000 into our array (remember that the ^ character is not an
      // exponent symbol in Java, so we need to use multiplication or call
      // on a method to achieve our desired result).
      squares[i] = (i+1)*(i+1);
    }
    
    // Example loop to print out contents of array
    // .length tells us how many slots there are in the array
    // (useful in case we want to make the array a different size later)
    // Note that it's .length, not .length() like it is for Strings!
    for(int i=0; i<squares.length; i++)
    {
      System.out.println(squares[i]);
    }
  }
}