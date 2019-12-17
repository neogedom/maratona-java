package br.com.abc.javacore.Wio.teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriterReaderTest
 */
public class FileWriterReaderTest {

    public static void main(String[] args) {
        File file = new File("Arquivo.txt");

        // Lembre-se que para arquivo se usa try-resources
        try (FileWriter fw = new FileWriter(file); FileReader fr = new FileReader(file);) {
            
            // Toda vez que eu chamar o write, ele sobrescreve o arquivo existente
            // Para adicionar coisas ao final do arquivo sem sobrescrever, passar o
            // parâmetro true no
            // construtor do FileWriter
            // FileWriter fw = new FileWriter(file, true);
            fw.write("Escrevendo uma mensagem no arquivo\n E pulando uma linha 3");
            
            // Quando você trabalha com arquivos, você usa buffer
            // No buffer existe uma espécie de túnel (stream) por onde passa os dados
            // Um erro possível é o de ficar algo no túnel
            // Para verificar que todos os dados saíram do túnel, use o flush()
            fw.flush();

            // EU não sei o tamanho do array, então crio um array de char com muitas
            // posições
            char[] in = new char[500];
            // o método read() retorna um int (número de caracteres lidos) e vai colocar
            // dentro de um array
            int size = fr.read(in);
            System.out.println("Tamanho " + size);
            for (char c : in) {
                System.out.print(c);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // // Por motivos de coesão, o FileWriter e o FileReader são classes separadas
        // try {

        // // Toda vez que eu chamar o write, ele sobrescreve o arquivo existente
        // //Para adicionar coisas ao final do arquivo sem sobrescrever, passar o
        // parâmetro true no
        // // construtor do FileWriter
        // //FileWriter fw = new FileWriter(file, true);
        // fw.write("Escrevendo uma mensagem no arquivo\n E pulando uma linha 3");
        // // Quando você trabalha com arquivos, você usa buffer
        // // No buffer existe uma espécie de túnel (stream) por onde passa os dados
        // // Um erro possível é o de ficar algo no túnel
        // // Para verificar que todos os dados saíram do túnel, use o flush()
        // fw.flush();
        // fw.close();

        // FileReader fr = new FileReader(file);
        // // EU não sei o tamanho do array, então crio um array de char com muitas
        // posições
        // char[] in = new char[500];
        // //o método read() retorna um int (número de caracteres lidos) e vai colocar
        // dentro de um array
        // int size = fr.read(in);
        // System.out.println("Tamanho " + size);
        // for (char c : in) {
        // System.out.print(c);
        // }
        // fr.close();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }
}