package Code.Expert;

/* Application Class
 * Creates windows 
 * */
public class MyApp {
	
	public static void main(String[] args) {
			
		/*create object WindowManager that extends 
		 * WindowSystem that extends GraphicsEventSystem
		 * to create and draw rectangle (desktop)
		 */
	        WindowManager wm = new WindowManager(1080, 680);
	        
	      //calls method addWindow to our buffer of SimpleWindow objects
	        wm.addWindow(new SimpleWindow(0, 0, 1, 300, 100, "Window1 with a super ultra very very long title"));
	        wm.addWindow(new SimpleWindow(300, 120, 2, 300, 100, "Window2"));
	        wm.addWindow(new SimpleWindow(400, 300, 3, 300, 100, "Window3")); 
	        wm.addWindow(new SimpleWindow(800, 120, 2, 300, 100, "Window4"));
	        wm.addWindow(new SimpleWindow(600, 400, 3, 300, 100, "Window5"));
	         wm.addWindow(new SimpleWindow(700, 0, 1, 300, 100, "Window6"));
	        wm.addWindow(new SimpleWindow(500, 520, 2, 400, 100, "Window7 with a super ultra very very long title"));
	        wm.addWindow(new SimpleWindow(200, 700, 3, 600, 300, "Window8"));
	         
	    }

}
