package app;

/**
 * Classe responsável por conter todas os utilitários para todo o sistema.
 */
public class Recursos {
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Printa em em coloração vermelha para representar uma mensagem de erro.
     * 
     * @param mensagemException mensagem que quer mostrar.
     */
    public static void mostraException(String mensagemException) {
        final String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_RED + mensagemException + ANSI_RESET);
    }

    /**
     * Printa em coloração verde para representar resultados.
     * 
     * @param mensagemResultado mensagem que quer mostrar.
     */
    public static void mostraResultado(String mensagemResultado) {
        final String ANSI_GREEN = "\u001B[32m";

        System.out.println(ANSI_GREEN + mensagemResultado + ANSI_RESET);
    }

    /**
     * Printa em coloração amarela para representar avisos.
     * 
     * @param mensagemAviso mensagem que quer mostrar.
     */
    public static void mostraAviso(String mensagemAviso) {
        final String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_YELLOW + mensagemAviso + ANSI_RESET);
    }
}
