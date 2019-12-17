package br.com.abc.javacore.Uexpressoresregulares.test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //O construtor de scanner recebe várias entradas. 
        // Ele é sobrecarregado pra receber entrada de teclado, de arquivo, etc.
        // Mas também recebe String
        Scanner scanner = new Scanner("1 true 100 oi");
        //Por padrão a classe Scanner usa o espaço como delimitador
        // se quiser trocar, você precisa chamar scanner.useDelimiter()

        //Verifica se no scanner há uma próxima posição
        while(scanner.hasNext()) {
            //Para pegar o valor e mudar o índice next()
            System.out.println(scanner.next());
        }
    }
}