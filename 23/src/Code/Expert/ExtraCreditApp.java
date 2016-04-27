package Code.Expert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter; 
import javax.swing.JComponent;
import javax.swing.JFrame; 

/**
 *
 * @author David
 */
public class ExtraCreditApp extends JFrame {
    
    int endYcoord;

    private final class Widget extends JComponent {
        
        int height = 600;
        int widht = 600;

        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(0, 0); 
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black); 
            g.drawLine(startPoint.x , startPoint.y, height - endPoint.y, startPoint.y); 
            System.out.println(endPoint.y);
        }

        public void setStart() {
            this.endPoint.y= height;
            this.startPoint.x = 0;
            this.startPoint.y= this.endPoint.x= 280;
            repaint();
        }
        
        
        public void setEnd(Point endPoint) {
            this.endPoint = endPoint;
            repaint();
        }
    }

    public ExtraCreditApp() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Widget myWidget = new Widget();
        myWidget.setPreferredSize(new Dimension(600, 600));
        myWidget.setStart();
        this.add(myWidget, BorderLayout.CENTER);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) { 
                myWidget.setEnd(e.getPoint());
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            
            }
        });

        this.pack();
        this.setVisible(true);
    }

    public static void main(String arg[]) {
        ExtraCreditApp app = new ExtraCreditApp();
    }

}


