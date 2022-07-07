/* Quick program demonstrating basic MyLinkedList functionality */
public class MyLinkedListTester
{
  public static void main(String[] args)
  {
    MyLinkedList test = new MyLinkedList();
    
    System.out.println(test.size() == 0);
    test.addToFront("Strawberry");
    test.addToFront("Watermelon");
    test.addToEnd("Mango");
    // Expect: Watermelon, Strawberry, Mango
    
    System.out.println(test.getHead());
    System.out.println(test.get(1));
    System.out.println(test.get(2));
    System.out.println(test.size());
  }
}