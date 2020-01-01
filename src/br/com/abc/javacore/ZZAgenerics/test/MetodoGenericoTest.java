package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

/**
 * MetodoGenericoTest
 */
public class MetodoGenericoTest {

    public static void main(String[] args) {
        
        List<Cachorro> cachorroList = criarArray(new Cachorro());
        System.out.println(cachorroList);
    }

    //Suponhamos que precisemos criar um array, mas não sabemos qual o tipo do elemento que virá
    //Deve-se criar o tipo genérico do método antes do retorno
    //Esse método não retorna o tipo genérico, apenas define a existência dele
    // Dá pra combinar o T com o wildcard, sem usar o ?
    public static <T extends Animal> List<T> criarArray(T t) {
        List<T> lista = new ArrayList<>(); 
        lista.add(t);
        return lista;
    }
}