package src;

import java.util.List;
import java.util.Scanner;

import src.CartaFactory.Carta;

public class Rodada {
    private static int quantidadeRodadas = 3;
    private static List<Jogador> listJogadores;
    private static List<Carta> listCartas;
    private static Scanner leitor;

    public Rodada(List<Jogador> novoListJogadores, List<Carta> novoListCartas, Scanner novoLeitor) {
        listJogadores = novoListJogadores;
        listCartas = novoListCartas;
        leitor = novoLeitor;
    }

    public static void setQuantidadeRodadas(int novaQuantidadeRodadas) {
        quantidadeRodadas = novaQuantidadeRodadas;
    }

    private static void apresentaCartaPorJogador() {
        for (Jogador jogador : listJogadores) {
            int indiceJogador = listJogadores.indexOf(jogador);

            System.out.println(
                    String.format("Jogador %s: %s", jogador.getNome(),
                            listCartas.get(indiceJogador).getNomeCarta()));
            listCartas.get(indiceJogador).novaCarta();
        }
    }

    public static void controlaRodadas() {
        int rodadaAtual = 1;
        while (rodadaAtual <= quantidadeRodadas) {
            apresentaCartaPorJogador();
            leitor.nextLine();
            rodadaAtual++;
        }
    }
}
