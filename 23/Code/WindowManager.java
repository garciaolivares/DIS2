package Code;

/* WindowManages Class
 * Look and feel window and its components
 * mouse actions/events
 * */
//initialization
public class WindowManager {

    Dock dock = new Dock();// Call to create dock
    int titleBarSize = 24;

    public final WindowSystem ws;
    public Palette palette = new Palette(); //object Palette to call personalized colors

    public WindowManager(WindowSystem ws) {
        this.ws = ws;
    }

    public void windowCreated(final SimpleWindow window) {
        ws.requestRepaint();
    }

    //draw titlebar
    public void drawTitleBar(SimpleWindow window, char status) {
        //set titlebar attributes starting/ending x,y coordinates
        window.getTitlebar().setsX(window.getRelativeX());
        window.getTitlebar().setsY(window.getRelativeY() - (titleBarSize - 2));
        window.getTitlebar().seteX(window.getRelativeX() + window.getWidth());
        window.getTitlebar().seteY(window.getRelativeY());

        //check status active/inactive window
        if (status == 'i') {
            //if inactive shades of gray
            ws.setColor(palette.gray());
            fillComponent(window.getTitlebar()); //use attributes/coordinates to fill
            ws.setColor(palette.black());
            drawComponent(window.getTitlebar()); //use attributes/coordinates to draw
            this.drawCloseButton(window, 'i');
            this.drawMinimizeButton(window, 'i'); //draw close button
            this.writeTitle(window); //write title string

        } else if (status == 'a') {
            //if active colors
            ws.setColor(palette.darkPurple());
            fillComponent(window.getTitlebar()); //use attributes/coordinates to fill  
            drawComponent(window.getTitlebar());
            this.drawCloseButton(window, 'a');
            this.drawMinimizeButton(window, 'a'); //draw close button
            this.writeTitle(window); //write title string
        }
    }

    // Writes Title String
    public void writeTitle(SimpleWindow window) {
        ws.setColor(palette.lightGray());
        String title = window.getTitle();
        title = title.length() < Math.round((window.getWidth()) / 8) ? title : title.substring(0, (int) Math.round((window.getWidth()) / 8)) + "...";

        ws.drawString(title, window.getRelativeX() + 8, window.getRelativeY() + 16 - (titleBarSize - 2));
    }

    // Draws Close button
    public void drawCloseButton(SimpleWindow window, char status) {

        //set button attributes starting/ending x,y coordinates
        window.getCloseButton().setsX(window.getRelativeX() + window.getWidth() - 28);
        window.getCloseButton().setsY(window.getRelativeY() + 2 - (titleBarSize - 2));
        window.getCloseButton().seteX(window.getRelativeX() + window.getWidth() - 2);
        window.getCloseButton().seteY(window.getRelativeY());

        //check status active/inactive window
        if (status == 'a') {
            //if active colors
            ws.setColor(palette.salmon());
            fillComponent(window.getCloseButton()); //use attributes/coordinates to fill
            ws.setColor(palette.white()); 
            ws.drawString("X", window.getRelativeX() + window.getWidth() - 18, window.getRelativeY() + 16 - (titleBarSize - 2));
        } else {
            //if inactive gray
            ws.setColor(palette.darkGray());
            fillComponent(window.getCloseButton()); //use attributes/coordinates to fill
            ws.setColor(palette.black());
            drawComponent(window.getCloseButton()); //use attributes/coordinates to draw
            ws.setColor(palette.white());
            ws.drawString("X", window.getRelativeX() + window.getWidth() - 18, window.getRelativeY() + 16 - (titleBarSize - 2));
        }
    }

