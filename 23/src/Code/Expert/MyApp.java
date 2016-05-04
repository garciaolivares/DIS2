package code;

public class MyApp {

    public static void main(String[] args) {

        WindowManager wm = new WindowManager(1000, 600);

        wm.addWindow(new SimpleWindow(0, 0, 1, 300, 100, "Window1"));
        wm.addWindow(new SimpleWindow(300, 120, 2, 300, 100, "Window2"));
        wm.addWindow(new SimpleWindow(400, 300, 3, 300, 100, "Window3"));
         
    }
}
