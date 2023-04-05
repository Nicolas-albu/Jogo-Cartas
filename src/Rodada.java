package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import java.util.List;
import java.util.Map;

import src.CartaFactory.Carta;

public class Rodada {
    // private static Map<Pontuacao, Jogador> pontuacoesJogadores = new TreeMap<>(new PontuacaoComparator());
    private static Map<Pontuacao, Jogador> pontuacoesJogadores = new HashMap<>();
    private static List<List<Carta>> listCartas = new ArrayList<>();
    private static List<Jogador> listJogadores = new ArrayList<>();
    private static int quantidadeRodadas = 3;
    private static int rodadaAtual = 1;
    private static Scanner leitor;

    public Rodada(Scanner novoLeitor) {
        leitor = novoLeitor;
    }

    // private static Map<Pontuacao, Jogador> 

    private static void mostraPontos(){
        for (Map.Entry<Pontuacao, Jogador> pontuacaoJogador : pontuacoesJogadores.entrySet()) {
            System.out.println(String.format("Jogador %s: %s", 
            pontuacaoJogador.getValue().getNome(),pontuacaoJogador.getKey().toString()));
        } 
    }

    public static List<List<Carta>> getListCartas() {
        return listCartas;
    }

    public static List<Jogador> getListJogadores() {
        return listJogadores;
    }

    public static List<Jogador> setListJogadores() {
        return listJogadores;
    }

    public static Map<Pontuacao, Jogador> getPontuacoesJogadores() {
        return pontuacoesJogadores;
    }

    public static void setQuantidadeRodadas(int novaQuantidadeRodadas) {
        quantidadeRodadas = novaQuantidadeRodadas;
    }

    public static int getQuantidadeRodadas() {
        return quantidadeRodadas;
    }

    private static void apresentaCartaPorJogador() {
        // mostraPontos();
        for (int indicePlayer = 0; indicePlayer < listJogadores.size(); indicePlayer++) {

            System.out.println(
                    String.format(
                        "Jogador %s: %s", 
                        getListJogadores().get(indicePlayer).getNome(),
                        getListCartas().get(indicePlayer).get(rodadaAtual-1).getNomeCarta()
                    )
            );
        }
    }

    private static void mostraPontuacoesRodadas() {
        for (Map.Entry<Pontuacao, Jogador> pontuacaoJogador : pontuacoesJogadores.entrySet()) {
            System.out.println(
                String.format(
                    "Jogador %s ganhou %s pontos", 
                    pontuacaoJogador.getValue().getNome(),
                    pontuacaoJogador.getKey().getPontuacaoFinal()
                )
            );

        }
    }

    public static void controlaRodadas() {
        while (rodadaAtual <= quantidadeRodadas) {
            apresentaCartaPorJogador();
            mostraPontuacoesRodadas();
            leitor.nextLine();
            rodadaAtual++;
        }
    }


}
