package src;

import java.util.Comparator;

public class PontuacaoComparator implements Comparator<Pontuacao> {

    @Override
    public int compare(Pontuacao pontos1, Pontuacao pontos2) {
        return Integer.compare(pontos1.getPontuacaoFinal(), pontos2.getPontuacaoFinal());
    }
    // @Override
    // public int compareTo(List<Carta> primeiroCartas) {

    //     // ordena as Listas em ordem decrescente
    //     Collections.sort(cartasIniciais, Collections.reverseOrder());
    //     Collections.sort(cartasSecundarias, Collections.reverseOrder());

    //     // compara os pontos em cada posição até encontrar uma diferença
    //     for (int indice = 0; indice < cartasIniciais.size() && indice < cartasSecundarias.size(); indice++) {
    //         int primeiroPonto = cartasIniciais.get(indice);
    //         int segundoPonto = cartasSecundarias.get(indice);

    //         // se os pontos são diferentes, a lista com o maior ponto é considerada "maior"
    //         if (primeiroPonto != segundoPonto) {
    //             return Integer.compare(primeiroPonto, segundoPonto);
    //         }
    //     }

    //     // se todas as posições forem iguais, a lista com mais pontos é considerada "maior"
    //     return Integer.compare(primeiroCartas.size(), segundoCartas.size());
    // }
}