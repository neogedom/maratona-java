package br.com.abc.javacore.Wio.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {
    public static void main(String[] args) {
        // Para arquivos pequenos, utilizar a FileWriter e a FileReader é até uma boa
        // ideia
        // pq é simples e rápido
        // Mas com arquivos maiores, é mais recomendável usar a BufferedWriter e
        // BufferedReader

        File file = new File("Arquivo.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                BufferedReader br = new BufferedReader(new FileReader(file))) {

            bw.write("Escrevendo é uma mensagem no arquivo");
            bw.newLine(); // não usar o /n para não se tornar dependente de SO
            bw.write("E pulando uma linha");
            bw.flush();

            // Ao invés de ler caractere por caractere, o BufferedReader vai ler uma linha
            // inteira e retornar uma String
            String s;

            // O BR retorna null quando termina. Então enquanto a operação de atribuição for
            // diferente de null...
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // try {

        // // Criando o encadeamento do BufferedWriter. É necessário passar um
        // FileWriter
        // // como argumento
        // // para o BufferedWriter
        // // FileWriter fw = new FileWriter(file);
        // // BufferedWriter bw = new BufferedWriter(fw);

        // bw.write("Escrevendo uma mensagem no arquivo");
        // bw.newLine(); // não usar o /n para não se tornar dependente de SO
        // bw.write("E pulando uma linha");
        // bw.flush();
        // bw.close();

        // // Criando o encadeamento do BufferedReader. É necessário passar um
        // FileReader
        // // como argumento
        // // para o BufferedReader
        // FileReader fr = new FileReader(file);
        // BufferedReader br = new BufferedReader(fr);
        // // Ao invés de ler caractere por caractere, o BufferedReader vai ler uma
        // linha
        // // inteira e retornar uma String
        // String s = null;

        // // O BR retorna null quando termina. Então enquanto a operação de atribuição
        // for
        // // diferente de null...
        // while ((s = br.readLine()) != null) {
        // System.out.println(s);
        // }

        // br.close(); // Nós não fechamos o fr, pq automaticamente ele fecha quando
        // chamamos o mais
        // // externo
        // } catch (IOException e) {

        // e.printStackTrace();
        // }
    }
}