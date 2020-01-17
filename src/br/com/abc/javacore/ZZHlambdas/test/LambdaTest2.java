package br.com.abc.javacore.ZZHlambdas.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;

/**
 * LambdaTest2 A diferença entre Predicate, Consumer e Function Predicate =
 * retorno de tipo booleano Consumer = retorna void Function = retorna qualquer
 * tipo (pega argumento do tipo T e retorna algo do tipo R)
 */

// Obs.: para usar variáveis locais dentro dos lambdas, as variáveis locais
// devem ser finais
// ou efetivamente finais (embora não explicitamente final, ninguém pode mudar o
// estado dela em qualquer parte do código, senão dá erro). Isso pq variáveis locais
// compartilham apenas a cópia com as threads, fazendo com que, se a original
// for alterada, a cópia fica inconsistente

// Obs.: embora não seja das melhores práticas o Consumer que retorna void
// consegue receber funções que retornam outras coisas  

//Target type = o tipo que espera o retorno da função lambda
public class LambdaTest2 {

    public static void main(String[] args) {
        forEach(Arrays.asList("William", "DeveDojo", "facebook.com"), (String s) -> System.out.println(s));
        List<Integer> list = map(Arrays.asList("William", "DeveDojo", "facebook.com"), (String s) -> s.length());
        List<String> listCores = map(
                Arrays.asList(new Carro("Preto", 2011), new Carro("Preto", 2011), new Carro("Preto", 2011)),
                (Carro c) -> c.getCor());
        System.out.println(listCores);

        // No Predicate é necessário usar as classes Wrapppers, para trocar no T
        // Observação: por usar Integer no Generics, o Java consegue deduzir que i no
        // lambda será Integer,
        // por isso não é obrigatório tipar
        Predicate<Integer> pares = i -> i % 2 == 0;
        System.out.println(pares.test(1000));

        // Para sistemas de ultra alta performance onde você precisa evitar o unboxing e
        // autoboxing
        // usar os Predicates dos tipos primitivos: IntPredicate, DoublePredicate, etc.
        IntPredicate impar = (int i) -> i % 2 == 1;
        System.out.println(impar.test(10));

        //Interface Supplier apenas retorna valores por meio do método get
        Supplier<String> sup1 = () -> "oi";
        Supplier<Carro> sup2 = () -> new Carro("preto", 2001);
        System.out.println(sup1.get());
        System.out.println(sup2.get());
    }

    // Consumer para criar funções que retornam void
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }

    }

    // Function para criar funções que retornam um tipo qualquer
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            result.add(function.apply(e));
        }

        return result;
    }
}