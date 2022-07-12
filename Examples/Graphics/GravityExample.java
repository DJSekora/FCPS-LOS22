/* We can interpret our screen as a side-view rather than a top-down view of
   a scene. 
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class GravityExample extends JPanel implements KeyListener
{
  int sx = 200;
  int sy = 200;
  int sw = 50;
  int sh = 50;

  int xSpeed = 0;
  int ySpeed = 0;

  int maxSpeed = 10;
  
  int acceleration = 1;
  int jumpSpeed = 20;
  
  int gravity = 1;
  int floor = 500;

  boolean leftPressed = false;
  boolean rightPressed = false;

  public GravityExample()
  {
    addKeyListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.fillRect(sx, sy, sw, sh);
  }
  
  public void mainLoop()
  {
    while(true)
    {
      try
      {
        Thread.sleep(20);
      }
      catch(Exception e){e.printStackTrace();}

      if(rightPressed)
      {
        xSpeed = Math.min(maxSpeed, xSpeed+acceleration);
      }
      if(leftPressed)
      {
        xSpeed = Math.max(-maxSpeed, xSpeed-acceleration);
      }
      
      ySpeed += gravity;
      
      /* Finally, we apply the xSpeed and ySpeed we calculated to the position
         variables, which will update the position of the square on the screen.
       */
      sx += xSpeed;
      sy += ySpeed;
      
      if(sy + sh >= floor)
      {
        sy = floor - sh;
        ySpeed = 0;
      }
      
      repaint();
    }
  }
  
  /* Required methods for KeyListener.
     (These are unchanged from EvenBetterKeyboardExample, which is part of why
      we set it up in this way!)
   */
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT)
    {
      rightPressed = true;
    }
    else if(code == KeyEvent.VK_LEFT)
    {
      leftPressed = true;
    }
  }
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT)
    {
      rightPressed = false;
    }
    else if(code == KeyEvent.VK_LEFT)
    {
      leftPressed = false;
    }
    else if(code == KeyEvent.VK_UP)
    {
      ySpeed -= jumpSpeed;
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }
}