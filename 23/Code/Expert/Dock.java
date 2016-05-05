package Code.Expert;
import java.util.ArrayList;

/* Dock Class
 *  Define the Dock and its attributes 
 *  Component: Icon (when window is minimized)
 * */
public class Dock extends Component {

    private int width = 0; //attibute for width 
    private int height = 0; //attibute for height
    private ArrayList<Component> currentIcons = new ArrayList<Component>(); //arraylist of icons

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
    public void addIcon(Component c) {
        this.currentIcons.add(c);
    }

    public void removeIcon(Component c) {
        this.currentIcons.remove(c);
    }

    //return specific icon
    public ArrayList<Component> getIcons() {
        return this.currentIcons;
    }
}
