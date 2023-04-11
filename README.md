# Jogo de Cartas :spades:

## :school::man_technologist: **Integrantes**
- Nícolas Albuquerque Ramos
- Otávio Fernandes de Oliveira
- Renata Cristina Alves da Silva

## :thinking: Resposta para As Perguntas: 
1° - **Conseguiu ou não realizar tudo o que foi proposto? Se não conseguiu, detalhe o que
faltou.**
R: Sim, conseguimos.

2° - **Quais os possíveis problemas que se identifica no código?**
R: A possibilidade de empate de vencedores finais.

3° - **Sentiu dificuldade para desenvolver o projeto? Quais?**
R: Sim, com as formas de múltiplos comportamentos dos objetos dentro de um sistema, separação de responsabilidades únicas e a tentativa de tratamento de dados da forma mais genérica, onde utilizando loops clássicos faziam com que o código ficasse mais difícil de ler.

## :pushpin: Lista de Tarefas
- [x] :point_right: O jogo poderá ter até 7 rodadas
- [x] :point_right: O padrão será 3 rodadas, mas poderá ser alterado
- [x] :point_right: O jogo poderá ser jogado por até 5 usuários
- [x] :point_right: Cada usuário identifica-se no sistema informando seu nome
- [x] :pushpin: **O usuário informará no início o tipo de carta, que pode ser:**

| Carta normal | Carta Naipe | Carta Valor |
|    :---:     |    :---:    |    :---:    |

- [x] :pushpin: Comparação das Cartas:
    - [x] :round_pushpin: Cartas Normais:
        - [x] :point_right: A pontuação final da carta normal é calculada multiplicando o **valor da carta** pelo **valor do naipe da carta**. 
        - [x] :point_right: quem tiver a maior pontuação final ganha 3 pontos na rodada
        - [x] :point_right: quem tiver a segunda maior pontuação final ganha 2 pontos na rodada 
        - [x] :point_right: quem tiver a terceira maior pontuação final ganha 1 ponto na rodada
    
    - [x] :round_pushpin: Cartas Naipe:
        - [x] :point_right: Todas as cartas têm o mesmo peso, ou seja, o naipe não influência na pontuação final da carta.
        - [x] :point_right: A pontuação dos jogadores é atribuída da mesma forma que na carta normal
        
        :warning: **A comparação das cartas Naipe é feita simplesmente comparando o valor numérico das cartas, onde a carta com maior valor ganha a rodada**
    
    - [x] :round_pushpin: Cartas Valor:
        - [x] :point_right: Mesma forma de pontuação final das cartas normais
        - [x] :point_right: As cartas Valor com números primos têm seu valor final multiplicado por 3
        - [x] :point_right: Mesma regra de comparação da comparação de cartas normais

    - [x] :round_pushpin: **Valores das cartas:**
        
        | Valor | 1 |	2 |	3 |	4 | 5 | 6 | 7 | 8 | 9 |	10 | 11 | 12 | 13 |
        | :---: | :---:  |	:---:  | :---:  | :---:  | :---: | :---:  | :---:  | :---:  | :---:  |	:---:  | :---:  |	:---:  |	:---:  |
        | Nome  | As     |         |	    |        |       |	      |        |        |	     |         | Valete |	Dama   |    Rei    |


    - [x] :round_pushpin: **Os Naipes:**

        | Valor | 2	| 3 | 4 | 5 |
        | :---: | :---:	| :---: | :---: | :---: |
        | Nome  | Paus  | Ouros	 | Copas | Espadas |


- [x] :pushpin: **A cada rodada deve acontecer o seguinte:**
    - [x] :point_right: Cada jogador recebe uma carta escolhida de forma aleatória pelo Jogo
    - [x] :point_right: O jogo apresenta a carta de cada jogador
    - [x] :point_right: As cartas dos jogadores são comparadas a partir da pontuação final da carta
    - [x] :point_right: Os **pontos** que cada jogador ganhou na rodada são armazenados
    - [x] :point_right: **Ao final de cada rodada, o jogo mostra:**
        - [x] :point_right: a carta de cada jogador
        - [x] :point_right: a pontuação final das cartas da rodada
        - [x] :point_right: a pontuação dos jogadores

- [x] :point_right: O **resultado** de cada rodada deverá ser armazenado

- [x] :pushpin: **Após todas as rodadas:**
    - [x] :point_right: O jogo será encerrado
    - [x] :point_right: A pontuação de cada Jogador é apresentada com a indicação do vencedor final

## :thinking: Exemplos

### Exemplo (Console)
```bash
$ Jogador 1: Valete de Paus
Pontuação final da carta: 11 * 2 == 22 // (valete=11, paus=2)

$ Jogador 2: 7 de Ouros
$ Pontuação final da carta: 7 * 3 == 21

$ Jogador 3: 5 de Espadas
$ Pontuação final da carta: 5 * 5 == 25

$ Nesta rodada:
Jogador 3 ganhou 3 pontos
Jogador 1 ganhou 2 pontos
Jogador 2 ganhou 1 pontos
```

