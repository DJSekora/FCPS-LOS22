/* This class contains an example of how to attach keyboard input to a
   window.
   
   We will need a new keyword: implements. The details of it aren't super
   important for our purposes, but for those interested I have included a
   comment at the end of this file with some explanation.
   
   Documentation for the different key codes can be found in the Oracle docs
   page for KeyEvent.
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class KeyboardExample extends JPanel implements KeyListener
{
  // These four variables describe the properties of our rectangle.
  int sx = 200;
  int sy = 200;
  int sw = 50;
  int sh = 50;
  
  // How many pixels to move per key press registered
  int speed = 5;

  public KeyboardExample()
  {
    // Activates keyboard input (links the KeyListener to the JPanel, see the
    // comment at the end of this file for more in-depth information)
    addKeyListener(this);
    
    // Allows the JPanel to be the 'focus' (the window to which keyboard and
    // mouse events are routed by the operating system)
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.fillRect(sx, sy, sw, sh);
  }
  
  /* Required methods for KeyListener */
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT)
    {
      sx += speed;
    }
    else if(code == KeyEvent.VK_LEFT)
    {
      sx -= speed;
    }
    else if(code == KeyEvent.VK_UP)
    {
      
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      
    }
    repaint();
  }
  public void keyReleased(KeyEvent e)
  {
  }
  public void keyTyped(KeyEvent e)
  {
  }
}
/* Explanation of the implements keyword:
     If A implements B, then A must contain all of the methods specified in B.
       (Here, A is a class, and B is a list of method prototypes called an
        'interface'. A 'method prototype' is the first line of the method
        defining its name, inputs, and outputs, among other things. Example:
          public static void main(String[] args) is the prototype for main.
     
     In exchange, we get to use A as if it were of type B. A class can only
     extend one class, but it can implement any number of interfaces. This is
     useful because it allows us to fit an object with custom behavior into an
     existing framework of method calls.
     
     In this particular case, a KeyListener is an object that looks for and
     responds to key actions (key presses, releases, and types). We could
     create a separate object to serve this purpose, but here we've actually
     done a bit of a 'hacky' solution to use the KeyboardExample class as its
     own KeyListener. This is why we get the following weird line:
     
       addKeyListener(this);
     
     This line calls the addKeyListener method from the JPanel class, which
     takes in a KeyListener object and routes keyboard input to that object
     whenever a key action occurs while this JPanel is active. The word
     'this' refers to the current object, since we are using it as its own
     KeyListener.
 */