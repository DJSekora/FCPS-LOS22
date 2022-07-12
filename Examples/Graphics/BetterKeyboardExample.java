/* This class contains some small improvements over the KeyboardExample class.
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class BetterKeyboardExample extends JPanel implements KeyListener
{
  int sx = 200;
  int sy = 200;
  int sw = 50;
  int sh = 50;
  
  // The speed will now change depending on input, and be applied in a main loop
  int xSpeed = 0;
  int ySpeed = 0;
  
  // How many pixels to move per second max
  int maxSpeed = 5;

  public BetterKeyboardExample()
  {
    addKeyListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.fillRect(sx, sy, sw, sh);
  }
  
  // Combine the timer idea and the keyboard input idea
  public void mainLoop()
  {
    while(true)
    {
      try
      {
        Thread.sleep(20);
      }
      catch(Exception e){e.printStackTrace();}
      
      sx+=xSpeed;
      sy+=ySpeed;
      
      repaint();
    }
  }
  
  /* Required methods for KeyListener */
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT)
    {
      xSpeed = maxSpeed;
    }
    else if(code == KeyEvent.VK_LEFT)
    {
      xSpeed = -maxSpeed;
    }
    else if(code == KeyEvent.VK_UP)
    {
      
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      
    }
  }
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT)
    {
      xSpeed = 0;
    }
    else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN)
    {
      
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }
}