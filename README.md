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
![image](https://user-images.githubusercontent.com/82288999/177216413-094807bb-bd31-4048-a2dd-385eab2e716d.png)

## Relatório de Evolução

Inicialmente, a dupla se programou para separar o projeto em duas entregas, onde na primeira, contemplava-se a parte fundamental e mais básica do jogo, isto é, funcionalidades que não poderiam faltar, tais como: Implementar interface gráfica, função que cria os puyo-puyos, movimentos, controles do jogo, entre outros. A segunda entrega seria para implementar atributos adicionais, de modo a deixar o jogo mais complexo, tais como ser multiplayer e adicionar puyo-puyos especiais (um que atrapalha e um que aumenta o score). Contudo, devido a dificuldades do grupo, principalmente relacionada a implementação da interface gráfica, a segunda entrega não foi realizada. 

Sobre a interface gráfica a dupla escolheu utilizar bibliotecas mais antigas, tais como : JavaSwing e JPanel, contudo o grupo percebeu durante o processo de desenvolvimento do jogo, que essa decisão não foi muito inteligente, isso porque essas bibliotecas por serem mais antigas que outras como a libgdx, se tornam menos flexíveis, com menos funcionalidades possíveis, dificultando o processo de criação da interface, e tornando-a mais simples do que ela poderia ser. Logo, uma possível melhoria seria utilizar bibliotecas mais recentes para produzir a interface.

O grupo percebeu no meio do projeto uma problemática de que no jogo há vários processos acontecendo ao mesmo tempo (puyo caindo, executando o comando do teclado, checando se há puyos para serem eliminados). Por isso, a equipe supôs que teria que ser implementado threads, de modo a permitir a ocorrência de eventos em paralelo. No entanto, o conhecimento do design pattern observer resolveu esse problema, dado que ele adiciona Listener (que implementam a interface ActionListener) em um array e vai realizando cada um deles na função notify, os processos não ocorrem de maneira paralela, mais a velocidade é o bastante para o jogo funcionar.

Além disso, como a proposta anterior era fazer um jogo mais complexo, que desse mais possibilidade de aplicar os conceitos de Programação orientada a objetos, a arquitetura inicial era que o Puyo herdasse a classe Componente, assim como na proposta inicial tinha mais do que um tipo de Puyo para ser implementado, essa decisão ia ser adequada. Contudo, a existência no jogo atual de só um tipo de Puyo tornou a arquitetura citada defasada, por isso a classe Componentes não foi usada no final. 


# Destaques de Código
> Busca Recursiva de Puyos de mesma cor a fim de eliminar puyos conectados em quantidade >= 4

![image](https://user-images.githubusercontent.com/82288999/177214914-8f03264f-2959-48ac-a7f1-d89f5ecf9ac3.png)

# Destaques de Orientação a Objetos
> Destaque partes do código em que a orientação a objetos foi aplicada para aprimorar seu código. Por exemplo, o uso de polimorfismo para ajustar ações conforme o contexto. Sugestão de estrutura:

## Diagrama de Classes usada no destaque OO:
> Sugere-se um diagrama de classes para o destaque, mas podem ser usados outros tipos de diagrama, conforme a necessidade.

## Código do Destaque OO
> Sobrecarga de métodos para adicionar ou um elemento em um array, ou um array em array

![image](https://user-images.githubusercontent.com/82288999/177216078-822c0a18-6ce3-4dce-9f4f-a2bb7af9c050.png)

> Uso de polimorfismo ao sobrescrever método (paintComponent) da super-classe 

![image](https://user-images.githubusercontent.com/82288999/177215776-8b044953-26d1-45ee-b300-4c8fa9828c6a.png)

![image](https://user-images.githubusercontent.com/82288999/177215909-09981611-1248-4d75-85b3-b1519cacb63e.png)

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

![Exception](https://user-images.githubusercontent.com/82288999/177318851-35d5d5fb-4730-435d-aa03-46eda1f9d34b.png)

## Descrição das classes de exceção

![Exception2](https://user-images.githubusercontent.com/82288999/177318572-47223ca7-13e4-4f6c-922d-19d3c4ceb3d9.png)


