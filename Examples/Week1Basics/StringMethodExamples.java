public class StringMethodExamples
{
  public static void main(String[] args)
  {
    String text = "Johnny walked to the house.";
    
    // Strings in Java are 0-indexed. The first position
    // in the String is 0.
    
    // charAt(n) retrieves the character at position n
    char c = text.charAt(3);
    System.out.println(c);
    
    // substring(a,b) gets the characters from position a to b
    String johnny = text.substring(0,6);
    
    System.out.println(johnny);
  }
}