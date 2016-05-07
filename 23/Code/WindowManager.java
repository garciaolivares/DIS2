

/* WindowManages Class
 * Look and feel window and its components
 * mouse actions/events
 * */

//initialization
public class WindowManager extends WindowSystem {

    public WindowManager(int i, int j) {
        super(i, j);
        super.setBackground(palette.lightBlue());
    }
    
    //draw titlebar
    public void drawTitleBar(SimpleWindow window, char status) {
    	
    	//set titlebar attributes starting/ending x,y coordinates
        window.getTitlebar().setsX(window.getRelativeX());
        window.getTitlebar().setsY(window.getRelativeY());
        window.getTitlebar().seteX(window.getRelativeX() + window.getWidth());
        window.getTitlebar().seteY(window.getRelativeY() + 22);
        
        //check status active/inactive window
        if (status == 'i') {
        	//if inactive shades of gray
            super.setColor(palette.gray());
            super.fillRect(
                    window.getTitlebar().getsX(), //use attributes/coordinates to fill
                    window.getTitlebar().getsY(),
                    window.getTitlebar().geteX(),
                    window.getTitlebar().geteY());
            super.setColor(palette.black());
            super.drawRect(
                    window.getTitlebar().getsX(), //use attributes/coordinates to draw
                    window.getTitlebar().getsY(),
                    window.getTitlebar().geteX(),
                    window.getTitlebar().geteY());
            this.drawCloseButton(window, 'i'); //draw close button
            this.writeTitle(window); //write title string

        } else if (status == 'a') {
        	//if active colors
            super.setColor(palette.green());
            super.fillRect(
                    window.getTitlebar().getsX(), //use attributes/coordinates to fill
                    window.getTitlebar().getsY(),
                    window.getTitlebar().geteX(),
                    window.getTitlebar().geteY());
            super.setColor(palette.black());
            super.drawRect(
                    window.getTitlebar().getsX(), //use attributes/coordinates to draw
                    window.getTitlebar().getsY(),
                    window.getTitlebar().geteX(),
                    window.getTitlebar().geteY());
            this.drawCloseButton(window, 'a'); //draw close button
            this.writeTitle(window); // write title string

        }

    }

    // Writes Title String
    public void writeTitle(SimpleWindow window) {
        super.setColor(palette.lightGray());
        super.drawString(window.getTitle(), window.getRelativeX() + 8, window.getRelativeY() + 16);
    }
    
    // Draws Close button
    public void drawCloseButton(SimpleWindow window, char status) {
    	
    	//set button attributes starting/ending x,y coordinates
        window.getCloseButton().setsX(window.getRelativeX() + window.getWidth() - 28);
        window.getCloseButton().setsY(window.getRelativeY() + 2);
        window.getCloseButton().seteX(window.getRelativeX() + window.getWidth() - 2);
        window.getCloseButton().seteY(window.getRelativeY() + 20);
        
      //check status active/inactive window
        if (status == 'a') {
        	//if active colors
            super.setColor(palette.red());
            super.fillRect(
                    window.getCloseButton().getsX(), //use attributes/coordinates to fill
                    window.getCloseButton().getsY(),
                    window.getCloseButton().geteX(),
                    window.getCloseButton().geteY());
            super.setColor(palette.black());
            super.drawRect(
                    window.getCloseButton().getsX(), //use attributes/coordinates to draw
                    window.getCloseButton().getsY(),
                    window.getCloseButton().geteX(),
                    window.getCloseButton().geteY());
            super.setColor(palette.white());
            super.drawString("X", window.getRelativeX() + window.getWidth() - 18, window.getRelativeY() + 16);

        } else {
        	//if inactive gray
            super.setColor(palette.darkGray());
            super.fillRect(
                    window.getCloseButton().getsX(), //use attributes/coordinates to fill
                    window.getCloseButton().getsY(),
                    window.getCloseButton().geteX(),
                    window.getCloseButton().geteY());
            super.setColor(palette.black());
            super.drawRect(
                    window.getCloseButton().getsX(), //use attributes/coordinates to draw
                    window.getCloseButton().getsY(),
                    window.getCloseButton().geteX(),
                    window.getCloseButton().geteY());
            super.setColor(palette.white());
            super.drawString("X", window.getRelativeX() + window.getWidth() - 18, window.getRelativeY() + 16);
        }
    }

