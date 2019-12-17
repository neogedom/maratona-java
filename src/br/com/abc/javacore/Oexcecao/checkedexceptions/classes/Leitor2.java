package br.com.abc.javacore.Oexcecao.checkedexceptions.classes;
import java.io.IOException;

/**
 * Leitor2
 */
public class Leitor2 implements AutoCloseable {

    @Override
    public void close() throws IOException {
       System.out.println("Fechando leitor 2");
    }

   


    
}