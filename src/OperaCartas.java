package src;

import java.util.List;

import src.CartaFactory.Carta;

public class OperaCartas {
    public static int somaPontuacaoFinal(List<Carta> cartas) {
        int soma = 0;
        for (Carta carta : cartas) {
            soma += carta.getPontuacaoFinal();
        }
        return soma;
    }
}
