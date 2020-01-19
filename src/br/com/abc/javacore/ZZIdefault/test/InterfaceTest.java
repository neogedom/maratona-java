package br.com.abc.javacore.ZZIdefault.test;

import br.com.abc.javacore.ZZIdefault.interfaces.MyList;

/**
 * InterfaceTest
 */
public class InterfaceTest implements MyList {

    public static void main(String[] args) {
        // Chamando um método estático de uma interface
        MyList.sort();
        // Chamamndo um método default da interface MyList
        // Devo chamar o método direto da classe que implementa
        new InterfaceTest().remove();
    }
}