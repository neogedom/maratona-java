package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pessoa;

/**
 * TestePessoa
 * Padrões de Projeto: experiência de vários engenheiros de software ao longo dos anos
 * para resolver problemas específicos
 * Padrão Builder: deixa os nomes legíveis
 */
public class TestePessoa {

    public static void main(String[] args) {
        //É difícil decorar qual é a semântica de cada argumento quando todos são do mesmo tipo
        // Pessoa pessoa = new Pessoa("Vinícius", "Ferreira", "Gomes", "Ademir");

        //Criando um objeto com o Padrão Builder
        // Dessa forma fica mais legível
        Pessoa pessoa = new Pessoa.PessoaBuilder("Vinícius")
            .nomeDoMeio("Gomes")
            .ultimoNome("Ferreira")
            .nomeDoPai("Ademir")
            .build();

        System.out.println(pessoa);
    }
}