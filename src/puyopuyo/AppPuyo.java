package puyopuyo;

public class AppPuyo {
	final static int MAX_PUYOS = 6*12;
	
	// tecnica para identificar o diretorio em que a classe esta
	public static String DIRETORIO =
         AppPuyo.class.getResource(".").getPath();
	
	public static Maker maker = new Maker();
	public static int i, j;
	public static Puyo[][] p = maker.makePuyos();
    
	public static void main(String[] args) {
		
	    JanelaImagem janela = new JanelaImagem();
	    
	    Notifier metro = new Notifier(1000, 10);
	    
	    for (i = 0; i < MAX_PUYOS/2; i++) {
	    	   for (j = 0; j < 2; j++) {   
	    		   if (j == 1)
	    			   p[i][j].setPosY(-25);
		     	   ImagemAnimada animado = p[i][j].getAnimado();
		     	   janela.adicionaImagem(animado);
		     	   System.out.println("Inseriu Puyo");
		     	   metro.start();
		       }
	    	   Keyboard keyboard = new Keyboard(p[i][0], p[i][1]);
	    	   try {
		 			Thread.sleep(7000);
		       	  } 
		       	  catch (InterruptedException e) {
		 			System.out.println(e);
		      }
	      }
    } 

}
