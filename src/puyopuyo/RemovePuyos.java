package puyopuyo;

public class RemovePuyos {
	final static int MAX_PUYOS = 6*12;
	
	public RemovePuyos(Puyo p[][], int i) {
		for(i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				int x = p[i][j].getPosX();
				int y = p[i][j].getPosY();
				int PuyosProx = findPuyos(p, i, x, y).length;
				if (PuyosProx != 0)
					p[i][j].setPuyosProx(findPuyos(p,i, x, y));
				if (p[i][j].getPuyosProx().length >= 3)
					EliminaPuyos(p[i][j].getPuyosProx());
					
			}
		}
	}
	public Puyo[] findPuyos(Puyo p[][], int i, int x, int y) {
		Puyo puyosProx[] = new Puyo [MAX_PUYOS];
		int n = 0;
		for(i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].isEliminado() == false) {
					if (p[i][j].getPosY() == y) {
						if (p[i][j].getPosX() == x-1 ) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
						if (p[i][j].getPosX() == x+1) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
					}
					if (p[i][j].getPosX() == x) {
						if (p[i][j].getPosX() == y-1 ) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
						if (p[i][j].getPosX() == y+1) {
							puyosProx[n] = p[i][j];
							n+=1;
						}
					}
				}
			}
		}
		return puyosProx;
	}
	
	public void EliminaPuyos(Puyo p[]) {
		for (int i = 0; i < p.length; i++) {
			p[i].setEliminado(true);
		}
	}
}
