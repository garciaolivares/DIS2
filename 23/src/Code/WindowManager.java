package Code;

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
    
    @Override
    public void handleMouseDragged(int x, int y) {
        windowSetPosition(x, y, windows.get(findWindow(x, y)));
    }
    
    @Override
    public void handleMouseClicked(int x, int y) { 
    }
    
    public String findWindow(int x, int y) {
        String key = "";
        
        Iterator<String> keySetIterator = windows.keySet().iterator();
        while (keySetIterator.hasNext()) {
            key = keySetIterator.next();
            
            if ((windows.get(key).getX() < x) && (windows.get(key).getY() < x)
                    && (windows.get(key).getX() + windows.get(key).getWidth() > x)
                    && (windows.get(key).getY() + windows.get(key).getHeight() > y)) {
                
                System.out.println(windows.get(key).getTitle());
                
            } else {
                
            }
            
        }
        
        return key;
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
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            super.drawWindow(windows.get(key));
            this.drawTitleBar(windows.get(key));
        }
    }
    
}
