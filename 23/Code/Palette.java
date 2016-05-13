package Code;
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
    private Color pink = new Color(191,37,71);
    private Color lightBlue = new Color(0,128,255);
    private Color lightGray = new Color(242,242,243);
    private Color darkGray = new Color(112,112,112);
    private Color trasparent = new Color(255,255,255,0);
    private Color orange = new Color(196,68,80);
    
  //Methods to call the value of a color from the other classes
    private Color purple = new Color(80,70,125);
    private Color darkPurple = new Color(42,45,60);
    private Color lightPurple = new Color(99,104,127);
    private Color salmon = new Color(196,68,80);
    private Color alfaGray = new Color(42,45,60,200);
    
    public Color purple(){  return purple; }
    public Color darkPurple(){  return darkPurple; }
    public Color lightPurple(){  return lightPurple; }
    public Color salmon(){  return salmon; }
    public Color alfaGray() {return alfaGray;}
    public Color transparent(){return trasparent;}
    public Color orange(){return orange;}
    
    
    public Color black(){  return black; }
    public Color white(){  return white; }
    public Color gray(){  return gray; }
    public Color blue(){  return blue; }
    public Color pink(){ return pink; }
    public Color lightGray(){  return lightGray; }
    public Color darkGray(){  return darkGray; }
    public Color lightBlue(){  return lightBlue; }
  

}