package Code.Expert;

import code.*;
import java.util.Iterator;

public class WindowManager extends WindowSystem {

    Dock dock = new Dock();

    public WindowManager(int i, int j) {
        super(i, j);
        super.setBackground(palette.lightBlue());

    }

    public void drawTitleBar(SimpleWindow window, char status) {
        window.getTitlebar().setsX(window.getX());
        window.getTitlebar().setsY(window.getY());
        window.getTitlebar().seteX(window.getX() + window.getWidth());
        window.getTitlebar().seteY(window.getY() + 22);

        if (status == 'i') {
            super.setColor(palette.gray());
            fillComponent(window.getTitlebar());
            super.setColor(palette.black());
            drawComponent(window.getTitlebar());
            this.drawCloseButton(window, 'i');
            this.drawMinimizeButton(window, 'i');
            this.writeTitle(window);
        } else if (status == 'a') {
            super.setColor(palette.darkPurple());
            fillComponent(window.getTitlebar());
//            super.setColor(palette.black());
//            drawComponent(window.getTitlebar());
            this.drawCloseButton(window, 'a');
            this.drawMinimizeButton(window, 'a');
            this.writeTitle(window);
        }
    }

    public void writeTitle(SimpleWindow window) {
        super.setColor(palette.lightGray());
        String title = window.getTitle();
        title = title.length() < Math.round((window.getWidth()) / 8) ? title : title.substring(0, (int) Math.round((window.getWidth()) / 8)) + "...";

        super.drawString(title, window.getX() + 8, window.getY() + 16);
    }

    public void drawCloseButton(SimpleWindow window, char status) {
        window.getCloseButton().setsX(window.getX() + window.getWidth() - 28);
        window.getCloseButton().setsY(window.getY() + 2);
        window.getCloseButton().seteX(window.getX() + window.getWidth() - 2);
        window.getCloseButton().seteY(window.getY() + 20);

        if (status == 'a') {
            super.setColor(palette.salmon());
            fillComponent(window.getCloseButton());
            super.setColor(palette.white());
//            drawComponent(window.getCloseButton());
//            super.setColor(palette.white());
            super.drawString("X", window.getX() + window.getWidth() - 18, window.getY() + 16);
        } else {
            super.setColor(palette.darkGray());
            fillComponent(window.getCloseButton());
            super.setColor(palette.black());
            drawComponent(window.getCloseButton());
            super.setColor(palette.white());
            super.drawString("X", window.getX() + window.getWidth() - 18, window.getY() + 16);
        }
    }

    public void drawMinimizeButton(SimpleWindow window, char status) {
        window.getMinimizeButton().setsX(window.getX() + window.getWidth() - 58);
        window.getMinimizeButton().setsY(window.getY() + 2);
        window.getMinimizeButton().seteX(window.getX() + window.getWidth() - 30);
        window.getMinimizeButton().seteY(window.getY() + 20);

        if (status == 'a') {
            super.setColor(palette.lightPurple());
            fillComponent(window.getMinimizeButton());
//            super.setColor(palette.black());
//            drawComponent(window.getMinimizeButton());
            super.setColor(palette.white());
            super.drawString("_", window.getX() + window.getWidth() - 46, window.getY() + 13);

        } else {
            super.setColor(palette.darkGray());
            fillComponent(window.getMinimizeButton());
            super.setColor(palette.black());
            drawComponent(window.getMinimizeButton());
            super.setColor(palette.white());
            super.drawString("_", window.getX() + window.getWidth() - 46, window.getY() + 13);
        }
    }

    public void drawDock() {
        dock.setsX(0);
        dock.setsY((int) this.height - 80);
        dock.seteX((int) this.width);
        dock.seteY((int) this.height);
        super.setColor(palette.alfaGray());
        super.fillRect(dock.getsX(), dock.getsY(), dock.geteX(), dock.geteY());
    }

