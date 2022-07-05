/* A quick example of how to use an array to improve a chatbot by having a list
   of recognized words stored in an array */
public class ArrayChatExample
{
  public static void main(String[] args)
  {
    System.out.println("How are you?");
    
    // Here we have created a String for demonstration purposes, but in a real
    // situation you would be getting this String from the user
    // (feel free to change this and play around)
    String response = "I'm doing good. In fact, I'm great!";
    
    // Store a bunch of positive words here so we can handle all of them
    // Note how we can use multiple lines so we don't have to scroll to read
    // the code (just make sure to close your curly brackets at the end and
    // add a semi-colon)
    String[] positive = new String[]{"good", "great", "fantastic", "wonderful",
                                     "magnificent", "splendid", "awesome",
                                     "stupendous", "exceptional", "amazing"};
    
    
    for(int i=0; i<positive.length; i++)
    {
      if(response.contains(positive[i]))
      {
        System.out.println("Great to hear that!");
        
        // We would like to end the loop here. Otherwise, if we found multiple
        // positive words, then we would print our message multiple times!
        break; // ends the loop
        //i = positive.length; // This is an alternate way to force the loop to end
      }
    }
    
    
    /* The previous method works fine, but it's a bit limited. If the user
       doesn't enter a positive word, we might want to tell them a different
       message, but the previous method doesn't really allow for that!
       In this case, we can use a boolean variable as a 'flag' to tell us
       whether or not a positive word was found, with only 3 extra lines:*/
    boolean foundPositive = false; // extra line 1
    for(int i=0; i<positive.length; i++)
    {
      if(response.contains(positive[i]))
      {
        // record when we find a positive
        foundPositive = true; // extra line 2
        System.out.println("Great to hear that!");
        break;
      }
    }
    if(!foundPositive) // extra line 3
    {
      System.out.println("I hope tomorrow is better!");
    }
  }
}