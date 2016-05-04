package Code; 

import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import java.awt.Color;
import java.util.Iterator;
import java.util.Set;

public class WindowManager extends WindowSystem {

    public WindowManager(int i, int j) {
        super(i, j);
    }

    public void drawTitleBar(SimpleWindow window) {
        super.setColor(palette.blue());
        super.fillRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + 22);
        super.setColor(palette.black());
        super.drawRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + 22);
        this.drawCloseButton(window);
        this.drawMinimizeButton(window);
        this.writeTitle(window);
    }

    public void writeTitle(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.drawString(window.getTitle(), window.getX() + 8, window.getY() + 16);
    }

    public void drawCloseButton(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.fillRect(window.getX() + window.getWidth() - 28, window.getY() + 2, window.getX() + window.getWidth() - 2, window.getY() + 20);
        super.setColor(palette.black());
        super.drawRect(window.getX() + window.getWidth() - 28, window.getY() + 2, window.getX() + window.getWidth() - 2, window.getY() + 20);
        super.drawString("X", window.getX() + window.getWidth() - 18, window.getY() + 16);
    }

    public void drawMinimizeButton(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.fillRect(window.getX() + window.getWidth() - 58, window.getY() + 2, window.getX() + window.getWidth() - 30, window.getY() + 20);
        super.setColor(palette.black());
        super.drawRect(window.getX() + window.getWidth() - 58, window.getY() + 2, window.getX() + window.getWidth() - 30, window.getY() + 20);
        super.drawString("_", window.getX() + window.getWidth() - 46, window.getY() + 13);
    }

    private boolean mousePressed = false;
    private boolean mouseDragging = false;
    private SimpleWindow activeWindow = new SimpleWindow();

    @Override
    public void handleMouseDragged(int x, int y) {
        y -= 32; 
        x -= 3; 
        if (mousePressed && mouseDragging) {
            windowSetPosition(x, y, activeWindow);
        } else {
            String key = findWindow(x, y);
            if (!key.equals("")) {
                activeWindow = windows.get(key);
                mouseDragging = true;
                windowSetPosition(x, y, windows.get(key));
            }
        }

    }

    @Override
    public void handleMousePressed(int x, int y) {
        mousePressed = true;
        
    }

    @Override
    public void handleMouseReleased(int x, int y) {
        mousePressed = false;
        mouseDragging = false;
        activeWindow = new SimpleWindow();

    }

    @Override
    public void handleMouseClicked(int x, int y) {
         
    }

    public String findWindow(int x, int y) {
        String window = "";
        Iterator<String> keySetIterator = windows.keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            if ((windows.get(key).getX() < x) && (windows.get(key).getY() < y)
                    && (windows.get(key).getX() + windows.get(key).getWidth() > x)
                    && (windows.get(key).getY() + windows.get(key).getHeight() > y)) {
                window = key;
            } else {

            }
        }
        return window;
    }

    public void windowSetPosition(int x, int y, SimpleWindow window) {
        window.setX(x);
        window.setY(y);
        requestRepaint();
    }

    @Override
    protected void handlePaint() {
        super.setBackground(palette.lightBlue());
        // Draw stored windows 
        Iterator<String> keySetIterator = windows.keySet().iterator();
        System.out.println(windows.keySet());
        
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            super.drawWindow(windows.get(key));
            this.drawTitleBar(windows.get(key));
             
        }
    }
    
    public void sortWindows(Iterator<String> keySetIterator){
        
    }

}