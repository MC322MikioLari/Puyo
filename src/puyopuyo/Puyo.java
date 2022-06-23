package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Puyo extends JLabel implements ActionListener{ //,Runnable {
   //private static final long serialVersionUID = 4310667556938403035L;

   private int x, y, shiftX, shiftY, angulo, color, event;
   private boolean ativo, eliminado;
   Puyo PuyosProx[] ;
   
   final static int MAX_PUYOS = 7*12;
	
   //Puyo colors
   final static int PURPLE   = 0;
   final static int RED    = 1;
   final static int YELLOW = 2;
   final static int GREEN  = 3;
   
   final static int WIDTH = 42;
   final static int HEIGHT = 42;
   final static int widthWindow = 252;
   final static int heightWindow = 504;
   
   public Puyo(String arquivoImagem) {
      super(new ImageIcon(arquivoImagem));
      setSize(42, 42);
      this.x = 0;
      this.y = 0;
      this.angulo = 0;
      this.shiftX = 0;
      this.shiftY = 20;
      this.color = -1;
      this.PuyosProx = null;
      this.ativo = true;
      this.eliminado = false;
      this.event = 0;
   }


   public int getAngulo() {
	   return angulo;
   }

   public void setAngulo(int angulo) {
	   this.angulo = angulo;
   }
   
   public int getX() {
	   return x;
   }

   public void setX(int x) {
	   this.x = x;
   }

   public int getY() {
	   return y;
   }

   public void setY(int y) {
	   this.y = y;
   }
   
   public int getShiftX() {
	   return shiftX;
   }

   public void setShiftX(int shiftX) {
		this.shiftX = shiftX;
   }

   public int getShiftY() {
		return shiftY;
   }

   public void setShiftY(int shiftY) {
		this.shiftY = shiftY;
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
   
   public int getColor() {
    	return this.color;
   }
   
   public void setColor(int color) {
    	this.color = color;
   }
   
   public boolean isEliminado() {
		return eliminado;
   }

   public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
		//this.setImage(null);
   }
   
   public int getEvent() {
		return event;
   }

   public void setEvent(int event) {
		this.event = event;
   }
   public void Gira(Puyo p) {
	   if (p.getAngulo() == 0) {
			 this.setX(getX()-42);
		 	 this.setY(getY()-42);
		 	 p.angulo = 45;
		 }
		 else if (p.getAngulo() == 45) {
			 this.setX(getX()+42);
			 p.setY(getY()-42);
			 p.angulo = 90;
		 }
		 else if (p.getAngulo()==90) {
			 p.setX(getX()-42);
		 	 p.setY(getY()-42);
		 	 p.angulo = 135;
		 }
		 else if (p.getAngulo()==135) {
			 p.setX(getX()+42);
		 	 this.setY(getY()-42);
		 	 p.angulo = 135;
		 }
   }
 
	public void actionPerformed(ActionEvent evento) {
		setLocation(x+=shiftX, y+=shiftY);
		this.setShiftX(0);
		this.setShiftY(20);
		setLocation(x+=shiftX, y+=shiftY);
	}

}
