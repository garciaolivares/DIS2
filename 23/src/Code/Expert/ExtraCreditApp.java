package Code.Expert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point; 
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import javax.swing.JFrame;
 
public class ExtraCreditApp extends JFrame { 

    private final class Widget extends JComponent {

        int height;
        int widht;

        Point startPoint = new Point(0, 0); //Start line's coordinates
        Point endPoint = new Point(0, 0); //End line's coordinates
        
        public Widget(int h, int w){ // initialize contructor
            this.setPreferredSize(new Dimension(h, w));
            height = h;
            widht = w;
        }

        @Override
        protected void paintComponent(Graphics g) { //Paint handle
            super.paintComponent(g);
            g.setColor(Color.black); // set the Graphic context color  
            g.drawLine(startPoint.x, startPoint.y, height - endPoint.y, startPoint.y); //draw the line  
        }

        public void setStart() { 
            this.endPoint.y = height; 
            this.startPoint.x = 0;
            this.startPoint.y = this.endPoint.x = 280;
            repaint(); // fires method paint Componet
        }

        public void setEnd(Point endPoint) {
            this.endPoint = endPoint;
            repaint(); // fires method paint Componet
        }
    }

    public ExtraCreditApp() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // terminates program by clicking close button 
        Widget myWidget = new Widget(600, 600);  // creates component
        myWidget.setStart(); // Initializes start coordinates
        this.add(myWidget, BorderLayout.CENTER); // adds myWidget in main frame

        this.addMouseMotionListener(new MouseMotionAdapter() {  // adds mouse motion listener in main frame 
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) { // overwhites method mouse Dragged
                myWidget.setEnd(e.getPoint()); //fetches the current mouse position
            }
        }); 

        this.pack(); // fits the windows in its preferent size
        this.setVisible(true); // makes the window visible
    }

    public static void main(String arg[]) {
        ExtraCreditApp app = new ExtraCreditApp(); // creats the main window
    }

}
