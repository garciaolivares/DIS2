package Code;

public class MyApp {

    public static void main(String[] args) {

        WindowManager wm = new WindowManager(1000, 600);

        wm.addWindow(new SimpleWindow(10, 10, 1, 300, 100, "W1"));
        wm.addWindow(new SimpleWindow(300, 120, 2, 300, 100, "W2"));
        wm.addWindow(new SimpleWindow(400, 300, 3, 300, 100, "W3"));
    }
}