    // Draws Minimize button
    public void drawMinimizeButton(SimpleWindow window, char status) {

        //set button attributes starting/ending x,y coordinates
        window.getMinimizeButton().setsX(window.getRelativeX() + window.getWidth() - 58);
        window.getMinimizeButton().setsY(window.getRelativeY() + 2 - (titleBarSize - 2));
        window.getMinimizeButton().seteX(window.getRelativeX() + window.getWidth() - 30);
        window.getMinimizeButton().seteY(window.getRelativeY());

        //check status active/inactive window
        if (status == 'a') {
            //if active colors
            ws.setColor(palette.lightPurple());
            fillComponent(window.getMinimizeButton()); //use attributes/coordinates to fill 
            ws.setColor(palette.white());
            ws.drawString("_", window.getRelativeX() + window.getWidth() - 46, window.getRelativeY() + 13 - (titleBarSize - 2));

        } else {
            //if inactive gray
            ws.setColor(palette.darkGray());
            fillComponent(window.getMinimizeButton()); //use attributes/coordinates to fill
            ws.setColor(palette.black());
            drawComponent(window.getMinimizeButton()); //use attributes/coordinates to draw
            ws.setColor(palette.white());
            ws.drawString("_", window.getRelativeX() + window.getWidth() - 46, window.getRelativeY() + 13 - (titleBarSize - 2));
        }
    }

    // Draw dock
    public void drawDock() {
        //set dock attributes
        dock.setsX(0);
        dock.setsY((int) ws.desktopHeight - 40);
        dock.seteX((int) ws.desktopWidth);
        dock.seteY((int) ws.desktopHeight);
        ws.setColor(palette.alfaGray());
        ws.fillRect(dock.getsX(), dock.getsY(), dock.geteX(), dock.geteY()); //draw 
    }

    //Draw icon
    public void drawIcon(int pos) {
        //size and separation between icons
        int sizeIcon = (((int) ws.desktopWidth - 12) / dock.getIcons().size());
        sizeIcon = (sizeIcon > 200) ? 200 : sizeIcon;

        //set Icon attributes
        dock.getIcons().get(pos).setsX((pos) * sizeIcon + 10);
        dock.getIcons().get(pos).setsY((int) ws.desktopHeight - 35);
        dock.getIcons().get(pos).seteX(((pos) * sizeIcon) + sizeIcon);
        dock.getIcons().get(pos).seteY((int) ws.desktopHeight);

        ws.setColor(palette.gray());
        ws.fillRect(dock.getIcons().get(pos).getsX(),
                dock.getIcons().get(pos).getsY(), //use attributes to fill
                dock.getIcons().get(pos).geteX(),
                dock.getIcons().get(pos).geteY());
        ws.setColor(palette.black());
        ws.drawRect(dock.getIcons().get(pos).getsX(),
                dock.getIcons().get(pos).getsY(), //use attributes to draw
                dock.getIcons().get(pos).geteX(),
                dock.getIcons().get(pos).geteY());

        ws.setColor(palette.white());
        String title = dock.getIcons().get(pos).getParent().getTitle(); //match icon title with window title as well as belonging to it
        title = title.length() < Math.round(sizeIcon / 9) ? title : title.substring(0, Math.round(sizeIcon / 9)) + "...";

        int yDif = ((dock.getIcons().get(pos).geteY() - dock.getIcons().get(pos).getsY()) - 10);
        ws.drawString(title,
                dock.getIcons().get(pos).getsX() + 10,
                dock.getIcons().get(pos).getsY() + yDif);
    }

    //Fill component with FillRect method from super
    public void fillComponent(Component Comp) {
        ws.fillRect(
                Comp.getsX(),
                Comp.getsY(),
                Comp.geteX(),
                Comp.geteY());
    }

    //Draw component with drawRect method from super
    public void drawComponent(Component Comp) {
        ws.drawRect(
                Comp.getsX(),
                Comp.getsY(),
                Comp.geteX(),
                Comp.geteY());
    }

    // Set active windows
    public void setActiveWindow(SimpleWindow w) {
        /*
    	 * Remove object simpleWindow and re-add it to the list
    	 * becomes topmost object and the one in front
         */
        w.setVisible(true);
        ws.windows.remove(w);
        ws.windows.add(w);
    }

    /*
     * Set of flags for mouse actions/events as well as active window
     */
    private boolean mousePressed = false;
    private boolean mouseDragging = false;
    private SimpleWindow activeWindow = new SimpleWindow();

    int deltaX, deltaY;

