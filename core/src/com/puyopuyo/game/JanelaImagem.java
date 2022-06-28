package com.puyopuyo.game;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   //private static final long serialVersionUID = 1278136335268310294L;
   public Container painel;
   
   final static int MAX_PUYOS = 6*13;
   
   final static int widthTotal = 400;
   final static int widthWindow = 252;
   final static int heightWindow = 468;
   final static int WIDTH = widthWindow/7;
   final static int HEIGHT = widthWindow/7;
   final static int Celula = widthWindow/7;

   Maker maker = new Maker();
   
   Board panel = new Board();
   
   int i, j;
   
   public static String DIRETORIO =
	         AppPuyo.class.getResource(".").getPath();
   
   public JanelaImagem(Keyboard keyboard, Placar placar) {
      super();
      setSize(widthTotal, heightWindow);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
      
      panel.add(keyboard);
      add(panel);
	  panel.setLayout(null);
	  panel.setBackground(Color.white);
   }
   
   public void adicionaImagem(Puyo img) {
	   panel.add(img);
	   SwingUtilities.updateComponentTreeUI(panel);
   }
   
   public void GameOver() {
	   this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	   /*
	   ImageIcon icon = new ImageIcon(DIRETORIO+"GameOver.jpg");
	   panel.add(new JLabel(icon));
	   SwingUtilities.updateComponentTreeUI(panel);
	   //this.pack();*/
   }
   
}
