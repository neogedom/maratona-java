package br.com.abc.javacore.ZZKstreams.test;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

/**
 * StreamTest6Collectors
 */
public class StreamTest6Collectors1 {

 public static void main(String[] args) {
      List<Pessoa> pessoas = Pessoa.bancoDePessoas();
      // contar pessoas do modo tradicional
      System.out.println(pessoas.stream().count());
      //contar pessoas usando collectors
      System.out.println(pessoas.stream().collect(Collectors.counting()));
      // pegando o maior salário entre as pessoas sem collector
      Optional<Pessoa> max = pessoas.stream().max(Comparator.comparing(Pessoa::getSalario));
      System.out.println(max.get().getSalario());
      // pegando o maior salário entre as pessoas com collector
      Optional<Pessoa> collect = pessoas.stream().collect(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)));
      System.out.println(collect.get().getSalario());

      //Somando todos os salários sem collectors
      System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());
      //Somando todos os salários com  collectors
      System.out.println(pessoas.stream().collect(Collectors.summingDouble(Pessoa::getSalario)));

      //retornando a sumarização dos salários por completo (média, soma, etc)
      DoubleSummaryStatistics dss = pessoas.stream().collect(Collectors.summarizingDouble(Pessoa::getSalario));
      System.out.println(dss);

      //concatenando o nome de todas as pessoas
      System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining()));
      //concatenando o nome de todas as pessoas usando delimitadores
      System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", ")));
    }
}