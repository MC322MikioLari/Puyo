package puyopuyo;

import java.awt.event.KeyEvent;

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
		/*
		animado.setShiftX(posX);
		animado.move();*/
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
    public int getColor() {
    	return this.color;
    }
    public void setColor(int color) {
    	this.color = color;
    }
    public String getImage() {
    	return this.img;
    }
    public void setImage(String img) {
    	this.img = img;
    	this.setAnimado(new ImagemAnimada(DIRETORIO + this.getImage(), 0, -50, 42, 42, 0, 60));
    }
    public ImagemAnimada getAnimado() {
		return animado;
	}
	public void setAnimado(ImagemAnimada animado) {
		this.animado = animado;
	}
	 public void Left() {
		   if (posX-30 > 0)
			   setPosX(posX-30);
	   }
	 public void Right(){
		if (posX+30 < widthWindow)
			 setPosX(posX+30);
	   }
	 public void Down(){
		if (posY + 30 < heightWindow)
			 setPosY(posY+30);
	   }
	 public void Gira() {
	   	
	 }
	 public void mover(int e) {
		if (e == KeyEvent.VK_RIGHT) {
			this.getAnimado().Right();
			this.Right();
		}
		else if (e == KeyEvent.VK_LEFT) {
			this.getAnimado().Left();
			this.Left();
		}
		else if (e == KeyEvent.VK_DOWN) {
			this.getAnimado().Down();
			this.Down();
		}
		else if (e == KeyEvent.VK_UP) {
			this.getAnimado().Gira();
			this.Gira();
		}
	}
}
