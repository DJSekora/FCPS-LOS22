/* An example of reading one file and writing another at the same time. */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReadAndWrite
{
  public static void main(String[] args)
  {
    // This scanner reads user input to accept the filename
    Scanner user = new Scanner(System.in);
    
    Scanner input = null;
    PrintWriter output = null;
    
    boolean needFile = true;
    
    while(needFile)
    {
      needFile = false;
      System.out.println("Enter filename to read: ");
      String inFilename = user.nextLine();
      
      try
      {
        input = new Scanner(new File(inFilename));
      }
      catch(Exception e)
      {
        // If an error occurred, we need to return to the start of the loop
        needFile = true;
        System.out.println("Error, please try again!");
        e.printStackTrace();
      }
    }
    
    needFile = true;
    
    while(needFile)
    {
      needFile = false;
      System.out.println("Enter filename to write: ");
      String outFilename = user.nextLine();
      
      try
      {
        output = new PrintWriter(new File(outFilename));
      }
      catch(Exception e)
      {
        // If an error occurred, we need to return to the start of the loop
        needFile = true;
        System.out.println("Error, please try again!");
        e.printStackTrace();
      }
    }
    
    String line;
    while(input.hasNextLine())
    {
      line = input.nextLine();
      
      // Do any processing you want on the line here!
      // If you do nothing, then this is just a copy operation.
      
      output.println(line); 
    }
    
    input.close();
    output.close();
  }
}