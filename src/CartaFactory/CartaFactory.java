package src.CartaFactory;

import java.util.HashMap;
import java.util.Map;

public class CartaFactory {
    public static Carta criaCarta(int tipoCarta) {
        Map<Integer, Carta> cartas = new HashMap<>(){
            {
                put(0, new CartaNormal());
                put(1, new CartaNaipe());
                put(2, new CartaValor());
            }
        };
        
        return cartas.get(tipoCarta);
    }
}
