package Code;

public class MyApp {
    public static void main(String[] args) {
       WindowSystem app = new WindowSystem(1000, 600);
       
       app.addWindow(10, 10, 300, 100);
       app.addWindow(300, 120, 300, 100);
       app.addWindow(400, 300, 300, 100);
     
    }
}
