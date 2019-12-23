package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversaoListaArray {
    public static void main(String [] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        Integer[] numeroArray = new Integer[numeros.size()];
        //Convertendo ArrayList em array
        //Se você não passar nenhum argumento, ele retorna  uma lista de objetos
        // Object [] objects = numeros.toArray();

        //Copiando o ArrayList para um array de inteiros
        numeros.toArray(numeroArray);
        System.out.println(numeros);
        System.out.println(Arrays.toString(numeroArray));
        System.out.println("---------------------------------");

        Integer[] numerosArray2 = new Integer[4];
        numerosArray2[0] = 10;
        numerosArray2[1] = 9;
        numerosArray2[2] = 8;
        numerosArray2[3] = 7;

        //Convertendo array em ArrayList
        List<Integer> numeros2 = Arrays.asList(numerosArray2);
        //Atenção! O método asList converte no mesmo lugar que o estão os elementos do array
        // Portanto o que eu fizer em numeros2, vai impactar em numeros2
        
        //Não dá nem para adicionar outro elemento nesse arraylist vinculado a um array
        // numeros2.add(10);
        // Como resolver?
        List<Integer> numeros3 = new ArrayList<>();
        numeros3.addAll(Arrays.asList(numerosArray2));

        numeros2.set(0, 1);
        numeros3.add(10);
        
        System.out.println(Arrays.toString(numerosArray2));
        System.out.println(numeros2);
        System.out.println(numeros3);
        

    }
}