package br.com.abc.javacore.ZZHlambdas.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;
import br.com.abc.javacore.ZZHlambdas.classes.ComparadorCarro;

/**
 * LambdaTest3 Haá 4 tipos de Method References Referência para um método
 * Referência para um método static;
 *  Referência para a instância de método de um objeto particular;
 * Referência para a instância de um objeto arbitrário de um tipo particular;
 * Refrência para um construtor
 * Se você só fizer uma chamada de método dentro de uma classe, então é possível
 * usar o MethodReference
 */
public class LambdaTest3 {

    public static void main( String[] args) {
        // Por causa do target type posso substituir (String s) por só s
        // forEach(Arrays.asList("William", "DeveDojo", "facebook.com"), s ->
        // System.out.println(s));
        // Usando o method reference (System.out::println), o Java sabe que eu quero
        // imprimir os valores
        // dentro do array
        forEach(Arrays.asList("William", "DevDojo", "facebook.com"), System.out::println);
         List<Carro> carros = Arrays.asList(new Carro("Vermelho", 1999), new Carro("Azul", 2005),
                new Carro("Preto", 1995));
        // criando função direto no lambda
       // Collections.sort(carros, (c1, c2) -> c1.getCor().compareTo(c2.getCor()));

       // Method Reference Referência para um método static;
       Collections.sort(carros, ComparadorCarro::compareByColor);
       System.out.println(carros);

       //Method Reference Referência para a instância de método de um objeto particular;
        ComparadorCarro comparadorCarro = new ComparadorCarro();
       Collections.sort(carros, comparadorCarro::compareByYear);
       System.out.println(carros);

      // Method Reference Referência para a instância de um objeto arbitrário de um tipo particular;
      // Ou seja, trabalhar diretamente com a classe, mas com métodos não estáticos
       List<String> nomes = Arrays.asList("William", "DevDojo", "Anna", "Brenon");
      //Com lambda
      nomes.sort((s1, s2) -> s1.compareTo(s2));
      // com Method reference (que vai dar o mesmo resultado)
      // O java entende que estou querendo comparar s1 e s2. 
      nomes.sort(String::compareTo);
      System.out.println(nomes);

      // Method Reference Refrência para um construtor
       Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new;
      System.out.println(comparadorCarroSupplier.get());
      //BiFunction = função lambda com dois argumentos
      // Chamando lambda convencional
       BiFunction<String, Integer, Carro> carroBiFunction = (s, i) -> new Carro(s, i);
      System.out.println(carroBiFunction.apply("rosa", 1994));
      // Chamando com method reference. É importante usar o BiFunction pq a chamada não
      // é para o construtor padrão, mas para um que tem dois argumentos
       BiFunction<String, Integer, Carro> carroBiFunction2 = Carro::new;
      System.out.println(carroBiFunction2.apply("cinza", 1999));
      

    }

    public static <T> void forEach(final List<T> list, final Consumer<T> consumer) {
        for ( T e : list) {
            consumer.accept(e);
        }

    }

    // Function para criar funções que retornam um tipo qualquer
    public static <T, R> List<R> map(final List<T> list, final Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T e : list) {
            result.add(function.apply(e));
        }

        return result;
    }
}