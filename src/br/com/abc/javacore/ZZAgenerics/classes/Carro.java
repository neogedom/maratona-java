package br.com.abc.javacore.ZZAgenerics.classes;

/**
 * Carro
 */
public class Carro {

    private String nome;

    public Carro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Carro [nome=" + nome + "]";
    }

    
}