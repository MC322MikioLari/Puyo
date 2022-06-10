package puyopuyo;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class Puyo extends Componentes{
	
	final static int MAX_PUYOS = 6*12;
	
	//puyo colors
    final static int PURPLE   = 0;
    final static int RED    = 1;
    final static int YELLOW = 2;
    final static int GREEN  = 3;
    
    final static int WIDTH = 42;
    final static int HEIGHT = 42;
    final static int widthWindow = 252;
    final static int heightWindow = 504;
    
    private int color, posX, posY;
    private String img;
    private int x, y;
    private ImagemAnimada animado;
    
    public static String DIRETORIO =
	         AppPuyo.class.getResource(".").getPath();
    
    public Puyo() {
    	this.posX = 0;
		this.posY = 0;
		this.color = 0;
		this.img = "";
		this.animado =  new ImagemAnimada("", 0, -50, 42, 42, 0, 60);
    }

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
		animado.setShiftX(posX);
		animado.move();
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
		animado.setY(posY);
	}
    public void setColor(int color) {
    	this.color = color;
    }
    public int getColor() {
    	return this.color;
    }
    public void setImage(String img) {
    	this.img = img;
    	this.setAnimado(new ImagemAnimada(DIRETORIO + this.getImage(), 0, -50, 42, 42, 0, 60));
    }
    public String getImage() {
    	return this.img;
    }
    public ImagemAnimada getAnimado() {
		return animado;
	}

	public void setAnimado(ImagemAnimada animado) {
		this.animado = animado;
	}
	
    public void Movimento(String comando) {
    	if (comando == "S")
    		if (getPosY() + 30 < heightWindow)
    			setPosY(getPosY()+30);
    	else if (comando == "A")
    		if (getPosX()-30 > 0)
    			setPosX(getPosX()-30);
    	else if (comando == "D")
    		if (getPosX()+30 < widthWindow)
    			setPosX(getPosX()+30);
    }
    public void Gira() {
    	
    }

}