    // Set active windows
    public void setActiveWindow(SimpleWindow w) {
    	/*
    	 * Remove object simpleWindow and re-add it to the list
    	 * becomes topmost object and the one in front
    	 */
        windows.remove(w);
        windows.add(w);
    }
    
    //Checks if pointer is inside Titlebar
    public boolean isInsideTitleBar(int x, int y, SimpleWindow w) {
    	
    	//compares position by coordinates
        if ((x > w.getTitlebar().getsX() && x < w.getTitlebar().geteX())
                && (y > w.getTitlebar().getsY() && y < w.getTitlebar().geteY())) {
            return true;
        }
        return false;
    }

    //Checks if pointer is inside button
    public boolean isInsideCloseButton(int x, int y, SimpleWindow w) {

    	//compares position by coordinates
        if ((x > w.getCloseButton().getsX() && x < w.getCloseButton().geteX())
                && (y > w.getCloseButton().getsY() && y < w.getCloseButton().geteY())) {
            return true;
        }
        return false;
    }

    /*
     * Set of flags for mouse actions/events as well as active window
     */
    private boolean mousePressed = false;
    private boolean mouseDragging = false;
    private SimpleWindow activeWindow = new SimpleWindow();
    

    @Override
    public void handleMouseDragged(int x, int y) {
        
        /*
         * If the pointes is inside desktop window, 
         * pressed and dragging inside selected window titlebar
         * detect coordinates and move window accordingly
         */
        if ((x>=0 && x<(desktopWidth-5))&&(y>=0 && y<(desktopHeight-10))){
	        if (mousePressed && mouseDragging) {
	            windowSetPosition(x, y, activeWindow);
	        } else {
	            SimpleWindow key = findWindow(x, y);
	            if (windows.contains(key) && isInsideTitleBar(x, y, key)) {
	                setActiveWindow(key);
	                activeWindow = key;
	                mouseDragging = true;
	                windowSetPosition(x, y, key);
	            }
	        }
        }
    }

    @Override
    public void handleMousePressed(int x, int y) {
        mousePressed = true; //detects click

    }

    @Override
    public void handleMouseReleased(int x, int y) {
    	//update flags and active window
        mousePressed = false; 
        mouseDragging = false;
        activeWindow = new SimpleWindow();

    }

    @Override
    public void handleMouseClicked(int x, int y) {
        
        //find active window and repaint if accrodingly
        SimpleWindow key = findWindow(x, y);
        if (windows.contains(key)) {
            setActiveWindow(key);
            activeWindow = key;
            requestRepaint();
            //if close button is pressed: delete window
            if (isInsideCloseButton(x, y, activeWindow)) {
                windows.remove(key);
                requestRepaint();
            }
        }

    }

    //Find specific window
    public SimpleWindow findWindow(int x, int y) {
        SimpleWindow window = new SimpleWindow();
        
        //iterate through collection of windows
        for (SimpleWindow w : windows) {
        	//compare by attributes and return window
            if ((w.getRelativeX() < x) && (w.getRelativeY() < y)
                    && (w.getRelativeX() + w.getWidth() > x)
                    && (w.getRelativeY() + w.getHeight() > y)) {
                window = w;
            }
        }
        return window;
    }

    //Recalculate relative coordinates of position of window after it is dragged
    public void windowSetPosition(int x, int y, SimpleWindow window) {
    	
    //Set position in X
        if (x > this.desktopWidth) {
            window.setAbsoluteX((float)(this.desktopWidth/desktopWidth));
        } else if (x < 0) {
            window.setAbsoluteX(0.0f);
        } else {
        	float absX= (float)(x/desktopWidth);
            window.setAbsoluteX(absX);
        }
        
        //Set position in Y
        if (y > this.desktopHeight) {
            window.setAbsoluteY((float)(this.desktopWidth/desktopWidth));
        } else if (y < 0) {
            window.setAbsoluteY(0.0f);
        } else {
        	float absY= (float)(y/desktopHeight);
            window.setAbsoluteY(absY);       
        }
        
        requestRepaint(); //repaint window
    }

    @Override
    protected void handlePaint() {
        super.setBackground(palette.lightBlue());
        //Draw stored windows 

        char status = 'i'; //active/inactive window flag
        for (SimpleWindow w : windows) {
            super.drawWindow(w); //draw simple window in windowSystem

            if (w == activeWindow) {
                status = 'a';
            }
            this.drawTitleBar(w, status); //draw Titlebar and components
        }
    }

}