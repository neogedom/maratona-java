package br.com.abc.javacore.ZZKstreams.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

/**
 * StreamTest
 */
public class StreamTest {

    public static void main(String[] args) {
        // Pegar os três primeiros nomes das pessoas com menos de 25 anos
        // Ordenados pelos nomes delas

        // Maneira de pegar sem o uso de Streams
        // O problema dessa maneira é que usa-se linhas demais
        // daí é menos trabalhoso ir no banco de dados e fazer a consulta pra retornar
        // mas isso tem menos desempenho
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Collections.sort(pessoas, (p1, p2) -> p1.getNome().compareTo(p2.getNome()));
       

        List<String> nomes = new ArrayList<>();
        
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getIdade() < 25) {
                nomes.add(pessoa.getNome());
                if (nomes.size() >= 3) {
                    break;
                }
            }
        }

        System.out.println(nomes);

        //Maneira de executar a mesma tarefa acima usando streams
        List<String> nomes2 = pessoas.stream()
                        .filter(p -> p.getIdade() < 25)
                        .sorted(Comparator.comparing(Pessoa::getNome))
                        .limit(3)
                        .map(Pessoa::getNome) // retorna um stream como resultado da execução de um método
                        .collect(Collectors.toList());

        System.out.println(nomes2);
    }
}