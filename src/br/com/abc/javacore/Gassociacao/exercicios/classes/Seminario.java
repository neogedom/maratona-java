package br.com.abc.javacore.Gassociacao.exercicios.classes;

/**
 * Seminario
 */
public class Seminario {
    private String titulo;
    private Professor professor;
    private Aluno[] alunos;
    private Local local;

    public Seminario() {

    }

    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    //Toda vez que trabalharmos com variáveis de referência, é possível que a variável esteja nula
    // por isso é importante verificá-la antes de chamar algum tipo de get/set
    // Se for usado algum array, verifique se ele está vazio, por ele pode ter um objeto array criado
    // Mas não ter nada dentro dele
    public void print() {
        System.out.println("-----------------Relatório de Seminário ------------------");
        System.out.println("Título: " + this.titulo);

        if (professor != null) {
            System.out.println("Professor palestrante: " + this.professor.getNome());
        }

        if (local != null) {
            System.out.println("Local: " + this.local.getRua() + ", bairro " + this.local.getBairro());
        } else {
            System.out.println("Nenhum local cadastrado para esse seminário");
        }

        if (alunos != null && alunos.length != 0) {
            System.out.println("----- Alunos ------ ");
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome());
            }
            return;
        }

        System.out.println("Nenhum aluno cadastrado");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

}