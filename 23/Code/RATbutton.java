
package Code;

public class RATbutton extends RATlabel implements RATmouseListener{

    public RATbutton(int sX, int sY, int eX, int eY, String text) {
        super(sX, sY, eX, eY, text);
        this.setBorderColor(new Palette().black());
    }

    @Override
    public void mouseClicked(int x, int y) {
         
    }
    
}
