package Code;

/* Simple Window class
 * Collection of Windows and its properties
 * */

public class SimpleWindow {

    private int locationX = 0; //attibute for position in x-axis
    private int locationY = 0; //attibute for position in y-axis
    private int locationZ = 0; //attibute for depth in z-axis
    private int width = 0; //attribute for window's width
    private int height = 0; //attribute for window's height
    private String title = ""; //attribute for window's title
    
    private Component titlebar = new Component(); //titlebar component of the window
    private Component closeButton = new Component();//close button component of the window
    
    /*
     * Set of constructors
     */
    
    //empty constructor
    public SimpleWindow(){}
    
    //constructor with x,y and z coordinates
    public SimpleWindow(int xPosition, int yPosition, int zDepth) {
        locationX = xPosition;
        locationY = yPosition;
        locationZ = zDepth;
    }

  //constructor with x,y and z coordinates as well as parameters for width and height
    public SimpleWindow(int xPosition, int yPosition, int zDepth, int width, int height) {
        this.locationX = xPosition;
        this.locationY = yPosition;
        this.locationZ = zDepth;
        this.width = width;
        this.height = height;
    }
    
  //constructor with x,y and z coordinates,parameters for width and height and Title name
    public SimpleWindow(int xPosition, int yPosition, int zDepth, int width, int height, String title) {
        this.locationX = xPosition;
        this.locationY = yPosition;
        this.locationZ = zDepth;
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    /*
     * Set and get for all attributes and components
     */
  //getters and setters for Title name
    String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    //getters and setters for x position
    int getX() {
        return locationX;
    }

    void setX(int x) {
        this.locationX = x;
    }

    //getters and setters for y position
    int getY() {
        return locationY;
    }

    void setY(int y) {
        this.locationY = y;
    }

    //getters and setters for z position
    int getZ() {
        return locationZ;
    }

    void setZ(int z) {
        this.locationZ = z;
    }

    //getters and setters for window's width
    void setWidth(int width) {
        this.width = width;
    }

    int getWidth() {
        return this.width;
    }

    //getters and setters for window's height
    void setHeight(int height) {
        this.height = height;
    }

    int getHeight() {
        return this.height;
    }
   
  //getters and setters for Component of Window: Title Bar
    public Component getTitlebar() {
        return titlebar;
    }

    public void setTitlebar(Component titlebar) {
        this.titlebar = titlebar;
    }

  //getters and setters for Component of Window: Title Bar
    public Component getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Component closeButton) {
        this.closeButton = closeButton;
    }

}