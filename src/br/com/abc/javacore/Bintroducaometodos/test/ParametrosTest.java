package br.com.abc.javacore.Bintroducaometodos.test;

import br.com.abc.javacore.Bintroducaometodos.classes.Calculadora;

/**
 * ParametrosTest
 */
public class ParametrosTest {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int num1 = 5;
        int num2 = 10;
        calc.alteraDoisNumeros(num1, num2);
        //Por mais que haja alteração dentro do método alteraDoisNumeros, aqui as variaveis continuam com os mesmos valores
        //Quando se está trabalhando com tipos primitivos, o que se passa é uma cópia do valor
        //Por isso o valor original nunca é alterado
        System.out.println("Dentro do teste: ");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
    }
}