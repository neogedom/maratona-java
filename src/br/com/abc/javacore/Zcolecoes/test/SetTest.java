package br.com.abc.javacore.Zcolecoes.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

public class SetTest {
    public static void main(String[] args) {
        Produto produto1 = new Produto("123", "Laptop Acer", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razor", 1000.0, 5);
        Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5, 0);
        Produto produto5 = new Produto("999", "Samsung Galaxy S8", 3296.5, 0);

        // Interface Set. A principal característica do Set é que ele não permite
        // elementos duplicados
        // Ao adicionar novo elemento, o Set usa o equals pra ver se o elemento existe e
        // o hashcode pra organizar o elemento
        Produto produto6 = new Produto("021", "Samsung Galaxy S6", 3296.5, 0);
        // Todas as coleções que tem Hash no nome faz uso do HashCode
        // Por utilizar o hash, o HashSet é uma coleção de alto desempenho

        // Set<Produto> produtos = new HashSet<>();
        //LinkedHashSet para manter a ordem de inserção
        Set<Produto> produtos = new LinkedHashSet();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        produtos.add(produto6);

        // Os elementos dentro dos Set não podem usar o método get, pq ele não é
        // indexado
        // System.out.println(produtos);

        // Percorrendo um Set
        // Não existe uma ordem no Set (quem entra por último, não fica por útimo)
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}