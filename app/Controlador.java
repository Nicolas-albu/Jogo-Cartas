package app;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import errors.CartaInexistente;
import errors.ExcessoJogadores;
import errors.EntradaNegativa;
import errors.ExcessoRodadas;
import errors.ExcessoPontos;
import errors.NuloInvalido;
import errors.ZeroInvalido;

import src.Jogador;
import src.Rodada;

/**
 * Classe responsável por controlar o fluxo geral do jogo.
 */
public class Controlador {
    private Scanner leitor = new Scanner(System.in);

    /**
     * Cria um novo controlador geral do jogo.
     */
    public Controlador() {
        this.trataEntradaQuantidadeRodadas(
                String.format("Quantas rodadas (padrão é %s)? ",
                        Constantes.QUANTIDADE_PADRAO_RODADAS.getValor()));
        this.trataEntradaQuantidadeJogadores(
                String.format("Quantos jogadores (máximo de %s)? ",
                        Constantes.QUANTIDADE_MAXIMA_JOGADORES.getValor()));
        this.tratamentoNomeJogadores();
        this.trataEntradaTipoCarta("Qual o tipo de carta do jogo? ");

        Rodada.getListJogadores().stream()
                .forEach(Jogador::criaCarta);

        this.controlaRodadas();
        this.apresentaVencedoresFinais();
    }

    /**
     * Cria um novo jogador e adiciona a lista de jogadores.
     * 
     * @param nome é o nome do novo jogador.
     */
    private void criaJogador(String nome) {
        try {
            Rodada.setJogador(new Jogador(nome));
        } catch (ExcessoJogadores error) {
            Recursos.mostraException("Não pode passar do limite de jogadores");
        }
    }

    /**
     * Recebe entradas do tipo inteiro e verifica se contém espaço ou nada.
     * 
     * @return retorna o valor inteiro.
     * @throws NuloInvalido quando é recebido pelo Scanner um espaço ou nada.
     */
    private int recebeEntradasInteiro() throws NuloInvalido {
        String entrada = leitor.nextLine();

        if (entrada.isBlank() || entrada.isEmpty())
            throw new NuloInvalido();

        return Integer.parseInt(entrada);
    }

