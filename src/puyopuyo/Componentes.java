package puyopuyo;

import javax.swing.JLabel;

public class Componentes extends JLabel {
	
	private int posX, posY, color;
	private String img;
	
    public Componentes(){
    	this.posX = 0;
		this.posY = 0;
		this.color = 0;
		this.img = "";
    }
}