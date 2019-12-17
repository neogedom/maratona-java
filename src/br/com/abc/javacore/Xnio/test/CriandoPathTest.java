package br.com.abc.javacore.Xnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTest {
    // Pacote NIO (new io)
    // Path (interface) veio para substituir a Classe File
    // Paths é a classe concreta de Path
    // Classe Files não tem nada a ver com File, ela utiliza a classe Paths e tem
    // métodos úteis
    public static void main(String[] args) {
        // Lembrando que Path é uma interface, portanto pra instanciar é necessário
        // chamar Paths.get()
        // Formas difernetes de pegar o arquivo
        Path p1 = Paths.get(
                "C:\\Users\\vinny\\OneDrive\\Documentos\\Estudos\\Programação em Java\\Maratona Java\\JavaOnline\\Arquivo.txt");
        Path p2 = Paths.get(
                "C:\\Users\\vinny\\OneDrive\\Documentos\\Estudos\\Programação em Java\\Maratona Java\\JavaOnline",
                "Arquivo.txt");
        Path p3 = Paths.get("C:",
                "Users\\vinny\\OneDrive\\Documentos\\Estudos\\Programação em Java\\Maratona Java\\JavaOnline",
                "Arquivo.txt");
        Path p4 = Paths.get("C:", "Users", "vinny", "OneDrive", "Documentos", "Estudos", "Programação em Java",
                "Maratona Java", "JavaOnline", "Arquivo.txt");
        System.out.println(p4.toAbsolutePath());

        // convertendo Path em File
        File file = p4.toFile();
        // Retornando o Path a partir da classe File
        Path path = file.toPath();

        // Criando diretórios. Para criar um caminho relativo ao projeto, não inicie a
        // string com \\ (/)
        Path path1 = Paths.get("pasta3");
        Path path2 = Paths.get("pasta//subpasta//subsubpasta");
        Path arquivo = Paths.get("pasta//subpasta//subsubpasta//file.txt");
        try {
            // Se eu tentar criar novamente, a classe lança uma exceção em tempo de execução
            if (Files.notExists(path2.getParent())) { // por isso é bom chamar o método notExists de Files para
                                                      // verificar se o arquivo já existe
                // Files.createDirectory(path1);
                // para criar pasta e subpastas
                Files.createDirectories(path2.getParent()); // se o path vier com o nome do arquivo, usar
                // o método getParent() para pegar a estrutura de diretórios
            }

            if (Files.notExists(arquivo)) {
                // Cria dentro da subpasta já existente
                Files.createFile(arquivo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Copiar um arquivo
        Path source = Paths.get("folder2\\arquivo.txt");
        Path target = Paths.get(path2 + "\\arquivoCopiado.txt");
        
        //Files.copy tbm lança uma exceção
        try {
            //Sem o REPLACE_EXISTING, o Java lança uma exceção pq o arquvo já existe.
            // Com o REPLACE_EXISTING, ele sobrescreve o arquivo existente
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

            //Para deletar um arquivo
           // Files.delete(path); //é mais seguro o deleteIfExists
            Files.deleteIfExists(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}