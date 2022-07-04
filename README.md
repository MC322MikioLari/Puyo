# Projeto `<Puyo-Puyo/Jogo>`

# Descrição Resumida do Projeto/Jogo

> Puyo Puyo é um jogo eletrônico de quebra-cabeça lançado em 1997 para o PlayStation, Sega Saturn, e Nintendo 64 apenas no Japão. Ele consiste em fazer combinações com os puyo-puyos enfilerando-os de modo que quando 4 ou mais puyos se tocam, eles explodem, a explosão de puyos, pode ocasionar a explosão de outros, assim, o jogo se torna mais estratégicos, visto que realizar essas configurações citadas, acarreta muito mais pontos, do que apenas estourar os Puyos que explodem diretamente. O fim do jogo ocorre quando um Puyo atinge o topo do quadro.

# Equipe
* `<Larissa Ayumi Okabayashi>` - `<247220>`
* `<Gabriel Mikio>` - `<248295>`

# Arquivo Executável do Jogo

> [link](https://github.com/MC322MikioLari/Puyo/blob/main/RunnablePuyo.jar)

# Slides do Projeto

## Slides da Prévia

> [ApresentaçãoPrévia](https://github.com/MC322MikioLari/Puyo/files/9002192/ApresentacaoPrevia.pdf)

## Slides da Apresentação Final

> [ApresentaçãoFinal](https://user-images.githubusercontent.com/82288999/176686081-beae6b43-6753-46b7-9d45-a5dc2f9f6fdd.mp4)

# Diagramas

## Diagrama Geral da Arquitetura do Jogo
![image](https://user-images.githubusercontent.com/82288999/176044745-79eb9d70-346f-4411-9e80-c45aa416bffd.png)

## Relatório de Evolução

> Relatório de evolução, descrevendo as evoluções do design do projeto, dificuldades enfrentadas, mudanças de rumo, melhorias e lições aprendidas. Referências aos diagramas e recortes de mudanças são bem-vindos.

# Destaques de Código

> Escolha trechos relevantes e/ou de destaque do seu código. Apresente um recorte (você pode usar reticências para remover partes menos importantes). Veja como foi usado o highlight de Java para o código.

~~~java
// Recorte do seu código
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

# Destaques de Orientação a Objetos
> Destaque partes do código em que a orientação a objetos foi aplicada para aprimorar seu código. Por exemplo, o uso de polimorfismo para ajustar ações conforme o contexto. Sugestão de estrutura:

## Diagrama de Classes usada no destaque OO:
> Sugere-se um diagrama de classes para o destaque, mas podem ser usados outros tipos de diagrama, conforme a necessidade.

## Código do Destaque OO
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

# Destaques de Pattern
> Destaque de patterns adotados pela equipe. Sugestão de estrutura:

## Diagrama do Pattern
> Diagrama do pattern dentro do contexto da aplicação.

## Código do Pattern
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

> Explicação de como o pattern foi adotado e quais suas vantagens, referenciando o diagrama.

# Conclusões e Trabalhos Futuros

> Apresente aqui as conclusões do projeto e propostas de trabalho futuro. Esta é a oportunidade em que você pode indicar melhorias no projeto a partir de lições aprendidas e conhecimentos adquiridos durante a realização do projeto, mas que não puderam ser implementadas por questões de tempo. Por exemplo, há design patterns aprendidos no final do curso que provavelmente não puderam ser implementados no jogo -- este é o espaço onde você pode apresentar como aplicaria o pattern no futuro para melhorar o jogo.

# Plano de Exceções

## Diagrama da hierarquia de exceções
> Elabore um diagrama com a hierarquia de exceções como detalhado a seguir.

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

> Monte uma tabela descritiva seguindo o exemplo:

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.
