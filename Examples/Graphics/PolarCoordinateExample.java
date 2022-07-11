/* Some types of shapes are easier to draw with functions on polar coordinates.
   Polar coordinates are an alternative to rectangular coordinates, which
   can be written in the form (r, theta). r is the radius (distance from the
   origin), and theta is the angle (measured counter-clockwise around the
   origin, typically in radians).
   
   We can represent the functions in two main ways:
    1. theta = f(r), which means we calculate the angle based on the distance
       from the center, or
    2. r = f(theta), which means we calculate the distance from the center
       based on the angle.
   
   Way 2 is more conventional, but sometimes way 1 lends itself more naturally
   to your code (especially when you want to make sure the graph stays within
   a certain boundary, like a square image box).
   
   To convert polar coordinates to rectangular ones (which we will need to do
   to actually draw the image), we can use these formulas:
   
     x = r*cos(theta)
     y = r*sin(theta)
     
   where cos and sin are the cosine and sine functions from trigonometry.
   
   Sine and cosine rarely produce integer values, so we will mostly be using
   double, casting to int only when we actually need to assign a color to a
   pixel.
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PolarCoordinateExample extends JPanel
{ 
  BufferedImage image;
  
  public PolarCoordinateExample()
  {
    // The width and height of the image itself
    int imageWidth = 800;
    int imageHeight = 600;
    
    // The origin for our coordinate system
    int xCenter = 400;
    int yCenter = 300;
    
    // The max distance from the center we will go to
    int radius = 300;
    
    /* The amount of points to sample per 1 pixel distance from the origin. */
    double density = 10.0;
    
    /* From the density, we calculate the difference between successive values
       of our loop variable (delta is often used to mean difference). */
    
    double rDelta = 1/density;
    
    // This is a multiplier we apply at the end of angle calculation. For the
    // spiral, it controls how "tight" the spiral is - lower values are looser.
    double rotationSpeed = 0.1;
    
    image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
    
    
    // Set up some loop variables to make our calculations more human-readable
    double angle;
    int x, y;
    
    // The following draws a spiral
    // We are graphing the function f(r) = ar, where a is a constant (scalar).
    // Here, we are using i to loop through different values of r, and 
    for(double i=0; i<radius; i+=rDelta)
    {
      angle = i*rotationSpeed;
      x = (int)(i*Math.cos(angle)) + xCenter;
      y = (int)(i*Math.sin(angle)) + yCenter;
      image.setRGB(x, y, 0xff000000);
    }
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);
  }
}
/* ROOM FOR IMPROVEMENT:

   Notice how in the spiral example, the displayed graph is very dense towards
   the center and sparse towards the edges. Ideally, the density would be low
   in the center (so we don't keep drawing the same points over and over again)
   and get higher as you get out towards the edges. This isn't that hard to do,
   you could for example increase the density (and therefore decrease the
   rDelta) as i gets larger. You just need to be careful to not increase it
   too much, because you have to make sure that the loop will eventually
   terminate!
   
   Try changing i+=rDelta to the following:
     i+=(rDelta/(i+1))
   Then see how low you can drop the density without losing too much of the
   spiral!
   
   We could also draw lines between each point to make sure the spiral is at
   least continuous (connected). This is a form of interpolation.
 */