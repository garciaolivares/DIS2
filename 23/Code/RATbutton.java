
package Code;

public abstract class RATbutton extends RATlabel implements RATmouseListener{

    public RATbutton(float sX, float sY, float eX, float eY, String text) {
        super(sX, sY, eX, eY, text);
        this.setBorderColor(new Palette().black());
        this.setBackgraoundColor(new Palette().gray());
    }

    @Override
    public abstract void performance();  
}
