package code;

public class Component {
  
    private int sX = 0; //attibute for position in x-axis
    private int sY = 0;
    private int eX = 0; //attribute for window's width
    private int eY = 0; //attribute for window's height 
    
    public Component(){}

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

}
