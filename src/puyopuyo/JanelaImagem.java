package puyopuyo;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   private static final long serialVersionUID = 1278136335268310294L;
   private Container painel;

   public JanelaImagem() {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      visual();
   }
    
   public void visual() {
      setSize(350, 600);

      painel = getContentPane();
      painel.setLayout(new BorderLayout());
      
      setVisible(true);
   }
   
   public void background(String arquivoImagem) {
	   ImageIcon imagem = new ImageIcon(arquivoImagem);
	   JLabel campoImagem = new JLabel(imagem);
	   painel.add(campoImagem);
	   SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void adicionaImagem(ImagemAnimada img) {
      painel.add(img);
      SwingUtilities.updateComponentTreeUI(this);
   }
}
