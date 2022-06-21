package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagemAnimada extends JLabel implements ActionListener {
   //private static final long serialVersionUID = 4310667556938403035L;

   private int x, y,
               shiftX, shiftY, angulo;
   
   final static int widthWindow = 252;
   final static int heightWindow = 504;
   
   public ImagemAnimada(String arquivoImagem, int x, int y,
                        int width, int height,
                        int shiftX, int shiftY) {
      super(new ImageIcon(arquivoImagem));
      setSize(width, height);
      this.x = x;
      this.y = y;
      setLocation(x, y);
      this.shiftX = shiftX;
      this.shiftY = shiftY;
      this.angulo = 0;
   }

   public int getAngulo() {
	   return angulo;
   }

   public void setAngulo(int angulo) {
	   this.angulo = angulo;
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

   public void move() {
      x += shiftX;
      y += shiftY;
      setLocation(x, y);
   }
   public void Left() {
	   if (x-30 > 0)
		   setLocation(x-30, y);
   }
   public void Right(){
	   if (x+30 < widthWindow)
		   setLocation(x+30, y);
   }
   public void Down(){
	   if (y + 30 < heightWindow)
		   setLocation(x, y+30);
   }
   public void Gira(ImagemAnimada a) {
	   if (a.getAngulo() == 0) {
			 this.setX(getX()-42);
		 	 this.setY(getY()-42);
		 	 a.angulo = 45;
		 }
		 else if (a.getAngulo() == 45) {
			 this.setX(getX()+42);
			 a.setY(getY()-42);
			 a.angulo = 90;
		 }
		 else if (a.getAngulo()==90) {
			 a.setX(getX()-42);
		 	 a.setY(getY()-42);
		 	 a.angulo = 135;
		 }
		 else if (a.getAngulo()==135) {
			 a.setX(getX()+42);
		 	 this.setY(getY()-42);
		 	 a.angulo = 135;
		 }
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

   public void actionPerformed(ActionEvent evento) {
	   move();
   }
}
