package br.com.abc.javacore.Isobrescrita.test;

import br.com.abc.javacore.Isobrescrita.classes.Pessoa;

/**
 * PessoaTest
 */
public class PessoaTest {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joaquina na esquina");
        pessoa.setIdade(300);
        //Quando mando imprimir um objeto sem um método para imprimir, ele chama o método toString da
        // classe Object
        System.out.println(pessoa);

        
    }
}