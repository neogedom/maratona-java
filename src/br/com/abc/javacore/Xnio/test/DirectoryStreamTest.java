package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * DirectoryStreamTest
 */

 //Buscando diretórios, mas ele só traz como se fosse um ls que não entra nas subpastas
public class DirectoryStreamTest {

    public static void main(String[] args) {
        Path dir = Paths.get("pasta");
        
        //Toda vez que for visto um "Stream" no nome, provavelmente deverá ser fechado
        //por isso se usa try-resources
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            // O DirectoryStream é quase como um array e o tipo que vai no for é o mesmo que 
            // vai entre as <>
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {

        }
    }
}