public class EqualsExample
{
  public static void main(String[] args)
  {
    int[] a = new int[]{1,2,3};
    int[] b = new int[]{1,2,3};
    int[] c = a;
    
    System.out.println(a == b);
    System.out.println(a == c);
    
    // Using a method is a great way to save copy-pasting work
    System.out.println(arraysEqual(a, b));
  }
  
  public static boolean arraysEqual(int[] a, int[] b)
  {
    // One way to check if two arrays have the same values
    // Assume yes and search for any counterexamples
    boolean same = true; // 'flag'
    for(int i=0; i<a.length; i++)
    {
      if(a[i] != b[i])
      {
        same = false;
        break; // once we find a counterexample, we're done
      }
    }
    return same;
    
    
    /* alternate approach same results
    for(int i=0; i<a.length; i++)
    {
      if(a[i] != b[i])
      {
        return false;
      }
    }
    return true;
    
    */
  }
}