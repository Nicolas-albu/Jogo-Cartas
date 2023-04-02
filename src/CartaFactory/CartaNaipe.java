package src.CartaFactory;

public class CartaNaipe extends Carta {
    private int pontuacaoFinal;

    public CartaNaipe() {
        super();
    }

    @Override
    public void geraPontuacaoFinal() {
        this.pontuacaoFinal = super.getValorCarta();
    }

    @Override
    public int getPontuacaoFinal() {
        return this.pontuacaoFinal;
    }

    @Override
    public String getTipoCarta() {
        return "Carta Naipe";
    }

    @Override
    public String getNomeCarta() {
        return Integer.toString(pontuacaoFinal);
    }

    @Override
    public void novaCarta() {
        super.novoValorCarta();
    }
}
