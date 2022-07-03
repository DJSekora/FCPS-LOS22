/* This file contains an example of how to use a while loop to force a user
   to continue entering inputs until the correct input is found.
   
   (In practice, if you do this you should make sure to give the user a way
    to cancel or exit, in case they do not know the password!)
    
   At the end, we have a small example of how to use the 'break' statement
   to end a loop early.
 */
import java.util.Scanner;
public class WhileExample
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter password:");
    
    String pass = scan.nextLine();
    
    // Repeat the body (code block inside of the {}) as long as the condition
    // is true. The condition is checked before the first execution of the
    // body, so if the condition is false at the beginning then the body will
    // never run.
    // Remember that the ! symbol means "NOT", so here in this example we
    // continue looping as long as the entered pass does NOT equal "Morbius"
    while(!(pass.equals("Morbius")))
    {
      System.out.println("Try again!");
      pass = scan.nextLine();
    }
    System.out.println("You entered the password!");
    
    /* Sometimes, we have different conditions that we want to check at
       different times to end the loop. Often, there is a way to structure
       the loop so that we can fit all of these conditions into the first line,
       but sometimes it's easier or more efficient to manually end the loop.
       
       In these cases, we can use the 'break' statement to end the loop
       immediately.
       
       The below example is a little silly, but it will demonstrate how the
       break statement works. We look through the numbers 1-20 to see which
       one has the binary representation 1010 (the answer is 10 in decimal).
       (Obviously, we know the answer, so we know that the end of the loop
        doesn't need to be 20. But 20 provides an upper bound on the number
        of numbers we will check.)
     */
    int x = 0;
    while(x < 20)
    {
      x++;
      if(x == 0b1010) // 0b means we are writing the number in binary
      {
        System.out.println("x is " + x + ", found it!");
        break; // End the loop
      }
      System.out.println("x is " + x + ", not correct.");
    }
    
    // In this case, it's quite easy to remove the break with a little
    // resturcturing. The following code does the same thing by combining
    // an extra condition using the boolean AND operator (&&):
    
    /*int x = 1;
    while(x < 20 && x != 0b1010)
    {
      System.out.println("x is " + x + ", not correct.");
      x++;
    }
    if(x == 0b1010)
    {
      System.out.println("x is " + x + ", found it!");
    }
    */
  }
}