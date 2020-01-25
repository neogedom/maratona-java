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
    private double salario;
    private Genero genero;

    public Pessoa(String nome, int idade, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public int getIdade() {
        return this.idade;
    }

    public static List<Pessoa> bancoDePessoas () {
        return asList(new Pessoa("Vinícius Gomes", 24, 7000, Genero.MASCULINO),
                    new Pessoa("Mercy", 30, 1450, Genero.FEMININO),
                    new Pessoa("Mercy", 22, 1450, Genero.FEMININO),
                    new Pessoa("Ana", 17, 1500, Genero.FEMININO), 
                    new Pessoa("Thor", 23, 1980, Genero.MASCULINO), 
                    new Pessoa("Hulk", 35, 8000, Genero.MASCULINO), 
                    new Pessoa("Flash", 29, 3800, Genero.MASCULINO),
                    new Pessoa("Batman", 37, 1000, Genero.MASCULINO),
                    new Pessoa("Lanterna Verde", 17, 3000, Genero.MASCULINO));
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

    public Pessoa(String nome, int idade, double salario, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}