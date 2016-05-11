package Code;

import java.awt.Color;

/* Application Class
 * Creates windows 
 * */
public class MyApp {

    public static void main(String[] args) {

        /*create object WindowManager that extends 
		 * WindowSystem that extends GraphicsEventSystem
		 * to create and draw rectangle (desktop)
         */
        WindowSystem ws = new WindowSystem(1080, 680);

        //calls method addWindow to our buffer of SimpleWindow objects
        SimpleWindow calculator = new SimpleWindow(0.3f, 0.2f, 0.2f, 0.4f, "Calculator");
        
        
        /*RATlabel l = new RATlabel(0.5f, 0.5f, 0.7f, 0.3f, "SOPAS");
        l.setFontColor(Color.red);
        l.setFontSize(20);
        l.setBorderColor(Color.yellow);
        */
         RATbutton b = new RATbutton(0.5f, 0.5f, 0.7f, 0.3f, "SOPAS2");
        b.setFontColor(Color.red);
        b.setFontSize(20);
        b.setBorderColor(Color.yellow);
        b.setBackgraoundColor(Color.darkGray);
        
        //calculator.add(l);
        calculator.add(b);
        
        
        ws.addWindow(calculator);
        
        
        

    }

}
