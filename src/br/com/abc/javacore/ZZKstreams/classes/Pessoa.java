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
                    new Pessoa("Mercy", 22, 1450),
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
           return p1.getNome().compareTo(p2.getNome());
        }
    
        
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}