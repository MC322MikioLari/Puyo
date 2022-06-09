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
   ImagemAnimada[] animado = new ImagemAnimada[2];
   Puyo[][] p = maker.makePuyos();
   Board panel = new Board();
   
   int i, j;
   
   public static String DIRETORIO =
	         AppPuyo.class.getResource(".").getPath();
   
   public JanelaImagem() {
      super();
      setSize(WIDTH, HEIGHT);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //visual();
      setLocationRelativeTo(null);
      setBackground(Color.white);
      setVisible(true);
  
      add(panel);
      panel.setLayout(null);
   }

   public ImagemAnimada[] sendPuyos(int i) {
	   animado[0] = new ImagemAnimada(DIRETORIO + p[i][0].getImage(), 126, -50, 42, 42, 0, 60);
	   animado[1] = new ImagemAnimada(DIRETORIO + p[i][1].getImage(), 126, -25, 42, 42, 0, 60);
	   return animado;
   }
   
   public void adicionaImagem(ImagemAnimada img) {
	   panel.add(img);
	   SwingUtilities.updateComponentTreeUI(panel);
   }
   /*
   public void adicionaImagem(String img) {
	   ImageIcon imagem = new ImageIcon(img);
	   JLabel campoImagem = new JLabel(imagem);
	   painel.add(campoImagem);
	   SwingUtilities.updateComponentTreeUI(this);
   }
   */
   
}