    public void drawIcon(int pos) {
        int sizeIcon = (((int) width - 10 - (2 * xError)) / dock.getIcons().size());
        sizeIcon = (sizeIcon > 200) ? 200 : sizeIcon;

        dock.getIcons().get(pos).setsX((pos) * sizeIcon + 10);
        dock.getIcons().get(pos).setsY((int) height - 75);
        dock.getIcons().get(pos).seteX(((pos) * sizeIcon) + sizeIcon);
        dock.getIcons().get(pos).seteY((int) height);

        super.setColor(palette.gray());
        super.fillRect(dock.getIcons().get(pos).getsX(),
                dock.getIcons().get(pos).getsY(),
                dock.getIcons().get(pos).geteX(),
                dock.getIcons().get(pos).geteY());
        super.setColor(palette.black());
        super.drawRect(dock.getIcons().get(pos).getsX(),
                dock.getIcons().get(pos).getsY(),
                dock.getIcons().get(pos).geteX(),
                dock.getIcons().get(pos).geteY());

        super.setColor(palette.white());
        String title = dock.getIcons().get(pos).getParent().getTitle();
        title = title.length() < Math.round(sizeIcon / 9) ? title : title.substring(0, Math.round(sizeIcon / 9)) + "...";

        super.drawString(title,
                dock.getIcons().get(pos).getsX() + 10,
                dock.getIcons().get(pos).getsY() + 26);
    }

    public void fillComponent(Component Comp) {
        super.fillRect(
                Comp.getsX(),
                Comp.getsY(),
                Comp.geteX(),
                Comp.geteY());
    }

    public void drawComponent(Component Comp) {
        super.drawRect(
                Comp.getsX(),
                Comp.getsY(),
                Comp.geteX(),
                Comp.geteY());
    }

    public void setActiveWindow(SimpleWindow w) {
        w.setVisible(true);
        windows.remove(w);
        windows.add(w);
    }

    private boolean mousePressed = false;
    private boolean mouseDragging = false;
    private SimpleWindow activeWindow = new SimpleWindow();

    @Override
    public void handleMouseDragged(int x, int y) {
        y -= yError;
        x -= xError;
        if (mousePressed && mouseDragging) {
            windowSetPosition(x, y, activeWindow);
        } else {
            SimpleWindow key = findWindow(x, y);
            if (windows.contains(key) && isInsideComponent(x, y, key.getTitlebar())) {
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
        y -= yError;
        x -= xError;
        SimpleWindow key = findWindow(x, y);

        if (windows.contains(key)) {
            setActiveWindow(key);
            activeWindow = key;
            requestRepaint();

            if (isInsideComponent(x, y, activeWindow.getCloseButton())) {
                windows.remove(key);
                requestRepaint();
            }

            if (isInsideComponent(x, y, activeWindow.getMinimizeButton())) {
                key.setVisible(false);
                Component icon = new Component();
                icon.setParent(activeWindow);
                dock.addIcon(icon);
                requestRepaint();
            }
        }

        if (isInsideComponent(x, y, dock)) {
            for (Component c : dock.getIcons()) {
                if (isInsideComponent(x, y, c)) {
                    activeWindow = c.getParent();
                    setActiveWindow(activeWindow);
                    dock.removeIcon(c);
                    requestRepaint();
                }
            }
        }
    }

    public boolean isInsideComponent(int x, int y, Component comp) {
        if ((x > comp.getsX() && x < comp.geteX())
                && (y > comp.getsY() && y < comp.geteY())) {
            return true;
        }
        return false;
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

        if (y > (this.height - 90)) {
            window.setY((int) this.height - 90);
        } else if (y < 0) {
            window.setY(0);
        } else {
            window.setY(y);
        }
        requestRepaint();
    }

    @Override
    protected void handlePaint() {
        super.setBackground(palette.purple());
        //Draw stored windows 

        char status = 'i';
        for (SimpleWindow w : windows) {
            if (w.isVisible()) {
                super.drawWindow(w);
                if (w == activeWindow) {
                    status = 'a';
                }
                this.drawTitleBar(w, status);
            }
        }

        drawDock();
        for (int i = 0; i < dock.getIcons().size(); i++) {
            drawIcon(i);
        }

    }

}
