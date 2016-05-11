/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author David
 */
public class Component {
     private int sX = 0; //attibute for starting position in x-axis
    private int sY = 0; //attibute for starting position in y-axis
    private int eX = 0; //attibute for ending position in x-axis
    private int eY = 0; //attibute for ending position in y-axis 
    private SimpleWindow parent; //simple window object
    
    //constructors
    public Component(){
    }
    
    public Component( SimpleWindow parent){
        this.parent = parent;
    }

    /*
     * Set and get for all attributes and components
     */
  //getters and setters for starting x-position
    public int getsX() {
        return sX;
    }

    public void setsX(int sX) {
        this.sX = sX;
    }

  //getters and setters for starting y-position
    public int getsY() {
        return sY;
    }

    public void setsY(int sY) {
        this.sY = sY;
    }

  //getters and setters for ending x-position
    public int geteX() {
        return eX;
    }

    public void seteX(int eX) {
        this.eX = eX;
    }

  //getters and setters for ending y-position
    public int geteY() {
        return eY;
    }

    public void seteY(int eY) {
        this.eY = eY;
    }

    //return parent window (in case of icon)
    public SimpleWindow getParent() {
        return parent;
    }

  //set parent window (in case of icon)
    public void setParent(SimpleWindow parent) {
        this.parent = parent;
    }
    
    
}
