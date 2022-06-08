package puyopuyo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   private static final long serialVersionUID = 1278136335268310294L;
   private Container painel;
   
   final static int MAX_PUYOS = 6*12;
   
   final static int WIDTH = 400;
   final static int HEIGHT = 504;
   
   Board board = new Board();
   ImagemAnimada[] animado = new ImagemAnimada[2];
   Puyo[][] p = board.createPuyos();
   
   int i, j;
   
   public static String DIRETORIO =
	         AppPuyo.class.getResource(".").getPath();
   
   public JanelaImagem() {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      visual();
   }
    
   public void visual() {
      setSize(WIDTH, HEIGHT);
      
      painel = getContentPane();
      painel.setLayout(null);
      
      setBackground(Color.white);
      
      painel.add(board);
      
      setVisible(true);
   }
   
   public ImagemAnimada[] sendPuyos(int i) {
	   animado[0] = new ImagemAnimada(DIRETORIO + p[i][0].getImage(), 126, -50, 42, 42, 0, 60);
	   animado[1] = new ImagemAnimada(DIRETORIO + p[i][1].getImage(), 126, -25, 42, 42, 0, 60);
	   return animado;
   }
   
   public void paintComponent(Graphics g) {
	  super.paintComponents(g);
	  board.paintBoard(g);
   }
   
   public void adicionaImagem(ImagemAnimada img) {
	   painel.add(img);
	   SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void adicionaImagem(String img) {
	   ImageIcon imagem = new ImageIcon(img);
	   JLabel campoImagem = new JLabel(imagem);
	   painel.add(campoImagem);
	   SwingUtilities.updateComponentTreeUI(this);
   }
}
