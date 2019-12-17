package br.com.abc.javacore.Gassociacao.exercicios.classes;

/**
 * Professor
 */
public class Professor {
    private String nome;
    private String especialidade;
    private Seminario[] seminarios;

    public Professor() {

    }

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void print() {
        System.out.println("-----------------Relatório de Professor ------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);

        if (seminarios != null && seminarios.length != 0) {
            System.out.print("Seminários: ");

            for (Seminario seminario : seminarios) {
                System.out.print(seminario.getTitulo() + " ");
            }
            System.out.print("\n");
            return;
        }

        System.out.println("Professor não vinculado a nenhum seminário");

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public Seminario[] getSeminario() {
        return seminarios;
    }

    public void setSeminario(Seminario[] seminario) {
        this.seminarios = seminario;
    }

}