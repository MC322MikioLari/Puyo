# Projeto `<Puyo-Puyo/Jogo>`

# Descrição Resumida do Projeto/Jogo

> Puyo Puyo é um jogo eletrônico de quebra-cabeça lançado em 1997 para o PlayStation, Sega Saturn, e Nintendo 64 apenas no Japão. Ele consiste em fazer combinações com os puyo-puyos enfilerando-os de modo que quando 4 ou mais puyos se tocam, eles explodem, a explosão de puyos, pode ocasionar a explosão de outros, assim, o jogo se torna mais estratégicos, visto que realizar essas configurações citadas, acarreta muito mais pontos, do que apenas estourar os Puyos que explodem diretamente. O fim do jogo ocorre quando um Puyo atinge o topo do quadro.

# Equipe
* `<Larissa Ayumi Okabayashi>` - `<247220>`
* `<Gabriel Mikio>` - `<248295>`

# Arquivo Executável do Jogo

> [link](https://github.com/MC322MikioLari/Puyo/blob/main/src/puyopuyo/Puyo.jar)

# Slides do Projeto

## Slides da Prévia

> [ApresentaçãoPrévia](https://github.com/MC322MikioLari/Puyo/files/9002192/ApresentacaoPrevia.pdf)

## Slides da Apresentação Final

> [ApresentaçãoFinal](https://user-images.githubusercontent.com/82288999/176686081-beae6b43-6753-46b7-9d45-a5dc2f9f6fdd.mp4)

# Diagramas

## Diagrama Geral da Arquitetura do Jogo
![image](https://user-images.githubusercontent.com/82288999/177216413-094807bb-bd31-4048-a2dd-385eab2e716d.png)

## Relatório de Evolução

Inicialmente, a dupla se programou para separar o projeto em duas entregas, onde na primeira, contemplava-se a parte fundamental e mais básica do jogo, isto é, funcionalidades que não poderiam faltar, tais como: Implementar interface gráfica, função que cria os puyo-puyos, movimentos, controles do jogo, entre outros. A segunda entrega seria para implementar atributos adicionais, de modo a deixar o jogo mais complexo, tais como ser multiplayer e adicionar puyo-puyos especiais (um que atrapalha e um que aumenta o score). Contudo, devido a dificuldades do grupo, principalmente relacionada a implementação da interface gráfica, a segunda entrega não foi realizada. 

Sobre a interface gráfica a dupla escolheu utilizar bibliotecas mais antigas, tais como : JavaSwing e JPanel, contudo o grupo percebeu durante o processo de desenvolvimento do jogo, que essa decisão não foi muito inteligente, isso porque essas bibliotecas por serem mais antigas que outras como a libgdx, se tornam menos flexíveis, com menos funcionalidades possíveis, dificultando o processo de criação da interface, e tornando-a mais simples do que ela poderia ser. Logo, uma possível melhoria seria utilizar bibliotecas mais recentes para produzir a interface.

O grupo percebeu no meio do projeto uma problemática de que no jogo há vários processos acontecendo ao mesmo tempo (puyo caindo, executando o comando do teclado, checando se há puyos para serem eliminados). Por isso, a equipe supôs que teria que ser implementado threads, de modo a permitir a ocorrência de eventos em paralelo. No entanto, o conhecimento do design pattern observer resolveu esse problema, dado que ele adiciona Listener (que implementam a interface ActionListener) em um array e vai realizando cada um deles na função notify, os processos não ocorrem de maneira paralela, mais a velocidade é o bastante para o jogo funcionar.

Além disso, como a proposta anterior era fazer um jogo mais complexo, que desse mais possibilidade de aplicar os conceitos de Programação orientada a objetos, a arquitetura inicial era que o Puyo herdasse a classe Componente, assim como na proposta inicial tinha mais do que um tipo de Puyo para ser implementado, essa decisão ia ser adequada. Contudo, a existência no jogo atual de só um tipo de Puyo tornou a arquitetura citada defasada, por isso a classe Componentes não foi usada no final. 


# Destaques de Código
Busca Recursiva de Puyos de mesma cor a fim de eliminar puyos conectados em quantidade >= 4

~~~java
public void SearchSameColor(Puyo P, Puyo CoresIguais[]) {
		add(visitados, P);
		add(CoresIguais,P.getPuyosProx());
		for (int w = 0; P.getPuyosProx()[w] != null; w++) { //Acessando a lista de PuyosProx do puyo
			if (P.getPuyosProx()[w].getPuyosProx()[0] != null && (P.getStatus() == "P") && !PuyoInList(P.getPuyosProx()[w], visitados))//Acessando a lista de PuyosProx do puyo que estava dentro da lista do primeiro
				SearchSameColor(P.getPuyosProx()[w], CoresIguais);	
		}
	}
~~~

# Destaques de Orientação a Objetos

## Diagrama de Classes usada no primeiro destaque OO:
Uso de polimorfismo ao sobrescrever método (paintComponent) da super-classe 

![Diagrama](https://user-images.githubusercontent.com/82288999/177548219-1263c1b4-1485-4d2a-bfff-94fe55d5734f.png)

## Código do primeiro Destaque OO

~~~java
public class Board extends JPanel{
~~~
~~~java
public void paintComponent(Graphics g2){
   super.paintComponent(g2);
~~~

## Diagrama de Classes usada no segundo destaque OO:
Sobrecarga de métodos para adicionar ou um elemento em um array, ou um array em array

![Diagrama](https://user-images.githubusercontent.com/82288999/177550623-3a5bd8de-b935-4b68-83fb-87e61195d9ae.png)

## Código do segundo Destaque OO

~~~java
	public void add(Puyo lista[], Puyo p[]) {
		int v, w = tam(lista);
		for (v = 0; p[v] != null; v++) {
			if (!PuyoInList(p[v], lista)) {
				lista[w] = p[v];
				w++;
			}
		}
	}
	
	public void add(Puyo lista[], Puyo p) {
		int w = tam(lista);
		lista[w] = p;
	}
~~~

## Diagrama de Classes usada no terceiro destaque OO:
Classe DescePuyo implementando interface actionListener e os métodos associados a ela

![Diagrama](https://user-images.githubusercontent.com/82288999/177552585-86d064ec-0050-4c7e-8dae-cff974bede1d.png)

## Código do terceiro Destaque OO
~~~java
public class DescePuyo implements ActionListener {
~~~
~~~java
public void actionPerformed(ActionEvent e) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "P" &&  p[i][j].getY() <= heightWindow && p[i][j].checkPuyos(p[i][j].getX(), p[i][j].getY() + Celula) == false) {
					p[i][j].setY(p[i][j].getY() + Celula);
					p[i][j].setLocation(p[i][j].getX(), p[i][j].getY());
				}
			}
		}
	}
~~~

# Destaques de Pattern
Action Listener e Singleton

## Observer

O Observer é um padrão de projeto comportamental que permite que você defina um mecanismo de assinatura para notificar múltiplos objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.

### Diagrama do Pattern: Observer

![Observer](https://user-images.githubusercontent.com/84105147/177977771-2e4089a9-adeb-4485-a823-8b44e70e429a.png)


### Código do Pattern: Observer
Classe "ActionSubject" responsável por definir o Array de "assinantes", assim como o método responsável por notificá-los em caso de alguma ação percebida.
~~~java
public abstract class ActionSubject {
	final static ArrayList<ActionListener> listenerArr =
         new ArrayList<ActionListener>(); 
  
   public void addActionListener(ActionListener listener) {
	  listenerArr.add(listener);
   }
   
   public void removeActionListener(ActionListener listener) {
      listenerArr.remove(listener);
   }
   
   public void notify(ActionEvent event) {
      for (ActionListener al: listenerArr) {
         al.actionPerformed(event);
      }
   }
}
~~~

Classe "Notifier" responsável por herdar os métodos da classe "Action Subject" e de fato definir o início e parada do "Timer", componente importantíssimo para o controle e desenvolvimento do jogo.

~~~java
public class Notifier extends ActionSubject implements ActionListener  {
   private Timer metro;
   private int quantidade, corrente;
	.
	.
	.
   
   public void start() {
      metro.start();
   }
    
   public void stop() {
      metro.stop();
   }
    
   public void actionPerformed(ActionEvent event) {
      corrente++;
      if (corrente >= quantidade)
         stop();
      notify(event);
   }
}
~~~

Um exemplo de uma das várias classs as quais implementam o design pattern Observer, sobreescrevendo o método "ActionPerformed"; no caso, a classe Keyboard descrevendo o que seria a sua "ação performada" a ser avisada ao Notifier.

~~~java
public class Keyboard extends JPanel implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if (event == KeyEvent.VK_RIGHT) { //Virando para direita
			if (p1.getX() + Celula <= widthWindow-WIDTH && p2.getX() + Celula <= widthWindow-WIDTH) {
				if ((p1.checkPuyos(p1.getX() + Celula, p1.getY()) == false) && (p2.checkPuyos(p2.getX() + Celula, p2.getY()) == false)) {
					p1.setX(p1.getX() + Celula);
					p2.setX(p2.getX() + Celula);
					event = 0;
				}
			}
		}
		.
		.
		.
	}
}
~~~

## Singleton

O Singleton é um padrão de projeto criacional que permite a você garantir que uma classe tenha apenas uma instância, enquanto provê um ponto de acesso global para essa instância.

### Código do Pattern: Singleton

![SingletonINstance](https://user-images.githubusercontent.com/84105147/177983102-2d59d3b8-ceed-428c-8dc7-46d0b0c5dff8.png)


# Conclusões e Trabalhos Futuros

Concluímos sobre como realmente usamos na prática, em projetos reais, os conceitos de Orientação a Objeto, e como eles são valiosos ao se montar um código robusto e escalável. Percebemos também, principalmente (e na pele), a importância dos FrameWorks, tais como o citado anteriormente LibGDX, pois nenhum dos 2 membros da dupla haviam tido contato com Frameworks anteriormente. É notável o quão limitados e sujeitos a diversos erros facilmente evitáveis nós nos tornanmos e nos colocamos, utilizando bibliotecas mais antigas de interface gráfica. 

Possíveis melhorias para o jogo são, em especial: uma mudança para uma interface gráfica mais moderna e robusta; a implementação de Exception Handling para lidar com a importação de arquivos de mídia tais como imagens e sons; o incremento de mais componentes, como os puyo-puyos de obstáculo (os quais atrapalham a se criar o combo/conexão das peças) e os puyo-puyos de bônus (os quais provêm pontos bônus ao serem consumidos juntamente a um combo); a adição da feature de multiplayer, seja contra uma segunda pessoa real, ou contra uma IA simples.

Além das melhorias no código, aprendemos também sobre melhorias no ato de se apresentar o projeto; através dos fatores pontuados pela banca no momento de apresentação do jogo em sala, como: evitar o uso de vídeo; focar mais nos pontos de destaque do projeto e em como a Orientação a Objeto se relaciona com ele, e não pontos de algoritmos recorrentes.

Apesar de todo o insumo que tivemos sobre melhorias na nossa apresentação e projeto como um todo, e das dificuldades apresentadas ao longo da criação do código; ficamos felizes ao conseguir entregar um jogo funcionável e fechado, e temos certeza de que a experiência trazida deste primeiro projeto nos ajudará em muito nos seguintes, seja no âmbito acadêmico ou profissional. 
