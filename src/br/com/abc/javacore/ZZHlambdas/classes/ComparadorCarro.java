package br.com.abc.javacore.ZZHlambdas.classes;

/**
 * ComparadorCarro
 */
public class ComparadorCarro {

    public static int compareByColor(Carro c1, Carro c2) {
        return c1.getCor().compareTo(c2.getCor());
    }

    public int compareByYear(Carro c1, Carro c2) {
        return ((Integer) c1.getAno()).compareTo(c2.getAno());
    }
}