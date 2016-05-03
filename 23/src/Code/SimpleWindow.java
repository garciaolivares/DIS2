package Code;

public class SimpleWindow {

    private int locationX = 0; //attibute for position in x-axis
    private int locationY = 0; //attibute for position in y-axis
    private int locationZ = 0; //attibute for depth in z-axis
    private int width = 0; //attribute for window's width
    private int height = 0; //attribute for window's height

    public SimpleWindow(int xPosition, int yPosition, int zDepth) {
        locationX = xPosition;
        locationY = yPosition;
        locationZ = zDepth;
    }

    public SimpleWindow(int xPosition, int yPosition, int zDepth, int width, int height) {
        locationX = xPosition;
        locationY = yPosition;
        locationZ = zDepth;
        this.width = width;
        this.height = height;
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

}

