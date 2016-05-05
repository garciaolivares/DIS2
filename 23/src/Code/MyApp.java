package Code;

/* Application Class
 * Creates windows (3 for this assignment)
 * */

public class MyApp {
	
	public static void main(String args[]){
		
		/*create object WindowManager that extends 
		 * WindowSystem that extends GraphicsEventSystem
		 * to create and draw rectangle (desktop)
		 */
		WindowManager wm = new WindowManager(1000, 600);

		//calls method addWindow to our buffer of SimpleWindow objects
        wm.addWindow(new SimpleWindow(10, 10, 1, 300, 100, "Window1"));
        wm.addWindow(new SimpleWindow(300, 120, 2, 300, 160, "Window2"));
        wm.addWindow(new SimpleWindow(400, 300, 3, 420, 220, "Window3"));
	}

}
