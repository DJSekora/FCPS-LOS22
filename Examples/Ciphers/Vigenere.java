/* This program contains methods to encrypt and decrypt messages using the
   Vigenere cipher. The methods are public and static, so they can be called
   from other files with Vigenere.encryptVigenere(String, String) and
   Vigenere.decryptVigenere(String, String).
   
   Our implementation will only operate on capital English letters for
   simplicity, although the core principles can easily be extended to work
   with any character set.
   
   This cipher is similar to a rotation cipher, but instead of rotating each
   letter by the same amount, the rotation changes from letter to letter.
   There are several types of ciphers that use this main idea, with the
   difference being the method by which the rotation amount is varied.
   In the case of the Vigenere cipher, a String known as the 'key' is used
   to provide this variation.
   
   The key is repeated to match the length of the original message. Every
   letter is assigned a unique value (0-25), and then each character in the
   original message is added to character at that position in the repeated key.
   If the result is greater than the value for 'Z' (25), then 26 is subtracted
   to get the result back into the correct range. Here is an example:
   
   
   EXAMPLE
   Message: I LOVE COMPUTER SCIENCE
   Key: CAT
   Letter Values (equal to ASCII encoding minus the value for 'A' (65)):
   A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
   
   
   Step 1 (repeat the key and line it up with the message):
   I LOVE COMPUTER SCIENCE
   C AWCA WCAWCAWC AWCAWCA
   
   
   Step 2 (convert to numerical values):
    I    L  O  V  E     C  O  M  P  U  T  E  R     S  C  I  E  N  C  E
    8   11 14 21  4     2 14 12 15 20 19  4 17    18  2  8  4 13  2  4
   
    C  A  W
    2  0 22
   
   
   Step 3 (add):
    8   11 14 21  4     2 14 12 15 20 19  4 17    18  2  8  4 13  2  4
  + 2    0 22  2  0    22  2  0 22  2  0 22  2     0 22  2  0 22  2  0
   ------------------------------------------------------------------
   10   11 36 23  4    24 16 12 37 22 19 26 19    18 24 10  4 35  4  4
   
   
   Step 4 (subtract 26 from any values that are 26 or higher):
   10   11 36 23  4    24 16 12 37 22 19 26 19    18 24 10  4 35  4  4
                                turns into
   10   11 10 23  4    24 16 12 11 22 19  0 19    18 24 10  4  9  4  4
   
   
   Step 5 (convert back into letters):
   
   10   11 10 23  4    24 16 12 11 22 19  0 19    18 24 10  4  9  4  4
    K    L  K  X  E     Y  Q  M  L  W  T  A  T     S  Y  K  E  J  E  E
    
   Final encrypted message: K LKXE YQMLWTAT SYKEJEE
   
   
   Historical note from Wikipedia:
   The Vigenere cipher is named after Blaise de Vigenere, although it was
   actually developed first by Giovan Battista Bellaso.
   The French name for the cipher is "le chiffrage indechiffrable", which
   translates to "the indecipherable cipher".
   (Vigenere himself created the autokey cipher, a similar cipher that uses
    the message itself as the key.)
    
   The cipher is not actually indecipherable, but it is stronger than a
   rotation or substitution cipher (unless the key is discovered, in which
   case the cipher is easily cracked)
   
 */
public class Vigenere
{ 
  /* This method encrypts a message using the Vigenere cipher with the provided
     key.
     
     Example method call: encryptVigenere("I LOVE COMPUTER SCIENCE", "CAW")
     should return the String "K LKXE YQMLWTAT SYKEJEE".
   */
  public static String encryptVigenere(String message, String key)
  {
    // This variable will store our position within the key.
    int keyIndex = 0;
    
    // This variable will hold our encrypted message. It starts empty, and we
    // will add one character at a time as we create our message.
    // (If we wanted to be more efficient, we could use a StringBuffer instead,
    //  but we haven't discussed that in class yet.)
    String encrypted = "";
    
    // This variable will hold the current character being encrypted
    char c;
    
    // This for loop iterates through every position in the String from 0 on
    for(int messageIndex = 0; messageIndex < message.length(); messageIndex++)
    {
      // Read the character at the current position in the String
      c = message.charAt(messageIndex);
      
      // For now, we are only working with capital letters, although we could
      // use the same ideas to encrypt any text.
      // Note that we can use < and > with characters, since they are really numbers.
      if(c >= 'A' && c <= 'Z')
      {
        // The letters A-Z are at consecutive locations in the ASCII table, so
        // subtracting 'A' from a letter will give a number between 0 and 25.
        // For example, 'J' = 74, so 'J' - 'A' = 74 - 65 = 9.
        // Also remember that [x += y] is the same thing as [x = x + y]
        c += (key.charAt(keyIndex) - 'A');
        
        // If the result is too large, subtract 26 to get it back into the
        // range of capital letters
        if(c > 'Z')
        {
          c = (char)(c - 26);
        }
        
        // Add our new character to the return String
        encrypted += c;
        
        // Advance to the next position in the key
        keyIndex++;
        
        // If the keyIndex is now too big, wrap back around to position 0
        if(keyIndex >= key.length())
        {
          keyIndex = 0;
        }
      }
      // If we get anything other than a capital letter, just copy the
      // character directly into the final String.
      else
      {
        encrypted += c;
      }
    }
    
    // Return the encrypted String at the end
    return encrypted;
  }
  
  
  
  /* This method decrypts a message that has previously been encrypted by the
     above encryptVigenere method.
     
     Notice how similar it looks - the code is copy-pasted with the comments
     removed, with new comments added in the two changed sections.
     
     Instead of copy-pasting, we could have added a boolean parameter to the
     original method, which might be 'true' if decrypting and 'false' if
     encrypting, and then put an 'if' statement at the appropriate location.
     
     Example method call: decryptVigenere("K LKXE YQMLWTAT SYKEJEE", "CAW")
     should return the String "I LOVE COMPUTER SCIENCE".
   */
  public static String decryptVigenere(String message, String key)
  {
    int keyIndex = 0;
    
    // We have changed the name of this String to 'decrypted'
    String decrypted = "";

    char c;

    for(int messageIndex = 0; messageIndex < message.length(); messageIndex++)
    {
      c = message.charAt(messageIndex);

      if(c >= 'A' && c <= 'Z')
      {
        // Subtraction instead of addition
        c -= (key.charAt(keyIndex) - 'A');
        
        // This part also needed to change, since now we might be too small
        // instead of too large
        if(c < 'A')
        {
          c = (char)(c + 26);
        }

        decrypted += c;

        keyIndex++;

        if(keyIndex >= key.length())
        {
          keyIndex = 0;
        }
      }
      else
      {
        decrypted += c;
      }
    }
    
    return decrypted;
  }
  
  public static void main(String[] args)
  {
    // Example of calling the functions
    String original = "I LOVE COMPUTER SCIENCE";
    String key = "CAW";
    String enc = encryptVigenere(original, key);
    String dec = decryptVigenere(enc, key);
    
    System.out.println("Original:  " + original);
    System.out.println("Key:       " + key);
    System.out.println("Encrypted: " + enc);
    System.out.println("Decrypted: " + dec);
  }
}