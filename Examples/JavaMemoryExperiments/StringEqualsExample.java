/* This file demonstrates that == works strangely sometimes when String
   literals (Strings written directly in your code with quotation marks "").
   
   The main takeaway (TLDR) here: always use .equals to check equality for Strings!
 */
public class StringEqualsExample
{
  public static void main(String[] args)
  {
    String a = "HI MOM";
    String b = "HI MOM";
    String c = "HI " + "MOM";
    char x = ' ';
    String d = "HI" + x + "MOM";
    
    // For Strings, they already wrote a method for us to tell if
    // they contain the same sequence of characters!
    // This is the RIGHT WAY to check if Strings contain the same characters
    System.out.println(a.equals(b));
    
    // We expect this to be false, but it turns out that when you put Strings
    // in quotes in your code, Java saves memory by only storing one copy of
    // each String. So, both a and b are pointing at the same copy of "HI MOM"
    System.out.println(a == b);
    
    // Apparently, Java also is smart enough to add String literals together
    // at compilation time. So even splitting "HI MOM" into two pieces isn't
    // enough!
    System.out.println(a == c);
    
    // Finally we get Java to store things in different locations by
    // introducing a variable. The Java compiler isn't smart enough to
    // determine the values of (most) variables at compile time, so it doesn't
    // know that it can just set d equal to the HI MOM String we already have.
    // This is the usual behavior you get when you try to compare Strings with
    // ==, it just took a little extra effort to trick Java into showing it to
    // us without using a Scanner etc..
    System.out.println(a == d);
  }
}