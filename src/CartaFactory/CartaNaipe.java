package src.CartaFactory;

public class CartaNaipe extends Carta {

    public CartaNaipe() {
        super();
        this.geraPontuacaoFinal();
    }

    @Override
    public void geraPontuacaoFinal() {
        super.pontuacaoFinal = super.getValorCarta();
    }

    @Override
    public int getPontuacaoFinal() {
        return super.pontuacaoFinal;
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
