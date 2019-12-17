package br.com.abc.javacore.Gassociacao.exercicios.test;

import br.com.abc.javacore.Gassociacao.exercicios.classes.Aluno;
import br.com.abc.javacore.Gassociacao.exercicios.classes.Local;
import br.com.abc.javacore.Gassociacao.exercicios.classes.Professor;
import br.com.abc.javacore.Gassociacao.exercicios.classes.Seminario;

/**
 * AssociacaoTest
 */
public class AssociacaoTest {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Vinícius Gomes", 28);
        Aluno aluno2 = new Aluno("Joana Darc", 19);
        Seminario seminario = new Seminario("Como ser um baita programador e ficar rico");
        Professor professor = new Professor("Yoda", "Usar a força para programar");
        Local local = new Local("Rua das Araras","Mato");


        aluno.setSeminario(seminario);
        aluno2.setSeminario(seminario);

        seminario.setProfessor(professor);
       // seminario.setLocal(local);
        //seminario.setAlunos(new Aluno[] {aluno, aluno2});

        professor.setSeminario(new Seminario [] {seminario});

        seminario.print();
        professor.print();
        aluno.print();

    }
}