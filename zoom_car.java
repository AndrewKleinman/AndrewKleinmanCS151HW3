   import java.awt.*;
   import java.awt.geom.*;
   import javax.swing.*;
   
   /**
      An icon that has the shape of a car.
   */
   //retrieved from slides
   public class zoom_car implements Icon
   {
      /**
         Constructs a car of a given width.
         @param width the width of the car
      */
      public zoom_car(int aWidth)
      {
         width = aWidth;
         JFrame frame = new JFrame();
         JLabel label = new JLabel(this);
         frame.setLayout(new FlowLayout());
         frame.add(label);
         Panel p = new Panel();
         Button b1 = new Button("Zoom in");
         Button b2 = new Button("Zoom out");
         p.add(b1);
         p.add(b2);
         b1.addActionListener(event -> {
 			width*=2;
 			label.repaint();
 			frame.pack();}
         
 			);
         b2.addActionListener(event -> {
  			width/=2;
  			label.repaint();
  			frame.pack();}
  			);
         frame.add(p);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
   

      }
      
      public int getIconWidth()
      {
         return width;
      }
   
      public int getIconHeight()
      {
         return width / 2;
      }
   
      public void paintIcon(Component c, Graphics g, int x, int y)
      {
         Graphics2D g2 = (Graphics2D) g;
         Rectangle2D.Double body
               = new Rectangle2D.Double(x, y + width / 6, 
                     width - 1, width / 6);
         Ellipse2D.Double frontTire
               = new Ellipse2D.Double(x + width / 6, y + width / 3, 
                     width / 6, width / 6);
         Ellipse2D.Double rearTire
               = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
                     width / 6, width / 6);
   
         // The bottom of the front windshield
         Point2D.Double r1
               = new Point2D.Double(x + width / 6, y + width / 6);
         // The front of the roof
         Point2D.Double r2
               = new Point2D.Double(x + width / 3, y);
         // The rear of the roof
         Point2D.Double r3
               = new Point2D.Double(x + width * 2 / 3, y);
         // The bottom of the rear windshield
         Point2D.Double r4
               = new Point2D.Double(x + width * 5 / 6, y + width / 6);
   
         Line2D.Double frontWindshield
               = new Line2D.Double(r1, r2);
         Line2D.Double roofTop
               = new Line2D.Double(r2, r3);
         Line2D.Double rearWindshield
               = new Line2D.Double(r3, r4);
   
         g2.fill(frontTire);
         g2.fill(rearTire);
         g2.setColor(Color.red);
         g2.fill(body);
         g2.draw(frontWindshield);
         g2.draw(roofTop);
         g2.draw(rearWindshield);
      }
      public static void main(String[] args)
      {
    	  zoom_car zoomcar = new zoom_car(width);
      }
   
      private static final int ICON_WIDTH = 400;
      private static final int ICON_HEIGHT = 100;
      private static int width = 100;
   }
 