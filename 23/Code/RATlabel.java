package Code;

import java.awt.Color;

public class RATlabel extends RATwidget {

   

    private Palette palette = new Palette();
    private Color backgraoundColor = palette.transparent();
    private Color borderColor = palette.transparent();
    private Color fontColor = palette.black();
    private String font = "Heveltica";
    private int typeFace = 0;
    private int fontSize = 12;
    private String text = "";

    public RATlabel(float sX, float sY, float eX, float eY, String text) {
        super(sX, sY, eX, eY);
        this.text = text;
    }

    public Color getBackgraoundColor() {
        return backgraoundColor;
    }

    public void setBackgraoundColor(Color backgraoundColor) {
        this.backgraoundColor = backgraoundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getTypeFace() {
        return typeFace;
    }

    public void setTypeFace(int typeFace) {
        this.typeFace = typeFace;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
