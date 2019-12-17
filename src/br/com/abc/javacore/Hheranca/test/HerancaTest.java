package br.com.abc.javacore.Hheranca.test;

import br.com.abc.javacore.Hheranca.classes.Endereco;
import br.com.abc.javacore.Hheranca.classes.Funcionario;
import br.com.abc.javacore.Hheranca.classes.Pessoa;

/**
 * HerancaTest
 */
public class HerancaTest {

    public static void main(String... args) {
        Pessoa pessoa = new Pessoa("Gina", "123456");
        Endereco endereco = new Endereco("Rua 25", "Bairro 1");
        pessoa.setEndereco(endereco);
        pessoa.print();

        Funcionario funcionario = new Funcionario("Augusto", "12345", 15000);
        funcionario.setEndereco(endereco);
        funcionario.print();
    }
}