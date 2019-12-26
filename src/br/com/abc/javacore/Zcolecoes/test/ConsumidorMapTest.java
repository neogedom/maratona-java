package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.abc.javacore.Zcolecoes.classes.Consumidor;
import br.com.abc.javacore.Zcolecoes.classes.Produto;

/**
 * ConsumidorMapTest
 */
public class ConsumidorMapTest {

    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor("Vinícius Gomes", "222");
        Consumidor consumidor2 = new Consumidor("Google", "123");

        Produto produto1 = new Produto("123", "Laptop Acer", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("879", "Teclado Razor", 1000.0);
        Produto produto4 = new Produto("021", "Samsung Galaxy S7", 3296.5);

        // Vamos supor que cada consumidor comprou mais de um produto
        Map<Consumidor, List<Produto>> map = new HashMap<>();

        List<Produto> produtosCon1 = new ArrayList<>();
        produtosCon1.add(produto1);
        produtosCon1.add(produto2);
        List<Produto> produtosCon2 = new ArrayList<>();
        produtosCon2.add(produto3);
        produtosCon2.add(produto4);

        map.put(consumidor, produtosCon1);
        map.put(consumidor2, produtosCon2);
        for (Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": ");
            //Criando um for para a lista de produtos retornado em getValue
            for (Produto produto : entry.getValue()) {
                 System.out.println(produto.getNome());
            }
        }
    }
}