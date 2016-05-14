
/* Calculator Class
 * Initialize the components
 * Do the operations
 * */

public class Calculator extends SimpleWindow {

    public enum Operator {
        EQUALS, PLUS, MINUS, MULTIPLY, DIVIDE;
    }
    //Set of buttons
    private RATlabel _display;
    private RATbutton _7;
    private RATbutton _8;
    private RATbutton _9;
    private RATbutton _slash;
    private RATbutton _4;
    private RATbutton _5;
    private RATbutton _6;
    private RATbutton _star;
    private RATbutton _1;
    private RATbutton _2;
    private RATbutton _3;
    private RATbutton _minus;
    private RATbutton _0;
    private RATbutton _dot;
    private RATbutton _equal;
    private RATbutton _plus;
    
    //Set of variables used in operations and calculations
    public String result = "0.0";
    public String input = "";
    public Operator newOperation;
    public Operator previousOperation = Operator.EQUALS;
    public double lastValue = 0.0;
    public int status = 0;
    public double displayValue = 0.0;
    
    //Set of attributes for the components of the calculator
    Palette palette = new Palette();
    float calHeight = 0.5f;
    float calWidth = 0.2f;
    float digitHeight = 1.0f / 5 ;
    float digitWidth = 1.0f / 4;

    //constructor of the window
    public Calculator(float xPosition, float yPosition, float width, float height, String title) {
        super(xPosition, yPosition, width, height, title);
        init();
    }

