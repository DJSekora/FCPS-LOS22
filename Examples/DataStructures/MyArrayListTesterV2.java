/* The beginning of a more sophisticated testing framework for MyArrayList.
   A core idea here is that we want to test rigorously, but only want to print
   what we need to.
   
   Consider what happens when you compile a program. If there were no errors,
   the compiler says nothing. We are abiding by the same principle for the
   most part - if the code has the expected behavior, we don't need to print
   anything in our tests. This way, we can quickly tell if anything is wrong
   and what that thing is.
   
   You also want to try to test each piece of your code individually, if
   possible. There are some core pieces of most programs that are required
   to make any functionality possible (in our example, it's difficult to test
   get in a way that doesn't use add), but once you have those core pieces
   try to find ways to test that will let you quickly figure out where the
   error lies (this usually involves isolating individual components of your
   code as much as possible).
   
   This file contains examples of how to test out the add and get methods.
   I encourage you to try writing tests for some of the other methods on your
   own!
 */
public class MyArrayListTesterV2
{
  public static void main(String[] args)
  {
    testAdd();
    testGet();
  }
  
  public static void testAdd()
  {
    MyArrayList test = new MyArrayList();
    
    // Adding 100 Strings makes sure the resizing functions correctly.
    for(int i=0; i<100; i++)
    {
      test.add("Thing " + i);
    }
    
    if(test.size() != 100)
    {
      System.out.println("Size 100 expected. Actual size: " + test.size());
    }
  }
  
  public static void testGet()
  {
    MyArrayList test = new MyArrayList();
    String[] testStrings = new String[]{"AAAA","BBBB","CCCC"};
    
    for(int i=0; i<testStrings.length; i++)
    {
      test.add(testStrings[i]);
    }
    
    for(int i=0; i<testStrings.length; i++)
    {
      //System.out.println("Element " + i + ": " + test.get(i));
      if(!test.get(i).equals(testStrings[i]))
      {
        System.out.println("At position " + i + ", expected " + testStrings[i] + ", was " + test.get(i));
      }
    }
    
    // Negative numbers will throw an ArrayIndexOutOfBoundsException.
    // Don't need to do anything special for negatives because we WANT the error
    // (technically, we should use try-catch, to make SURE that the error is thrown)
    // But this is a DEVELOPMENT CHOICE not a REQUIREMENT
    // (we could make negative array indices have some other functionality if we wanted)
    //test.get(-1);
    
    System.out.println(test.get(4));
  }
}