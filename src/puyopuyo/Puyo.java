package puyopuyo;

import java.util.Random;

public class Puyo extends Componentes{
	
	final static int MAX_PUYOS = 6*12;
	
	//puyo colors
    final static int BLUE   = 0;
    final static int RED    = 1;
    final static int YELLOW = 2;
    final static int GREEN  = 3;
    
    final static int WIDTH = 42;
    final static int HEIGHT = 42;
    
    private int color, posX, posY;
    private String img;

    
    public Puyo() {
    	this.posX = 0;
		this.posY = 0;
		this.color = 0;
		this.img = "";
    }
    
    public void setColor(int color) {
    	this.color = color;
    }
    public int getColor() {
    	return this.color;
    }
    public void setImage(String img) {
    	this.img = img;
    }
    public String getImage() {
    	return this.img;
    }
}
