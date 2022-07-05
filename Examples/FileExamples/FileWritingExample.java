/* This program demonstrates how to write text to a file using a PrintWriter,
   which has print and println methods (which work the same as the System.out
   versions).
   
   Try running this program twice and observing what happens. Does the program
   add new text to the end of the existing file, or does it overwrite the file?
 */
import java.io.PrintWriter;
import java.io.File;

public class FileWritingExample
{
  public static void main(String[] args)
  {
    /* Again, we use try-catch because working with files is dangerous! */
    try
    {
      // Open the file for writing, set up our PrintWriter
      PrintWriter writer = new PrintWriter(new File("test.txt"));
      
      // Example call to println to write a line of text to the file
      writer.println("THIS IS A TEST");
      
      // Make sure to close the file when done to save your work!
      writer.close();
    }
    catch(Exception e)
    {
      // Print out the error if one occurs
      e.printStackTrace();
    }
  }
}