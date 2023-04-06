package src.CartaFactory;

public class CartaValor extends CartaNormal {
    public CartaValor() {
        super();
    }

    @Override
    public void geraPontuacaoRodada() {
        if (this.isPrimo(super.getValorCarta())) {
            super.pontuacaoCarta = super.getPontuacaoRodada() * 3;
            return;
        }
        super.geraPontuacaoRodada();
    }

    private boolean isPrimo(int numero) {
        if (numero == 1 || numero == 2) return true;
        for(int contador = 2; contador < numero; contador++) {
            if (numero % contador == 0) return true;
        }
        
        return false;
    }
}
