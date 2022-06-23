package puyopuyo;

public class RemovePuyos {
	final static int MAX_PUYOS = 7*12;
	
	public RemovePuyos(Puyo p[][]) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				int x = p[i][j].getX();
				int y = p[i][j].getY();
				int PuyosProx = findPuyos(p, x, y).length;
				if (PuyosProx != 0)
					p[i][j].setPuyosProx(findPuyos(p, x, y));
				if (p[i][j].getPuyosProx().length >= 3)
					EliminaPuyos(p[i][j].getPuyosProx(), p);
					
			}
		}
	}
	public Puyo[] findPuyos(Puyo p[][], int x, int y) {
		Puyo puyosProx[] = new Puyo [MAX_PUYOS];
		int n = 0;
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].isEliminado() == false) {
					if (p[i][j].getY() == y) {
						if (p[i][j].getX() == x-1 ) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
						if (p[i][j].getX() == x+1) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
					}
					if (p[i][j].getX() == x) {
						if (p[i][j].getX() == y-1 ) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
						if (p[i][j].getX() == y+1) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
					}
				}
			}
		}
		return puyosProx;
	}
	
	public boolean checkPuyos(int y, int x, Puyo p[][]) {
		for (int i=0; i < MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getX() == x && p[i][j].getY() == y && p[i][j].isEliminado() == true)
					return false;
			}
		}
		return true;
	}
	public void DescePuyo(int y, Puyo p[][]) {
		for (int i=0; i < MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getY() < y) {
					if (p[i][j].isEliminado() == false) {
						while(checkPuyos(y+1, p[i][j].getX(), p) == false) {
							p[i][j].setY(p[i][j].getY() + 1);
							y += 1;
						}
					}
				}
			}
		}
	}
	public void EliminaPuyos(Puyo eliminados[], Puyo p[][]) {
		for (int i = 0; i < p.length; i++) {
			eliminados[i].setEliminado(true);
			int y = eliminados[i].getY();
			DescePuyo(y, p);	
		}
	}
}
