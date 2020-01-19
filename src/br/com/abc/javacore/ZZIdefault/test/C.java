package br.com.abc.javacore.ZZIdefault.test;

import br.com.abc.javacore.ZZIdefault.test.A;
import br.com.abc.javacore.ZZIdefault.test.B;

/**
 * C
 */
public class C extends D implements A, B {

    public static void main(String[] args) {
        // O método de mesma assinatura mais específico será selecionado
        // Uma classe pai sempre terá prioridade sobre os métodos default
        new C().oi();

        // A forma de chamar o método oi das interfaces A e B se uma não herdar da outra
        // public void oi() {
        //     B.super.oi();
        //     A.super.oi();
        // }
    }

}