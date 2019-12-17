package br.com.abc.javacore.Yserializacao.classes;

/**
 * Turma
 */

// Ao associar uma classe com outra serializável, tome o cuidado para serializar
// tbm
public class Turma {
    private String nome;

    public Turma(String nome) {
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
        return "Turma [nome=" + nome + "]";
    }

}