package src.CartaFactory;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public abstract class Carta {
    protected Random geradorAleatorio = new Random();
    protected int pontuacaoFinal;
    private String nomeValorCarta;
    private int valorCarta;

    public Carta() {
        this.novoValorCarta();
    }

    public abstract void geraPontuacaoFinal();

    public abstract int getPontuacaoFinal();

    public abstract String getTipoCarta();

    public abstract String getNomeCarta();

    public abstract void novaCarta();

    protected void novoValorCarta() {
        this.geraValorCarta();
        this.geraNomeValorCarta();
    }

    protected String getNomeValorCarta() {
        return this.nomeValorCarta;
    }

    protected int getValorCarta() {
        return this.valorCarta;
    }

    private void geraValorCarta() {
        this.valorCarta = geradorAleatorio.nextInt(12) + 1;
    }

    private void geraNomeValorCarta() {
        Map<Integer, String> nomeValorCarta = new HashMap<>() {
            {
                put(1, "Ás");
                put(11, "Valete");
                put(12, "Dama");
                put(13, "Rei");
            }
        };

        this.nomeValorCarta = nomeValorCarta.get(this.valorCarta);
    }
}
