package br.com.abc.javacore.Bintroducaometodos.test;

import br.com.abc.javacore.Bintroducaometodos.classes.Professor;

/**
 * ProfessorTest
 */
public class ProfessorTest {

    public static void main(String[] args) {
        Professor prof = new Professor();
        prof.cpf = "111.222.333-44";
        prof.matricula = "111222";
        prof.nome = "Marcos";
        prof.rg = "111222-3";

        // System.out.println("Fora do imprime 1: " + prof.nome);

        Professor prof2 = new Professor();
        prof2.cpf = "555.666.777-99";
        prof2.matricula = "333444";
        prof2.nome = "Joana";
        prof2.rg = "333444-5";

        // //Entrando nesse método com o argumento prof, faremos o parâmetro aux do método imprime apontar para o endereço
        // // de memória da variável prof
        prof.imprime();
        prof2.imprime();
        // System.out.println("Fora do imprime 2: " + prof.nome);

        // Aqui faremos aux apontar para o endereços de memória de prof2
        //prof.imprime(prof2);

        // Isso é diferente do que acontece nos tipos primitivos, que passam cópias dos valores para os parâmetros
    }
}