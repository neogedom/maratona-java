package br.com.abc.javacore.Wio.teste;

import java.io.Console;

//Obtendo o console. É preciso rodar isso num console.
// Dependendo da IDE não vai dar certo
public class ConsoleTest {
    public static void main (String [] args) {
        Console c = System.console();
        //o método readLine() retorna uma String e o método readPassword() retorna um char
        // Isso por questões de segurança: como String, por ser imutável, ao fazer alguma mudança ela 
        // fica no pool de Strings e não é eliminada. Isso é problemático se um hacker conseguir acessá-lo
        // Os caracteres podem ser eliminados completamente da memória
        //%s é uma questão de formatação do console, indicando que ele receberá caracteres, mas como String
        char[] pw = c.readPassword("%s", "pw: ");

        for(char pass: pw) {
            //Format imprime formatado no console
            c.format("%c ", pass);
        }
        c.format("\n");
        String texto;
        while (true) {

            texto = c.readLine("%s", "Digite: ");
            c.format(" esse é texto %s foi digitado\n", retorno(texto));
        }
    }

    public static String retorno (String arg1) {
        return arg1;
    }
}