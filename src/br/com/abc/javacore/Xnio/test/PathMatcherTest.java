package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//Tarefa: procurar por todos os arquivos que tenha Test e a extensão .java ou .class
class findAllTest extends SimpleFileVisitor<Path> {
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java, class}");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        
        if(matcher.matches(file)) {
            System.out.println(file.getFileName());
        }

        return FileVisitResult.CONTINUE;
    }
}


public class PathMatcherTest {
    public static void main(String[] args) throws IOException {
        //O Windows reconhece tanto a / quanto a \\ como separador de diretório
        // O Linux não reconhece a \\
        Path path1 = Paths.get("pasta/subpasta/subsubpasta/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("vinicius-gomes");
        Path path4 = Paths.get("vinicius");
        //Para trabalhar com a PathMatcher é preciso pegar através do SO usando a FileSystems (não confundir com FileSystem)
        // no FileSystems a diferença entre \\ e / já começa a impactar a performance e o resultado
        //O pattern que vai como argumento do método getPathMatcher é um glob e sempre começa com glob:
        // no glob, o * considera qualquer coisa, exceto os separadores de diretório
        // E aí, depende do SO. No Linux, por exemplo, o getPathMatcher ao receber um glob com * não
        // trataria as \\ como separadores do diretório, pois isso não pertence ao sistema de arquivo do 
        // Linux
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");
        System.out.println(matcher.matches(path1)); // Aqui apesar de ter file.bkp, ele tem um caminho e por isso fica false
        System.out.println(matcher.matches(path2));
        System.out.println("--------------------");
        matches(path1,"glob:*.bkp");
        // Para incluir os diretórios são **
        matches(path1,"glob:**.bkp");
        matches(path1,"glob:*"); // Pega tudo desconsiderando os separadores de diretório
        matches(path1,"glob:**"); // Pega tudo

        //Se tiver 3 caracteres depois do ponto
        System.out.println("--------------------");
        matches(path1,"glob:*.???");
        // Para incluir os diretórios são **
        matches(path1,"glob:**.???");
        matches(path1,"glob:**/*.???");
        matches(path1,"glob:**.???");

        //Procure por vinicius ou gomes
        System.out.println("--------------------");
        matches(path3,"glob:{vinicius*,gomes*}");
        matches(path3,"glob:{vinicius,gomes}*"); // essa é a mesma coisa que glob:{vinicius*,gomes*}
        matches(path4,"glob:{vinicius,gomes}"); //exatamente vinicius ou gomes


        //Executando a classe que procura pelos Test.java ou Test.class
        //O primeiro argumento se refere a de onde eu começo a percorrer as pastas
        // O segundo é o comportamento (pelo quê estou procurando?)
        Files.walkFileTree(Paths.get("./"), new findAllTest());

    }

    private static void matches (Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + " : " + matcher.matches(path));
       
    }
}