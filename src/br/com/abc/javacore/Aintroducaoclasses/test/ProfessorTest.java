package br.com.abc.javacore.Aintroducaoclasses.test;

import br.com.abc.javacore.Aintroducaoclasses.classes.Professor;

/**
 * ProfessorTest
 */
public class ProfessorTest {

    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome = "Pasquale";
        professor.matricula = "1244";
        professor.cpf = "11223344550";
        professor.rg = "23231";

        System.out.println(professor.nome);
        System.out.println(professor.matricula);
        System.out.println(professor.cpf);
        System.out.println(professor.rg);


    }
}