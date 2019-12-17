package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * FileVisitorTest
 */
// Percorrendo dentro dos diretórios para captar o que há dentro das subpastas
// Estou criando uma classe aqui para mudar o comportamento do método
// FileVisitResult visitFile
// Pq eu quero chamar essa minha classe com meus comportamentos alterados
// (sobrescritos)
// Você pode criar quantas classes quiser no mesmo arquivo, mas só pode ter uma
// classe pública
// e ela deve ter o mesmo nome do arquivo
class AcharTodosOsBkp extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        //Essa expressão do endsWith pode ser substituída por um PathMatcher melhor
        if (file.getFileName().toString().endsWith(".bkp")) // endsWith é um método de String
        {
            System.out.println(file.getFileName());
        }

        // Tenho 4 retornos possíveis: CONTINUE, SKIP_SIBLINGS, SKIP_SUBTREE, TERMINATE
        return FileVisitResult.CONTINUE;
    }
}

public class FileVisitorTest {

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("pasta"), new PrintDirs());
    }
}


//Classe que faz com que ele use todos os métodos de SimpleFileVisitor
class PrintDirs extends SimpleFileVisitor<Path> {

    //Antes de entrar na pasta
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("pre: " + dir);
        
        if (dir.getFileName().toString().equals("subpasta")) {
            //Se eu quiser parar ao chegar na subpasta return FileVisitResult.TERMINATE;
            //Se eu quiser ignorar a subpasta
            return FileVisitResult.SKIP_SUBTREE;

            //SIBLINGS: não olhe para nenhuma pasta no mesmo subnível
        }
        
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        System.out.println(file.getFileName());

        // Tenho 4 retornos possíveis: CONTINUE, SKIP_SIBLINGS, SKIP_SUBTREE, TERMINATE
        return FileVisitResult.CONTINUE;
    }

    // Caso ele falhe
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    //Depois de entrar na pasta
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("post: " + dir);
        return FileVisitResult.CONTINUE;
    }

}