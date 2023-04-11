package src.CartaFactory;

public class CartaNaipe extends Carta {

    public CartaNaipe() {
        super();
        this.geraPontuacaoRodada();
    }

    @Override
    public void geraPontuacaoRodada() {
        super.pontuacaoCarta = super.getValorCarta();
    }

    @Override
    public int getPontuacaoRodada() {
        return super.pontuacaoCarta;
    }

    @Override
    public String getTipoCarta() {
        return "Carta Naipe";
    }

    @Override
    public String toString() {
        return Integer.toString(super.getValorCarta());
    }

    @Override
    public void atualizaCarta() {
        super.novoValorCarta();
    }
}
