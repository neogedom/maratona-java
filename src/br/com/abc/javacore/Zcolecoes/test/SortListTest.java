package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String args [])
    {
        List<String> nomes = new ArrayList<>();
        nomes.add("Vinícius");
        nomes.add("Gomes");
        nomes.add("IFMS");
        nomes.add("Linus Torvalds");
        nomes.add("Ian Sommerville");
        nomes.add(0, "Ada Lovelace");

        //Ordenando a lista
        //Aqui ele ordena no mesmo objeto ArrayList usando a forma como o tipo de dado deve ser ordenado
        // No caso de String, é por ordem alfabética
        Collections.sort(nomes);

        List<Double> numeros = new ArrayList<>();
        numeros.add(1.1);
        numeros.add(1.5);
        numeros.add(1.3);
        numeros.add(1.9);
        numeros.add(2d);
        Collections.sort(numeros);

        //Lembrando, o ArrayList é ordenada por índice e não sortida (ordem por inserção)
        for (String nome : nomes) {
            System.out.println(nome);
        }

        for (Double numero: numeros) {
            System.out.println(numero);
        }
    }
}