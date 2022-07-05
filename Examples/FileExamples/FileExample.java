/* This file contains an example of how to read data from a text file using
   a Scanner.
   
   (There are other ways to read data that are better suited for large files
    (such as a BufferedReader), but we'll use Scanner here because it's
    familiar from all of our user input stuff!)
 */
import java.io.File;
import java.util.Scanner;
public class FileExample
{
  public static void main(String[] args)
  {
    /* try-catch is the paradigm for error handling in Java. We use it whenever
       the operations we are trying to execute might produce an error. Here,
       we need to do this because file handling is prone to a variety of
       errors: the file might not exist, you might not have entered the
       correct name or path, the file might be deleted or modified by another
       program while it is being loaded, you might not have permission to
       access the file, etc..
     */
    try
    {
      // A file object holds information about the name of the file and where
      // it is located. In this case, we'll keep it simple and make sure all
      // of our files are in the same directory
      File theFile = new File("hello.txt");
      
      // Previously, we have only seen Scanners with System.in. Now, we can
      // use a Scanner with a file, and we get access to all the same methods!
      Scanner scan = new Scanner(theFile);
      
      // Example of reading and printing the first line from the file
      String firstLine = scan.nextLine();
      System.out.println(firstLine);
      
      // Make sure you close the file at the end
      scan.close();
    }
    /* If an error is encountered anywhere in the above try block, we come
       down here to the catch block.. In this case, we want to do the same
       thing for any type of error, so we just use the superclass Exception.
       If we wanted to respond differently to different types of errors (e.g.
       the file doesn't exist vs you don't have permission to access the file),
       then we could have the different types each in their own catch block.*/
    catch(Exception e)
    {
      // All we will do here is print out an error message.
      // We could do something simple like this:
      //System.out.println("ERROR");
      
      // But, Java has a built-in way to print errors, which is usually
      // pretty informative:
      e.printStackTrace();
    }
  }
}