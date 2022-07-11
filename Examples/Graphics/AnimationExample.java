/* Basic example of how to do animation.

   Make sure to call panel.mainLoop() in your main method!
 */
import javax.swing.JPanel;
import java.awt.Graphics;

public class AnimationExample extends JPanel
{
  private int x;
  private int speed;

  public AnimationExample()
  {
    x = 50;
    speed = 5;
  }
  
  public void mainLoop()
  {
    // Not great style to say while(true), but we'll talk about alternatives
    // later. For now, this is our main way to have a persistent program.
    while(true)
    {
      try
      {
        Thread.sleep(50);
      }catch(Exception e){e.printStackTrace();}
      
      x+=speed;
      repaint();
    }
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    g.drawRect(x, 100,50,50);
  }
}