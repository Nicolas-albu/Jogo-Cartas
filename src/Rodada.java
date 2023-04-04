package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

import src.CartaFactory.Carta;

public class Rodada {
    private static Map<List<Carta>, Jogador> pontuacoesJogadores = new TreeMap<>();
    private static int quantidadeRodadas = 3;
    private static Scanner leitor;
    private static int rodadaAtual = 1;

    public Rodada(Map<List<Carta>, Jogador> novoPontuacoesJogadores, Scanner novoLeitor) {
        pontuacoesJogadores = novoPontuacoesJogadores;
        leitor = novoLeitor;
    }

    public static void setQuantidadeRodadas(int novaQuantidadeRodadas) {
        quantidadeRodadas = novaQuantidadeRodadas;
    }

    public static int getQuantidadeRodadas() {
        return quantidadeRodadas;
    }

    public static void controlaRodadas() {
        System.out.println(pontuacoesJogadores);
        while (rodadaAtual <= quantidadeRodadas) {
            apresentaCartaPorJogador();
            mostraPontuacoesRodadas();
            leitor.nextLine();
            rodadaAtual++;
        }
    }

    private static void apresentaCartaPorJogador() {
        for (Map.Entry<List<Carta>, Jogador> player : pontuacoesJogadores.entrySet()) {

            System.out.println(
                    String.format(
                        "Jogador %s: %s", 
                        player.getValue().getNome(),
                        player.getKey().get(rodadaAtual-1).getNomeCarta()
                    )
            );
        }
    }

    private static int somaPontos(List<Carta> pontuacoes) {
        int soma = 0;
        for (Carta carta : pontuacoes) {
            soma += carta.getPontuacaoFinal();
        }
        return soma;
    }

    // private static void comparaPontuacoesFinais() {
    //     int pontuacaoAtual = 3;
    //     for (Map.Entry<Integer, Jogador> pontuacaoJogador : pontuacoesJogadores.entrySet()) {
    //         pontuacoesJogadores.put(
    //             pontuacaoAtual,
    //             pontuacaoJogador.getValue()
    //         );
    //         if (pontuacaoAtual != 1)
    //             pontuacaoAtual--;
            
    //         pontuacoesJogadores.remove(pontuacaoJogador.getKey());    
    //     }
    // }

    private static void mostraPontuacoesRodadas() {
        for (Map.Entry<List<Carta>, Jogador> pontuacaoJogador : pontuacoesJogadores.entrySet()) {
            System.out.println(
                String.format(
                    "Jogador %s ganhou %s pontos", 
                    pontuacaoJogador.getValue().getNome(),
                    somaPontos(pontuacaoJogador.getKey())
                )
            );

        }
    }
}
