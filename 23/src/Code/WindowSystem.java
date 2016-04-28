package Code; 

import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Color;
import java.util.Hashtable;

public class WindowSystem extends GraphicsEventSystem {

    double width, height;
    Hashtable<String, SimpleWindow> windows = new Hashtable<String, SimpleWindow>();

    //initialization 
    public WindowSystem(int i, int j) {
        super(i, j); // call parent class to draw our "desktop" with size ixj 
        // define width and height of our desktop with values i and j
        width = (double) i;
        height = (double) j;
        // add window in the hashtable in order to keep tracking of it
        addWindow();
    }

    final void addWindow() {
        SimpleWindow w = new SimpleWindow(0,0,windows.size());
        windows.put(w.toString(), w);
    }

    @Override
    protected void handlePaint() {
        // draw a single line from (0.2, 0.3) to (0.8, 0.7) with resolution independet drawline method
        this.drawLine(0.2f, 0.3f, 0.8f, 0.7f);
    }

    //resolution independent drawline 
    public void drawLine(float StartX, float StartY, float EndX, float EndY) {

        /*
    	*  Take floating values of coordinates and multiply by current height and widht of our desktop
    	*  new values will match desktop size
         */
        StartX = (float) (StartX * width);
        StartY = (float) (StartY * height);
        EndX = (float) (EndX * width);
        EndY = (float) (EndY * height);

        super.setColor(Color.black); //set color of line
        //rount values to int to use drawline method in GraphicsEventSystem library
        super.drawLine(Math.round(StartX), Math.round(StartY), Math.round(EndX), Math.round(EndY));
    }

}
