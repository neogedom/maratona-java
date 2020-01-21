package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

import br.com.abc.javacore.ZZJoptional.classes.Seguradora;

/**
 * Carro
 */
public class Carro {

    private Seguradora seguradora;
    private String nome;

    public Carro(Seguradora seguradora, String nome) {
        this.seguradora = seguradora;
        this.nome = nome;
    }

    public Optional<Seguradora> getSeguradora() {
        return Optional.ofNullable(seguradora);
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    
}