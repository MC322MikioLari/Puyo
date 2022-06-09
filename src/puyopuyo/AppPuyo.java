package puyopuyo;

public class AppPuyo {
	final static int MAX_PUYOS = 6*12;
	
	// tecnica para identificar o diretorio em que a classe esta
	public static String DIRETORIO =
         AppPuyo.class.getResource(".").getPath();
   
    public static void main(String[] args) {

       JanelaImagem janela = new JanelaImagem();
       
       Metronomo metro = new Metronomo(1000, 10);
       
       for (int i = 0; i < MAX_PUYOS/2; i++) {
     	  ImagemAnimada[] animado =janela.sendPuyos(i);
     	  metro.addActionListener(animado[0]);
     	  metro.addActionListener(animado[1]);
     	  janela.adicionaImagem(animado[0]);
     	  janela.adicionaImagem(animado[1]);
     	  metro.start();
       	  try {
 			Thread.sleep(7000);
       	  } 
       	  catch (InterruptedException e) {
 			System.out.println(e);
       	  }
       	  System.out.println("Inseriu Puyo");
       }
   }
}
