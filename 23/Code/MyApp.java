package Code;

/* Application Class
 * Creates windows 
 * */
public class MyApp {

    public static void main(String[] args) {

        /*create object WindowManager that extends 
		 * WindowSystem that extends GraphicsEventSystem
		 * to create and draw rectangle (desktop)
         */
        
        Palette palette = new Palette();
        
        int width = 1080;
        int height = 680;

        float calHeight = 0.5f;
        float calWidth = 0.2f;

        WindowSystem ws = new WindowSystem(width, height);

        //calls method addWindow to our buffer of SimpleWindow objects
        SimpleWindow calculator = new SimpleWindow(0.0f, 0.0f, calWidth, calHeight, "Calculator");

        float digitHeight = 1.0f / 5 + 0.001f;
        float digitWidth = 1.0f / 4;

        RATlabel _display = new RATbutton(0.0f, 0.0f, 1.0f, digitHeight, "");
        _display.setBackgraoundColor(palette.white());

        RATbutton _7 = new RATbutton(0.0f, digitHeight, digitWidth, digitHeight, "7");
         _7.setBackgraoundColor(palette.lightGray());
        RATbutton _8 = new RATbutton(digitWidth, digitHeight, digitWidth, digitHeight, "8");
        _8.setBackgraoundColor(palette.lightGray());
        RATbutton _9 = new RATbutton(digitWidth * 2, digitHeight, digitWidth, digitHeight, "9");
        _9.setBackgraoundColor(palette.lightGray());
        RATbutton _slash = new RATbutton(digitWidth * 3, digitHeight, digitWidth, digitHeight, "/");
        _slash.setBackgraoundColor(palette.orange());

        RATbutton _4 = new RATbutton(0.0f, digitHeight * 2, digitWidth, digitHeight, "4");
        _4.setBackgraoundColor(palette.lightGray());
        RATbutton _5 = new RATbutton(digitWidth, digitHeight * 2, digitWidth, digitHeight, "5");
        _5.setBackgraoundColor(palette.lightGray());
        RATbutton _6 = new RATbutton(digitWidth * 2, digitHeight * 2, digitWidth, digitHeight, "6");
        _6.setBackgraoundColor(palette.lightGray());
        RATbutton _asterick = new RATbutton(digitWidth * 3, digitHeight * 2, digitWidth, digitHeight, "*");
        _asterick.setBackgraoundColor(palette.orange());

        RATbutton _1 = new RATbutton(0.0f, digitHeight * 3, digitWidth, digitHeight, "1");
        _1.setBackgraoundColor(palette.lightGray());
        RATbutton _2 = new RATbutton(digitWidth, digitHeight * 3, digitWidth, digitHeight, "2");
        _2.setBackgraoundColor(palette.lightGray());
        RATbutton _3 = new RATbutton(digitWidth * 2, digitHeight * 3, digitWidth, digitHeight, "3");
        _3.setBackgraoundColor(palette.lightGray());
        RATbutton _minus = new RATbutton(digitWidth * 3, digitHeight * 3, digitWidth, digitHeight, "-");
        _minus.setBackgraoundColor(palette.orange());

        RATbutton _0 = new RATbutton(0.0f, digitHeight * 4, digitWidth, digitHeight, "0");
        _0.setBackgraoundColor(palette.lightGray());
        RATbutton _dot = new RATbutton(digitWidth, digitHeight * 4, digitWidth, digitHeight, ".");
        _dot.setBackgraoundColor(palette.lightGray());
        RATbutton _equal = new RATbutton(digitWidth * 2, digitHeight * 4, digitWidth, digitHeight, "=");
        _equal.setBackgraoundColor(palette.orange());
        RATbutton _plus = new RATbutton(digitWidth * 3, digitHeight * 4, digitWidth, digitHeight, "+");
        _plus.setBackgraoundColor(palette.orange());

        calculator.add(_display);

        calculator.add(_7);
        calculator.add(_8);
        calculator.add(_9);
        calculator.add(_slash);

        calculator.add(_4);
        calculator.add(_5);
        calculator.add(_6);
        calculator.add(_asterick);

        calculator.add(_1);
        calculator.add(_2);
        calculator.add(_3);
        calculator.add(_minus);

        calculator.add(_0);
        calculator.add(_dot);
        calculator.add(_equal);
        calculator.add(_plus);

        ws.addWindow(calculator);

    }

}
