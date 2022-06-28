package puyopuyo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
	public static Notifier metro = Singleton.getInstance();
	public static Keyboard keyboard = new Keyboard(metro);
	public static Placar placar = new Placar();
	public static JanelaImagem janela = new JanelaImagem(keyboard, placar);
    public static Remove removePuyos = new Remove(p, metro, placar, janela);
    public static DescePuyo descePuyo = new DescePuyo(p, metro);
    static boolean gameOver = false;
    
	public static void main(String[] args) {
	    while (gameOver == false) {
	    	try {
	            AudioInputStream audioInputStream = 
	            		AudioSystem.getAudioInputStream(AppPuyo.class.getResource("assets/backgroundMusic.wav"));
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
	            clip.loop(Clip.LOOP_CONTINUOUSLY);
	            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 
	            // If you want to stop the sound, then use clip.stop();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		    for (i = 0; i < MAX_PUYOS/2; i++) {
	    		p[i][0].setY(Celula);
	    		janela.adicionaImagem(p[i][0]);
	    		janela.adicionaImagem(p[i][1]);
	    		try {
	    			Thread.sleep(1000);
			    } 
			    catch (InterruptedException e) {
			 		System.out.println(e);
			    }
		    	for (j = 0; j < 2; j++) {   
		    		p[i][j].setX(0);
		    		p[i][0].setY(-Celula);
		    		p[i][1].setY(-2*Celula);
		    		p[i][j].setStatus("A");
		    		p[i][j].setId(i*10+j);
		    		p[i][j].link(p);
			   }
		    	janela.adicionaImagem(p[i][0]);
		     	janela.adicionaImagem(p[i][1]);
		     	p[i][0].metro.addActionListener(p[i][0]);
		     	p[i][1].metro.addActionListener(p[i][1]);
		     	p[i][0].metro.start();
		     	p[i][1].metro.start();
		    	keyboard.link(p[i][0], p[i][1]);
		    	keyboard.settingEvent();
		    	metro.start();
		    	try {
			 		Thread.sleep(5000);
			    } 
			    catch (InterruptedException e) {
			 		System.out.println(e);
			    }
		    	if (p[i][1].getGameOver() == true || p[i][0].getGameOver() == true) {
		    		System.out.println("GAME OVER");
		    		gameOver = true;
		    		janela.GameOver();
		    	}
		    }
	    }
    }
}
