package Code;
import java.util.ArrayList;

/* Dock Class
 *  Define the Dock and its attributes 
 *  Component: Icon (when window is minimized)
 * */
public class Dock extends RATwidget {

    private int width = 0; //attibute for width 
    private int height = 0; //attibute for height
    private ArrayList<RATwidget> currentIcons = new ArrayList<RATwidget>(); //arraylist of icons

    /*
     * Set and get for all attributes and components
     */
  //getters and setters for width
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

  //getters and setters for height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /*
     * Methods to manipulate icons
     */
    public void addIcon(RATwidget c) {
        this.currentIcons.add(c);
    }

    public void removeIcon(RATwidget c) {
        this.currentIcons.remove(c);
    }

    //return specific icon
    public ArrayList<RATwidget> getIcons() {
        return this.currentIcons;
    }
}
