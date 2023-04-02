package app;

import java.util.ArrayList;
import java.util.Scanner;
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

    private void setQuantidadeRodadas(int novaQuantidadeRodadas) throws ExcessoRodadas, EntradaNegativo, ZeroInvalido {
        if (novaQuantidadeRodadas == 0) throw new ZeroInvalido();
        if (novaQuantidadeRodadas > 7) throw new ExcessoRodadas();
        if (novaQuantidadeRodadas < 0) throw new EntradaNegativo();
        this.quantidadeRodadas = novaQuantidadeRodadas;
    }

    private void setQuantidadeJogadores(int novaQuantidadeJogadores) throws ExcessoJogador, EntradaNegativo, ZeroInvalido {
        if (novaQuantidadeJogadores == 0) throw new ZeroInvalido();
        if (novaQuantidadeJogadores > 5) throw new ExcessoJogador();
        if (novaQuantidadeJogadores < 0) throw new EntradaNegativo();
        this.quantidadeJogadores = novaQuantidadeJogadores;
    }

    private void setTipoCarta(int novoTipoCarta) throws CartaInexistente, EntradaNegativo, ZeroInvalido {
        if (novoTipoCarta == 0) throw new ZeroInvalido();
        novoTipoCarta--;
        if (novoTipoCarta > 2) throw new CartaInexistente();
        if (novoTipoCarta < 0) throw new EntradaNegativo();
        this.tipoCarta = novoTipoCarta;
    }
    
    private void criarJogador(String nome){
        try {
            Jogador player = new Jogador(nome);
        } catch (ExcessoJogador error){
            System.out.println("Não pode passar do limite de jogadores.");
        }
    }

    private int tratamentoEntradas() throws NuloInvalido {
        String entrada = leitor.nextLine();
                
        if (entrada.isBlank() || entrada.isEmpty()) throw new NuloInvalido();
        
        return Integer.parseInt(entrada);
    }

    private void trataEntradaQuantidadeRodadas(String mensagemEntrada){
        while (true){
            try {
                System.out.print(mensagemEntrada);
                String entrada = leitor.nextLine();
                
                if (entrada.isBlank() || entrada.isEmpty()) break;
                
                int quantidadeRodadas = Integer.parseInt(entrada);
                this.setQuantidadeRodadas(quantidadeRodadas);
                break;

            } catch (NumberFormatException error) {
                System.out.println("Insira apenas valores inteiros.");
                continue;
            } catch (ExcessoRodadas error) {
                System.out.println("Não pode inserir mais de 7 rodadas.");
                continue;
            } catch (EntradaNegativo error) {
                System.out.println("Não pode inserir inteiros negativos.");
                continue;
            } catch (ZeroInvalido error) {
                System.out.println("Não pode inserir zero.");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    private void trataEntradaQuantidadeJogadores(String mensagemEntrada){
        while (true){
            try {
                System.out.print(mensagemEntrada);
                this.setQuantidadeJogadores(this.tratamentoEntradas());
                break;
    
            } catch (NumberFormatException error) {
                System.out.println("Insira apenas valores inteiros.");
                continue;
            } catch (ExcessoJogador error) {
                System.out.println("Não pode inserir mais de 5 jogadores.");
                continue;
            } catch (EntradaNegativo error) {
                System.out.println("Não pode inserir inteiros negativos.");
                continue;
            } catch (ZeroInvalido error) {
                System.out.println("Não pode inserir zero.");
                continue;
            } catch (NuloInvalido error) {
                System.out.println("Insira apenas a quantidade de jogadores.");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }
    }

    private void trataEntradaTipoCarta(String mensagemEntrada){
        List<String> cartas = new ArrayList<>();
        cartas.add("Carta Normal");
        cartas.add("Carta Naipe");
        cartas.add("Carta Valor");

        while (true) {
            try {
                for (String carta : cartas) {
                    System.out.println("[" + (cartas.indexOf(carta)+1) + "] " + carta);;
                }
                System.out.print(mensagemEntrada);
                this.setTipoCarta(this.tratamentoEntradas());
                break;

            } catch (NumberFormatException error) {
                System.out.println("Insira apenas os números das opções.");
                continue;
            } catch (EntradaNegativo error) {
                System.out.println("Não pode inserir inteiros negativos.");
                continue;
            } catch (CartaInexistente error) {
                System.out.println("O tipo de carta inserida não existe.");
                continue;
            } catch (ZeroInvalido error) {
                System.out.println("Não pode inserir zero.");
                continue;
            } catch (NuloInvalido error) {
                System.out.println("Insira apenas os números dos tipos de cartas.");
                continue;
            } finally {
                System.out.println(); // Quebra de linha para todos os casos
            }
        }       
    }

    public Manipulador(){
        this.trataEntradaQuantidadeRodadas("Quantas rodadas (padrão é 3)? ");
        this.trataEntradaQuantidadeJogadores("Quantos jogadores (máximo de 5)? ");
        this.trataEntradaTipoCarta("Qual o tipo de carta do jogo? ");
    }
}