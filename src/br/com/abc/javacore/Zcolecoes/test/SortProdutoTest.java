package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

/**
 * SortProdutoTest
 */
public class SortProdutoTest {

    public static void main(String[] args) {
         List<Produto> produtos = new ArrayList<>();
         Produto produto1 = new Produto("123", "Laptop Acer", 2000.0);
         Produto produto2 = new Produto("321", "Picanha", 26.4);
         Produto produto3 = new Produto("879", "Teclado Razor", 1000.0);
         Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5);

         produtos.add(produto1);
         produtos.add(produto2);
         produtos.add(produto3);
         produtos.add(produto4);

         //O Java vai na classe e procura por uma interface chamada Comparable para chegar o tipo
         // que está no generics dela, assim ele sabe como ordenar a classe
         //No caso de objeto, o Java não sabe como ordenar
         Collections.sort(produtos);
         
         for (Produto produto : produtos) {
             System.out.println(produto);
         }
    }
}