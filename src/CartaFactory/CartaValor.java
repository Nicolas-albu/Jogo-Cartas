package src.CartaFactory;

/**
 * Classe que representa uma carta do tipo valor.
 */
public class CartaValor extends CartaNormal {
    
    /**
     * Cria uma nova carta valor.
     */
    public CartaValor() {
        super();
        this.geraPontuacaoRodada();
    }

    @Override
    public void geraPontuacaoRodada() {
        if (this.isPrimo(super.getValorCarta())) {
            super.pontuacaoCarta = super.getPontuacaoRodada() * 3;
        } else {
            super.geraPontuacaoRodada();
        }
    }

    /**
     * Verifica se um {@code int numero} é primo.
     * 
     * @param numero 
     * @return retorna true caso {@code int numero} for primo, senão false.
     */
    private boolean isPrimo(int numero) {
        if (numero == 1 || numero == 2)
            return true;

        // busca por divisores entre 2 até a sua raiz quadrada
        for (int contador = 2; contador < Math.sqrt(numero); contador++) {
            if (numero % contador == 0)
                return false;
        }

        return true;
    }
}
