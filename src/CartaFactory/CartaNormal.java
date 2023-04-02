package src.CartaFactory;

import java.util.HashMap;
import java.util.Map;

public class CartaNormal extends Carta {
    protected int pontuacaoFinal;
    private String nomeNaipe;
    private int valorNaipe;

    public CartaNormal() {
        super();
        this.geraValorNaipe();
        this.geraNomeNaipe();
    }

    @Override
    public void geraPontuacaoFinal() {
        this.pontuacaoFinal = super.getValorCarta() * this.valorNaipe;
    }

    @Override
    public int getPontuacaoFinal() {
        return this.pontuacaoFinal;
    }

    @Override
    public String getTipoCarta() {
        return "Carta Normal";
    }

    @Override
    public String getNomeCarta() {
        if (super.getNomeValorCarta() == null) {
            return String.format("%s de %s", this.getValorCarta(), this.getNomeNaipe());
        }
        return String.format("%s de %s", this.getNomeValorCarta(), this.getNomeNaipe());
    }

    @Override
    public void novaCarta() {
        super.novoValorCarta();
        this.geraValorNaipe();
        this.geraNomeNaipe();
    }

    private String getNomeNaipe() {
        return this.nomeNaipe;
    }

    private void geraValorNaipe() {
        this.valorNaipe = geradorAleatorio.nextInt(3, 6);
    }

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