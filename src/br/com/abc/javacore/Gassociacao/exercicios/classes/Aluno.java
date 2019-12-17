package br.com.abc.javacore.Gassociacao.exercicios.classes;

/**
 * Aluno
 */
public class Aluno {
    private String nome;
    private int idade;
    private Seminario seminario;

    public Aluno() {
       
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void print() {
        System.out.println("-----------------Relatório de Aluno ------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        if (this.seminario != null) {
            System.out.println("Seminário: " + this.seminario.getTitulo());
            return;
        } 
        
        System.out.println("Aluno não está inscrito em nenhum seminário");
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }

   
    
}