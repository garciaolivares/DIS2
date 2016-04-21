import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class HelloWorldGraphical extends JFrame {

    private JButton german = new JButton("German");
    private JButton english = new JButton("English");
    private JButton french = new JButton("french");
    private JButton quit = new JButton("Beenden");
    private JLabel msgLabel = new JLabel("");;
    private JPanel controlPanel = new JPanel(new GridBagLayout());;
    private JPanel buttonPanel = new JPanel(new GridBagLayout());;
    private JPanel msgPanel = new JPanel(new GridBagLayout());;

    public HelloWorldGraphical() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Hello GUI");
        this.setLayout(new GridBagLayout());
        this.setSize(300, 300);

        GridBagConstraints constraints = new GridBagConstraints(); 
        
        //controlPanel
        constraints.weighty = 0.5;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(controlPanel, constraints);
        
        //msgPanel
        constraints.gridy = 1;
        constraints.weighty = 0.5;
        this.add(msgPanel, constraints); 
        
        //buttonPanel
        constraints.gridy = 2;
        constraints.weighty = 0.1;
        this.add(buttonPanel, constraints);

        //german
        constraints = new GridBagConstraints();
        german.setPreferredSize(new Dimension(140, 25));
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.insets = new Insets(10, 10, 10, 10);
        controlPanel.add(german, constraints);

        //english
        constraints.gridy = 1;
        english.setPreferredSize(new Dimension(140, 25));
        controlPanel.add(english, constraints);

        //french
        constraints.gridy = 2;
        french.setPreferredSize(new Dimension(140, 25));
        controlPanel.add(french, constraints);
         
        //msn
        msgLabel.setPreferredSize(new Dimension(140, 25));
        msgPanel.add(msgLabel, constraints);

        //quit
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        quit.setPreferredSize(new Dimension(140, 25));
        constraints.anchor = GridBagConstraints.EAST;
        buttonPanel.add(quit, constraints);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                if (e.getSource().equals(german)) {
                    msgLabel.setText("Guten Tag!");
                } else if (e.getSource().equals(english)) {
                    msgLabel.setText("Good day!");
                } else if (e.getSource().equals(french)) {
                    msgLabel.setText("Bon Jour!");
                } else {
                    System.exit(0);
                } 
            }
        };

        german.addActionListener(listener);
        english.addActionListener(listener);
        french.addActionListener(listener);
        quit.addActionListener(listener);
    }

    public static void main(String[] args) {
        HelloWorldGraphical app = new HelloWorldGraphical();
        app.setVisible(true);
    }
}
