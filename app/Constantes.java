package app;

/**
 * Enumarate que contém todas as constantes para o funcionamento do jogo.
 */
public enum Constantes {
    QUANTIDADE_MAXIMA_JOGADORES(5),
    QUANTIDADE_MAXIMA_RODADAS(7),
    QUANTIDADE_PADRAO_RODADAS(3),
    QUANTIDADE_MAXIMA_CARTAS(3);

    private final int valor;

    /**
     * Cria uma nova constante.
     * 
     * @param valor é o valor da constante.
     */
    Constantes(int valor) {
        this.valor = valor;
    }

    /**
     * @return retorna o valor da constante.
     */
    public int getValor() {
        return this.valor;
    }
}
