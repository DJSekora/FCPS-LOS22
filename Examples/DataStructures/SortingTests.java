public class SortingTests
{
  public static void main(String[] args)
  {
    int n = 100000;
    int[] sorted = new int[n];
    int[] reversed = new int[n];
    for(int i=0; i<n; i++)
    {
      sorted[i] = i;      //   0  1  2  3  4 ... n-1
      reversed[i] = n-i;  // 100 99 98 97 96 ... 1
    }
    
    long start = System.currentTimeMillis();
    SortsExample.bubbleSort(sorted);
    long elapsed = System.currentTimeMillis() - start;
    System.out.println("Bubble sort on sorted list: " + elapsed);
    
    start = System.currentTimeMillis();
    SortsExample.selectionSort(sorted);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Selection sort on sorted list: " + elapsed);
    
    start = System.currentTimeMillis();
    SortsExample.insertionSort(sorted);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Insertion sort on sorted list: " + elapsed);
    
    int[] reversedCopy = copyIntArray(reversed);
    start = System.currentTimeMillis();
    SortsExample.bubbleSort(reversedCopy);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Bubble sort on reversed list: " + elapsed);
    
    reversedCopy = copyIntArray(reversed);
    start = System.currentTimeMillis();
    SortsExample.selectionSort(reversedCopy);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Selection sort on reversed list: " + elapsed);
    
    reversedCopy = copyIntArray(reversed);
    start = System.currentTimeMillis();
    SortsExample.insertionSort(reversedCopy);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Insertion sort on reversed list: " + elapsed);
    
    /*printIntArray(sorted);
    printIntArray(reversed);*/
    
    //System.out.println(isSorted(sorted));
    //System.out.println(isSorted(reversed));
  }
  
  public static void printIntArray(int[] array)
  {
    for(int i=0; i<array.length; i++)
    {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  
  // Returns a copy of the input array
  public static int[] copyIntArray(int[] array)
  {
    int[] copy = new int[array.length];
    for(int i=0; i<array.length; i++)
    {
      copy[i] = array[i];
    }
    return copy;
  }
  
  // Return false if the array is not sorted, true if it is sorted
  public static boolean isSorted(int[] array)
  {
    for(int i=1; i < array.length; i++)
    {
      if(array[i-1] > array[i])
      {
        return false;
      }
    }
    return true;
  }
}