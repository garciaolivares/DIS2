/* Hello World Graphical Class
 * Initialize the components
 * Call for the events
 * */
public class HelloWorldGraphical extends SimpleWindow {

	//Components/widgets
    RATlabel label;
    RATbutton english;
    RATbutton french;
    RATbutton german;
    RATbutton close;
    Palette palette;

    //Constructor of the window
    public HelloWorldGraphical(float xPosition, float yPosition, float width, float height, String title) {
        super(xPosition, yPosition, width, height, title);
        init();
    }

    /*
     * Initialize the components, create the widgets with their attributes, set color, size, text
     * Have action event called performance
     */
    public void init() {
        palette = new Palette();
        label = new RATlabel(0.35f, 0.58f, 0.3f, 0.15f, "");

        english = new RATbutton(0.35f, 0.1f, 0.3f, 0.15f, "ENGLISH") {
            @Override
            public void performance() {
                label.setText("Good Day!");
            }
        };

        french = new RATbutton(0.35f, 0.26f, 0.3f, 0.15f, "FRANCAIS") {
            @Override
            public void performance() {
                label.setText("Bonjour!");
            }
        };

        german = new RATbutton(0.35f, 0.42f, 0.3f, 0.15f, "DEUTSCH") {
            @Override
            public void performance() {
                label.setText("Guten Tag!");
            }
        };

        close = new RATbutton(0.69f, 0.84f, 0.3f, 0.15f, "CLOSE") {
            @Override
            public void performance() {
                closeWindow();
            }
        };

        //set color for the buttons
        english.setBackgraoundColor(palette.lightGray());
        german.setBackgraoundColor(palette.lightGray());
        french.setBackgraoundColor(palette.lightGray());
        label.setBackgraoundColor(palette.lightGray());

      //Add widgets to the window 
        this.add(label);
        this.add(english);
        this.add(german);
        this.add(french);
        this.add(close);
    }

    //action for button close
    public void closeWindow() {
        this.getWS().windows.remove(this);
    }

    /*create object WindowSystem that extends GraphicsEventSystem
	 * to create and draw desktop
	 * create an object HelloWorldGraphical window and add it to our desktop via windowSystem
     */
    public static void main(String[] args) {
        int width = 1080;
        int height = 680;
        WindowSystem ws = new WindowSystem(width, height);
        HelloWorldGraphical HWG = new HelloWorldGraphical(0.25f, 0.25f, 0.5f, 0.5f, "Hello World Graphical");
        HWG.setWS(ws);
        ws.addWindow(HWG);
    }
}
