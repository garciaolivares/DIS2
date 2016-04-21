import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class HelloWorldGraphical  {
    
   private JFrame mainFrame;
   private JLabel msgLabel;
   private JPanel controlPanel;
   private JPanel buttonPanel;
   private JPanel msgPanel;

   public HelloWorldGraphical(){
      loadGUI();
   }

   public static void main(String[] args){
      HelloWorldGraphical  hello = new HelloWorldGraphical();      
      hello.printMsg();
   }

   private void loadGUI(){
      mainFrame = new JFrame("Hello GUI");
      mainFrame.setSize(300,300);
      mainFrame.setLayout(new GridLayout(3,1,0,2));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    

      controlPanel = new JPanel();
      controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
      
      msgLabel = new JLabel("",JLabel.CENTER);    
     
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
      buttonPanel.add(Box.createHorizontalGlue());
      buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));

      JButton beenden = new JButton("Beenden");
      beenden.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }          
      });
      beenden.setAlignmentY(Component.BOTTOM_ALIGNMENT);
      buttonPanel.add(beenden);

      mainFrame.add(controlPanel);
      mainFrame.add(msgLabel);
      mainFrame.add(buttonPanel);
      mainFrame.setVisible(true);  
   }
    
   private void printMsg(){

      JButton deutsch = new JButton("Deutsch");        
      JButton english = new JButton("English");
      JButton francais = new JButton("Français");
      francais.setHorizontalTextPosition(SwingConstants.LEFT);   

      deutsch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            msgLabel.setText("Guten Tag!");
         }          
      });

      english.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            msgLabel.setText("Good Day!");
         }
      });

      francais.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            msgLabel.setText("Bon Jour!");
         }
      });

      deutsch.setAlignmentX(Component.CENTER_ALIGNMENT);
      english.setAlignmentX(Component.CENTER_ALIGNMENT);
      francais.setAlignmentX(Component.CENTER_ALIGNMENT);
      controlPanel.add(deutsch);
      controlPanel.add(english);
      controlPanel.add(francais);       

      mainFrame.setVisible(true);  
   }
}