### Exemplo (Comparação da carta Valor)
Se um jogador recebe uma carta com o número 3 de Copas (copas=4), o valor final da carta será 3 * 4 = 12. Já se o jogador recebe uma carta com o número 5 de Espadas (espadas=5), o valor final da carta será 5 * 5 * 3 = 75. Assim, as cartas com números primos terão um valor final mais alto do que as cartas não-primas.


## :stuck_out_tongue_winking_eye: Dicas
1. Naipe é cada "família" ou tipo das cartas. 
2. Cada naipe traz todos os números de 2 a 10, o Ás (que representa ora 1, ora 14), Valete, Dama e Rei. 
3. As 52 cartas representam as 52 semanas do ano. Os 4 naipes representam as 4 estações do ano.
4. As 13 cartas de cada naipe representam as 13 semanas que compõem cada estação.

## FAQS

### Como é feito a comparação das cartas normais?

Na comparação das cartas normais, a pontuação final da carta é calculada multiplicando o valor da carta pelo naipe da carta, considerando que Valete, Dama e Rei valem respectivamente 11, 12 e 13 pontos, e o Ás vale 1 ponto. Os naipes têm os seguintes valores: Paus=2, Ouros=3, Copas=4 e Espadas=5. Depois de calculada a pontuação final de cada carta, elas são comparadas para determinar quem ganhou a rodada. O jogador com a maior pontuação final ganha 3 pontos, o jogador com a segunda maior pontuação final ganha 2 pontos, e o jogador com a menor pontuação final ganha 1 ponto.

### E como é feito a comparação das cartas naipes?

No tipo de carta Naipe+, todas as cartas têm o mesmo peso, ou seja, o naipe não influencia na pontuação final da carta. Portanto, a comparação das cartas desse tipo é feita simplesmente comparando o valor numérico das cartas, onde a carta com maior valor ganha a rodada. A pontuação dos jogadores é atribuída da mesma forma que na carta normal, ou seja, o jogador com a maior carta ganha 3 pontos, o segundo maior ganha 2 pontos e o terceiro maior ganha 1 ponto.

### E como é feito a comparação das cartas valor?

No tipo de carta Valor+, as cartas com números primos têm seu valor final multiplicado por 3. Portanto, a comparação das cartas desse tipo é feita levando em consideração a multiplicação do valor final da carta pelos valores dos naipes, seguindo as mesmas regras da carta normal.

Ao final da rodada, a pontuação dos jogadores é atribuída da mesma forma que na carta normal, ou seja, o jogador com a maior carta ganha 3 pontos, o segundo maior ganha 2 pontos e o terceiro maior ganha 1 ponto.


## :page_with_curl: **Referências**
1. [How to print color in console using System.out.println?](https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println)
2. [Atualizar Valor HashMap](https://www.guj.com.br/t/atualizar-valor-hashmap/58647)
3. [HashMap Java: Trabalhando com Listas key-value](https://www.devmedia.com.br/hashmap-java-trabalhando-com-listas-key-value/29811)
4. [COMO IMPRIMIR TEXTO COLORIDO NO CONSOLE JAVA?](https://acervolima.com/como-imprimir-texto-colorido-no-console-java/)
5. [Descobrir se um número é primo ou não](https://www.guj.com.br/t/descobrir-se-um-numero-e-primo-ou-nao/81156/4)
6. [Descobrir se um número é primo ou não](https://www.guj.com.br/t/descobrir-se-um-numero-e-primo-ou-nao/81156/3)
7. [Factory Method em Java](https://refactoring.guru/pt-br/design-patterns/factory-method/java/example)
8. [CLASSES ABSTRATAS](https://www.alura.com.br/apostila-java-orientacao-objetos/classes-abstratas)
9. [Números Aleatórios em Java – A Classe java.util.Random](https://www.devmedia.com.br/numeros-aleatorios-em-java-a-classe-java-util-random/26355)
10. [The import java.util.ArrayList cannot be resolved](https://cursos.alura.com.br/forum/topico-the-import-java-util-arraylist-cannot-be-resolved-153016)
11. [What does for(int i : x) do? [duplicate]](https://stackoverflow.com/questions/29588837/what-does-forint-i-x-do)
12. [Adicionar elementos de array em ArrayList e imprimir os valores](https://pt.stackoverflow.com/questions/360215/adicionar-elementos-de-array-em-arraylist-e-imprimir-os-valores)
13. [Como funciona a classe Scanner do Java?](https://www.devmedia.com.br/como-funciona-a-classe-scanner-do-java/28448)
14. [Scanner error with nextInt() [duplicate]](https://stackoverflow.com/questions/12832006/scanner-error-with-nextint)