package app;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import error.CartaInexistente;
import error.EntradaNegativo;
import error.ExcessoJogador;
import error.ExcessoRodadas;
import error.NuloInvalido;
import error.ZeroInvalido;
import src.Jogador;

public class Manipulador {
    private int quantidadeRodadas = 3;
    private int quantidadeJogadores;
    private int tipoCarta;

    Scanner leitor = new Scanner(System.in);

    private void setQuantidadeRodadas(int novaQuantidadeRodadas)
            throws ExcessoRodadas, EntradaNegativo, ZeroInvalido {
        if (novaQuantidadeRodadas == 0)
            throw new ZeroInvalido();
        if (novaQuantidadeRodadas > 7)
            throw new ExcessoRodadas();
        if (novaQuantidadeRodadas < 0)
            throw new EntradaNegativo();
        this.quantidadeRodadas = novaQuantidadeRodadas;
    }

    private void setQuantidadeJogadores(int novaQuantidadeJogadores)
            throws ExcessoJogador, EntradaNegativo, ZeroInvalido {
        if (novaQuantidadeJogadores == 0)
            throw new ZeroInvalido();
        if (novaQuantidadeJogadores > 5)
            throw new ExcessoJogador();
        if (novaQuantidadeJogadores < 0)
            throw new EntradaNegativo();
        this.quantidadeJogadores = novaQuantidadeJogadores;
    }

    private void setTipoCarta(int novoTipoCarta)
            throws CartaInexistente, EntradaNegativo, ZeroInvalido {
        if (novoTipoCarta == 0)
            throw new ZeroInvalido();
        novoTipoCarta--;
        if (novoTipoCarta > 2)
            throw new CartaInexistente();
        if (novoTipoCarta < 0)
            throw new EntradaNegativo();
        this.tipoCarta = novoTipoCarta;
    }

    private static void mostraException(String mensagemException){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_RED + mensagemException + ANSI_RESET);
    }

    private void criaJogador(String nome) {
        try {
            Jogador player = new Jogador(nome);
        } catch (ExcessoJogador error) {
            mostraException("Não pode passar do limite de jogadores");
            // System.out.println("Não pode passar do limite de jogadores.");
        }
    }

    private int recebeEntradas() throws NuloInvalido {
        String entrada = leitor.nextLine();

        if (entrada.isBlank() || entrada.isEmpty())
            throw new NuloInvalido();

        return Integer.parseInt(entrada);
    }

    private void trataEntradaQuantidadeRodadas(String mensagemEntrada) {
        while (true) {
            try {
                System.out.print(mensagemEntrada);
                String entrada = leitor.nextLine();

                if (entrada.isBlank() || entrada.isEmpty())
                    break;

                int quantidadeRodadas = Integer.parseInt(entrada);
                this.setQuantidadeRodadas(quantidadeRodadas);
                break;

            } catch (NumberFormatException error) {
                mostraException("Insira apenas valores inteiros");
                continue;
            } catch (ExcessoRodadas error) {
                mostraException("Não pode inserir mais de 7 rodadas");
                continue;
            } catch (EntradaNegativo error) {
                mostraException("Não pode inserir inteiros negativos");
                continue;
            } catch (ZeroInvalido error) {
                mostraException("Não pode inserir zero");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    private void trataEntradaQuantidadeJogadores(String mensagemEntrada) {
        while (true) {
            try {
                System.out.print(mensagemEntrada);
                this.setQuantidadeJogadores(this.recebeEntradas());
                break;

            } catch (NumberFormatException error) {
                mostraException("Insira apenas valores inteiros");
                continue;
            } catch (ExcessoJogador error) {
                mostraException("Não pode inserir mais de 5 jogadores");
                continue;
            } catch (EntradaNegativo error) {
                mostraException("Não pode inserir inteiros negativos");
                continue;
            } catch (ZeroInvalido error) {
                mostraException("Não pode inserir zero");
                continue;
            } catch (NuloInvalido error) {
                mostraException("Insira apenas a quantidade de jogadores");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    private void tratamentoNomeJogadores() {
        int jogador = 0;
        while (true) {
            try {
                if (jogador < this.quantidadeJogadores) {
                    System.out.print(String.format("Qual o nome do jogador %s? ", jogador+1));
                } else {
                    break;
                }
                String entrada = leitor.nextLine();

                if (entrada.isBlank() || entrada.isEmpty())
                    throw new NuloInvalido();

                this.criaJogador(entrada);
                jogador++;
                continue;

            } catch (NuloInvalido error) {
                mostraException("Insira apenas o nome do jogador");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    private void trataEntradaTipoCarta(String mensagemEntrada) {
        List<String> cartas = Arrays.asList("Carta Normal", "Carta Naipe", "Carta Valor");

        while (true) {
            try {
                for (String carta : cartas) {
                    System.out.println(String.format("[%s] %s", cartas.indexOf(carta)+1, carta));
                }
                System.out.print(mensagemEntrada);
                this.setTipoCarta(this.recebeEntradas());
                break;

            } catch (NumberFormatException error) {
                mostraException("Insira apenas os números das opções");
                continue;
            } catch (EntradaNegativo error) {
                mostraException("Não pode inserir inteiros negativos");
                continue;
            } catch (CartaInexistente error) {
                mostraException("O tipo de carta inserida não existe");
                continue;
            } catch (ZeroInvalido error) {
                mostraException("Não pode inserir zero");
                continue;
            } catch (NuloInvalido error) {
                mostraException("Insira apenas os números dos tipos de cartas");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    public Manipulador() {
        this.trataEntradaQuantidadeRodadas("Quantas rodadas (padrão é 3)? ");
        this.trataEntradaQuantidadeJogadores("Quantos jogadores (máximo de 5)? ");
        this.tratamentoNomeJogadores();
        this.trataEntradaTipoCarta("Qual o tipo de carta do jogo? ");
    }
}