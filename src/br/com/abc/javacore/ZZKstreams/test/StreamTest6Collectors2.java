package br.com.abc.javacore.ZZKstreams.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.abc.javacore.ZZKstreams.classes.Genero;
import br.com.abc.javacore.ZZKstreams.classes.Maioridade;
import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

/**
 * StreamTest6Collectors2 Agrupamento
 */
public class StreamTest6Collectors2 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();

        // agrupando pessoas por gênero sem collectors
        Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();
        List<Pessoa> masculino = new ArrayList<>();
        List<Pessoa> feminino = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getGenero() == null) {
                break;
            }

            if (pessoa.getGenero().equals(Genero.FEMININO)) {
                feminino.add(pessoa);
            } else {
                masculino.add(pessoa);
            }

            generoListMap.put(Genero.FEMININO, feminino);
            generoListMap.put(Genero.MASCULINO, masculino);
        }
        
        System.out.println(generoListMap);

         // agrupando pessoas por gênero com collectors
         // o argumento de groupingBy é do mesmo tipo da chave do map
        Map<Genero, List<Pessoa>> collect = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero));
        System.out.println(collect);

        //agrupando pessoas por maioridade sem a declaração do que é de maior e o que é de menor
        Map<Maioridade, List<Pessoa>> collect1 = pessoas.stream().collect(Collectors.groupingBy(p -> {
            if (p.getIdade() < 18) {
                return Maioridade.MENOR;
            } else {
                return Maioridade.ADULTO;   
            }
        }));
        System.out.println(collect1);

        //Agrupando por gênero e maioridade (dois maps)
        //o groupingBy recebe outro groupingby como segundo argumento
        Map<Genero, Map<Maioridade, List<Pessoa>>> collect2 = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.groupingBy(p -> {
            if (p.getIdade() < 18) {
                return Maioridade.MENOR;
            } else {
                return Maioridade.ADULTO;   
            }
        })));

        System.out.println(collect2);

        //Agrupando por gênero e determinando a quantidade
        Map<Genero, Long> collect3 = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.counting()));

        System.out.println(collect3);


        //Maior salário por gênero
        Map<Genero, Optional<Pessoa>> collect4 = pessoas.stream()
                    .collect(Collectors.groupingBy(Pessoa::getGenero, 
                        Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
        System.out.println(collect4);

        //Colentando maior salário por gênero e retirando do Optional
        //collectingAndThen = coleta o valor e faz algo depois
        Map<Genero, Pessoa> collect5 = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                    Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)), 
                            Optional::get)));
        
        System.out.println(collect5);

        //Coletando as estatísticas sumarizadas por gênero
        Map<Genero, DoubleSummaryStatistics> collect6 = pessoas.stream()
                    .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.summarizingDouble(Pessoa::getSalario)));
        System.out.println(collect6);

        //Verficando se exixtem adultos e menores em cada gênero
        // o mapping permite adaptar o tipo do objeto recebido pelo groupingBy para Set (que é distinto)
        Map<Genero, Set<Maioridade>> collect7 = pessoas.stream()
                    .collect(Collectors.groupingBy(Pessoa::getGenero, 
                        Collectors.mapping(p -> {
                            if (p.getIdade() < 18) {
                                return Maioridade.MENOR;
                            } else {
                                return Maioridade.ADULTO;   
                            }}, Collectors.toSet())));
    }
}
