public class MyArrayList
{
  // Store the actual data
  private String[] array;
  
  // How many of the slots are currently filled
  private int length;
  
  // Constructor
  // tells us how to initialize the data structure
  public MyArrayList()
  {
    // default to 10 slots to start
    array = new String[10];
    
    length = 0;
  }
  
  public String get(int index)
  {
    return array[index];
  }
  
  public void add(String toAdd)
  {
    // If we are out of space, double the capacity
    if(length >= array.length)
    {
      String[] temp = new String[2*array.length];
      // Copy over all of the old stuff
      for(int i=0; i<array.length; i++)
      {
        temp[i] = array[i];
      }
      // Update array to point to our new improved one
      array = temp;
    }
  
    // Add the new item to the end
    array[length] = toAdd;
    
    // Update where the end is
    length++;
  }
  
  /* Put the String toAdd in the slot index of the array */
  public void set(int index, String toAdd)
  {
    
  }
  
  /* Return the number of elements stored in the array
     not counting the blank slots
   */
  public int size()
  {
    return 0; // FIX THIS!
  }
  
  /* Delete the item at the specified index.
     All entries after that index will be shifted by 1,
     and the length will be decreased by 1.
   */
  public void remove(int index)
  {
    
  }
}