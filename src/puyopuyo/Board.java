package puyopuyo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Board extends JPanel{
	int i,j;
	private Puyo puyos[][] = new Puyo[MAX_PUYOS][2];
	
	final static int MAX_PUYOS = 6*12;
	
	//puyo colors
    final static int BLUE   = 0;
    final static int RED    = 1;
    final static int YELLOW = 2;
    final static int GREEN  = 3;
    
    final static int WIDTH = 42;
    final static int HEIGHT = 42;
	
	public Board() {
		
	}
	
	public void paintBoard(Graphics g2){
		super.paintComponent(g2);
		g2.setColor(Color.BLACK);
		// creates a solid stroke with line width is 2
		Stroke stroke = new BasicStroke(4f);
		((Graphics2D) g2).setStroke(stroke);
		g2.drawLine(252, 0, 252, 700);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("serif", Font.BOLD, 20));
		g2.drawString("Score: ", 260, 20);
		System.out.println("Entrou");
	}
	
	public Puyo[][] createPuyos() {
		Random rand = new Random();
		for(i=0; i<MAX_PUYOS/2; i++) {
			for(j=0; j<2; j++) {
				puyos[i][j] = new Puyo();
				int color = java.lang.Math.abs(rand.nextInt()%4);
				switch(color)  {
					case Puyo.BLUE:
					    puyos[i][j].setColor(Puyo.BLUE);
					    puyos[i][j].setImage("imagens/blue.png");
					    System.out.println("fez azul");
					    break;
					case Puyo.RED:
					    puyos[i][j].setColor(Puyo.RED);
					    puyos[i][j].setImage("imagens/red.png");
					    System.out.println("fez verm");
					    break;
					case Puyo.YELLOW:
					    puyos[i][j].setColor(Puyo.YELLOW);
					    puyos[i][j].setImage("imagens/yellow.png");
					    System.out.println("fez amarelo");
					    break;
					case Puyo.GREEN:
					    puyos[i][j].setColor(Puyo.GREEN);
					    puyos[i][j].setImage("imagens/green.png");
					    System.out.println("fez verde");
					    break;
				}
			}
			
		}
		return puyos;
	}
}

