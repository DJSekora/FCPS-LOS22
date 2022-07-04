public class SubstitutionCipher
{
  /* This method encrypts a String 'message' with the substitution cipher
     specified by the two input character arrays. The first array contains
     the characters to be replaced, and the second array contains the
     replacements in order.
   */
  public static String encryptSubstitution(String message, char[] original, char[] encrypted)
  {
    // The method doesn't work if the input arrays aren't the same size. So,
    // in this case we don't encrypt the message at all.
    if(original.length != encrypted.length)
    {
      System.out.println("ERROR: ARRAY LENGTH MISMATCH");
      return message;
    }
    
    // A StringBuffer is a more efficient way to build up a String character
    // by character
    StringBuffer ret= new StringBuffer();
    
    char cur; // The current character being encoded
    int kI; // A variable we use to iterate through the key arrays
    
    for(int i=0; i<message.length(); i++)
    {
      cur = message.charAt(i);
      for(kI = 0; kI < original.length; kI++)
      {
        if(original[kI] == cur)
        {
          break; // end loop early so kI has the correct value
        }
      }
      // If this is one of the characters we want to encode, do it.
      if(kI < original.length)
      {
        // ret = ret + encrypted[kI]
        ret.append(encrypted[kI]);
      }
      // Else, copy the character directly
      else
      {
        ret.append(cur);
      }
    }
    return ret.toString();
  }
  
  /* To decrypt, we just do the same thing as encryption, except we swap the
     original and encrypted arrays. We could copy-paste all the code, but
     that'd be a waste when we can just call the method directly! */
  public static String decryptSubstitution(String message, char[] original, char[] encrypted)
  {
    return encryptSubstitution(message, encrypted, original);
  }
  
  public static void main(String[] args)
  {
    // Example usage of encrypt and decrypt
    String message = "HELLO, WORLD!";
    
    char[] orig = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] enc  = new char[]{'M','H','T','O','U','A','F','P','R','N','I','G','K','Q','X','D','B','W','V','Y','L','S','J','C','E','Z'};
    String encrypted = encryptSubstitution(message, orig, enc);
    
    System.out.println(encrypted);
    System.out.println(decryptSubstitution(encrypted, orig, enc));
  }
  
  /* There are several ways we could make this more efficient:
  
     1. If we are only working with capital letters all the time, we could fix
        the positions of A-Z in slots 0-25 and do away with both the need for
        the 'original' array and for searching through the whole list to find
        the current character. Instead, we could use math and ASCII character
        codes to streamline the process
        
     2. We could use a data structure that's faster than an array to search
        for the target character, such as a hash table (but we haven't learned
        about those yet!)
   */
}