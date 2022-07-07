/* A simple program with a main method, demonstrating how to use some basic
   features of the MyArrayList class.
 */
public class MyArrayListTester
{
  public static void main(String[] args)
  {
    MyArrayList test = new MyArrayList();
    
    test.add("Computer");
    test.add("Science");
    test.add("is");
    test.add("fun!");
    
    System.out.println(test.size()); // Should print 4
    test.set(1, "Engineering"); // should change Science to Engineering
    test.remove(2); // Should make the array hold {"Computer", "Engineering", "fun!"}
    System.out.println(test.size()); // Should print 3
    
    for(int i=1; i<=100; i++)
    {
      test.add("Thing " + i);
    }
  }
}