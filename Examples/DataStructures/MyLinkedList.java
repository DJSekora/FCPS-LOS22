/* This class contains a simple implementation of a (singly) linked list.
   A linked list consists of a series of nodes linked together connected
   by references. Each node contains two things: a single piece of information,
   plus a pointer to the location of the next node after it in the list.
   
   This structure is similar to an ArrayList in that the data is stored in a
   linear fashion (one element after another in a sequence), but the way we
   store and access the data is completely different! This results in
   tradeoffs of space and time efficiency.
 */
public class MyLinkedList
{
  /* It's WEIRD time! We can put class definitions inside other classes!
     And classes can be private!
     It's actually a surprisingly intuitive system for the most part - this
     class is treated the same as methods and variables that are in the same
     scope. 'private' means that the Node class can only be interacted with
     from within this class.
     (You can even do 'public static class', but the distinction between
      static and non-static classes isn't particularly important for this
      application so I'll let you read about that on your own if you're
      interested.)
   */
  private class Node
  {
    // These are the fields that belong to EACH node
    Node next;
    String data;
    
    private Node(String nData)
    {
      data = nData;
      next = null;
    }
    
    // You can have multiple constructors for convenience as long as the
    // arguments are different
    private Node(String nData, Node nextNode)
    {
      data = nData;
      next = nextNode;
    }
  } // End of Node class
  
  // These are the fields of the linked list itself. There is ONE copy of each
  // of these for the whole list.
  private int length; // number of nodes in the list
  private Node head;  // the first node in the list
  
  /* Constructor to create a new empty list */
  public MyLinkedList()
  {
    head = null;
    length = 0;
  }
  
  /* Return the number of elements in the list. Works the same as for an
     ArrayList.
   */
  public int size()
  {
    return length;
  }
  
  /* Creates a new node, sets the next reference of the new node to point at
     the old head, then places the new node as the new head.
     Also increases the length by 1.
   */
  public void addToFront(String data)
  {
    Node node = new Node(data, head);
    head = node;
    
    // This would also do the same thing as the above 2 lines
    // head = new Node(data, head);
    
    length++;
  }
  
  /* Adding to the end is more complicated, since we don't know where the end
     is. So, we have to start at the head and keep going until we find a node
     whose next reference is null.
     Also increases the length by 1.
   */
  public void addToEnd(String data)
  {
    // If the list is empty, this should have the same behavior as addToFront.
    // We could write it out the long way, but this is easier
    if(size() == 0)
    {
      addToFront(data);
    }
    else
    {
      Node current = head;
      
      // When we find null, we found the tail
      // (we could also use a for loop up to the length)
      while(current.next != null)
      {
        current = current.next;
      }
      Node newNode = new Node(data);
      current.next = newNode;
      length++;
    }
  }
  
  /* Retrieves the element at position index in the list.
     Because linked lists have a different structure than array lists, we now
     need a more complicated procedure to access individual elements.
     Throws an exception when index is negative
   */
  public String get(int index)
  {
    if(index < 0)
    {
      throw new UnsupportedOperationException("Negative index: " + index);
    }
  
    // Optional: check if index is too big and throw an error
    // (a NullPointerException will be thrown anyway so not a big deal)
  
    Node current = head;
    
    for(int i=0; i<index; i++)
    {
      current = current.next;
    }
  
    return current.data;
  }
  
  /* Getting the head is very easy! Can be done in one line. */
  public String getHead()
  {
    return head.data;
  }
  
  /* Getting the tail can be hard or easy, depending on design decisions made. */
  public String getTail()
  {
    return null; // PLACEHOLDER FIX THIS
  }
  
  /* Removes the first item in the list.
     This is also very easy, just like adding to the head!
   */
  public void removeHead()
  {
    // Overwrite the head reference. Now, the node that used to be the head
    // has no references to it, so it can be claimed by garbage collection.
    head = head.next;
    length--; // maintain the length so our size() method works correctly
  }
  
  /* Removes the last item in the list.
     IMPLEMENT THIS!
   */
  public void removeTail()
  {
  }
  
  /* Removes the item at the specified index.
     IMPLEMENT THIS!
   */
  public void remove(int index)
  {
  }
}