    public void handleMouseDragged(int x, int y) {
        deltaX = ws.oldX - ws.currentX;
        deltaY = ws.oldY - ws.currentY;
        /*
         * If the pointes is inside desktop window, 
         * pressed and dragging inside selected window titlebar
         * detect coordinates and move window accordingly
         */
        //if ((x >= 0 && x < (ws.desktopWidth - 5)) && (y >= 0 && y < (ws.desktopHeight - 15))) {
        if (mousePressed && mouseDragging) {
            windowSetPosition(x, y, activeWindow);
        } else {
            SimpleWindow key = findWindow(x, y);
            if (ws.windows.contains(key) && isInsideComponent(x, y, key.getTitlebar())) {
                setActiveWindow(key);
                activeWindow = key;
                mouseDragging = true;
                windowSetPosition(x, y, key);
            }
        }
        //}
//        oldX = x;
//        oldY = y;
    }

    public void handleMousePressed(int x, int y) {
        deltaX = ws.oldX - ws.currentX;
        deltaY = ws.oldY - ws.currentY;
        mousePressed = true; //detects click
    }

    public void handleMouseReleased(int x, int y) {
        //update flags and active window
        mousePressed = false;
        mouseDragging = false; 
        activeWindow = new SimpleWindow();
        
    }

    public void handleMouseClicked(int x, int y) {
        deltaX = ws.oldX - ws.currentX;
        deltaY = ws.oldY - ws.currentY;
        //find active window and repaint if accrodingly
        SimpleWindow key = findWindow(x, y);
        if (ws.windows.contains(key)) {
            setActiveWindow(key);
            activeWindow = key;
            ws.requestRepaint();
            //if close button is pressed: delete window
            if (isInsideComponent(x, y, activeWindow.getCloseButton())) {
                ws.windows.remove(key);
                ws.requestRepaint();
            }
            //if min button is pressed: set icon and set visible window to false
            if (isInsideComponent(x, y, activeWindow.getMinimizeButton())) {
                key.setVisible(false);
                Component icon = new Component() {
                };
                icon.setParent(activeWindow);
                dock.addIcon(icon);
                ws.requestRepaint();
            }
        }
        //if icon is pressed: delete icon and repaint window
        if (isInsideComponent(x, y, dock)) {
            for (Component c : dock.getIcons()) {
                if (isInsideComponent(x, y, c)) {
                    activeWindow = c.getParent();
                    setActiveWindow(activeWindow);
                    dock.removeIcon(c);
                    ws.requestRepaint();
                    break;
                }
            }
        }
    }

    //Checks if pointer is inside Component
    public boolean isInsideComponent(int x, int y, Component comp) {
        //compares position by coordinates
        if ((x > comp.getsX() && x < comp.geteX())
                && (y > comp.getsY() - (titleBarSize) && y < comp.geteY())) {
            return true;
        }
        return false;
    }

    //Find specific window
    public SimpleWindow findWindow(int x, int y) {
        SimpleWindow window = new SimpleWindow();

        //iterate through collection of windows
        for (SimpleWindow w : ws.windows) {
            //compare by attributes and return window
            if ((w.getRelativeX() < x) && (w.getRelativeY() - (titleBarSize) < y)
                    && (w.getRelativeX() + w.getWidth() > x)
                    && (w.getRelativeY() + w.getHeight() > y)
                    && w.isVisible()) {
                window = w;
            }
        }
        return window;
    }

    //Set position of window
    public void windowSetPosition(int x, int y, SimpleWindow window) {
        window.setRelativeX((window.getRelativeX()-deltaX));
        window.setRelativeY((window.getRelativeY()-deltaY)); 
        ws.requestRepaint(); //repaint window 
    }

    protected void decorateWindow(SimpleWindow w) {
        //Draw stored windows 
        char status = 'i'; //active/inactive window flag 
        ws.drawWindow(w); //draw simple window in windowSystem
        if (w == activeWindow) {
            status = 'a';
        }
        this.drawTitleBar(w, status); //draw Titlebar and components 
    }

    protected void refreshDock() {
        drawDock(); //call draw dock
        for (int i = 0; i < dock.getIcons().size(); i++) {
            drawIcon(i); //call draw icons
        }
    }

}
