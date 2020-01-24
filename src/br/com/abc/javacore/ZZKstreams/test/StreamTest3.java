package br.com.abc.javacore.ZZKstreams.test;

import java.util.List;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

/**
 * StreamTest3
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        // método anyMatch permite verificar se há algum elemento 
        // no stream que bata com o predicate (no caso abaixo, alguém tem salário > 4000?)
        System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 4000));
        // allMatch verifica se todos os elementos dentro do stream bate com o valor especificado
        System.out.println(pessoas.stream().allMatch(p -> p.getIdade() > 19));
        // noneMatch verifica se nenhum elemento dentro do stream bate com o valor especificado
        System.out.println(pessoas.stream().noneMatch(p -> p.getIdade() > 19));
        //findAny e findFIrst retornam um Optional do qual é possível executar o método ifPresent
        pessoas.stream().filter(p -> p.getIdade() < 25)
                        .findAny()
                        .ifPresent(p -> System.out.println(p.getNome()));
        pessoas.stream().filter(pessoa -> pessoa.getIdade() > 30)
                        .findFirst()
                        .ifPresent(param -> System.out.println(param.getNome()));

    
    }
}