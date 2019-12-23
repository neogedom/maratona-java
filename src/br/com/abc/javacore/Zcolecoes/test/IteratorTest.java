package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

/**
 * IteratorTest
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto("123", "Laptop Acer", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razor", 1000.0, 5);
        Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5, 0);
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

         //Não podemos executar o remove dentro de um for pois modifica o tamanho do ArrayList
         // Por isso esse código abaixo não vai funcionar corretamente     
        // for (Produto produto : produtos) {
        //     if (produto.getQuantidade() == 0) {
        //         produtos.remove(produto);
        //     }
        // }

        //Escolha sempre utilizar o Iterator ao invés de for para iterar em listas
        // For só pra arrays
        Iterator<Produto> produtosIterator = produtos.iterator();
        //hasNext() verificar se tem um próximo elemento
        // next() pega o elemento da lista
        while (produtosIterator.hasNext()) {
            if (produtosIterator.next().getQuantidade() == 0) {
                produtosIterator.remove();
            }
        }

        System.out.println(produtos.size());
    }
}