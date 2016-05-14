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
    public int oldX, oldY;
    public int currentX, currentY;

    //initialization 
    public WindowSystem(int i, int j) {
        // call parent class to draw our "desktop" with size ixj 
        super(i, j);
        super.setBackground(palette.purple());
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
        y -= 33;
        currentX = x;
        currentY = y;
        if (wm != null) {
            wm.handleMouseDragged(x, y);
        }
        oldX = currentX;
        oldY = currentY;
    }

    public void handleMousePressed(int x, int y) {
        y -= 33;
        currentX = x;
        currentY = y;
        oldX = currentX;
        oldY = currentY;
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
        y -= 33;
        currentX = x;
        currentY = y;
        oldX = currentX;
        oldY = currentY;
        if (wm != null) {
            wm.handleMouseClicked(x, y);
        }

        SimpleWindow activeWindow = findWindow(x, y);
        if (windows.contains(activeWindow)) {
            RATbutton widget = (RATbutton) getClickedWidget(x, y, activeWindow);
            if (widget != null) {
                widget.performance();
                requestRepaint();
            }
        }

    }

    public RATwidget getClickedWidget(int x, int y, SimpleWindow parent) {
        for (RATwidget widget : parent.getWidgets()) {
            if (widget instanceof RATbutton) {
                int sX = (int) ((widget.getsX() * parent.getWidth()) + parent.getRelativeX());
                int eX = (int) ((widget.getsX() * parent.getWidth() + widget.getWidth() * parent.getWidth()) + parent.getRelativeX());
                int sY = (int) ((widget.getsY() * parent.getHeight()) + parent.getRelativeY());
                int eY = (int) ((widget.getsY() * parent.getHeight() + widget.getHeight() * parent.getHeight()) + parent.getRelativeY());
                if (x > sX && x < eX && y > sY && y < eY) {
                    return widget;
                }
            }
        }
        return null;
    }

    public SimpleWindow findWindow(int x, int y) {
        SimpleWindow window = new SimpleWindow();
        //iterate through collection of windows
        for (SimpleWindow w : windows) {
            //compare by attributes and return window
            if ((w.getRelativeX() < x) && (w.getRelativeY() - (wm.titleBarSize) < y)
                    && (w.getRelativeX() + w.getWidth() > x)
                    && (w.getRelativeY() + w.getHeight() > y)
                    && w.isVisible()) {
                window = w;
            }
        }
        return window;
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
        int sy = (int) (widget.getsY() * parent.getHeight()) + parent.getRelativeY();
        int ex = (int) (widget.getWidth() * parent.getWidth()) + sx;
        int ey = (int) (widget.getHeight() * parent.getHeight()) + sy;
        int textPosition = sy + ((int) (widget.getHeight() * parent.getHeight()) / 2) + (widget.getFontSize() / 2) - 2;
        int textAlign = (int) (widget.getFontSize() / 2 + (widget.getWidth()));
        //Compare wheter if the widget coordinetes are out of windows range
        ex = ex > parent.getRelativeX() + parent.getWidth() ? (int) parent.getRelativeX() + parent.getWidth() : (ex <= parent.getRelativeX() ? (int) parent.getRelativeX() : ex );
        ey = ey > parent.getRelativeY() + parent.getHeight() ? (int) parent.getRelativeY() + parent.getHeight() : (ey < parent.getRelativeY() ? (int) parent.getRelativeY() : ey);
        super.setColor(widget.getBackgraoundColor());
        super.fillRect(sx, sy, ex, ey);
        super.setColor(widget.getBorderColor());
        super.drawRect(sx, sy, ex, ey);
        super.setFont(new Font(widget.getFont(), widget.getTypeFace(), widget.getFontSize()));
        super.setColor(widget.getFontColor());
        super.drawString(widget.getText(), sx + textAlign, textPosition);
    }

    //Method to draw a new Window (basic one, no look and feel only plain box)
    public void drawWindow(SimpleWindow window) {
        //absoluteToRelative(window);
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
        window.setRelativeY((int) (window.getAbsoluteY() * desktopHeight) + wm.titleBarSize);
        window.setWidth((int) (window.getAbsoluteW() * desktopWidth));
        window.setHeight((int) (window.getAbsoluteH() * desktopHeight));
    }

}
