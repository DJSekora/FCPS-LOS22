/* 
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseGridExample extends JPanel implements MouseListener
{
  int rows = 5;
  int cols = 6;
  int boxSize = 50;
  
  // for convenience
  int height = rows*boxSize;
  int width = cols*boxSize;
  
  int x = -1;
  int y = -1;

  public MouseGridExample()
  {
    addMouseListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    // Draw the horizontal lines
    for(int row = 0; row <= rows; row++)
    {
      g.drawLine(0, row*boxSize, width, row*boxSize);
    }
    
    // Draw the vertical lines
    for(int col = 0; col <= cols; col++)
    {
      g.drawLine( col*boxSize, 0, col*boxSize, height);
    }
    
    g.setColor(Color.YELLOW);
    g.fillRect(x*boxSize+1, y*boxSize+1, boxSize-1, boxSize-1);
  }
  
  /* Required methods for MouseListener */
  public void mousePressed(MouseEvent e)
  {
    int button = e.getButton();
    if(button == MouseEvent.BUTTON1)
    {
      if(e.getX() >= 0 && e.getX() < width && e.getY() >= 0 && e.getY() < height)
      {
        x = e.getX()/boxSize;
        y = e.getY()/boxSize;
      }
      //System.out.println("Row: " + y + ", Col: " + x);
    }
    repaint();
  }
  public void mouseReleased(MouseEvent e)
  {
  }
  public void mouseClicked(MouseEvent e)
  {
  }  
  public void mouseEntered(MouseEvent e)
  { 
  } 
  public void mouseExited(MouseEvent e)
  { 
  } 
}