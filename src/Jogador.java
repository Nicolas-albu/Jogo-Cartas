package src;

import java.util.ArrayList;
import java.util.List;

import errors.ExcessoJogadores;
import errors.ExcessoPontos;

import src.CartaFactory.CartaFactory;
import src.CartaFactory.Carta;

import app.Constantes;

/**
 * Classe responsável por representar um jogador.
 */
public class Jogador {
    private static int quantidadeAtualJogadores;
    private List<Integer> pontuacoesRodadas = new ArrayList<>();
    private int pontuacaoFinal;
    private String nome;
    private Carta carta;

    /**
     * Cria um novo jogador.
     * 
     * @param nome é o nome do jogador.
     * @throws ExcessoJogadores quando é tentado criar mais jogadores do que a
     *                          quantidade máxima de jogadores.
     */
    public Jogador(String nome) throws ExcessoJogadores {
        if ((getQuantidadeJogadores() + 1) > Constantes.QUANTIDADE_MAXIMA_JOGADORES.getValor())
            throw new ExcessoJogadores();

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
    }

    /**
     * @return retorna a pontuação final do jogador.
     */
    public int getPontuacaoFinal() {
        return this.pontuacaoFinal;
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
     * Gera a pontuação da carta do jogador na rodada atual.
     */
    public void gerePontuacaoRodada() {
        this.carta.geraPontuacaoRodada();
    }

    /**
     * Gera a pontuação final de todas as rodadas pela soma das pontuações das
     * rodadas.
     */
    public void gerePontuacaoFinal() {
        this.pontuacaoFinal = this.pontuacoesRodadas.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Cria e adiciona uma carta para o jogador.
     */
    public void criaCarta() {
        this.carta = CartaFactory.criaCarta(Rodada.getTipoCarta());
    }
}
