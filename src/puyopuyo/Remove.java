package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Remove implements ActionListener {
	final static int MAX_PUYOS = 7*13;
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	final static int WIDTH = widthWindow/7;
	final static int HEIGHT = widthWindow/7;
	final static int Celula = widthWindow/7;
	Puyo p[][];
	Puyo puyosProx[] = new Puyo [MAX_PUYOS];
	int k = 0;
	
	public Remove(Puyo p[][], Notifier metro) {
		this.p = p;
		metro.addActionListener(this);
	}
	
	public boolean PuyoInList(Puyo p, Puyo puyos[]){
		for(int i=0; i<MAX_PUYOS/2; i++) {
			if (puyos[i] != null && puyos[i].getStatus() != "D")
				if (puyos[i].getId() == p.getId())
					return true;
		}
		return false;
	}
	public Puyo[] findPuyos(Puyo p[][], int I, int J, int color) {
		int n = 0;
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "A" && !PuyoInList(p[i][j], puyosProx)) {
					if (p[i][j].getCelula().getJ() == p[I][J].getCelula().getJ() && (p[i][j].getCelula().getI() == p[I][J].getCelula().getI()-1 || p[i][j].getCelula().getI()== p[I][J].getCelula().getI()+1) &&  p[i][j].getColor() == color) {
							puyosProx[n] = p[i][j];
							n+=1;
							System.out.println("i: " + i + " j: " + j);
					}
					if (p[i][j].getCelula().getI() == p[I][J].getCelula().getI() && (p[i][j].getCelula().getJ() == p[I][J].getCelula().getJ()-1 || p[i][j].getCelula().getJ()== p[I][J].getCelula().getJ()+1) && p[i][j].getColor() == color) {
							puyosProx[n] = p[i][j];
							n+=1;
							System.out.println("i: " + i + " j: " + j);
					}
				}
			}
		}
		return puyosProx;
	}
	/*
	public void DescePuyo(Celula c, Puyo p[][]) {
		int J = c.getJ();
		int I = c.getI();
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() != "E" && p[i][j].getStatus() != "D") {
					if (p[i][j].getCelula().getI() == I && p[i][j].getCelula().getJ() == J-1)
				}
					
			}
		}
	}*/
	public void EliminaPuyos(Puyo eliminados[], Puyo p[][]) {
		for (int i = 0; i < p.length; i++) {
			eliminados[i].setStatus("E");
			Celula c = eliminados[i].getCelula();
			eliminados[i] = new Puyo("");
			//DescePuyo(c, p);	
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "A") {
					findPuyos(p, i, j, p[i][j].getColor());
					if (puyosProx[0] != null) {
						for (k= 0; puyosProx[k] != null; k++) {
							int J = puyosProx[k].getId()%10;
						 	int I = (puyosProx[k].getId()-J)/10;
							findPuyos(p, I, J, puyosProx[k].getColor());
						}
						if (k >= 3)
							EliminaPuyos(puyosProx, p);
					}
				}
			}
		}
		
	}
}
