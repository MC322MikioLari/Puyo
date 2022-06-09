package puyopuyo;

import java.util.Scanner;

public class AppPuyo {
	final static int MAX_PUYOS = 6*12;
	
	// tecnica para identificar o diretorio em que a classe esta
	public static String DIRETORIO =
         AppPuyo.class.getResource(".").getPath();
   
    public static void main(String[] args) {

       JanelaImagem janela = new JanelaImagem();
    
       Metronomo metro = new Metronomo(1000, 10);
       
       Maker maker = new Maker();
       Puyo[][] p = maker.makePuyos();
       
       Controle control = new Controle();
       
       for (int i = 0; i < MAX_PUYOS/2; i++) {
    	   for (int j = 0; j < MAX_PUYOS/2; j++) {
    		   if (j == 1)
    			   p[i][j].setPosY(-25);
	     	  ImagemAnimada animado = p[i][j].animado;
	     	  metro.addActionListener(animado);
	     	  janela.adicionaImagem(animado);
	     	  metro.start();
	       	  try {
	 			Thread.sleep(7000);
	       	  } 
	       	  catch (InterruptedException e) {
	 			System.out.println(e);
	       	  }
	       	  System.out.println("Inseriu Puyo");
	       }
	       try (Scanner leitor = new Scanner(System.in)) {
	    	   String comando = leitor.next();
			   control.executa(comando);
	       }
       }
   }
}
