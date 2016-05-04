package Code;

public class Component {

    class Type { 
        public static final int BUTTON = 1;
        public static final int TITLEBAR = 2; 
    } 
    
    SimpleWindow parent; 
    private int sX = 0; //attibute for position in x-axis
    private int sY = 0;
    private int eX = 0; //attribute for window's width
    private int eY = 0; //attribute for window's height
    private int type = 0;
    
    public Component(){}

    public Component(int x, int y, int w, int h, int type) {
        this.parent = parent;
    } 
    

    public SimpleWindow getParent() {
        return parent;
    }

    public void setParent(SimpleWindow parent) {
        this.parent = parent;
    }

    public int getsX() {
        return sX;
    }

    public void setsX(int sX) {
        this.sX = sX;
    }

    public int getsY() {
        return sY;
    }

    public void setsY(int sY) {
        this.sY = sY;
    }

    public int geteX() {
        return eX;
    }

    public void seteX(int eX) {
        this.eX = eX;
    }

    public int geteY() {
        return eY;
    }

    public void seteY(int eY) {
        this.eY = eY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    } 
    
     
}
