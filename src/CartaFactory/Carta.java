package src.CartaFactory;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

/**
 * Classe abstrata que representa todos os tipos de cartas no jogo.
 */
public abstract class Carta {
    protected Random geradorAleatorio = new Random();
    protected int pontuacaoCarta;
    private String nomeValorCarta;
    private int valorCarta;

    /**
     * Cria uma nova carta.
     */
    public Carta() {
        this.novoValorCarta();
    }

    /**
     * Calcula a pontuação da carta.
     */
    public abstract void geraPontuacaoRodada();

    /**
     * @return retorna o inteiro correspondente a pontuação da
     *         carta na rodada atual.
     */
    public abstract int getPontuacaoRodada();

    /**
     * @return retorna o inteiro correspondente ao tipo de carta.
     */
    public abstract String getTipoCarta();

    /**
     * Atualiza todos os dados necessários da carta.
     * Se for uma CartaNormal ou CartaValor, irá gerar um novo valor da carta
     * (novoValorCarta) e um novo valor de naipe (geraValorNaipe).
     * Se for uma CartaNaipe, irá gerar apenas um novo valor da carta
     * (novoValorCarta).
     */
    public abstract void atualizaCarta();

    /**
     * Gera um novo valor para a carta.
     */
    protected void novoValorCarta() {
        this.geraValorCarta();
        this.geraNomeValorCarta();
    }

    /**
     * @return retorna o nome correspondente ao valor da carta.
     */
    protected String getNomeValorCarta() {
        return this.nomeValorCarta;
    }

    /**
     * @return retorna o valor da carta.
     */
    protected int getValorCarta() {
        return this.valorCarta;
    }

    /**
     * Gera o valor da carta.
     */
    private void geraValorCarta() {
        this.valorCarta = geradorAleatorio.nextInt(12) + 1;
    }

    /**
     * Gera o nome correspondente ao valor da carta.
     */
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
