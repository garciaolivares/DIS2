package Code;

public class Calculator {

    public double buffer = 0.0;
    public String input = "";

    public String appendValue(String val) {
        return input = input + val;
    }

    public String Add() {
        buffer += Double.parseDouble(input);
        input = "";
        return Double.toString(buffer);
    }

    public String Division() {
        buffer /= Double.parseDouble(input);
        input = "";
        return Double.toString(buffer);
    }

    public String Multiplication() {
        buffer *= Double.parseDouble(input);
        input = "";
        return Double.toString(buffer);
    }

    public String Subtraction() {
        buffer -= Double.parseDouble(input);
        input = "";
        return Double.toString(buffer);
    }

    public String result() {
        return Double.toString(buffer);
    }

}
