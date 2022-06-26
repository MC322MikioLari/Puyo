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
	Placar placar;
	JanelaImagem janela;
	int k = 0;
	int n = 1;
	
	public Remove(Puyo p[][], Notifier metro, Placar placar, JanelaImagem janela) {
		this.p = p;
		this.placar = placar;
		this.janela = janela;
		metro.addActionListener(this);
	}
	
	public boolean PuyoInList(Puyo p, Puyo puyos[]){
		for(int i=0; i<20; i++) {
			if (puyos[i] != null && puyos[i].getStatus() != "D")
				if (puyos[i].getId() == p.getId())
					return true;
		}
		return false;
	}

	public void findPuyos(Puyo p[][], int I, int J, int color) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "A") {
					if (p[i][j].getCelula().getJ() == p[I][J].getCelula().getJ() && (p[i][j].getCelula().getI() == p[I][J].getCelula().getI()-1 || p[i][j].getCelula().getI()== p[I][J].getCelula().getI()+1) &&  p[i][j].getColor() == color) {
						p[I][J].addPuyoProx(p[i][j]);
					}
					if (p[i][j].getCelula().getI() == p[I][J].getCelula().getI() && (p[i][j].getCelula().getJ() == p[I][J].getCelula().getJ()-1 || p[i][j].getCelula().getJ()== p[I][J].getCelula().getJ()+1) && p[i][j].getColor() == color) {
						p[I][J].addPuyoProx(p[i][j]);
					}
				}
			}
		}
	}
	public void DescePuyo(Celula c, Puyo p[][]) {
		int J = c.getJ();
		int I = c.getI();
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
					if (p[i][j].getStatus() != "E" && p[i][j].getStatus() != "D") {
						if (p[i][j].getCelula().getI() == I && p[i][j].getCelula().getJ() < J && p[i][j].checkPuyos(p[i][j].getX(), p[i][j].getY() + Celula) == false) {
							p[i][j].setY(p[i][j].getY() + Celula);
							p[i][j].setLocation(p[i][j].getX(), p[i][j].getY());
						}
					}
				}
			}
		}
	public void EliminaPuyos(Puyo eliminados[], Puyo p[][]) {
		for (int i = 0; eliminados[i] != null; i++) {
			eliminados[i].setStatus("E");
			Celula c = eliminados[i].getCelula();
			System.out.println("Eliminou");
			janela.panel.remove(eliminados[i]);
			janela.panel.validate();
			DescePuyo(c,p);
		}
	}
	
	public int add(Puyo lista[], Puyo p[]) {
		int w, v, i = 0;
		for (w = 0; lista[w] != null; w++);
		for (v = 0; p[v] != null; v++) {
			if (!PuyoInList(p[v], lista)) {
				i = 1;
				lista[w] = p[v];
				w++;
			}
		}
		return i;
	}
	
	public int tam(Puyo lista[]) {
		int w;
		for (w = 0; lista[w] != null; w++);
		return w;
	}
	
	public Puyo[] SearchSameColor(Puyo P, Puyo CoresIguais[]) {
		if ((P.getStatus() == "A" || P.getStatus() == "P") && P.getPuyosProx()[0] != null) {
			if (add(CoresIguais,P.getPuyosProx()) == 1) {
				for (int w = 0; P.getPuyosProx()[w] != null; w++) { //Acessando a lista de PuyosProx do puyo
					if (P.getPuyosProx()[w].getPuyosProx()[0] != null)//Acessando a lista de PuyosProx do puyo que estava dentro da lista do primeiro
						CoresIguais = SearchSameColor(P.getPuyosProx()[w], CoresIguais);
				}
			}	
		}
		return CoresIguais;
	}
				
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "A" || p[i][j].getStatus() == "P") {
					findPuyos(p, i, j, p[i][j].getColor());
				}
			}
		}
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				Puyo CoresIguais[] = new Puyo [20];
				CoresIguais = SearchSameColor(p[i][j], CoresIguais);
				if (tam(CoresIguais) >= 4) {
					System.out.println("Estourar");
					EliminaPuyos(CoresIguais, p);
					placar.setScore(k*5);
				}
			}
		}
	}
}


























/*if (puyosProx[0] != null) {
						for (k= 0; puyosProx[k] != null; k++) {
							int J = puyosProx[k].getId()%10;
						 	int I = (puyosProx[k].getId()-J)/10;
							findPuyos(p, I, J, puyosProx[k].getColor());*/







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