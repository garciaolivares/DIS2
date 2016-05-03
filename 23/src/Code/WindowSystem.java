package Code;

import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Color;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class WindowSystem extends GraphicsEventSystem {

    double width, height;
    public Palette palette = new Palette();
    Hashtable<String, SimpleWindow> windows; // creat hash table that stores created windows

    //initialization 
    public WindowSystem(int i, int j) {
        // call parent class to draw our "desktop" with size ixj 
        super(i, j);

        // define width and height of our desktop with values i and j
        width = (double) i;
        height = (double) j;
        // initialize hash table that stores created windows
        windows = new Hashtable<String, SimpleWindow>();

    }

    public void addWindow(SimpleWindow window) {
         
        windows.put(window.toString(), window);
    }

    @Override
    protected void handlePaint() {
        // Draw stored windows
        Set<String> keySet = windows.keySet();
        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            this.drawWindow(windows.get(key));
        }
    }

    public void drawWindow(SimpleWindow window) {
        super.setColor(Color.gray);
        super.fillRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + window.getHeight());
        super.setColor(Color.black);
        super.drawRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + window.getHeight());
    }

}
