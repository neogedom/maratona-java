package br.com.abc.javacore.Uexpressoresregulares.test;

public class TokensTest {
    public static void main (String ... args) {
        String str = "William0 Paulo2 Joana3 Camila5 Ana3 João5 Matheus6";  

        //Você deseja separar cada nome em uma variável diferente, sabendo que o delimitador é ,
        // os nomes serão os tokens
        //Usando a classe String. O método split retorna uma string
        //String [] tokens = str.split(",");

        //Dá pra usar expressões regulares para informar delimitadores
        String [] tokens = str.split("\\d");
        
        for (String arr : tokens) {
            //Caso seja necessário eliminar o espaço em branco, lembre-se do trim
            System.out.println(arr.trim());
        }
    }
}