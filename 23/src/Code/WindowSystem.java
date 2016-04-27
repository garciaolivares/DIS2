package Code;
import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Color;

public class WindowSystem extends GraphicsEventSystem{
	
	double width, height;
	float StartX, StartY, EndX, EndY;
	
    public WindowSystem(int i, int j) {
        super(i, j);
        width = (double)i;
        height = (double)j;
        
    }
         
    @Override
    protected void handlePaint() {
    	
    	this.drawLine(0.2f, 0.3f, 0.8f, 0.7f);
    }
    
    public void drawLine(float StartX, float StartY, float EndX, float EndY){
    	
    	StartX= (float) (StartX * width);
    	StartY= (float) (StartY * height);
    	EndX= (float)(EndX * width);
    	EndY= (float)(EndY * height);	
    	super.setColor(Color.black);
    	super.drawLine(Math.round(StartX), Math.round(StartY), Math.round(EndX), Math.round(EndY));
    }
    
}
