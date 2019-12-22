package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

/**
 * SortProdutoTest
 */

// Por manutenibilidade (caso alguém queira trocar a forma pela qual um objeto
// deve ser ordenado no futuro), o comparator é melhor que o comparable
class ProdutoNomeComparator implements Comparator<Produto> {

    // Diferente da forma como se usa o Comparable, o comparator tem um método
    // chamado compare (e não compareTo) e recebe dois argumentos de Produto (e não
    // somente um)
    // Isso porque a classe que trabalha com o Comparator não é a própria classe
    // Produto, mas uma classe diferente (ProdutoNomeComparator) e não dá pra usar o
    // this
    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}

public class SortProdutoTest {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto [] produtosArray = new Produto[4];
        Produto produto1 = new Produto("123", "Laptop Acer", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("879", "Teclado Razor", 1000.0);
        Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5);

        produtosArray[0]  = produto1;
        produtosArray[1]  = produto2;
        produtosArray[2]  = produto3;
        produtosArray[3]  = produto4;


        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        // O Java vai na classe e procura por uma interface chamada Comparable para
        // chegar o tipo
        // que está no generics dela, assim ele sabe como ordenar a classe
        // No caso de objeto, o Java não sabe como ordenar
        //Collections.sort(produtos);

        //Ordenando com o Comparator
        Collections.sort(produtos, new ProdutoNomeComparator());

        // for (Produto produto : produtos) {
        //     System.out.println(produto);
        // }

        //Imprimindo um array
        System.out.println(Arrays.toString(produtosArray));

        //Ordenando um array usando comparable
        //Arrays.sort(produtosArray);

        // Ordenando um array usando comparator
        Arrays.sort(produtosArray, new ProdutoNomeComparator());

         for (Produto produto : produtosArray) {
            System.out.println(produto);
        }
    }
}