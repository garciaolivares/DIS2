package Code;

/* Expert Class
 * Used for the calculator
 * */

public class ExpertApp  {

    public static void main(String[] args) {

        /*create object WindowSystem that extends GraphicsEventSystem
		 * to create and draw desktop
		 * create an object calculator window and add it to our desktop via windowSystem
         */
        int width = 1080;
        int height = 680;
        WindowSystem ws = new WindowSystem(width, height);
        Calculator cal = new Calculator(0.1f, 0.1f, 0.22f, 0.5f, "Hello World Graphical");
        cal.setWS(ws);
        ws.addWindow(cal);
        

    }

}
