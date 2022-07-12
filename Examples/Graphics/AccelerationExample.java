/* This class makes some small modifications to EvenBetterKeyboardExample to
   add acceleration. Now, the controls don't increase or decrease the position
   of the square directly - instead, they increase or decrease the velocity of
   the square in that direction, and then the velocity at each frame is used
   to calculate the position.
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class AccelerationExample extends JPanel implements KeyListener
{
  int sx = 200;
  int sy = 200;
  int sw = 50;
  int sh = 50;

  int xSpeed = 0;
  int ySpeed = 0;
  
  /* Our maxSpeed makes a comeback, this time as a limiter on how large the
     speed can get in each direction.
     (If we wanted to be even more realistic, we could limit the TOTAL speed
      instead of the speed in each direction, but that would require some
      trigonometry and more code so we'll leave that for now.)
   */
  int maxSpeed = 10;
  
  // This variable controls the rate of change of the speed at each frame.
  // If we want more fine-grained control, we can either use doubles or use
  // speeds at a magnified scale (e.g. multiply maxSpeed by 10, then divide by
  // 10 whenever you use a speed to modify a velocity)
  int acceleration = 1;
  
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  public AccelerationExample()
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
      
      /* We use the acceleration to increase or decrease the speed depending on
         which button is pressed. The Math.min and Math.max calls are for
         limiting the speed to be no greater than maxSpeed.
       */
      if(rightPressed)
      {
        xSpeed = Math.min(maxSpeed, xSpeed+acceleration);
        //The above line is equivalent to:
        /* xSpeed += acceleration;
        if(xSpeed > maxSpeed)
        {
          xSpeed = maxSpeed;
        } */
      }
      if(leftPressed)
      {
        xSpeed = Math.max(-maxSpeed, xSpeed-acceleration);
      }
      if(upPressed)
      {
        ySpeed = Math.max(-maxSpeed, ySpeed-acceleration);
      }
      if(downPressed)
      {
        ySpeed = Math.min(maxSpeed, ySpeed+acceleration);
      }
      
      /* Finally, we apply the xSpeed and ySpeed we calculated to the position
         variables, which will update the position of the square on the screen.
       */
      sx += xSpeed;
      sy += ySpeed;
      
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
    else if(code == KeyEvent.VK_UP)
    {
      upPressed = true;
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      downPressed = true;
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
      upPressed = false;
    }
    else if(code == KeyEvent.VK_DOWN)
    {
      downPressed = false;
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }
}