    /*
     * Initialize the components, create the widgets with their attributes, set color, size, text
     * Performance: action/response to when clicked
     */
    public void init() {
        _display = new RATlabel(0.0f, 0.0f, 1.0f, digitHeight, "0");
        _display.setBackgraoundColor(palette.white());
        _display.setBorderColor(palette.black());

        _7 = new RATbutton(0.0f, digitHeight, digitWidth, digitHeight, "7") {
            @Override
            public void performance() {
                String val = appendValue("7");
                _display.setText(val);
                status = 1;
            }
        };
        _7.setBackgraoundColor(palette.lightGray());

        _8 = new RATbutton(digitWidth, digitHeight, digitWidth, digitHeight, "8") {
            @Override
            public void performance() {
                String val = appendValue("8");
                _display.setText(val);
                status = 1;
            }
        };
        _8.setBackgraoundColor(palette.lightGray());

        _9 = new RATbutton(digitWidth * 2, digitHeight, digitWidth, digitHeight, "9") {
            @Override
            public void performance() {
                String val = appendValue("9");
                _display.setText(val);
                status = 1;
            }
        };
        _9.setBackgraoundColor(palette.lightGray());

        _slash = new RATbutton(digitWidth * 3, digitHeight, digitWidth, digitHeight, "/") {
            @Override
            public void performance() {
                displayValue = Double.parseDouble(_display.getText());
                input = "";
                operatorButtonPressed(Operator.DIVIDE);
                _display.setText(getResult());
                status = 0;
            }
        };
        _slash.setBackgraoundColor(palette.pink());

        _4 = new RATbutton(0.0f, digitHeight * 2, digitWidth, digitHeight, "4") {
            @Override
            public void performance() {
                String val = appendValue("4");
                _display.setText(val);
                status = 1;
            }
        };
        _4.setBackgraoundColor(palette.lightGray());

        _5 = new RATbutton(digitWidth, digitHeight * 2, digitWidth, digitHeight, "5") {
            @Override
            public void performance() {
                String val = appendValue("5");
                _display.setText(val);
                status = 1;
            }
        };
        _5.setBackgraoundColor(palette.lightGray());

        _6 = new RATbutton(digitWidth * 2, digitHeight * 2, digitWidth, digitHeight, "6") {
            @Override
            public void performance() {
                String val = appendValue("6");
                _display.setText(val);
                status = 1;
            }
        };
        _6.setBackgraoundColor(palette.lightGray());

        _star = new RATbutton(digitWidth * 3, digitHeight * 2, digitWidth, digitHeight, "*") {
            @Override
            public void performance() {
                displayValue = Double.parseDouble(_display.getText());
                input = "";
                operatorButtonPressed(Operator.MULTIPLY);
                _display.setText(getResult());
                status = 0;
            }
        };
        _star.setBackgraoundColor(palette.pink());

        _1 = new RATbutton(0.0f, digitHeight * 3, digitWidth, digitHeight, "1") {
            @Override
            public void performance() {
                String val = appendValue("1");
                _display.setText(val);
                status = 1;
            }
        };
        _1.setBackgraoundColor(palette.lightGray());

        _2 = new RATbutton(digitWidth, digitHeight * 3, digitWidth, digitHeight, "2") {
            @Override
            public void performance() {
                String val = appendValue("2");
                _display.setText(val);
                status = 1;
            }
        };
        _2.setBackgraoundColor(palette.lightGray());

        _3 = new RATbutton(digitWidth * 2, digitHeight * 3, digitWidth, digitHeight, "3") {
            @Override
            public void performance() {
                String val = appendValue("3");
                _display.setText(val);
                status = 1;
            }
        };
        _3.setBackgraoundColor(palette.lightGray());

        _minus = new RATbutton(digitWidth * 3, digitHeight * 3, digitWidth, digitHeight, "-") {
            @Override
            public void performance() {
                displayValue = Double.parseDouble(_display.getText());
                input = "";
                operatorButtonPressed(Operator.MINUS);
                _display.setText(getResult());
                status = 0;
            }
        };
        _minus.setBackgraoundColor(palette.pink());

        _0 = new RATbutton(0.0f, digitHeight * 4, digitWidth, digitHeight, "0") {
            @Override
            public void performance() {
                String val = appendValue("0");
                _display.setText(val);
                status = 1;
            }
        };
        _0.setBackgraoundColor(palette.lightGray());

        _dot = new RATbutton(digitWidth, digitHeight * 4, digitWidth, digitHeight, ".") {
            @Override
            public void performance() {
                String val = appendValue(".");
                _display.setText(val);
            }
        };
        _dot.setBackgraoundColor(palette.lightGray());

        _equal = new RATbutton(digitWidth * 2, digitHeight * 4, digitWidth, digitHeight, "=") {
            @Override
            public void performance() {
                displayValue = Double.parseDouble(_display.getText());
                input = "";
                operatorButtonPressed(Operator.EQUALS);
                _display.setText(getResult());
            }
        };
        _equal.setBackgraoundColor(palette.pink());

        _plus = new RATbutton(digitWidth * 3, digitHeight * 4, digitWidth, digitHeight, "+") {
            @Override
            public void performance() {
                displayValue = Double.parseDouble(_display.getText());
                input = "";
                operatorButtonPressed(Operator.PLUS);
                _display.setText(getResult());
                status = 0;
            }
        };
        _plus.setBackgraoundColor(palette.pink());

        //Add widgets to the window calculator
        this.add(_display);

        this.add(_7);
        this.add(_8);
        this.add(_9);
        this.add(_slash);

        this.add(_4);
        this.add(_5);
        this.add(_6);
        this.add(_star);

        this.add(_1);
        this.add(_2);
        this.add(_3);
        this.add(_minus);

        this.add(_0);
        this.add(_dot);
        this.add(_equal);
        this.add(_plus);

    }

    //Do the operations accordingly Add, Substraction, Multiplication, Division and Equals
    public void operatorButtonPressed(Operator newOperation) {
    	if (status!=0){
	        switch (previousOperation) {
	            case PLUS:
	                displayValue = lastValue + displayValue;
	                commitOperation(newOperation, displayValue);
	                break;
	            case MINUS:
	                displayValue = lastValue - displayValue;
	                commitOperation(newOperation, displayValue);
	                break;
	            case MULTIPLY:
	                displayValue = lastValue * displayValue;
	                commitOperation(newOperation, displayValue);
	                break;
	            case DIVIDE:
	                if (displayValue == 0) {
	                    setError();
	                } else {
	                    displayValue = lastValue / displayValue;
	                    commitOperation(newOperation, displayValue);
	                }
	                break;
	            case EQUALS:
	                commitOperation(newOperation, displayValue);
	        }
    	}
    	
    }

    //Append operations and set result accordingly
    public void commitOperation(Operator operation, double result) {
        lastValue = result;
        previousOperation = operation;
        setResult(String.valueOf(result));
    }

    //Setter and getter of the result
    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    //Error for division
    public void setError() {
        setResult("ERROR: Division by Zero");
    }

    //Append the numbers introduce in calculator before an operator is selected
    public String appendValue(String val) {
        return input = input + val;
    }
}
