package puyopuyo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   //private static final long serialVersionUID = 1278136335268310294L;
   public Container painel;
   
   final static int MAX_PUYOS = 6*12;
   
   final static int WIDTH = 400;
   final static int HEIGHT = 504;

   Maker maker = new Maker();
   
   Board panel = new Board();
   Keyboard keyboard = new Keyboard(new Puyo(""), new Puyo(""));
   
   int i, j;
   
   public static String DIRETORIO =
	         AppPuyo.class.getResource(".").getPath();
   
   public JanelaImagem() {
      super();
      setSize(WIDTH, HEIGHT);
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
   
}



















/*
panel.add(new ImagemAnimada(DIRETORIO + "imagens/purple.png", 0, 0, 42, 42, 0, 60));
panel.add(new ImagemAnimada(DIRETORIO + "imagens/red.png", 0, 40, 42, 42, 0, 60));
panel.add(new ImagemAnimada(DIRETORIO + "imagens/red.png", 0, 80, 42, 42, 0, 60));
SwingUtilities.updateComponentTreeUI(panel);*/
