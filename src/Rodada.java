package src;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import errors.ExcessoJogadores;
import errors.CartaInexistente;
import errors.EntradaNegativa;
import errors.ExcessoRodadas;
import errors.ExcessoPontos;
import errors.ZeroInvalido;

import app.Constantes;
import app.Recursos;

/**
 * Classe responsável por controlar todo o fluxo de rodadas.
 */
public class Rodada {
    private static int quantidadeRodadas = Constantes.QUANTIDADE_PADRAO_RODADAS.getValor();
    private static List<Jogador> listJogadores = new ArrayList<>();
    private static int quantidadeTotalJogadores;
    private static int rodadaAtual = 1;
    private static int tipoCarta;

    /**
     * Método responsável por executar o fluxo de uma rodada.
     * 
     * @param leitor instância de Scanner.
     * @throws ExcessoPontos quando é tentado inserir mais pontos do que a
     *                       quantidade total de rodadas.
     */
    public static void executeRodada(Scanner leitor) throws ExcessoPontos {
        comparadorPontuacoes();

        Recursos.mostraAviso(String.format("RODADA %s", rodadaAtual));
        apresentaCartaPorJogador();

        System.out.println();
        mostraPontuacoesRodadas();

        leitor.nextLine();
        atualizaCartasJogadores();
    }

    /**
     * @return retorna o inteiro refente ao tipo de carta.
     */
    public static int getTipoCarta() {
        return tipoCarta;
    }

    /**
     * @return retorna a quantidade total de jogadores.
     */
    public static int getQuantidadeJogadores() {
        return quantidadeTotalJogadores;
    }

    /**
     * @return a rodada atual.
     */
    public static int getRodadaAtual() {
        return rodadaAtual;
    }

    /**
     * Aumenta uma rodada da rodada atual.
     */
    public static void aumenteRodadaAtual() {
        rodadaAtual++;
    }

    /**
     * @return lista de todos os jogadores.
     */
    public static List<Jogador> getListJogadores() {
        return listJogadores;
    }

    public static void setJogador(Jogador jogador) {
        listJogadores.add(jogador);
    }

    /**
     * @return a quantidade total de rodadas.
     */
    public static int getQuantidadeRodadas() {
        return quantidadeRodadas;
    }

    /**
     * Inseri o inteiro responsável por declarar qual tipo de carta será utilizada
     * no jogo.
     * 
     * @param novoTipoCarta é o inteiro referente ao tipo de carta.
     * @throws CartaInexistente quando é passado como argumento um valor
     *                          correspondente ao tipo de carta inválida.
     * @throws EntradaNegativa  quando é passado como argumento um valor negativo.
     * @throws ZeroInvalido     quando é passado como argumento um valor zero.
     */
    public static void setTipoCarta(int novoTipoCarta)
            throws CartaInexistente, EntradaNegativa, ZeroInvalido {
        if (novoTipoCarta == 0)
            throw new ZeroInvalido();
        novoTipoCarta--;

        if (novoTipoCarta > (Constantes.QUANTIDADE_MAXIMA_CARTAS.getValor() - 1))
            throw new CartaInexistente();
        if (novoTipoCarta < 0)
            throw new EntradaNegativa();
        tipoCarta = novoTipoCarta;
    }

    /**
     * Inseri quantidade total de rodadas.
     * 
     * @param novaQuantidadeRodadas nova quantidade total de rodadas a ser inserida.
     * @throws ZeroInvalido    quando é passado como argumento o zero.
     * @throws ExcessoRodadas  quando é passado como argumento uma quantidade de
     *                         rodadas maior do que a quantidade máxima de rodadas.
     * @throws EntradaNegativa quando é passado como argumento um valor negativo.
     */
    public static void setQuantidadeRodadas(int novaQuantidadeRodadas)
            throws ZeroInvalido, ExcessoRodadas, EntradaNegativa {
        if (novaQuantidadeRodadas == 0)
            throw new ZeroInvalido();
        if (novaQuantidadeRodadas > Constantes.QUANTIDADE_MAXIMA_RODADAS.getValor())
            throw new ExcessoRodadas();
        if (novaQuantidadeRodadas < 0)
            throw new EntradaNegativa();
        quantidadeRodadas = novaQuantidadeRodadas;
    }

