package br.com.abc.javacore.ZZKstreams.classes;

import java.util.List;
import static java.util.Arrays.asList;

import java.util.Comparator;

/**
 * Pessoa
 */
public class Pessoa {

    private String nome;
    private int idade;
    private int salario;

    public Pessoa(String nome, int idade, int salario) {
        this.nome = nome;
        this.salario = salario;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public int getSalario() {
        return this.salario;
    }

    public int getIdade() {
        return this.idade;
    }

    public static List<Pessoa> bancoDePessoas () {
        return asList(new Pessoa("Vinícius Gomes", 24, 7000),
                    new Pessoa("Mercy", 30, 1450),
                    new Pessoa("Ana", 19, 1500), 
                    new Pessoa("Thor", 23, 1980), 
                    new Pessoa("Hulk", 35, 8000), 
                    new Pessoa("Flash", 29, 3800),
                    new Pessoa("Batman", 37, 100000000),
                    new Pessoa("Lanterna Verde", 31, 3000));
    }

    public static class PessoaNomeComparator implements Comparator<Pessoa> {

        @Override
        public int compare(Pessoa p1, Pessoa p2) {
            // TODO Auto-generated method stub
            return p1.getNome().compareTo(p2.getNome());
        }
    
        
    }
}