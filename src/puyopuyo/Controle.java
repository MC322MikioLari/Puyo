package puyopuyo;

public class Controle {
	// Uma Classe de Controle do Jogo. Essa classe deve controlar os movimentos e pontuacao do jogo.
	int score;
	Puyo p = new Puyo();
	
	public boolean comandoValido(char comando) {
		if (comando == 'w' || comando == 'a'|| comando == 's' || comando == 'd' ||comando == 'q') {
			return true;
		}
		else return false;
		}
		
		
	public void executa(String comando) {
		if (comando == "a"|| comando == "s" || comando == "d") {
			p.Movimento(comando);	
		}
		else if (comando == "w") {
			p.Gira();
		}
		else if (comando == "q") {
			//quer sair do jogo
		}
		else System.out.println("Erro: comando nao existente.");
	}
}
