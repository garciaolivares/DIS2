

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
	        wm.addWindow(new SimpleWindow(0.0f, 0.0f, 1, 0.3f, 0.2f, "Window1 with a super ultra very very long title"));
	        wm.addWindow(new SimpleWindow(0.3f, 0.12f, 2, 0.25f, 0.15f, "Window2"));
	        wm.addWindow(new SimpleWindow(0.4f, 0.3f, 3, 0.25f, 0.15f, "Window3")); 
	        wm.addWindow(new SimpleWindow(0.8f, 0.12f, 2, 0.25f, 0.15f, "Window4"));
	        wm.addWindow(new SimpleWindow(0.6f, 0.4f, 3, 0.25f, 0.15f, "Window5"));
	        wm.addWindow(new SimpleWindow(0.7f, 0.0f, 1, 0.25f, 0.15f, "Window6"));
	        wm.addWindow(new SimpleWindow(0.5f, 0.5f, 2, 0.25f, 0.15f, "Window7 with a super ultra very very long title"));
	        wm.addWindow(new SimpleWindow(0.2f, 0.7f, 3, 0.25f, 0.25f, "Window8"));
	         
	    }

}
