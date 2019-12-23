package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

//Busca binária para ArrayList
// Diferente do método contains, ele retorna o índice onde o elemento está
public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);


        //Para usar o binarySearch, a lista passada como parâmetro deve estar ordenada
        Collections.sort(numeros);
        // Procurando o valor 1 na lista
        //Não existindo o valor: (-(ponto de inserção) + -1)
        //O 1 seria inserido na posição 1 (entre o 0 e 2), por isso o resultado é -1 + -1 = -2
        System.out.println(Collections.binarySearch(numeros, 2));
        //Pegando o numero 2 de novo
        System.out.println(numeros.get(Collections.binarySearch(numeros, 2)));

        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto("123", "Laptop Acer", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("879", "Teclado Razor", 1000.0);
        Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5);
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        Collections.sort(produtos, new ProdutoNomeComparator());
        Produto produto5 = new Produto("000", "Antena", 50d);
        //Se você usou o comparator, você deve passar o comparator usado como argumento
        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        System.out.println(Collections.binarySearch(produtos, produto5, new ProdutoNomeComparator()));

        Integer[] arrayIntegers = new Integer[4];
        arrayIntegers[0] = 2;
        arrayIntegers[1] = 0;
        arrayIntegers[2] = 4;
        arrayIntegers[3] = 3;
        Arrays.sort(arrayIntegers);
        System.out.println(Arrays.binarySearch(arrayIntegers, 1));

       


    }
}