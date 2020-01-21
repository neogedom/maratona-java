package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

import br.com.abc.javacore.ZZJoptional.classes.Carro;

/**
 * Pessoa
 */
public class Pessoa {

    private Carro carro;
    private String nome;
    private int idade; 

    

    public Optional<Carro> getCarro() {
        return Optional.ofNullable(carro);
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(Carro carro, String nome) {
        this.carro = carro;
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    
}