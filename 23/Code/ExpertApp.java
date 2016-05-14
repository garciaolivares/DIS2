package Code;

public class ExpertApp  {

   

    public static void main(String[] args) {

        /*create object WindowManager that extends 
		 * WindowSystem that extends GraphicsEventSystem
		 * to create and draw rectangle (desktop)
         */
        int width = 1080;
        int height = 680;
        WindowSystem ws = new WindowSystem(width, height);
        Calculator cal = new Calculator(0.1f, 0.1f, 0.22f, 0.5f, "Hello World Graphical");
        cal.setWS(ws);
        ws.addWindow(cal);
        
        HelloWorldGraphical HWG = new HelloWorldGraphical(0.25f, 0.25f, 0.5f, 0.5f, "Hello World Graphical");
        HWG.setWS(ws);
        ws.addWindow(HWG);

    }

}
