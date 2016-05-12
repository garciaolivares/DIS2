package Code;

import java.util.ArrayList;

import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Font;
import java.awt.Rectangle;

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
        absoluteToRelative(window);
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
        super.setBackground(palette.purple());
        // Draw stored windows
        for (SimpleWindow w : windows) {
            if (w.isVisible()) {
                this.drawWindow(w);
                if (wm != null) {
                    wm.decorateWindow(w);
                }
                drawWidgets(w);
            }
        }
        if (wm != null) {
            wm.refreshDock();
        }
    }

    public void drawWidgets(SimpleWindow window) {
        for (RATwidget widget : window.getWidgets()) {
            if (widget instanceof RATlabel) {
                drawWidget((RATlabel) widget, window);
            }
            if (widget instanceof RATbutton) {
                drawWidget((RATbutton) widget, window);
            }
        }
    }

    public void drawWidget(RATlabel widget, SimpleWindow parent) {
        int sx = (int) (widget.getsX() * parent.getWidth()) + parent.getRelativeX();
        int sy = (int) (widget.getsY() * parent.getHeight()) + parent.getRelativeY() + wm.titleBarSize-2;
        int ex = (int) (widget.getWidth() * parent.getWidth()) + sx;
        int ey = (int) (widget.getHeight() * parent.getHeight()+wm.titleBarSize-2) + sy;
        int textPosition = sy +((int)(widget.getHeight() * parent.getHeight())/2)+(widget.getFontSize()/2)-2;
        //Compare wheter if the widget coordinetes are out of windows range
        //ex = ex > parent.getRelativeX()+parent.getWidth()? (int) parent.getRelativeX()+parent.getWidth() : (ex <= parent.getRelativeX() ? (int) parent.getRelativeX() : ex);
        //ey = ey > parent.getRelativeY()+parent.getHeight()? (int) parent.getRelativeY()+parent.getHeight()-2 : (ey < parent.getRelativeY()? (int)parent.getRelativeY(): ey);
        super.setColor(widget.getBackgraoundColor());
        super.fillRect(sx, sy, ex, ey);
        super.setColor(widget.getBorderColor());
        super.drawRect(sx, sy, ex, ey);
        super.setFont(new Font(widget.getFont(), widget.getTypeFace(), widget.getFontSize()));
        super.setColor(widget.getFontColor());
        super.drawString(widget.getText(), sx, textPosition);
    }
    
    



    //Method to draw a new Window (basic one, no look and feel only plain box)
    public void drawWindow(SimpleWindow window) {
        absoluteToRelative(window);
        super.setColor(palette.lightGray());
        super.fillRect(window.getRelativeX(), window.getRelativeY(), window.getRelativeX() + window.getWidth(), window.getRelativeY() + window.getHeight());
        super.setColor(palette.black());
        super.drawRect(window.getRelativeX(), window.getRelativeY(), window.getRelativeX() + window.getWidth(), window.getRelativeY() + window.getHeight());
    }

    /*
     * Absolute to relative coordinates and size(W,H)
     */
    public void absoluteToRelative(SimpleWindow window) {
        window.setRelativeX((int) (window.getAbsoluteX() * desktopWidth));
        window.setRelativeY((int) (window.getAbsoluteY() * desktopHeight));
        window.setWidth((int) (window.getAbsoluteW() * desktopWidth));
        window.setHeight((int) (window.getAbsoluteH() * desktopHeight));
    }

}
