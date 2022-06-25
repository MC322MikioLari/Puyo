package puyopuyo;

public class AppPuyo{
	final static int MAX_PUYOS = 7*13;
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	final static int WIDTH = widthWindow/7;
	final static int HEIGHT = widthWindow/7;
	final static int Celula = widthWindow/7;
	
	// tecnica para identificar o diretorio em que a classe esta
	public static String DIRETORIO =
         AppPuyo.class.getResource(".").getPath();
	
	public static Maker maker = new Maker();
	public static int i, j;
	public static Puyo[][] p = maker.makePuyos();
	public static Notifier metro = new Notifier(1000, 10);
	public static Keyboard keyboard = new Keyboard(metro);
    public static Remove removePuyos = new Remove(p, metro);
	
	public static void main(String[] args) {
	    JanelaImagem janela = new JanelaImagem(keyboard);
	    
	    for (i = 0; i < MAX_PUYOS/2; i++) {
	    	   for (j = 0; j < 2; j++) {   
	    		   if (j == 1)
	    			   p[i][j].setY(-Celula);
	    		   p[i][j].setStatus("A");
	    		   p[i][j].setId(i*10+j);
	    		   p[i][j].link(p);
		     	   p[i][j].metro.addActionListener(p[i][j]);
		     	   janela.adicionaImagem(p[i][j]);
		     	   p[i][j].metro.start();
		       }
	    	   keyboard.link(p[i][0], p[i][1]);
	    	   keyboard.settingEvent();
	    	   metro.start();
	    	   try {
		 			Thread.sleep(10000);
		       	  } 
		       	  catch (InterruptedException e) {
		 			System.out.println(e);
		      }
	      }
    }

}