    /**
     * Inseri quantidade total de jogadores.
     * 
     * @param novaQuantidadeJogadores nova quantidade total de jogadores a ser
     *                                inserida.
     * @throws ExcessoJogadores quando é passado como argumento maior do que a
     *                          quantidade máxima de jogadores.
     * @throws EntradaNegativa  quando é passado como argumento um valor negativo.
     * @throws ZeroInvalido     quando é passado como argumento o zero.
     */
    public static void setQuantidadeJogadores(int novaQuantidadeJogadores)
            throws ExcessoJogadores, EntradaNegativa, ZeroInvalido {
        if (novaQuantidadeJogadores == 0)
            throw new ZeroInvalido();
        if (novaQuantidadeJogadores > Constantes.QUANTIDADE_MAXIMA_JOGADORES.getValor())
            throw new ExcessoJogadores();
        if (novaQuantidadeJogadores < 0)
            throw new EntradaNegativa();
        quantidadeTotalJogadores = novaQuantidadeJogadores;
    }

    /**
     * Printa o nome da carta de cada jogador na rodada atual.
     */
    private static void apresentaCartaPorJogador() {
        listJogadores.stream()
                .forEach(jogador -> System.out.println(
                        String.format("Jogador %s: %s",
                                jogador, jogador.getCarta())));
    }

    /**
     * Printa as pontuações de cada jogador na rodada atual.
     */
    private static void mostraPontuacoesRodadas() {
        listJogadores.stream()
                .filter(jogador -> jogador.getPontuacaoRodada() > 0)
                .forEach(jogador -> Recursos.mostraAviso(
                        String.format("Jogador %s ganhou %s pontos",
                                jogador, jogador.getPontuacaoRodada())));
    }

    /**
     * Atualiza as cartas de cada jogador na rodada atual.
     */
    private static void atualizaCartasJogadores() {
        listJogadores.stream()
                .forEach(jogador -> jogador.getCarta().atualizaCarta());
    }

    /**
     * Compara as pontuações das cartas dos jogadores na rodada atual.
     * 
     * @throws ExcessoPontos quando é tentado inserir mais pontos do que a
     *                       quantidade total rodadas.
     */
    public static void comparadorPontuacoes() throws ExcessoPontos {
        List<Boolean> verificadores = new ArrayList<>();
        verificadores.add(true);
        verificadores.add(true);
        verificadores.add(true);

        // Obter as pontuações das cartas na rodada atual
        List<Integer> pontuacoes = listJogadores.stream()
                .map(Jogador::getPontuacaoCarta)
                .collect(Collectors.toList());

        // Ordenar as pontuações das cartas em ordem decrescente
        Collections.sort(pontuacoes, Collections.reverseOrder());

        // Atribuir pontos aos jogadores correspondentes
        for (int indice = 0; indice < listJogadores.size(); indice++) {
            Jogador jogador = listJogadores.get(indice);
            int pontuacaoCarta = jogador.getPontuacaoCarta();

            if (verificadores.get(0) && pontuacaoCarta == pontuacoes.get(0)) {
                jogador.setPontoRodada(3);
                verificadores.set(0, false);
                continue;
            } else if (verificadores.get(1) && pontuacaoCarta == pontuacoes.get(1)) {
                jogador.setPontoRodada(2);
                verificadores.set(1, false);
                continue;
            } else if (verificadores.get(2) && pontuacaoCarta == pontuacoes.get(2)) {
                jogador.setPontoRodada(1);
                verificadores.set(2, false);
                continue;
            }
            // Adiciona zero na rodada do jogador que não ganhou na rodada atual.
            jogador.setPontoRodada(0);
        }
    }
}
