/* This class contains an example of how to set up a basic graphical window
   on which images can be drawn.
   
   Main method can be found in GraphicsMainExample.java
   
   Analogy:
    JFrame:   the easel
    JPanel:   the canvas
    Graphics: the paintbrush
    Color:    the paint
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class BGPExample extends JPanel
{
  // Constructor does nothing for now, we can add in functionality later.
  public BGPExample()
  {
  }
  
  /* This method is where you put everything to be drawn to the screen. */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    g.setColor(Color.RED);
    g.drawRect(50,50,100,100);
  }
}