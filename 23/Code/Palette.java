
import java.awt.Color;

/*Palette class 
 * Define colors to be used by components and attributes of the desktop and windows
 * */

public class Palette {
	
	//Colors with specified RGB values in the range (0 - 255)
    private Color black = new Color(0,0,0);
    private Color white = new Color(255,255,255);
    private Color gray = new Color(128,128,128);
    private Color blue = new Color(43,79,137);
    private Color red = new Color(255,102,102);
    private Color yellow = new Color(255,153,51);
    private Color pink = new Color(255,0,128);
    private Color green = new Color(72,216,168);
    private Color lightBlue = new Color(0,128,255);
    private Color lightGray = new Color(228,228,228);
    private Color darkGray = new Color(112,112,112);
    
    
    //Methods to call the value of a color from the other classes
    public Color black(){  return black; }
    public Color white(){  return white; }
    public Color gray(){  return gray; }
    public Color blue(){  return blue; }
    public Color red(){ return red; }
    public Color yellow(){ return yellow; }
    public Color pink(){ return pink; }
    public Color green(){ return green; }
    public Color lightGray(){  return lightGray; }
    public Color darkGray(){  return darkGray; }
    public Color lightBlue(){  return lightBlue; }
  
}
