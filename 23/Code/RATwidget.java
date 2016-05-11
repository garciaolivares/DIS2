
package Code;

public abstract class RATwidget{
    
    private float sX = 0; //attibute for starting position in x-axis
    private float sY = 0; //attibute for starting position in y-axis
    private float eX = 0; //attibute for ending position in x-axis
    private float eY = 0; //attibute for ending position in y-axis 
    
    //constructors
    public RATwidget(float sX, float sY, float eX, float eY){
        this.setsX(sX);
        this.setsY(sY);
        this.seteX(eX);
        this.seteY(eY);
    }

    /*
     * Set and get for all attributes and components
     */
  //getters and setters for starting x-position
    public float getsX() {
        return sX;
    }

    public void setsX(float sX) {
        this.sX = sX;
    }

  //getters and setters for starting y-position
    public float getsY() {
        return sY;
    }

    public void setsY(float sY) {
        this.sY = sY;
    }

  //getters and setters for ending x-position
    public float geteX() {
        return eX;
    }

    public void seteX(float eX) {
        this.eX = eX;
    }

  //getters and setters for ending y-position
    public float geteY() {
        return eY;
    }

    public void seteY(float eY) {
        this.eY = eY;
    }    
    
}

