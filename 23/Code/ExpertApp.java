package Code;

import Code.Calculator.Operator;

/* Application Class
 * Creates Calculator
 * */
public class ExpertApp {


	public static void main(String[] args) {

        /*create object WindowManager that extends 
		 * WindowSystem that extends GraphicsEventSystem
		 * to create and draw rectangle (desktop)
         */
        
        Palette palette = new Palette();
        Calculator cal = new Calculator();
        
        int width = 1080;
        int height = 680;

        float calHeight = 0.5f;
        float calWidth = 0.2f;
        
        WindowSystem ws = new WindowSystem(width, height);

        //calls method addWindow to our buffer of SimpleWindow objects
        SimpleWindow calculator = new SimpleWindow(0.2f, 0.2f, calWidth, calHeight, "Calculator");

        float digitHeight = 1.0f / 5 + 0.001f;
        float digitWidth = 1.0f / 4;

        RATlabel _display = new RATlabel(0.0f, 0.0f, 1.0f, digitHeight, "");
        _display.setBackgraoundColor(palette.white());
        
        
        RATbutton _7 = new RATbutton(0.0f, digitHeight, digitWidth, digitHeight, "7") {
            @Override
            public void performance() {
                 String val = cal.appendValue("7");
                _display.setText(val); 
            }
        };
         _7.setBackgraoundColor(palette.lightGray()); 
         
        RATbutton _8 = new RATbutton(digitWidth, digitHeight, digitWidth, digitHeight, "8") {
            @Override
            public void performance() {
                String val = cal.appendValue("8");
                _display.setText(val);
            }
        };
        _8.setBackgraoundColor(palette.lightGray());
        
        RATbutton _9 = new RATbutton(digitWidth * 2, digitHeight, digitWidth, digitHeight, "9") {
            @Override
            public void performance() {
                String val = cal.appendValue("9");
                _display.setText(val);
            }
        };
        _9.setBackgraoundColor(palette.lightGray());
        
        RATbutton _slash = new RATbutton(digitWidth * 3, digitHeight, digitWidth, digitHeight, "/") {
            @Override
            public void performance() {
            	cal.displayValue = Double.parseDouble(_display.getText());
            	cal.input = "";
            	cal.operatorButtonPressed(Operator.DIVIDE);
                _display.setText(cal.getResult());
            }
        };
        _slash.setBackgraoundColor(palette.pink());

        RATbutton _4 = new RATbutton(0.0f, digitHeight * 2, digitWidth, digitHeight, "4") {
            @Override
            public void performance() {
                String val = cal.appendValue("4");
                _display.setText(val);
            }
        };
        _4.setBackgraoundColor(palette.lightGray());
        
        RATbutton _5 = new RATbutton(digitWidth, digitHeight * 2, digitWidth, digitHeight, "5") {
            @Override
            public void performance() {
                String val = cal.appendValue("5");
                _display.setText(val);
            }
        };
        _5.setBackgraoundColor(palette.lightGray());
        
        RATbutton _6 = new RATbutton(digitWidth * 2, digitHeight * 2, digitWidth, digitHeight, "6") {
            @Override
            public void performance() {
                String val = cal.appendValue("6");
                _display.setText(val);
            }
        };
        _6.setBackgraoundColor(palette.lightGray());
        
        RATbutton _star = new RATbutton(digitWidth * 3, digitHeight * 2, digitWidth, digitHeight, "*") {
            @Override
            public void performance() {
            	cal.displayValue = Double.parseDouble(_display.getText());
            	cal.input = "";
            	cal.operatorButtonPressed(Operator.MULTIPLY);
                _display.setText(cal.getResult());
            }
        };
        _star.setBackgraoundColor(palette.pink());

        RATbutton _1 = new RATbutton(0.0f, digitHeight * 3, digitWidth, digitHeight, "1") {
            @Override
            public void performance() {
                String val = cal.appendValue("1");
                _display.setText(val);
            }
        };
        _1.setBackgraoundColor(palette.lightGray());
        
        RATbutton _2 = new RATbutton(digitWidth, digitHeight * 3, digitWidth, digitHeight, "2") {
            @Override
            public void performance() {
                String val = cal.appendValue("2");
                _display.setText(val);
            }
        };
        _2.setBackgraoundColor(palette.lightGray());
        
        RATbutton _3 = new RATbutton(digitWidth * 2, digitHeight * 3, digitWidth, digitHeight, "3") {
            @Override
            public void performance() {
                String val = cal.appendValue("3");
                _display.setText(val);
            }
        };
        _3.setBackgraoundColor(palette.lightGray());
        
        RATbutton _minus = new RATbutton(digitWidth * 3, digitHeight * 3, digitWidth, digitHeight, "-") {
            @Override
            public void performance() { 
            	cal.displayValue = Double.parseDouble(_display.getText());
            	cal.input = "";
            	cal.operatorButtonPressed(Operator.MINUS);
                _display.setText(cal.getResult());
            }
        };
        _minus.setBackgraoundColor(palette.pink());

        RATbutton _0 = new RATbutton(0.0f, digitHeight * 4, digitWidth, digitHeight, "0") {
            @Override
            public void performance() {
                String val = cal.appendValue("0");
                _display.setText(val);
            }
        };
        _0.setBackgraoundColor(palette.lightGray());
        
        RATbutton _dot = new RATbutton(digitWidth, digitHeight * 4, digitWidth, digitHeight, ".") {
            @Override
            public void performance() {
               String val = cal.appendValue(".");
                _display.setText(val);
            }
        };
        _dot.setBackgraoundColor(palette.lightGray());
        
        RATbutton _equal = new RATbutton(digitWidth * 2, digitHeight * 4, digitWidth, digitHeight, "=") {
            @Override
            public void performance() { 
            	cal.displayValue = Double.parseDouble(_display.getText());
            	cal.input = "";
                cal.operatorButtonPressed(Operator.EQUALS);
                _display.setText(cal.getResult());
            }
        };
        _equal.setBackgraoundColor(palette.pink());
        
        RATbutton _plus = new RATbutton(digitWidth * 3, digitHeight * 4, digitWidth, digitHeight, "+") {
            @Override
            public void performance() {  
            	cal.displayValue = Double.parseDouble(_display.getText());
            	cal.input = "";
            	cal.operatorButtonPressed(Operator.PLUS);
                _display.setText(cal.getResult());
            }
        };
        _plus.setBackgraoundColor(palette.pink());

        
        calculator.add(_display);

        calculator.add(_7);
        calculator.add(_8);
        calculator.add(_9);
        calculator.add(_slash);

        calculator.add(_4);
        calculator.add(_5);
        calculator.add(_6);
        calculator.add(_star);

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
