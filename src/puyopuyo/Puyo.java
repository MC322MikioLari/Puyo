package puyopuyo;


public class Puyo extends Componentes{
	
	//puyo colors
    final static int BLUE   = 0;
    final static int RED    = 1;
    final static int YELLOW = 2;
    final static int GREEN  = 3;
    
    final static int WIDTH = 32;
    final static int HEIGHT = 32;
    
    int color;
    
    public Puyo(int nFrames) {
    	super(nFrames);
    }
    
    public void setColor(int color) {
    	this.color = color;
    }
    
}
