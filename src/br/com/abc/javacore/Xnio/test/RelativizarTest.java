package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * RelativizarTest
 */
public class RelativizarTest {

    //Relativizar é quando você tem dois paths e você quer eliminar o que tem em comum entre os dois
    public static void main(String[] args) {
        Path dir = Paths.get("/home/vinicius");
        Path classe = Paths.get("/home/vinicius/java/Pessoa.java");

        //Demonstra quais os outros diretórios pelos quais deve-se percorrer para chegar até Pessoa.java
        // Ex.: me dê o caminho dir e me mostra como chegar ao caminho classe
        // É o contrário do resolve que junta dois diretórios
        Path pathToClasse = dir.relativize(classe);
        System.out.println(pathToClasse);
        

        Path absoluto1 = Paths.get("/home/vinicius");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/vinicius/java/Pessoa.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/Funcionario.java");

        System.out.println("1: " + absoluto1.relativize(absoluto3));
        System.out.println("2: " + absoluto3.relativize(absoluto1));
        System.out.println("3: " + absoluto1.relativize(absoluto2));
        System.out.println("4: " + relativo1.relativize(relativo2));
       

        //Aqui teremos uma exceção pq o Java não consegue saber como fazer de um caminho absoluto para um caminho relativo
        //O java não sabe onde o temp tá localizado, por isso não dá pra chegar lá. Ele volta pra raiz, mas não sabe pra onde ir
        //System.out.println("5: " + relativo1.relativize(absoluto1));
       // System.out.println("6: " + absoluto1.relativize(relativo1));
    }
}