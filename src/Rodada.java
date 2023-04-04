package src;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.CartaFactory.Carta;

public class Rodada {
    private static Map<Jogador, Integer> pontuacoesJogadores = new TreeMap<>();
    private static final List<List<Carta>> listCartas = new ArrayList<>();
    private static final List<Jogador> listJogadores = new ArrayList<>();

    private static int quantidadeRodadas = 3;
    private static Scanner leitor;
    private static int rodadaAtual = 1;

    public Rodada(Map<Jogador, Integer> novoPontuacoesJogadores, List<List<Carta>> listCartas, Scanner novoLeitor) {
        pontuacoesJogadores = novoPontuacoesJogadores;
        leitor = novoLeitor;
    }

    public static List<List<Carta>> getListCartas() {
        return listCartas;
    }

    public static List<Jogador> getListJogadores() {
        return listJogadores;
    }

    public static void setQuantidadeRodadas(int novaQuantidadeRodadas) {
        quantidadeRodadas = novaQuantidadeRodadas;
    }

    public static int getQuantidadeRodadas() {
        return quantidadeRodadas;
    }

    private static void apresentaCartaPorJogador() {
        for (Map.Entry<Jogador, Integer> player : pontuacoesJogadores.entrySet()) {

            System.out.println(
                    String.format(
                        "Jogador %s: %s", 
                        player.getKey().getNome(),
                        player.getValue().get(rodadaAtual-1).getNomeCarta()
                    )
            );
        }
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


    private static void mostraPontuacoesRodadas() {
        for (Map.Entry<Jogador, List<Carta>> pontuacaoJogador : pontuacoesJogadores.entrySet()) {
            System.out.println(
                String.format(
                    "Jogador %s ganhou %s pontos", 
                    pontuacaoJogador.getKey().getNome(),
                    OperaCartas.somaPontuacaoFinal(pontuacaoJogador.getValue())
                )
            );

        }
    }
}
