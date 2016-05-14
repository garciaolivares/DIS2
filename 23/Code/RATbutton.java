/*RATbutton class 
 * Initialize a button, set attributes of color,position,size and text
 * implements RATmouseListener for events (when clicked)
 * */

public abstract class RATbutton extends RATlabel implements RATmouseListener{

	//Constructor
    public RATbutton(float sX, float sY, float eX, float eY, String text) {
        super(sX, sY, eX, eY, text);
        this.setBorderColor(new Palette().black());
        this.setBackgraoundColor(new Palette().gray());
    }

    //Performance when clicked
    @Override
    public abstract void performance();  
}
