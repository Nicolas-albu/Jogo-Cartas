package src;

import java.util.ArrayList;
import java.util.List;

import error.ExcessoJogador;
import src.CartaFactory.Carta;
import src.CartaFactory.CartaFactory;

public class Jogador {
    private List<Carta> cartas = new ArrayList<>();
    private static int quantidadeJogadores;
    private String nome;
    private int pontos;

    public Jogador(String nome) throws ExcessoJogador {
        this.setQuantidadeJogadores();
        if (getQuantidadeJogadores() > 5)
            throw new ExcessoJogador();
        this.nome = nome;
        this.pontos = 0;
    }

    public static int getQuantidadeJogadores() {
        return quantidadeJogadores;
    }

    private void setQuantidadeJogadores() {
        quantidadeJogadores++;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCarta()

    public void criaCartaJogador(int tipoCarta) {
        Rodada.getListJogadores()
            .forEach(jogador -> jogador.criaCartaJogador(tipoCarta));
        Rodada.getListJogadores()
            .forEach();
        // this.cartas.add(CartaFactory.criaCarta(tipoCarta));
    }

    public void calculaPontuacaoFinalPartida() {
        // Simula a jogada do jogador e atualiza a pontuação
        this.pontos += cartas.stream()
                            .mapToInt(Carta::getPontuacaoFinal)
                            .sum();
    }

}
