package src.CartaFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa uma carta do tipo normal.
 */
public class CartaNormal extends Carta {
    private String nomeNaipe;
    private int valorNaipe;

    /**
     * Cria uma nova carta normal.
     */
    public CartaNormal() {
        super();
        this.geraValorNaipe();
        this.geraNomeNaipe();
        this.geraPontuacaoRodada();
    }

    @Override
    public void geraPontuacaoRodada() {
        super.pontuacaoCarta = super.getValorCarta() * this.valorNaipe;
    }

    @Override
    public int getPontuacaoRodada() {
        return super.pontuacaoCarta;
    }

    @Override
    public String getTipoCarta() {
        return "Carta Normal";
    }

    @Override
    public String toString() {
        if (super.getNomeValorCarta() == null) {
            return String.format("%s de %s", this.getValorCarta(), this.getNomeNaipe());
        }
        return String.format("%s de %s", this.getNomeValorCarta(), this.getNomeNaipe());
    }

    @Override
    public void atualizaCarta() {
        super.novoValorCarta();
        this.geraValorNaipe();
        this.geraNomeNaipe();
    }

    /**
     * @return retorna o nome do naipe da carta.
     */
    private String getNomeNaipe() {
        return this.nomeNaipe;
    }

    /**
     * Gera o valor do naipe da carta normal.
     */
    private void geraValorNaipe() {
        this.valorNaipe = geradorAleatorio.nextInt(3, 6);
    }

    /**
     * Gera o nome do naipe da carta normal.
     */
    private void geraNomeNaipe() {
        Map<Integer, String> naipes = new HashMap<>() {
            {
                put(2, "Paus");
                put(3, "Ouros");
                put(4, "Copas");
                put(5, "Espadas");
            }
        };

        this.nomeNaipe = naipes.get(this.valorNaipe);
    }
}
