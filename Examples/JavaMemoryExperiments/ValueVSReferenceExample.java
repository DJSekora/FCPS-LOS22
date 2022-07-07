/* This example demonstrates one important difference between primitive types
   and objects.
   
   Primitive types store the value directly with the variable. Setting an
   int variable 'var1' equal to another 'var2' changes the value stored
   in 'var1' to be the same as the value stored in 'var2'. But, the variables
   aren't linked together - if you later change 'var2', 'var1' will not
   change with it.
   
   Arrays (and also objects) work differently. A variable referring to an
   array or object actually only contains a reference to the location of the
   object in memory. Setting these variables equal to each other means they
   will be pointing at the same memory address, which means they will be
   pointing at the same object. Modifying this object means the changes will
   be reflected for BOTH variables, because there is only one copy of the
   actual object. (If you later set one of the variables equal to a different
   object, then the variables will be separate again because they will be
   pointing at different locations.)
 */
public class ValueVSReferenceExample
{
  public static void main(String[] args)
  {
    int x, y;
    
    x = 5;
    y = x; // y and x have the same value here, but aren't linked
    x = 7; // y will still be 5
    
    System.out.println("x: " + x); // Prints 7
    System.out.println("y: " + y); // Prints 5
    
    
    // This demonstrates that arrays work differently
    int[] array1;
    int[] array2;
    
    array1 = new int[]{1,2,3};
    array2 = array1; // array1 and array2 both point to the same array in memory
    
    // remember that there is only one copy of the data being stored, so this
    // also changes what the array2 variable sees
    array1[2] = 47;
    
    System.out.println(array2[2]); // prints 47
    
    // After this line, array1 will be pointing to a different memory
    // address. array2 will still be {1,2,47}
    array1 = new int[]{6, 7, 8};
    
    System.out.println(array2[2]); // still prints 47
    
    // If we do this now, both variables will be pointing at the {6,7,8}
    // array, and the {1,2,47} array will be picked up by garbage collection
    // and eventually deleted.
    array2 = array1;
  }
}