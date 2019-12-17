package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ResolvendoPaths
 */
public class ResolvendoPaths {

    //Resolver path = juntar os dois paths
    public static void main(String[] args) {
       // Obs.: Não necessariamente o caminho precisa existir para trabalhar com o Paths.get()
        Path dir = Paths.get("home\\vinicius");
        Path arquivo = Paths.get("dev\\arquivo.txt");
       
       // método resolve serve pra juntar. Recebe tanto objeto da classe Path quanto String
        Path result = dir.resolve(arquivo);
        System.out.println(result);

        //O problema é quando se tem caminhos absolutos e caminhos relativos
        // Se você estiver trabalhando com o formato do linux, não precisa do \\
        Path absoluto = Paths.get("/home/vinicius");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1: "+ absoluto.resolve(relativo));
        System.out.println("2: "+ absoluto.resolve(file));
        System.out.println("3: "+ relativo.resolve(file));

        //o caminho absoluto se resolve e não precisa de nada atrás dele
        // por isso o caminho relativo colocado atrás dele some
        System.out.println("4: "+ relativo.resolve(absoluto));
        System.out.println("5: "+ file.resolve(absoluto));

        //Tome cuidado com a resolução de um arquivo com um caminho relativo, pq fica uma bagunça
        System.out.println("6: "+ file.resolve(relativo));
    }
}