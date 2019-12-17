package br.com.abc.javacore.Dsobrecargaconstrutores.test;

import br.com.abc.javacore.Dsobrecargaconstrutores.classes.Estudante;

/**
 * EstudanteTest
 */
public class EstudanteTest {

    public static void main(String[] args) {
        Estudante estudante = new Estudante("1122233", "Carlitos", new double []{5,7,9}, "12/12/2010");
        estudante.imprime();
    }
}