

/* Component Class
 *  Define Components and its attributes 
 *  Component: Title Bar and Buttons are/can be used in the window
 * */

public class Component {
	  
    private int sX = 0; //attibute for starting position in x-axis
    private int sY = 0; //attibute for starting position in y-axis
    private int eX = 0; //attibute for ending position in x-axis
    private int eY = 0; //attibute for ending position in y-axis
    

    public Component(){}

    /*
     * Set and get for all attributes and components
     */
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