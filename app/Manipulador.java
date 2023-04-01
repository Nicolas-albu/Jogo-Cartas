package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import error.EntradaNegativo;
import error.ExcessoJogador;
import error.ExcessoRodadas;
import src.Jogador;


public class Manipulador {
    private int quantidadeRodadas = 3;
    private int quantidadeJogadores;

    Scanner leitor = new Scanner(System.in);

    private void setQuantidadeRodadas(int novaQuantidadeRodadas) throws ExcessoRodadas, EntradaNegativo {
        if (novaQuantidadeRodadas > 7) throw new ExcessoRodadas();
        if (novaQuantidadeRodadas < 0) throw new EntradaNegativo();
        this.quantidadeRodadas = novaQuantidadeRodadas;
    }

    public void setQuantidadeJogadores(int novaQuantidadeJogadores) throws ExcessoJogador, EntradaNegativo {
        if (novaQuantidadeJogadores > 5) throw new ExcessoJogador();
        if (novaQuantidadeJogadores < 0) throw new EntradaNegativo();
        this.quantidadeJogadores = novaQuantidadeJogadores;
    }

    private void criarJogador(String nome){
        try {
            Jogador player = new Jogador(nome);
        } catch (ExcessoJogador error){
            System.out.println("Não pode passar do limite de jogadores.");
        }
    }

    private void trataEntradaQuantidadeRodadas(String mensagemEntrada){
        try {
            System.out.print(mensagemEntrada);
            String saida = leitor.nextLine();
            
            if (saida.isBlank() || saida.isEmpty()) return;
            
            int quantidadeRodadas = Integer.parseInt(saida);
            this.setQuantidadeRodadas(quantidadeRodadas);

        } catch (NumberFormatException error){
            System.out.println("Insira apenas valores inteiros.");
        } catch (ExcessoRodadas error) {
            System.out.println("Não pode inserir mais de 7 rodadas.");
        } catch (EntradaNegativo error){
            System.out.println("Não pode inserir inteiros negativos.");
        }
    }

    private void trataEntradaQuantidadeJogadores(String mensagemEntrada){
        try {
            System.out.print(mensagemEntrada);
            this.setQuantidadeJogadores(leitor.nextInt());
            
        } catch (InputMismatchException error){
            System.out.println("Insira apenas valores inteiros.");
        } catch (ExcessoJogador error) {
            System.out.println("Não pode inserir mais de 5 jogadores.");
        } catch (EntradaNegativo error){
            System.out.println("Não pode inserir inteiros negativos.");
        }
    }

    public Manipulador(){    
        this.trataEntradaQuantidadeRodadas("Quantas rodadas (padrão é 3)? ");    
        this.trataEntradaQuantidadeJogadores("Quantos jogadores (máximo de 5)? ");
    }
}