/*RATwidget class 
 * Initialize the widget, set attributes of color,position,size and text
 * */

public abstract class RATwidget {

    private float sX = 0; //attibute for starting position in x-axis
    private float sY = 0; //attibute for starting position in y-axis
    private float width = 0;
    private float height = 0;

    @Override
    public String toString() {
        return "RATwidget{" + "sX=" + sX + ", sY=" + sY + ", width=" + width + ", height=" + height + '}';
    }

    //constructors
    public RATwidget(float sX, float sY, float width, float height) {
        this.sX = sX;
        this.sY = sY;
        this.width = width;
        this.height = height;
    }

    /*
     * Set and get for all attributes and components
     */
    public float getsX() {
        return sX;
    }

    public void setsX(float sX) {
        this.sX = sX;
    }

    public float getsY() {
        return sY;
    }

    public void setsY(float sY) {
        this.sY = sY;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
