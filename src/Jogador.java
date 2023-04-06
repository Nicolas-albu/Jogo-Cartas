package src;

import java.util.ArrayList;
import java.util.List;

import src.CartaFactory.CartaFactory;
import src.CartaFactory.Carta;

import app.Constantes;
import errors.ExcessoJogador;
import errors.ExcessoPontos;

public class Jogador {
    private static int quantidadeAtualJogadores;

    private List<Integer> pontuacoesRodadas = new ArrayList<>();
    private String nome;
    private Carta carta;

    public Jogador(String nome) throws ExcessoJogador {
        if ((getQuantidadeJogadores() + 1) > Constantes.QUANTIDADE_MAXIMA_JOGADORES.getValor())
            throw new ExcessoJogador();

        quantidadeAtualJogadores++;
        this.nome = nome;
    }

    /**
     * @return retorna o nome do jogador.
     */
    @Override
    public String toString() {
        return this.nome;
    }

    /**
     * @return retorna a quantidade total de jogadores.
     */
    public static int getQuantidadeJogadores() {
        return quantidadeAtualJogadores;
    }

    /**
     * @return retorna a pontuação do jogador na rodada atual.
     */
    public int getPontuacaoRodada() {
        return !this.pontuacoesRodadas.isEmpty() ? this.pontuacoesRodadas.get(Rodada.getRodadaAtual() - 1) : -1;
        // return this.pontuacoesRodadas.get(Rodada.getRodadaAtual() - 1);
    }

    /**
     * @return retorna a carta da rodada atual do jogador.
     */
    public Carta getCarta() {
        return this.carta;
    }

    /**
     * @return retorna a pontuação da carta da rodada atual.
     */
    public int getPontuacaoCarta() {
        return this.carta.getPontuacaoRodada();
    }

    /**
     * Inseri um ponto da rodada no jogador.
     * 
     * @param pontoRodada é o inteiro do ponto da rodada do jogador.
     * @throws ExcessoPontos quando é tentado inserir mais pontos do que a
     *                       quantidade total de rodadas.
     */
    public void setPontoRodada(int pontoRodada) throws ExcessoPontos {
        if ((this.pontuacoesRodadas.size() + 1) > Rodada.getQuantidadeRodadas())
            throw new ExcessoPontos();

        this.pontuacoesRodadas.add(pontoRodada);
    }

    /**
     * Cria e adiciona uma carta para o jogador.
     */
    public void criaCarta() {
        this.carta = CartaFactory.criaCarta(Rodada.getTipoCarta());
    }
}
