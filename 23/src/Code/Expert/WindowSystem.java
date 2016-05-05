package Code.Expert;

import code.*;
import de.rwth.hci.Graphics.GraphicsEventSystem; 
import java.util.ArrayList;  

public class WindowSystem extends GraphicsEventSystem {

    double width, height;
    public Palette palette = new Palette(); 
    public ArrayList<SimpleWindow> windows;
    public int xError = 3;
    public int yError = 33;

    //initialization 
    public WindowSystem(int i, int j) {
        // call parent class to draw our "desktop" with size ixj 
        super(i, j); 
        // define width and height of our desktop with values i and j
        width = (double) i;
        height = (double) j;
        // initialize hash table that stores created windows
        windows  = new ArrayList();

    }

    public void addWindow(SimpleWindow window) { 
        windows.add(window);
    }

    @Override
    protected void handlePaint() { 
       // Draw stored windows
          for (SimpleWindow w : windows) {
             this.drawWindow(w); 
        }
    }

    public void drawWindow(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.fillRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + window.getHeight());
        super.setColor(palette.black());
        super.drawRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + window.getHeight());
    }
}
