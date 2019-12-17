package br.com.abc.javacore.Oexcecao.checkedexceptions.classes;

/**
 * Leitor1
 */
public class Leitor1 implements AutoCloseable{

    @Override
    public void close () throws Exception {
        System.out.println("Fechando Leitor 1");

    }
}