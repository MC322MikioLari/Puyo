package puyopuyo;

import java.awt.event.KeyEvent;
import java.util.Arrays;

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
    
    private int color, posX, posY, angulo;
    private boolean ativo, eliminado;

	Puyo PuyosProx[] ;
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
		this.angulo = 0;
		this.PuyosProx = null; //ele mesmo
		this.ativo = true;
		this.eliminado = false;
    }

	public Puyo[] getPuyosProx() {
		return PuyosProx;
	}

	public void setPuyosProx(Puyo[] puyosProx) {
		System.arraycopy(puyosProx, 0, this.PuyosProx, this.PuyosProx.length, puyosProx.length);
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}
	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
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
	 public void Gira(Puyo p) {
		 if (p.getAngulo() == 0) {
			 this.setPosX(this.getPosX()-42);
		 	 this.setPosY(this.getPosY()-42);
		 	 p.angulo = 45;
		 }
		 else if (p.getAngulo() == 45) {
			 this.setPosX(this.getPosX()+42);
			 p.setPosY(p.getPosY()-42);
			 p.angulo = 90;
		 }
		 else if (p.getAngulo()==90) {
			 p.setPosX(p.getPosX()-42);
		 	 p.setPosY(p.getPosY()-42);
		 	 p.angulo = 135;
		 }
		 else if (p.getAngulo()==135) {
			 p.setPosX(p.getPosX()+42);
		 	 this.setPosY(this.getPosY()-42);
		 	 p.angulo = 135;
		 }
	 }
}

