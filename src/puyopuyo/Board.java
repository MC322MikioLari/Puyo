package puyopuyo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	public Board() {
		  BufferedImage backbuffer = new BufferedImage(175, 300,BufferedImage.TYPE_INT_RGB);
		  Graphics2D g2 = (Graphics2D)backbuffer.getGraphics();
		  super.paintComponent(g2);
	}
	public void paintComponent(Graphics g2){
		g2.setColor(Color.BLACK);
		// creates a solid stroke with line width is 2
		Stroke stroke = new BasicStroke(4f);
		((Graphics2D) g2).setStroke(stroke);
		g2.drawLine(270, 0, 270, 600);
	}
	/*
	public void SetBackgroundColorInJLabel() {
	        // sets the background color of this component
	        // the background color is used only if the component is opaque
	        label.setBackground(Color.BLUE);
	 
	        // add label to frame
	        add(label);
	 
	    }*/
}

