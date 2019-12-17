package br.com.abc.javacore.Wio.teste;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * FileTest
 */
public class FileTest {

    public static void main(String[] args) {
        // Caso queira criar o arquivo nessa pasta, basta colocar o nome do arquivo
        // Caso queira criar dentro de um diretório, colocar o diretório (com \\)
        // ex: C:\\Users\\vinny\\OneDrive\\Documentos\\Estudos\\Programação em
        // Java\\Maratona Java\\JavaOnline\\Arquivo.txt
        // Nesse momento não estou criando o arquivo em si, mas apenas criando o objeto
        // File
        File file = new File("Arquivo.txt");

        // Para criar o arquivo
        try {
            // createNewFile retorna um valor booleano, que retorna true se ele for criado
            // boolean newFile = file.createNewFile();
            // System.out.println(newFile);

            System.out.println(file.createNewFile());

            //Métodos da classe file

            // Verificar se o arquivo tem permissão de leitura
            System.out.println("Permissão de leitura?" + file.canRead());

            //Descobrir o path do arquivo
            System.out.println("Caminho: " + file.getPath()); // só aquilo utilizado no construtor de new File();
            System.out.println("Caminho inteiro: " + file.getAbsolutePath());

            //Saber se é um diretório
            System.out.println("É um diretório? " + file.isDirectory());

            //Saber se é um arquivo oculto
            System.out.println("É oculto? " + file.isHidden());

            //Saber quando foi modificado. Ele retorna um long que pode ser jogado no construtor da classe
            //Date
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy 'às' HH:mm:ss z", new Locale("pt", "BR"));
            System.out.println("Quando foi modificado? " + df.format(new Date(file.lastModified())));

            //Saber se o arquivo existe
           boolean exists = file.exists();
           if (exists) {
                System.out.println("Deletado? " + file.delete());
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}