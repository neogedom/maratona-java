package br.com.abc.javacore.ZZHlambdas.interfaces;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;

/**
 * CarroPredicate
 * Essa interface permite parametrizar as verificações nos fluxos de controle
 * ao retornar um boolean. Assim, o teste fica genérico, pois a cada tipo de 
 * teste que eu precisar fazer, é só implementar essa interface Predicate e 
 * implementar a verificação do teste em outra classe
 * Esse é o padrão de projeto Strategy
 * Vantagens: diminuir a quantidade de código, deixar o código mais adaptável a futuras
 * slicitações de mudança de requisitos
 */

 //Interfaces funcionais possuem apenas um método obrigatório
@FunctionalInterface
 public interface CarroPredicate {

    //O método obrigatório (function descriptor) determinará como a Lambda ficará
    // nesse caso: (Carro carro) -> expressão
    boolean test(Carro carro); 
}