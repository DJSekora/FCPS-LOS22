/* This is a basic main method to be used with graphical applications.
   It can technically go in the same class as the Panel class, but we've
   separated it here for clarity.
 */
import javax.swing.JFrame;

public class GraphicsMainExample
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    
    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BGPExample vpanel = new BGPExample();
    frame.add(vpanel);
    frame.setVisible(true);
  }
}