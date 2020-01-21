package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

/**
 * Seguradora
 */
public class Seguradora {
    // Só de olhar a declaração da variável como, não é possível 
    // determinar se ela deve ser ou não obrigatória
    // Não declaramos o nome como Optional pq o Optional não foi criado
    // para declaração de atributos, além disso ela não inclui a interface
    // serializable, o que impediria ela de ser usada em muitos frameworks
    private String nome;

    public Seguradora (String nome) {
        this.nome = nome;
    }

    public Seguradora() {

    }

    public String getNome() {

        //Retornar Optional.ofNullable para indicar que o nome pode
        // ser nulo
       // return Optional.ofNullable(nome);
       return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Seguradora [nome=" + nome + "]";
    }

    
}