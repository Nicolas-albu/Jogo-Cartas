package src.CartaFactory;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por alicar o Design Pattern Factory Method, para a criação
 * de cartas normais, naipes e valores.
 */
public class CartaFactory {
    /*
     * No caso da fábrica de cartas, cada entrada no mapa "cartas" associa um tipo
     * de carta (representado por um inteiro) a uma função que cria um objeto
     * "Carta" correspondente.
     */
    public static Carta criaCarta(int tipoCarta) {
        Map<Integer, Supplier<Carta>> cartas = new HashMap<>() {
            {
                put(0, CartaNormal::new);
                put(1, CartaNaipe::new);
                put(2, CartaValor::new);
            }
        };

        return cartas.getOrDefault(tipoCarta, () -> null).get();
    }
}
