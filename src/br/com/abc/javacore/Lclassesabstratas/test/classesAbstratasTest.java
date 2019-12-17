package br.com.abc.javacore.Lclassesabstratas.test;

import br.com.abc.javacore.Lclassesabstratas.classes.Gerente;
import br.com.abc.javacore.Lclassesabstratas.classes.Vendedor;

/**
 * classesAbstratasTest
 */
public class classesAbstratasTest {

    public static void main(String[] args) {
        //Marcos é um gerente ou um vendedor?
        //Funcionario funcionario = new Funcionario("Marcos","202020-1", 2000);
        Vendedor vendedor = new Vendedor("Marcos","202020-1", 1500, 5000);
        Gerente gerente = new Gerente("Anna","2895230-1", 2000);
        vendedor.calculaSalario();
        gerente.calculaSalario();
        System.out.println(vendedor);
        System.out.println(gerente);
        

    }
}