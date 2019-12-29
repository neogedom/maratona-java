package br.com.abc.javacore.Zcolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import br.com.abc.javacore.Zcolecoes.classes.Consumidor;

public class TreeMapTest {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        // Consumidor consumidor = new Consumidor("Vinícius Gomes", "122");
        // Consumidor consumidor2 = new Consumidor("Maysa", "321");
        // // map.put("A", consumidor2);
        // map.put("D", consumidor);
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");

        // Embora eu insira de forma desorganizada, assim como na TreeSet, ele imprime
        // de forma organizada
        // Ele organiza pela chave e não pelo valor
        // A classe que vai na chave é obrigada a implementar comparable, a que vai no
        // valor não
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Métodos úteis
        // headMap() retorna um Map com as chaves menores que a chave passada como
        // argumento
        // O map derivado é ligado ao map original, ao passo que se apagarmos algo dele
        // apaga do original também
        //O argumento com boolean com true significa que você quer incluir aquela chave passada
        System.out.println(map.headMap("C", true));

        //pollFirstEntry e pollLastEntry retorna o primeiro e último valor e os exclui da lista
        System.out.println(map.pollFirstEntry());
        System.out.println(map.pollLastEntry());

    }
}