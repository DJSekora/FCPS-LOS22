/* A quick example of how we could use an array to put a list of information
   in a random order (used for group forming in this class!)


   The basic procedure: for each index i in the array, we pick a random
   person that has not been picked yet, and swap them with whoever is in
   slot i. This way, the beginning of the array will be randomized, and
   the end of the array will contain all of the people who haven't been
   picked yet.
       
   EXAMPLE: We are randomizing [A|B|C|D|E|F|G].
       
     Array: [A|B|C|D|E|F|G]
     Cursor: ^
       
    Cursor starts at position 0.
    Pick a random number 0 through 6. Let's say we get 4.
    The person at slot 4 (E) is then swapped with the person at slot 0 (A),
    and the cursor then advances to slot 1. Current state:
    
     Array: [E|B|C|D|A|F|G]
     Cursor:   ^
    
    Repeat this process 2 more times:
    
     Random draw between 1 and 6: say we get 2
     Swap: B and C
     Array: [E|C|B|D|A|F|G]
     Cursor:     ^
    
     Random draw between 2 and 6: say we get 6
     Swap: G and B
     Array: [E|C|G|D|A|F|B]
     Cursor:       ^

    Now, the positions of E, C, and G (everything before the cursor) are fixed,
    but the positions of D, A, F, and B have yet to be determined. Repeat 3
    more times:
     
     Random draw between 3 and 6: say we get 3
     Swap: D and D (no change)
     Array: [E|C|G|D|A|F|B]
     Cursor:         ^
     
     Random draw between 4 and 6: say we get 6
     Swap: A and B
     Array: [E|C|G|D|B|F|A]
     Cursor:           ^
     
     Random draw between 5 and 6: say we get 5
     Swap: F and F (no change)
     Array: [E|C|G|D|B|F|A]
     Cursor:             ^
     
    The cursor is at the end, so we are done!
 */

import java.util.Random;

public class RandomDraw
{
  public static void main(String[] args)
  {
    // The full list of names, initially in alphabetical order
    String[] names = new String[]{"Jimin", "Aidan", "Vadim", "TJ", "Daniel",
                                  "Samuel", "Joanna", "Brian", "Nabeela",
                                  "Ian", "Katie", "Jayden", "Melanie"};
    
    Random rng = new Random();
    
    for(int i=0; i<names.length; i++)
    {
      // This gives us a random number between i and 12, inclusive
      int slot = rng.nextInt(13-i) + i;
      
      // We are making a swap here, which means that we need an extra temporary
      // variable to hold the original value of names[slot] before we overwrite it
      String temp = names[slot];
      names[slot] = names[i];
      names[i] = temp;
    }
    
    for(int i=0; i<names.length; i++)
    {
      System.out.println(names[i]);
    }
  }
}