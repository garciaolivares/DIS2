
import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;  

/* WindowSystem Class
 * Basic windows task, draw desktop and simple window
 * Conversion between absolute and relative coordinates and size
 * */

public class WindowSystem extends GraphicsEventSystem {

    double desktopWidth, desktopHeight;
    public Palette palette = new Palette(); //object Palette to call personalized colors
    ArrayList<SimpleWindow> windows; //data structure for our collection of Simple Window objects 
    

    //initialization 
    public WindowSystem(int i, int j) {
        // call parent class to draw our "desktop" with size ixj 
        super(i, j); 
        // define width and height of our desktop with values i and j
        desktopWidth = i;
        desktopHeight = j;
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
    	
    	convertX(window);
        convertY(window);
        convertWidth(window);
        convertHeight(window);
        
        super.setColor(palette.lightGray());
        super.fillRect(window.getRelativeX(), window.getRelativeY(), window.getRelativeX() + window.getWidth(), window.getRelativeY() + window.getHeight());
        super.setColor(palette.black());
        super.drawRect(window.getRelativeX(), window.getRelativeY(), window.getRelativeX() + window.getWidth(), window.getRelativeY() + window.getHeight());
    }
    
    /*
     * Absolute to relative coordinates and size(W,H)
     */
    public void convertX(SimpleWindow window){
    	float coord = window.getAbsoluteX();
    	int x = (int)(coord*desktopWidth);
    	window.setRelativeX(x);
    }
    
    public void convertY(SimpleWindow window){
    	float coord = window.getAbsoluteY();
    	int y = (int)(coord*desktopHeight);
    	window.setRelativeY(y);
    }
    
    public void convertWidth(SimpleWindow window){
    	float size = window.getAbsoluteW();
    	int w = (int)(size*desktopWidth);
    	window.setWidth(w);
    }


	public void convertHeight(SimpleWindow window){
		float size = window.getAbsoluteH();
    	int h = (int)(size*desktopHeight);
    	window.setHeight(h);
	}
}
