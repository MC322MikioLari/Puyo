package puyopuyo;

public class AppGuiAnimacao {
   // tecnica para identificar o diretorio em que a classe esta
   public static String DIRETORIO =
         AppGuiAnimacao.class.getResource(".").getPath();
   
   public static void main(String[] args) {
       JanelaImagem janela = new JanelaImagem();
       
       janela.background(DIRETORIO + "borda.png");
       
       ImagemAnimada animado = new ImagemAnimada(DIRETORIO + "green.png", 0, 0, 50, 50, 0, 30);
       
       janela.adicionaImagem(animado);
       
       Metronomo metro = new Metronomo(1000, 10);
       metro.addActionListener(animado);
       metro.start();
   }
}
