package src;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import app.Constantes;
import app.Recursos;
import errors.CartaInexistente;
import errors.EntradaNegativo;
import errors.ExcessoJogador;
import errors.ExcessoRodadas;
import errors.ExcessoPontos;
import errors.ZeroInvalido;

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
     * @throws EntradaNegativo  quando é passado como argumento um valor negativo.
     * @throws ZeroInvalido     quando é passado como argumento um valor zero.
     */
    public static void setTipoCarta(int novoTipoCarta)
            throws CartaInexistente, EntradaNegativo, ZeroInvalido {
        if (novoTipoCarta == 0)
            throw new ZeroInvalido();
        novoTipoCarta--;

        if (novoTipoCarta > (Constantes.QUANTIDADE_MAXIMA_CARTAS.getValor() - 1))
            throw new CartaInexistente();
        if (novoTipoCarta < 0)
            throw new EntradaNegativo();
        tipoCarta = novoTipoCarta;
    }

    /**
     * Inseri quantidade total de rodadas.
     * 
     * @param novaQuantidadeRodadas nova quantidade total de rodadas a ser inserida.
     * @throws ZeroInvalido    quando é passado como argumento o zero.
     * @throws ExcessoRodadas  quando é passado como argumento uma quantidade de
     *                         rodadas maior do que a quantidade máxima de rodadas.
     * @throws EntradaNegativo quando é passado como argumento um valor negativo.
     */
    public static void setQuantidadeRodadas(int novaQuantidadeRodadas)
            throws ZeroInvalido, ExcessoRodadas, EntradaNegativo {
        if (novaQuantidadeRodadas == 0)
            throw new ZeroInvalido();
        if (novaQuantidadeRodadas > Constantes.QUANTIDADE_MAXIMA_RODADAS.getValor())
            throw new ExcessoRodadas();
        if (novaQuantidadeRodadas < 0)
            throw new EntradaNegativo();
        quantidadeRodadas = novaQuantidadeRodadas;
    }

    /**
     * Inseri quantidade total de jogadores.
     * 
     * @param novaQuantidadeJogadores nova quantidade total de jogadores a ser
     *                                inserida.
     * @throws ExcessoJogador  quando é passado como argumento maior do que a
     *                         quantidade máxima de jogadores.
     * @throws EntradaNegativo quando é passado como argumento um valor negativo.
     * @throws ZeroInvalido    quando é passado como argumento o zero.
     */
    public static void setQuantidadeJogadores(int novaQuantidadeJogadores)
            throws ExcessoJogador, EntradaNegativo, ZeroInvalido {
        if (novaQuantidadeJogadores == 0)
            throw new ZeroInvalido();
        if (novaQuantidadeJogadores > Constantes.QUANTIDADE_MAXIMA_JOGADORES.getValor())
            throw new ExcessoJogador();
        if (novaQuantidadeJogadores < 0)
            throw new EntradaNegativo();
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
                .forEach(jogador -> System.out.println(
                        String.format("Jogador %s ganhou %s pontos",
                                jogador, jogador.getPontuacaoRodada())));
    }

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
        // Obter as pontuações das cartas na rodada atual
        List<Integer> pontuacoes = listJogadores.stream()
                .map(Jogador::getPontuacaoCarta)
                .collect(Collectors.toList());

        System.out.println(pontuacoes);

        // Ordenar as pontuações das cartas em ordem decrescente
        Collections.sort(pontuacoes, Collections.reverseOrder());

        // Atribuir pontos aos jogadores correspondentes
        for (int indice = 0; indice < listJogadores.size(); indice++) {
            Jogador jogador = listJogadores.get(indice);
            int pontuacaoCarta = jogador.getPontuacaoCarta();

            if (pontuacaoCarta == pontuacoes.get(0))
                jogador.setPontoRodada(3);
            else if (pontuacaoCarta == pontuacoes.get(1))
                jogador.setPontoRodada(2);
            else if (pontuacaoCarta == pontuacoes.get(2))
                jogador.setPontoRodada(1);
        }
    }
}
