package Code;  

import java.awt.Color;
import java.util.Iterator;
import java.util.Set;

public class WindowManager extends WindowSystem {

    public WindowManager(int i, int j) {
        super(i, j);
        super.setBackground(palette.lightBlue());
    }

    public void drawTitleBar(SimpleWindow window , char status) {
        
        if (status == 'i'){
            
            super.setColor(palette.gray());
            super.fillRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + 22);
            super.setColor(palette.black());
            super.drawRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + 22);
            this.drawCloseButton(window, 'i');
            this.drawMinimizeButton(window, 'i');
            this.writeTitle(window);
            
        } else if (status == 'a'){
            
            super.setColor(palette.green());
            super.fillRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + 22);
            super.setColor(palette.black());
            super.drawRect(window.getX(), window.getY(), window.getX() + window.getWidth(), window.getY() + 22);
            this.drawCloseButton(window, 'a');
            this.drawMinimizeButton(window, 'a');
            this.writeTitle(window);
            
        }
        
    }

    public void writeTitle(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.drawString(window.getTitle(), window.getX() + 8, window.getY() + 16);
    }

    public void drawCloseButton(SimpleWindow window, char status) {
        
        if (status == 'a'){
            super.setColor(palette.red());
            super.fillRect(window.getX() + window.getWidth() - 28, window.getY() + 2, window.getX() + window.getWidth() - 2, window.getY() + 20);
            super.setColor(palette.black());
            super.drawRect(window.getX() + window.getWidth() - 28, window.getY() + 2, window.getX() + window.getWidth() - 2, window.getY() + 20);
            super.setColor(palette.white());
            super.drawString("X", window.getX() + window.getWidth() - 18, window.getY() + 16);
        
        } else {
        
            super.setColor(palette.darkGray());
            super.fillRect(window.getX() + window.getWidth() - 28, window.getY() + 2, window.getX() + window.getWidth() - 2, window.getY() + 20);
            super.setColor(palette.black());
            super.drawRect(window.getX() + window.getWidth() - 28, window.getY() + 2, window.getX() + window.getWidth() - 2, window.getY() + 20);
            super.setColor(palette.white());
            super.drawString("X", window.getX() + window.getWidth() - 18, window.getY() + 16);
        }
    }

    public void drawMinimizeButton(SimpleWindow window, char status) {
        
        if (status == 'a'){
            super.setColor(palette.yellow());
            super.fillRect(window.getX() + window.getWidth() - 58, window.getY() + 2, window.getX() + window.getWidth() - 30, window.getY() + 20);
            super.setColor(palette.black());
            super.drawRect(window.getX() + window.getWidth() - 58, window.getY() + 2, window.getX() + window.getWidth() - 30, window.getY() + 20);
            super.setColor(palette.white());
            super.drawString("_", window.getX() + window.getWidth() - 46, window.getY() + 13);
        
        }else{
        
            super.setColor(palette.darkGray());
            super.fillRect(window.getX() + window.getWidth() - 58, window.getY() + 2, window.getX() + window.getWidth() - 30, window.getY() + 20);
            super.setColor(palette.black());
            super.drawRect(window.getX() + window.getWidth() - 58, window.getY() + 2, window.getX() + window.getWidth() - 30, window.getY() + 20);
            super.setColor(palette.white());
            super.drawString("_", window.getX() + window.getWidth() - 46, window.getY() + 13);
        }
    }
    
    public void setActiveWindow(SimpleWindow w){
        windows.remove(w);
        windows.add(w);
    }

    private boolean mousePressed = false;
    private boolean mouseDragging = false;
    private SimpleWindow activeWindow = new SimpleWindow();
    private int xClicked, yClicked = 0;

    @Override
    public void handleMouseDragged(int x, int y) { 
            y -=23; 
            x -=1 ;  
            if (mousePressed && mouseDragging) {
                windowSetPosition(x, y, activeWindow);
            } else {
                SimpleWindow key = findWindow(x, y);
                if (windows.contains(key)) {
                    setActiveWindow(key);
                    activeWindow = key;
                    mouseDragging = true;
                    windowSetPosition(x, y, key);
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
        
        SimpleWindow key = findWindow(x, y);
        if (windows.contains(key)) {
            setActiveWindow(key);
            activeWindow = key;
            requestRepaint();
        }
       
    }

    public SimpleWindow findWindow(int x, int y) {
        SimpleWindow window = new SimpleWindow();
        
         for (SimpleWindow w : windows) {
           if ((w.getX() < x) && (w.getY() < y)
                    && (w.getX() + w.getWidth() > x)
                    && (w.getY() + w.getHeight() > y)) {
                window = w;
            }  
        } 
        return window;
    }
    public void windowSetPosition(int x, int y, SimpleWindow window) {

        if (x > this.width) {
            window.setX((int) this.width - 10);
        } else if (x < 0) {
            window.setX(0);
        } else {
            window.setX(x);
        }

        if (y > this.height) {
            window.setY((int) this.height - 30);
        } else if (y < 0) {
            window.setY(0);
        } else {
            window.setY(y);
        }
        requestRepaint();
    }

    @Override
    protected void handlePaint() {
        super.setBackground(palette.lightBlue());
        //Draw stored windows 
        
        char status = 'i';
        for (SimpleWindow w : windows) {
            super.drawWindow(w);
            
            if(w == activeWindow){
                 status = 'a';
            } 
            this.drawTitleBar(w, status);       
        }
    }

    public void sortWindows(Iterator<String> keySetIterator) {

    }
}