    /**
     * Recebe entradas do tipo String e verifica se contém espaço ou nada.
     * 
     * @param mensagemEntrada mensagem a ser exibida.
     */
    private void trataEntradaQuantidadeRodadas(String mensagemEntrada) {
        while (true) {
            try {
                System.out.print(mensagemEntrada);
                String entrada = leitor.nextLine();

                if (entrada.isBlank() || entrada.isEmpty())
                    break;

                int quantidadeRodadas = Integer.parseInt(entrada);
                Rodada.setQuantidadeRodadas(quantidadeRodadas);
                break;

            } catch (NumberFormatException error) {
                Recursos.mostraException("Insira apenas valores inteiros");
                continue;
            } catch (ExcessoRodadas error) {
                Recursos.mostraException(
                        String.format("Não pode inserir mais de %s rodadas",
                                Constantes.QUANTIDADE_MAXIMA_RODADAS.getValor()));
                continue;
            } catch (EntradaNegativa error) {
                Recursos.mostraException("Não pode inserir inteiros negativos");
                continue;
            } catch (ZeroInvalido error) {
                Recursos.mostraException("Não pode inserir zero");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    /**
     * Recebe entradas do tipo Integer para tratar a quantidade de jogadores.
     * 
     * @param mensagemEntrada mensagem a ser exibida.
     */
    private void trataEntradaQuantidadeJogadores(String mensagemEntrada) {
        while (true) {
            try {
                System.out.print(mensagemEntrada);
                Rodada.setQuantidadeJogadores(this.recebeEntradasInteiro());
                break;

            } catch (NumberFormatException error) {
                Recursos.mostraException("Insira apenas valores inteiros");
                continue;
            } catch (ExcessoJogadores error) {
                Recursos.mostraException((String.format("Não pode inserir mais de %s jogadores",
                        Constantes.QUANTIDADE_MAXIMA_JOGADORES.getValor())));
                continue;
            } catch (EntradaNegativa error) {
                Recursos.mostraException("Não pode inserir inteiros negativos");
                continue;
            } catch (ZeroInvalido error) {
                Recursos.mostraException("Não pode inserir zero");
                continue;
            } catch (NuloInvalido error) {
                Recursos.mostraException("Insira apenas a quantidade de jogadores");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    /**
     * Recebe entradas do tipo String para tratar o nome dos jogadores.
     * 
     * @throws NuloInvalido quando é recebido pelo Scanner um espaço ou nada.
     */
    private void tratamentoNomeJogadores() {
        int jogador = 0;
        while (true) {
            try {
                if (jogador < Rodada.getQuantidadeJogadores()) {
                    System.out.print(String.format("Qual o nome do jogador %s? ", jogador + 1));
                } else
                    break;

                String entrada = leitor.nextLine();
                if (entrada.isBlank() || entrada.isEmpty())
                    throw new NuloInvalido();

                this.criaJogador(entrada);
                jogador++;

                continue;

            } catch (NuloInvalido error) {
                Recursos.mostraException("Insira apenas o nome do jogador");
                continue;
            } finally {
                System.out.println();
            }
        }
    }

    /**
     * Recebe entradas do tipo Integer para tratar o tipo de carta.
     * 
     * @param mensagemEntrada mensagem a ser exibida.
     */
    private void trataEntradaTipoCarta(String mensagemEntrada) {
        List<String> cartas = Arrays.asList("Carta Normal", "Carta Naipe", "Carta Valor");

        while (true) {
            try {
                for (String carta : cartas) {
                    System.out.println(String.format("[%s] %s", cartas.indexOf(carta) + 1, carta));
                }
                System.out.print(mensagemEntrada);
                Rodada.setTipoCarta(this.recebeEntradasInteiro());
                break;

            } catch (NumberFormatException error) {
                Recursos.mostraException("Insira apenas os números das opções");
                continue;
            } catch (EntradaNegativa error) {
                Recursos.mostraException("Não pode inserir inteiros negativos");
                continue;
            } catch (CartaInexistente error) {
                Recursos.mostraException("O tipo de carta inserida não existe");
                continue;
            } catch (ZeroInvalido error) {
                Recursos.mostraException("Não pode inserir zero");
                continue;
            } catch (NuloInvalido error) {
                Recursos.mostraException("Insira apenas os números dos tipos de cartas");
                continue;
            } finally {
                System.out.println();
            }
        }
    }

    /**
     * Controla todas as rodadas.
     */
    private void controlaRodadas() {
        while (Rodada.getRodadaAtual() <= Rodada.getQuantidadeRodadas()) {
            try {
                Rodada.executeRodada(leitor);

                // Gera uma nova pontuação das cartas para a próxima rodada.
                Rodada.getListJogadores().stream()
                        .forEach(Jogador::gerePontuacaoRodada);

                Rodada.aumenteRodadaAtual();
            } catch (ExcessoPontos error) {
                Recursos.mostraException("Erro no processo de pontuação");
                continue;
            } finally {
                System.out.println();
            }
        }
    }

    /**
     * Apresenta os vencedores finais.
     */
    private void apresentaVencedoresFinais() {
        // Ativa a geração de pontuação final de cada jogador.
        Rodada.getListJogadores().stream()
                .forEach(Jogador::gerePontuacaoFinal);

        // Obtém uma lista das pontuações finais de cada jogador.
        List<Integer> pontuacoesFinais = Rodada.getListJogadores().stream()
                .map(Jogador::getPontuacaoFinal).collect(Collectors.toList());

        // Obtém a maior pontuação final.
        int pontuacaoFinalMaxima = Collections.max(pontuacoesFinais);

        Recursos.mostraAviso("VENCEDOR FINAL");
        Rodada.getListJogadores().stream()
                .filter(jogador -> jogador.getPontuacaoFinal() == pontuacaoFinalMaxima)
                .forEach(jogador -> Recursos.mostraResultado(
                        String.format("Jogador %s venceu com %s pontos!",
                                jogador, jogador.getPontuacaoFinal())));
    }
}