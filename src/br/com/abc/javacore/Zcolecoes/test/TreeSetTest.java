package br.com.abc.javacore.Zcolecoes.test;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import br.com.abc.javacore.Zcolecoes.classes.Celular;
import br.com.abc.javacore.Zcolecoes.classes.Produto;

// class CelularNomeComparator implements Comparator<Celular>
// {
//     @Override
//     public int compare (Celular c1, Celular c2) {
//         return c1.getNome().compareTo(c2.getNome());
//     }
// }

// No TreeSet a cada nova inserção, ele coloca no começo da pilha
public class TreeSetTest {
    public static void main(String[] args) {
        Produto produto1 = new Produto("123", "Laptop Acer", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razor", 1000.0, 5);
        Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5, 0);
        Produto produto5 = new Produto("023", "Samsung Galaxy S7", 1d, 0);
        // Celular celular = new Celular("iPhone", "1234");
        // Na orientada a interfaces, ao invés de usar o Set, é bom usar o NavigableSet
        // Pq o NavigableSet tem operações que não têm no set

        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        produtoNavigableSet.add(produto1);
        produtoNavigableSet.add(produto2);
        produtoNavigableSet.add(produto3);
        produtoNavigableSet.add(produto4);
        produtoNavigableSet.add(produto5);

        // for (Produto produto : produtoNavigableSet) {
        // System.out.println(produto);
        // }

        // Imprimindo a lista numa ordem inversa
        for (Produto produto : produtoNavigableSet.descendingSet()) {
            System.out.println(produto);
        }

        System.out.println("------------------");
        // Métodos do TreeSet
        // lower, (<) retorna produto mais caro, exceto o produto dado
        System.out.println(produtoNavigableSet.lower(produto4));
        // floor (<=), inclui o produto passado na busca e retorna o produto mais caro
        System.out.println(produtoNavigableSet.floor(produto4));
        // higher (>), inclui o produto mais barato depois do produto que passamos sem
        // incluí-lo
        System.out.println(produtoNavigableSet.higher(produto5));
        // ceiling (>=), inclui o produto passado na busca e retorna o produto mais barato
        System.out.println(produtoNavigableSet.ceiling(produto5));

        System.out.println("-------------------------");
        System.out.println(produtoNavigableSet.size());
        // Retorna o primeiro produto e o remove da lista
        System.out.println(produtoNavigableSet.pollFirst());
        System.out.println(produtoNavigableSet.size());
        // Retorna o último produto e o remove da lista
        System.out.println(produtoNavigableSet.pollLast());
        System.out.println(produtoNavigableSet.size());


        // //Regra do NavigableSet, ao add novo elemento ele deve implementar Comparable
        // // Ou pelo menos o construtor de TreeSet deve receber um comparator como
        // argumento
        // NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new
        // CelularNomeComparator());

        // celularNavigableSet.add(celular);
        // for (Celular celular1 : celularNavigableSet) {
        // System.out.println(celular1);
        // }

    }
}