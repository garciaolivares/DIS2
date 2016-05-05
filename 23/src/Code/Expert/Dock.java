package Code.Expert;

import java.util.ArrayList;

public class Dock extends Component {

    private int width = 0;
    private int height = 0;
    private ArrayList<Component> currentIcons = new ArrayList<Component>();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addIcon(Component c) {
        this.currentIcons.add(c);
    }

    public void removeIcon(Component c) {
        this.currentIcons.remove(c);
    }

    public ArrayList<Component> getIcons() {
        return this.currentIcons;
    }
}
