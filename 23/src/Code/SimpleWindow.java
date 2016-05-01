package Code;
public class SimpleWindow {

    private int locationX = 0; //attibute for position in x-axis
    private int locationY = 0; //attibute for position in y-axis
    private int locationZ = 0; //attibute for depth in z-axis

    public SimpleWindow(int x, int y, int z) {
        locationX = x;
        locationY = y;
        locationZ = z;
    }
    
    //getters and setters for x, y, and z position
    
    int getX() { 
        return locationX;
    }
	
    void setX(int x) {
        this.locationX = x;
    }

    int getY() {
        return locationY;
    }

    void setY(int y) {
        this.locationY = y;
    }

    int getZ() {
        return locationZ;
    }

    void setZ(int z) {
        this.locationZ = z;
    }

}
