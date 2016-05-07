

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
        wm.addWindow(new SimpleWindow(0.08f, 0.07f, 1, 0.2f, 0.2f, "Window1"));
        wm.addWindow(new SimpleWindow(0.2f, 0.2f , 2, 0.4f, 0.3f, "Window2"));
        wm.addWindow(new SimpleWindow(0.4f, 0.3f, 3, 0.3f, 0.5f, "Window3"));
	}

}
