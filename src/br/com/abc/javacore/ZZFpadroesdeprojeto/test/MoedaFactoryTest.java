package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.MoedaFactory;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pais;
import br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces.Moeda;

/**
 * MoedaFactoryTest
 * 
 */
public class MoedaFactoryTest {

    public static void main(String[] args) {
        // A complexidade de criação de objeto fica em uma outra classe
        // A lógica fica abstraída e pode ser reutilizada sempre que um objeto precisa ser criado
        Moeda moeda = MoedaFactory.criarMoeda(Pais.BRASIL);
        System.out.println(moeda.getSimbolo());
    }
}