package br.com.abc.javacore.Csobrecargametodos.test;

import br.com.abc.javacore.Csobrecargametodos.classes.Funcionario;

/**
 * FuncionarioTest
 */
public class FuncionarioTest {

    public static void main(String... args) {
        Funcionario funcionario = new Funcionario("Chica da Silva", "111.222.333-44", 4500.00, "111222-45");
        Funcionario funcionario2 = new Funcionario();
        // funcionario.setNome("Chica da Silva");
        // funcionario.setCpf("111.222.333-44");
        // funcionario.setSalario(4500.00);

       // funcionario.init("Chica da Silva", "111.222.333-44", 4500.00);// Assim eu chamo um método
        // funcionario.init("Chica da Silva", "111.222.333-44", 4500.00, "111222-45"); //Aqui eu chamo o outro

        funcionario.imprime();
        funcionario2.imprime();
    }
}