package src;

import error.ExcessoJogador;

public class Jogador {
    private String nome;
    private static int quantidadeJogadores;

    public static int getQuantidadeJogadores(){
        return quantidadeJogadores;
    }

    private void setQuantidadeJogadores(){
        quantidadeJogadores++; 
    }
    
    public String getNome(){
        return this.nome;
    }


    public Jogador(String nome) throws ExcessoJogador {
        this.setQuantidadeJogadores();
        if (getQuantidadeJogadores() > 5) throw new ExcessoJogador();
        this.nome = nome;
    }

}
