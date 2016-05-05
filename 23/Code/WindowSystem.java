package Code;
import de.rwth.hci.Graphics.GraphicsEventSystem; 
import java.util.ArrayList;  

/* WindowSystem Class
 * Basic windows task, draw desktop and simple window
 * 
 * */

public class WindowSystem extends GraphicsEventSystem {

    double width, height;
    public Palette palette = new Palette(); //object Palette to call personalized colors
    ArrayList<SimpleWindow> windows; //data structure for our collection of Simple Window objects 
    public int xError = 1; 
    public int yError = 23;

    //initialization 
    public WindowSystem(int i, int j) {
        // call parent class to draw our "desktop" with size ixj 
        super(i, j); 
        // define width and height of our desktop with values i and j
        width = (double) i;
        height = (double) j;
        // initialize arraylist that stores created windows
        windows  = new ArrayList();

    }

  //Method to add a new Window
    public void addWindow(SimpleWindow window) { 
        windows.add(window);  //Add SimpleWindow object to our collection
    }

    @Override
    protected void handlePaint() { 
       // Draw stored windows
          for (SimpleWindow w : windows) {
             this.drawWindow(w);
        }
    }

  //Method to draw a new Window (basic one, no look and feel only plain box)
    public void drawWindow(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.fillRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + window.getHeight());
        super.setColor(palette.black());
        super.drawRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + window.getHeight());
    }
}
