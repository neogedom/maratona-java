package br.com.abc.javacore.ZZKstreams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamTest2
 */
public class StreamTest2 {

    public static void main(String[] args) {
        List<List<String>> nomes = new ArrayList<>();
        nomes.add(Arrays.asList("DevDojo", "Valeu por aumentar a letra"));
        nomes.add(Arrays.asList("Willian", "Pq você demorou 180 aulas pra isso?"));
        System.out.println(nomes);
        //FlatMap para "achatar" o valores e transformar as listas em uma String só
        // o método stream() retorna um Stream, mas queremos o valor que está dentro 
        // do Stream 
        // Stream<String> stringStream = nomes.stream().flatMap(Collection::stream);
       
        // Convertendo para uma lista de strings e não uma stream de strings
        List<String> listStream = nomes.stream().flatMap(Collection::stream).collect(Collectors.toList());
        listStream.forEach(System.out::println);
        System.out.println(listStream);

        List<String> palavras = Arrays.asList("Olá", "Goku");
        palavras.stream().map(p -> p.split(""));
        
        // separando os caracteres de olá de forma convencional
        // ou seja, criando uma um vetor de strings, cada um com um
        // caractere de Olá
        String[] split = palavras.get(0).split(""); 
        System.out.println(Arrays.toString(split));

        // o map retorna uma stream como resultado da função passada como argumento
        // o collect converte o stream em uma lista chamando o Collectors.toList()
        List<String []> collect = palavras.stream().map(p -> p.split("")).collect(Collectors.toList());
        
        Stream<String> stream = Arrays.stream( (String []) palavras.toArray());
        List<String> collect2 = palavras.stream() // retorna palavras em versão Stream
                            .map(p -> p.split("")) // retorna O,l,a (um array de Strings) em versão Stream
                            // o map aplica uma transformação no strem de dados, não mudando a lista original
                            .flatMap(Arrays::stream) // retorna um Stream sequencial
                            .collect(Collectors.toList()); // devolve no formato Array de String
        System.out.println(collect2);

    }
    
    // Obs.: o ideal é fazer as filtragens primeiro, depois fazer as transformações
    
}