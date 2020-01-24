package br.com.abc.javacore.ZZKstreams.test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

/**
 * StreaTest4Reduce
 * Reduce = "reduz" uma sequência de valor a um valor só conforme a função que for passada
 * dentro do reduce, usar apenas funções associativas
 */
public class StreaTest4Reduce {

    public static void main(String[] args) {
        //no caso de operações de soma, ele acumula os valores dentro da lista somando-os
        // Stream<Integer> stream = getStream();
        // retorna um optional por não ter certeza de que foi passado algum valor dentro da String
        Optional<Integer> reduce = getStream().reduce((x, y) -> x + y); 
        // usando o valor de identidade para retornar um valor do tipo da operação e não Optional
        // o valor de identidade é o valor que vai passar no primeiro argumento 
        // (nesse caso, a primeira soma será executada com ele)
        // Quando não há nenhum argumento, o valor retornado será o valor de identidade
        // Obs.: o valor de identidade deve ser o valor, que se colocado na operação,
        // não fará diferença nenhuma (para soma é 0 e para multiplicação é 1)
        // Integer soma = stream.reduce(0, (x, y) -> x + y); 

        System.out.println(reduce.get());

        //Exceção em tempo de execução, pq reduce é terminal
        // o que significa que a operação já foi fechada
        // e não é possível aproveitar a mesma stream para fazer
        // outra operação
        //System.out.println(soma);

        // stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        Integer soma = getStream().reduce(0, (x, y) -> x + y); 
        System.out.println(soma);

        //stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        // acumulando no reduce com Integer.sum()
        Optional<Integer> soma1 = getStream().reduce(Integer::sum); 
        System.out.println(soma);


        Optional<Integer> mult = getStream().reduce((x,y) -> x*y);
        System.out.println(mult.get());


        Integer mult1 = getStream().reduce(1, (x,y) -> x*y);
        System.out.println(mult1);

        // Encontrando o maior valor dentro de um stream usando 
        // operador ternário
        Optional<Integer> maiorValor = getStream().reduce((x, y) -> x > y ? x : y);
        System.out.println(maiorValor.get());

        // Encontrando o maior valor dentro de um stream usando 
        // Math.max usando lambda
        Optional<Integer> maiorValor1 = getStream().reduce((x, y) -> Math.max(x, y));
        System.out.println(maiorValor.get());

        // Encontrando o maior valor dentro de um stream usando 
        // Math.max usando method reference
        Optional<Integer> maiorValor2 = getStream().reduce(Math::max);
        System.out.println(maiorValor.get());


        Stream<Pessoa> streamPessoa = Pessoa.bancoDePessoas().stream();
        Optional<Double> somaSalario = streamPessoa.filter(p -> p.getSalario() > 4000)
                    .map(Pessoa::getSalario)
                    .reduce(Double::sum);
        System.out.println(somaSalario.get());

        // retornando a soma um tipo primitivo de uma operação com atributos de objetos
        Double somaDouble = Pessoa.bancoDePessoas().stream().filter(p -> p.getSalario() > 4000)
                                    .mapToDouble(Pessoa::getSalario)
                                    .sum();
        System.out.println(somaDouble);


        //Voltando DoubleStream para a stream correspondente
        DoubleStream doubleStream = Pessoa.bancoDePessoas().stream().filter(p -> p.getSalario() > 4000)
                                    .mapToDouble(Pessoa::getSalario);
        Stream<Double> double1 = doubleStream.boxed();
    }


    // Método para retornar um stream da lista de números
    // a fim de facilitar o reaproveitamento de código
    // e não ter que inicializar a variável stream todas as vezes
    private static Stream<Integer> getStream() {
        return Arrays.asList(1, 2, 3, 4, 5, 6).stream();
    }
}