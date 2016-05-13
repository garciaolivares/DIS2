package Code;

public class HelloWorldGraphical extends SimpleWindow {

    RATlabel label;
    RATbutton english;
    RATbutton french;
    RATbutton german;
    RATbutton close;
    Palette palette;

    private HelloWorldGraphical(float xPosition, float yPosition, float width, float height, String title) {
        super(xPosition, yPosition, width, height, title);
        init();
    }

    public void init() {
        palette = new Palette();
        label = new RATlabel(0.35f, 0.58f, 0.3f, 0.15f, "");

        english = new RATbutton(0.35f, 0.1f, 0.3f, 0.15f, "ENGLISH") {
            @Override
            public void performance() {
                label.setText("Good Day!");
            }
        };

        french = new RATbutton(0.35f, 0.26f, 0.3f, 0.15f, "FRENCH") {
            @Override
            public void performance() {
                label.setText("Bonjour!");
            }
        };

        german = new RATbutton(0.35f, 0.42f, 0.3f, 0.15f, "GERMAN") {
            @Override
            public void performance() {
                label.setText("Guten Tag");
            }
        };

        close = new RATbutton(0.69f, 0.84f, 0.3f, 0.15f, "CLOSE") {
            @Override
            public void performance() {
                System.exit(0);
            }
        };

        english.setBackgraoundColor(palette.lightGray());
        german.setBackgraoundColor(palette.lightGray());
        french.setBackgraoundColor(palette.lightGray());
        label.setBackgraoundColor(palette.lightGray());

        this.add(label);
        this.add(english);
        this.add(german);
        this.add(french);
        this.add(close);
    }

    public static void main(String[] args) {
        int width = 1080;
        int height = 680;
        WindowSystem ws = new WindowSystem(width, height); 
        ws.addWindow(new HelloWorldGraphical(0.25f, 0.25f, 0.5f, 0.5f, "Calculator")); 
    }
}
