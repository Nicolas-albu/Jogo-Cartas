# Jogo de Cartas :spades:

:warning: **Esse jogo ainda está em desenvolvimento!**

## :pushpin: Lista de Tarefas
- [x] :point_right: O jogo poderá ter até 7 rodadas
- [x] :point_right: O padrão será 3 rodadas, mas poderá ser alterado
- [x] :point_right: O jogo poderá ser jogado por até 5 usuários
- [x] :point_right: Cada usuário identifica-se no sistema informando seu nome
- [x] **O usuário informará no início o tipo de carta, que pode ser:**

| Carta normal | Carta Naipe | Carta Valor |
|    :---:     |    :---:    |    :---:    |
| Conforme descrito na parte 1 | Nesse tipo de carta, os valores/peso de todos os naipes são 1 | As cartas com números primos terão o valor final para comparação multiplicados por 3 |

- [ ] **A cada rodada deve acontecer o seguinte:**
    - [ ] :point_right: Cada jogador recebe uma carta escolhida de forma aleatória pelo Jogo
    - [ ] :point_right: O jogo apresenta a carta de cada jogador
    - [ ] :point_right: **As cartas dos jogadores são comparadas a partir da pontuação final da carta:**
        - [ ] :point_right: quem tiver a maior pontuação final ganha 3 pontos na rodada
        - [ ] :point_right: quem tiver a segunda maior pontuação final ganha 2 pontos na rodada 
        - [ ] :point_right: quem tiver a menor pontuação final ganha 1 ponto na rodada
    - [ ] :point_right: Os **pontos** que cada jogador ganhou na rodada são armazenados
    - [ ] :point_right: **Ao final de cada rodada, o jogo mostra:**
        - [ ] :point_right: a carta de cada jogador
        - [ ] :point_right: a pontuação final das cartas da rodada
        - [ ] :point_right: a pontuação dos jogadores

- [ ] :point_right: O **resultado** de cada rodada deverá ser armazenado

- [ ] :point_right: **Após todas as rodadas:**
    - [ ] :point_right: O jogo será encerrado
    - [ ] :point_right: A pontuação de cada Jogador é apresentada com a indicação do vencedor final

- [ ] :point_right: **A comparação das cartas considerará o valor e o naipe das cartas, da seguinte forma:**
    - [ ] :point_right: **Os valores para as cartas são:**

        | Valor | Nome  |
        | :---: | :---: |
        | 1 | As |
        | 2 | |
        | 3 | |
        | 4 | |
        | 5 | |
        | 6 | |
        | 7 | | 
        | 8 | |
        | 9 | |
        | 10 | |
        | 11 | Valete |
        | 12 | Dama |
        | 13 | Rei |

    - [ ] :point_right: **O Naipes terão os seguintes valores:**

        | Valor | Nome  |
        | :---: | :---: |
        | 2 | Paus |
        | 3 | Ouros |
        | 4 | Copas |
        | 5 | Espadas |

    - [ ] :point_right: A pontuação final da carta será a multiplicação do Valor pelo Naipe

## :thinking: Exemplo Comparação de Cartas

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

## :stuck_out_tongue_winking_eye: Dicas
1. Naipe é cada "família" ou tipo das cartas. 
2. Cada naipe traz todos os números de 2 a 10, o Ás (que representa ora 1, ora 14), Valete, Dama e Rei. 
3. As 52 cartas representam as 52 semanas do ano. Os 4 naipes representam as 4 estações do ano.
4. As 13 cartas de cada naipe representam as 13 semanas que compõem cada estação.