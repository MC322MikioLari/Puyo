package puyopuyo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   private static final long serialVersionUID = 1278136335268310294L;
   private Container painel;
   Graphics2D board;
   
   public JanelaImagem() {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      visual();
   }
    
   public void visual() {
      setSize(350, 600);

      painel = getContentPane();
      painel.setLayout(new BorderLayout());
      
      setBackground(Color.lightGray);
      
      painel.add(new Board());
      
      setVisible(true);
   }
   
   /*
   public void background(String arquivoImagem) {
	   ImageIcon imagem = new ImageIcon(arquivoImagem);
	   JLabel campoImagem = new JLabel(imagem);
	   painel.add(campoImagem);
	   SwingUtilities.updateComponentTreeUI(this);
   }
   */
   
   private void setOpacity(boolean b) {
	// TODO Auto-generated method stub
	
}

public void adicionaImagem(ImagemAnimada img) {
      painel.add(img);
      SwingUtilities.updateComponentTreeUI(this);
   }
}
