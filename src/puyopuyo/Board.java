package puyopuyo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;

public class Board extends JPanel{
	//private static final long serialVersionUID = 1278136335268310294L;

	Placar placar = new Placar();
		
	public void paintComponent(Graphics g2){
		super.paintComponent(g2);
		g2.setColor(Color.BLACK);
		// creates a solid stroke with line width is 2
		Stroke stroke = new BasicStroke(4f);
		((Graphics2D) g2).setStroke(stroke);
		g2.drawLine(252, 0, 252, 700);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("serif", Font.BOLD, 20));
			
		String score = Integer.toString(placar.getScore());
		g2.drawString("Score: " + score, 260, 20);
	}
 }
