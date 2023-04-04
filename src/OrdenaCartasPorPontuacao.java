package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import src.CartaFactory.Carta;

// public class Comparadores {
//     // public static Comparator<List<Carta>> ordenaCartasPorPontuacao = new Comparator<List<Carta>>() {
//     //     @Override
//     //     public int compare(List<Carta> primeiroCartas, List<Carta> segundoCartas) {
//     //         // ordena as Listas em ordem decrescente
//     //         Collections.sort(primeiroCartas, Collections.reverseOrder());
//     //         Collections.sort(segundoCartas, Collections.reverseOrder());

//     //         for (int indice = 0; indice < primeiroCartas.size() && indice < segundoCartas.size(); indice++) {
//     //             int primeiroPonto = primeiroCartas.get(indice).getPontuacaoFinal();
//     //             int segundoPonto = segundoCartas.get(indice).getPontuacaoFinal();

//     //             if (primeiroPonto != segundoPonto) {
//     //                 return Carta.compare(primeiroPonto, segundoPonto);
//     //             }
//     //         }

//     //         return Carta.compare(primeiroCartas.size(), segundoCartas.size());
//     //     }
//     // };


// }


public class OrdenaCartasPorPontuacao implements Comparator<List<Carta>> {
    @Override
    public int compare(List<Carta> primeiroCartas, List<Carta> segundoCartas) {
        List<Integer> cartasIniciais = new ArrayList<>();
        List<Integer> cartasSecundarias = new ArrayList<>();

        for (Carta primeirasCartas : primeiroCartas) {
            cartasIniciais.add(primeirasCartas.getPontuacaoFinal());
        }

        for (Carta secundariasCartas : segundoCartas) {
            cartasSecundarias.add(secundariasCartas.getPontuacaoFinal());
        }

        // ordena as Listas em ordem decrescente
        Collections.sort(cartasIniciais, Collections.reverseOrder());
        Collections.sort(cartasSecundarias, Collections.reverseOrder());

        // compara os pontos em cada posição até encontrar uma diferença
        for (int indice = 0; indice < cartasIniciais.size() && indice < cartasSecundarias.size(); indice++) {
            int primeiroPonto = cartasIniciais.get(indice);
            int segundoPonto = cartasSecundarias.get(indice);

            // se os pontos são diferentes, a lista com o maior ponto é considerada "maior"
            if (primeiroPonto != segundoPonto) {
                return Integer.compare(primeiroPonto, segundoPonto);
            }
        }

        // se todas as posições forem iguais, a lista com mais pontos é considerada "maior"
        return Integer.compare(primeiroCartas.size(), segundoCartas.size());
    }
}