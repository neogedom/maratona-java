package br.com.abc.javacore.ZZHlambdas.test;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;
import br.com.abc.javacore.ZZHlambdas.interfaces.CarroPredicate;

/**
 * LambdaTest
 * Lambda foi criado para atacar a verbosidade do Java
 * É uma representação concisa de uma função anônima que pode ser passado como parâmetro
 * ou ser associado a uma variável de referência
 * Lambda é uma função e não método, pq não está associada a nenhuma classe
 * Ela não traz nada novo em relação ao que já se podia fazer com as funções anônimas
 * É só uma modifcação de sintaxe
 * Sintaxe da lambda: (Carro carro) -> carro.getCor().equals("verde");
 * primeira parte parâmetro, seta que separa lista de parâmetros do corpo e o corpo da expressão
 * As lambdas servem para serem usadas com as interfaces funcionais (@FunctionalInterface)
 * que são aquelas interfaces que têm apenas um método obrigatórios (ainda é possível trazer métodos default)
 */
public class LambdaTest {

    public static void main(String[] args) {
        // classe anônima
        CarroPredicate carroPredicate = new CarroPredicate(){
        
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("verde");
            }
        };

        // Lambda
        // se for usar return, tem que colocar as chaves
        CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
        System.out.println(carroPredicate.test(new Carro("verde", 2012)));
        System.out.println(carroPredicate2.test(new Carro("verde", 2012)));
        
        //O Runnable tbm usa interface funcional, portanto tbm dá pra chamar com lambda
        Runnable runnable = () -> System.out.println("Dentro do run");
        new Thread(runnable).start();
    }
}