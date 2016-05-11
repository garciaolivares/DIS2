package Code;

import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Font;

/* WindowSystem Class
 * Basic windows task, draw desktop and simple window
 * Conversion between absolute and relative coordinates and size
 * */
public class WindowSystem extends GraphicsEventSystem {

    double desktopWidth, desktopHeight;
    public Palette palette = new Palette(); //object Palette to call personalized colors
    public ArrayList<SimpleWindow> windows; //data structure for our collection of Simple Window objects
    private WindowManager wm;

    //initialization 
    public WindowSystem(int i, int j) {
        // call parent class to draw our "desktop" with size ixj 
        super(i, j);
        // define width and height of our desktop with values i and j
        desktopWidth = i;
        desktopHeight = j;
        // initialize arraylist that stores created windows
        windows = new ArrayList();
        wm = new WindowManager(this);

    }

    //Method to add a new Window
    public void addWindow(SimpleWindow window) {
        convertX(window);
        convertY(window);
        convertWidth(window);
        convertHeight(window);
        windows.add(window); //Add SimpleWindow object to our collection

        if (wm != null) {
            wm.windowCreated(window);
        }
    }

    public void handleMouseDragged(int x, int y) {
        if (wm != null) {
            wm.handleMouseDragged(x, y);
        }
    }

    public void handleMousePressed(int x, int y) {
        if (wm != null) {
            wm.handleMousePressed(x, y);
        }
    }

    public void handleMouseReleased(int x, int y) {
        if (wm != null) {
            wm.handleMouseReleased(x, y);
        }
    }

    public void handleMouseClicked(int x, int y) {
        if (wm != null) {
            wm.handleMouseClicked(x, y);
        }
    }

    @Override
    protected void handlePaint() {
        //super.setBackground(palette.purple());
        // Draw stored windows
        for (SimpleWindow w : windows) {

            if (w.isVisible()) {
                this.drawWindow(w);
                wm.decorateWindow(w);
                drawWidgets(w);
            }
        }

        wm.refreshDock();

    }

    public void drawWidgets(SimpleWindow window) {
        for (RATwidget widget : window.getWidgets()) {
            if (widget instanceof RATlabel) {
                drawLabel((RATlabel) widget, window);
            }
             if (widget instanceof RATbutton) {
                drawButton((RATbutton) widget, window);
            }
        }
    }

    public void drawLabel(RATlabel widget, SimpleWindow parent) {
        
        double sx = (widget.getsX()*parent.getWidth())+parent.getRelativeX();
        double sy = (widget.getsY()*parent.getHeight())+parent.getRelativeY()+20;
        double ex = (widget.geteX()*parent.getWidth())+parent.getRelativeX();
        double ey = (widget.geteY()*parent.getHeight())+parent.getRelativeY()+20;
        
        super.setColor(widget.getBackgraoundColor());
        super.fillRect(sx, sy, ex, ey);
        super.setColor(widget.getBorderColor());
        super.drawRect(sx, sy, ex, ey);  
        super.setFont(new Font(widget.getFont(), widget.getTypeFace(), widget.getFontSize()));
        super.setColor(widget.getFontColor());
        super.drawString(widget.getText(),sx,sy); 
       
    }
    
    public void drawButton(RATbutton widget, SimpleWindow parent) { 
        
        double sx = (widget.getsX()*parent.getWidth())+parent.getRelativeX();
        double sy = (widget.getsY()*parent.getHeight())+parent.getRelativeY()+20;
        double ex = (widget.geteX()*parent.getWidth())+parent.getRelativeX();
        double ey = (widget.geteY()*parent.getHeight())+parent.getRelativeY()+20;
        
        super.setColor(widget.getBackgraoundColor());
        super.fillRect(sx, sy, ex, ey);
        super.setColor(widget.getBorderColor());
        super.drawRect(sx, sy, ex, ey);  
        super.setFont(new Font(widget.getFont(), widget.getTypeFace(), widget.getFontSize()));
        super.setColor(widget.getFontColor());
        super.drawString(widget.getText(),sx,sy);  
       
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
    public void convertX(SimpleWindow window) {
        float coord = window.getAbsoluteX();
        int x = (int) (coord * desktopWidth);
        window.setRelativeX(x);
    }

    public void convertY(SimpleWindow window) {
        float coord = window.getAbsoluteY();
        int y = (int) (coord * desktopHeight);
        window.setRelativeY(y);
    }

    public void convertWidth(SimpleWindow window) {
        float size = window.getAbsoluteW();
        int w = (int) (size * desktopWidth);
        window.setWidth(w);
    }

    public void convertHeight(SimpleWindow window) {
        float size = window.getAbsoluteH();
        int h = (int) (size * desktopHeight);
        window.setHeight(h);
    }
}
