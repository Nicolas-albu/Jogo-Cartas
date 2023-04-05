package src;

import java.util.List;

import src.CartaFactory.Carta;

public class Pontuacao {
    private int pontuacaoFinal;
    
    public Pontuacao(List<Carta> cartas) {
        this.pontuacaoFinal = somaPontuacaoFinal(cartas);
    }

    private static int somaPontuacaoFinal(List<Carta> cartas) {
        int soma = 0;
        for (Carta carta : cartas) {
            soma += carta.getPontuacaoFinal();
        }
        return soma;
    } 
    
    public int getPontuacaoFinal() {
        return this.pontuacaoFinal;
    }
}
