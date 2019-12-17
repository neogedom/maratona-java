package br.com.abc.javacore.Oexcecao.checkedexceptions.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import br.com.abc.javacore.Oexcecao.checkedexceptions.classes.Leitor1;
import br.com.abc.javacore.Oexcecao.checkedexceptions.classes.Leitor2;

/**
 * tryWithResource
 */
public class tryWithResource {

    public static void main(final String[] args) {
       // O java fechará o leitor1 e leitor2 sem precisar eu chamar o close
       // e ele vai chamar na ordem inversa da declaração dos argumentos
        lerArquivo();
    }

    public static void lerArquivo() {
        // try-resources
        // Declarando variáveis para o try, dá pra declarar mais de uma
        // A regra é que as variáveis de referência que vão dentro dos parênteses do try
        // precisam implementar a interface Closeble ou AutoCloseable
        // O que é criado dentro dos parênteses, será fechado pelo java ao final do try
        // - resource
        // try (Reader reader = new BufferedReader(new FileReader("text.txt"));
        //         Reader reader2 = new BufferedReader(new FileReader("text.txt"));) {
        // } // para usar o catch você é obrigado a usar a exceção IOException
        // catch ( IOException e) {
        //     e.printStackTrace();

        // }

        try (Leitor1 leitor1 = new Leitor1();
         Leitor2 leitor2 = new Leitor2();) {
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        // usando o try-resource, você não precisaria usar um catch, desde que seu
        // método lance o IOException
        // mas é uma boa prática colocar o catch
    }

    public void lerArquivoOld() {
        // reader criado aqui pq se ele tivesse sido criado dentro do try, ele
        // sobreviveria apenas
        // dentro do escopo representada pelo { }
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("text.txt"));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            // Eu preciso fechar o arquivo independente do que aconteça, por o close está
            // aqui
            // mas Como reader.close() lança uma exceção, ele me obriga a colocar um try -
            // catch
            // de novo
            // Era assim que era feito no Java 6. Dava pra criar um método pra fechar ao
            // invés de
            // criar um novo try-catch, mas ainda assim o código não fica bom
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

    }
}