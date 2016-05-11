package Code;

import java.awt.Color;

public class RATlabel extends RATwidget {

    public enum Typeface {
        PLAIN,
        BOLD,
        CURSIVE,
        ITALIC,
    }

    private Palette palette = new Palette();
    private Color backgraoundColor = palette.white();
    private Color borderColor = palette.transparent();
    private Color fontColor = palette.black();
    private String font = "Heveltica";
    private Typeface typeFace = Typeface.PLAIN;
    private int fontSize = 12;
    private String text = "";

    public RATlabel(int sX, int sY, int eX, int eY, String text) {
        this.setsX(sX);
        this.setsY(sY);
        this.seteX(eX);
        this.seteY(eY);
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

    public Typeface getTypeFace() {
        return typeFace;
    }

    public void setTypeFace(Typeface typeFace) {
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
