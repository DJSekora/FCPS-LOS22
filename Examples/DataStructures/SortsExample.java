/* This class includes examples of several sorting algorithms. */
public class SortsExample
{
  
  public static void bubbleSort(int[] list)
  {
    // keeps track of if we need to continue sorting
    boolean sorted = false;
    int cap = list.length;
    while(!sorted)
    {
      sorted = true;
      for(int i=1; i<cap; i++)
      {
        // if entries are out of order, swap them
        if(list[i-1] > list[i])
        {
          int temp = list[i]; // make sure we don't lose data
          list[i] = list[i-1];
          list[i-1] = temp;
          sorted = false;
        }
      }
      cap--;
    }
  }
  
  /* Find the first element of the list and put it into the
     correct location. Repeat until list is sorted.
   */
  public static void selectionSort(int[] list)
  {
    // outer for loop iterates through indices
    // When i is k, that means we are finding the correct element
    // to put in slot k
    for(int i = 0; i<list.length; i++)
    {
      int smallestIndex = i;
      // Find the LOCATION OF the smallest thing in the unsorted area of the list
      for(int j = i + 1; j < list.length; j++)
      {
        // if we found a smaller thing, update smallestIndex
        if(list[j] < list[smallestIndex])
        {
          smallestIndex = j;
        }
      }
      
      // Now swap that smallest item into the correct location
      int temp = list[i];
      list[i] = list[smallestIndex];
      list[smallestIndex] = temp;
    }
  }
  
  
  public static void insertionSort(int[] list)
  {
    int current;
    // i tells us the index of the element we are currently trying to insert
    for(int i = 0; i<list.length; i++)
    {
      // j is looking at everything in the sorted portion to figure out where
      // our highlighted element should go
      int j;
      for(j = 0; j<i; j++)
      {
        if(list[i] < list[j])
        {
          break; // at this point, j tells us where the item at slot i should go
        }
      }
      
      int temp = list[i];
      // Now insert the new item in the correct location
      for(int k = i; k > j; k--)
      {
        list[k] = list[k-1];
      }
      list[j] = temp;
    }
  }
  
  public static void bogoSort(int[] list)
  {
  }
  
  public static void mergeSort(int[] list)
  {
    
  }
}