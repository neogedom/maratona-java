package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {
    // Suponha que algum script mande a localização de arquivo.txt separada em
    // partes e junta essas partes para compor uma String que será transformada em Path
    public static void main (String [] args) {
        String diretorioDoProjeto = "JavaOnline\\home\\vinicius\\dev";

        //Às vezes um script dá comandos baseados no Linux para movimentação em diretórios
        String arquivoTxt = "..\\..\\arquivo.txt";
        Path p1 = Paths.get(diretorioDoProjeto, arquivoTxt);
        
        System.out.println(p1);
        //O método normalize converte os comandos ..\\ do Linux em percorrendo diretórios
        System.out.println(p1.normalize());

        //Quando você está no mesmo diretório, você tem o .\
        Path p2 = Paths.get("home/./vinicius/./dev");
        System.out.println(p2);
        System.out.println(p2.normalize());
    }
}