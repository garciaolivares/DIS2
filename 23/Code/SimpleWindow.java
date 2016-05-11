package Code;

import java.util.ArrayList;

/* Simple Window class
 * Collection of Windows and its properties
 * */
public class SimpleWindow {

    private float absoluteX = 0; // absolute coordinates
    private float absoluteY = 0;
    private float absoluteW = 0; // absolute size
    private float absoluteH = 0;
    private int relativeX = 0; // relative coordinates
    private int relativeY = 0;
    private int width = 0; // relative size
    private int height = 0;
    private String title = ""; //attribute for window's title
    private boolean visible = true; //flag to set visibility of window
    private ArrayList<RATwidget> widgets = new ArrayList<RATwidget>();

    private Component titlebar = new Component() {
    }; //titlebar component of the window
    private Component closeButton = new Component() {
    }; //close button component of the window
    private Component minimizeButton = new Component() {
    }; //minimize button component of the window
    private Component icon = new Component() {
    }; //icon component of the window (when is minimized)

    /*
     * Set of constructors
     */
    public SimpleWindow() {
    }

    public void add(RATwidget widget) {
        widgets.add(widget);
    }
    
    public ArrayList<RATwidget> getWidgets(){
        return this.widgets;
    }

    public SimpleWindow(float xPosition, float yPosition) {
        this.absoluteX = xPosition;
        this.absoluteY = yPosition;
    }

    public SimpleWindow(float xPosition, float yPosition, float width, float height) {
        this.absoluteX = xPosition;
        this.absoluteY = yPosition;
        this.absoluteW = width;
        this.absoluteH = height;
    }

    public SimpleWindow(float xPosition, float yPosition, float width, float height, String title) {
        this.absoluteX = xPosition;
        this.absoluteY = yPosition;
        this.absoluteW = width;
        this.absoluteH = height;
        this.title = title;
    }

    /*
     * Flag for visibility window
     */
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /*
     * Set and get for all attributes and components of the Window
     */
    String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getAbsoluteX() {
        return absoluteX;
    }

    public void setAbsoluteX(float absoluteX) {
        this.absoluteX = absoluteX;
    }

    public float getAbsoluteY() {
        return absoluteY;
    }

    public void setAbsoluteY(float absoluteY) {
        this.absoluteY = absoluteY;
    }

    public float getAbsoluteW() {
        return absoluteW;
    }

    public void setAbsoluteW(float absoluteW) {
        this.absoluteW = absoluteW;
    }

    public float getAbsoluteH() {
        return absoluteH;
    }

    public void setAbsoluteH(float absoluteH) {
        this.absoluteH = absoluteH;
    }

    public int getRelativeX() {
        return relativeX;
    }

    public void setRelativeX(int relativeX) {
        this.relativeX = relativeX;
    }

    public int getRelativeY() {
        return relativeY;
    }

    public void setRelativeY(int relativeY) {
        this.relativeY = relativeY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public Component getTitlebar() {
        return titlebar;
    }

    public void setTitlebar(Component titlebar) {
        this.titlebar = titlebar;
    }

    public Component getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Component closeButton) {
        this.closeButton = closeButton;
    }

    public Component getMinimizeButton() {
        return minimizeButton;
    }

    public void setMinimizeButton(Component minimizeButton) {
        this.minimizeButton = minimizeButton;
    }

    public Component getIcon() {
        return icon;
    }

    public void setIcon(Component icon) {
        this.icon = icon;
    }

}
