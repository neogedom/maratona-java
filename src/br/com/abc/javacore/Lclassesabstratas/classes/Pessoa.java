package br.com.abc.javacore.Lclassesabstratas.classes;

/**
 * Pessoa
 */
public abstract class Pessoa {
    protected String nome;

    //Eu sou obrigado a implementar na primeira classe concreta, 
    // que nesse caso é Gerente e Vendedor
    public abstract void imprime();

    public Pessoa () {
    }

    public Pessoa (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}