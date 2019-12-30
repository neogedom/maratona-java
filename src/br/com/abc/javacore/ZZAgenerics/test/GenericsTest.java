package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Consumidor;

/**
 * GenericsTest
 */
public class GenericsTest {

    public static void main(String[] args) {
        // Implementação do Java 4
        // List lista = new ArrayList();
        // lista.add("String");
        // lista.add(1L);
        // lista.add(new Consumidor("Vinícius", "89080"));

        // for (Object object : lista) {
        // if (object instanceof String) {
        // System.out.println(object);
        // }
        // if (object instanceof Long) {
        // System.out.println(object);
        // }
        // if (object instanceof Consumidor) {
        // Consumidor c = (Consumidor) object;
        // System.out.println(c.getNome());
        // }
        // }

        // Agora é possível definir o tipo dos elementos de uma collection
        // de forma a facilitar a implementação do for
        // Para ser compatível com as versões anteriores do Java, Generics é algo que
        // existe somente em tempo de compilação
        List<String> lista = new ArrayList<>();
        lista.add("String");
        lista.add("String");
        lista.add("Vinícius");

        for (String object : lista) {
            System.out.println(object);
        }

        add(lista, 1L);

        // Como o Generics só acontece em tempo de compilação (type erasure), o Java vai lançar exceção
        // apenas quando for implementado o for que tenta ler vários tipos de elementos
        // da collection. Em tempo de execução, o Java não diferencia collection com
        // generics e collection sem generics
        // for (String object : lista) {
        // System.out.println(object);
        // }
    }

    public static void add(List lista, Long l) {
        lista.add(l);

    }
}