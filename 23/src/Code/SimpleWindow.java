package Code;
public class SimpleWindow {

    private int locationX = 0;
    private int locationY = 0;
    private int locationZ = 0;

    public SimpleWindow(int x, int y, int z) {
        locationX = x;
        locationY = y;
        locationZ = z;
    }

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
