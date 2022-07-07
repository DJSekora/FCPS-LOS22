/* This class quickly demonstrates that objects work like arrays with
   respect to setting one variable to another.
   
   For use with the Person class (a Person as we defined it in this course
   is a simple object with two fields, a name and an age).
 */
public class ObjectReferenceExample
{
  public static void main(String[] args)
  {
    Person a = new Person("John", 10);
    Person b = a; // b and a are now pointing at the same object in memory
    
    // This also changes the age for b because there is only one Person object
    a.age = 15; 
    
    System.out.println(b.age); // prints 15
  }
}