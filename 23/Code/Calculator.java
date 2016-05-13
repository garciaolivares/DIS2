package Code;

public class Calculator {

    public String result = "";
    public String input = "";
    public Operator newOperation;
    public Operator previousOperation = Operator.EQUALS;
    public double lastValue = 0.0;
    public String status = "";
    public double displayValue = 0.0;

    
    public enum Operator{
    	EQUALS, PLUS, MINUS, MULTIPLY, DIVIDE;
    }
    
    public void operatorButtonPressed(Operator newOperation) {

            switch (previousOperation) {
                case PLUS:
                	input = "";
                    displayValue = lastValue + displayValue;
                    commitOperation(newOperation, displayValue);
                    break;
                case MINUS:
                	input = "";
                    displayValue = lastValue - displayValue;
                    commitOperation(newOperation, displayValue);
                    break;
                case MULTIPLY:
                	input = "";
                    displayValue = lastValue * displayValue;
                    commitOperation(newOperation, displayValue);
                    break;
                case DIVIDE:
                    if (displayValue == 0) {
                        setError();
                    } else {
                    	input = "";
                        displayValue = lastValue / displayValue;
                        commitOperation(newOperation, displayValue);
                    }
                    break;
                case EQUALS:
                   commitOperation(newOperation, displayValue);
        }
            
    }
    
    public void commitOperation(Operator operation, double result) {
        status = "FIRST";
        lastValue = result;
        previousOperation = operation;
        setResult(String.valueOf(result));
    }
    
    public void setResult(String result){
    	this.result = result;
    }
    public String getResult(){
    	return result;
    }
    
    public void setError() {
    	setResult("ERROR: Division by Zero");
    }
    
    public String appendValue(String val) {
        return input = input + val;
    }

}
