package puyopuyo;

import java.util.Random;

public class Maker {
	//private static final long serialVersionUID = 1278136335268310294L;
	int i,j;
	private Puyo puyos[][] = new Puyo[MAX_PUYOS][2];
	
	public static String DIRETORIO =
	         AppPuyo.class.getResource(".").getPath();
	
	final static int MAX_PUYOS = 6*12;
		
	//puyo colors
	final static int PURPLE   = 0;
	final static int RED    = 1;
	final static int YELLOW = 2;
	final static int GREEN  = 3;
	    
	final static int WIDTH = 42;
	final static int HEIGHT = 42;
		
	public Puyo[][] makePuyos() {
		Random rand = new Random();
		for(i=0; i<MAX_PUYOS/2; i++) {
			for(j=0; j<2; j++) {
				puyos[i][j] = new Puyo();
				int color = java.lang.Math.abs(rand.nextInt()%4);
				switch(color)  {
					case Puyo.PURPLE:
					    puyos[i][j].setColor(Puyo.PURPLE);
					    puyos[i][j].setImage("imagens/purple.png");
					    System.out.println("fez roxo");
					    break;
					case Puyo.RED:
					    puyos[i][j].setColor(Puyo.RED);
					    puyos[i][j].setImage("imagens/red.png");
					    System.out.println("fez verm");
					    break;
					case Puyo.YELLOW:
					    puyos[i][j].setColor(Puyo.YELLOW);
					    puyos[i][j].setImage("imagens/yellow.png");
					    System.out.println("fez amarelo");
					    break;
					case Puyo.GREEN:
					    puyos[i][j].setColor(Puyo.GREEN);
					    puyos[i][j].setImage("imagens/green.png");
					    System.out.println("fez verde");
					    break;
				}
			}
			
		}
		return puyos;
	}
}
