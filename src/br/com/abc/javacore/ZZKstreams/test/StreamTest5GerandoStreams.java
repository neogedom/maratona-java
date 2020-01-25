package br.com.abc.javacore.ZZKstreams.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamTest5GerandoStreams
 */
public class StreamTest5GerandoStreams {

    public static void main(String[] args) {
        //range para criar número de x até y, sendo x e y os argumentos
        // rangeClosed, inlcui y na contagem
        IntStream.rangeClosed(1, 100).filter(n -> n %  2 == 0)
                .forEach(s -> System.out.print(s + " "));;
        System.out.println();
        IntStream.range(1, 100).filter(n -> n %  2 == 0)
                .forEach(s -> System.out.print(s + " "));

        System.out.println();

        // criando streams direto de palavras
       Stream<String> stringStream = Stream.of("olá", "olé", "oli");
        stringStream.map(String::toUpperCase).forEach(s -> System.out.print(s + " "));

        //criando streams vazios
        Stream<Object> streamObject = Stream.empty();

        //criando streams de arrays
        int nums[] = {1, 2, 3, 4, 5, 6};
        OptionalDouble optionalDouble = Arrays.stream(nums).average();
        System.out.println(optionalDouble.getAsDouble());
       
        //pegando arquivos como stream e transformando seu conteúdo em String
        // o método Files.lines() retorna um stream e recebe o Path do arquivo 
        // e o tipo de charset desejado
        try(Stream<String> lines = Files.lines(Paths.get("Teste.txt"), Charset.defaultCharset())){
            lines.flatMap(line -> Arrays.stream(line.split("\n")))
                    .filter(line -> line.contains("File"))
                    .forEach(System.out::println); //forEach imprime e retorna void

        } catch(IOException e) {
            e.printStackTrace();
        }

        //Streams infinitos que são um perigo para a memória
        // quando usados, devem possui limit()
        //o iterate tem uma função que é executada eternamente a partir do seed
        // nesse caso, 1
        Stream.iterate(1, n -> n + 1)
        .limit(10)
        .forEach(System.out::println);
        // Fibonacci com iterate do Stream
        // Começamos (seed) de um array com 0 e 1
        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
            .limit(5)
            .forEach(t -> System.out.println(Arrays.toString(t)));

        
        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
            .limit(5)
            .map(p -> p[0]) // extraindo os valores do array
            .forEach(n -> System.out.println(n));

        // o generate fica gerando números de acordo com uma determinada função
        Stream.generate(Math::random)
            .limit(10)
            .map(n -> n * 100)
            .forEach(s -> System.out.println(s + " "));

    }
}