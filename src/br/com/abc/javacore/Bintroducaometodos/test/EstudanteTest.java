package br.com.abc.javacore.Bintroducaometodos.test;

import br.com.abc.javacore.Bintroducaometodos.classes.Estudante;

/**
 * EstudanteTest
 */
public class EstudanteTest {

    public static void main(String[] args) {
        Estudante estudante = new Estudante();

        estudante.setNome("Midoryia");
        estudante.setIdade(-1);
        estudante.setNotas(new double[]{5.0, 6.0, 6.0} );


        System.out.println("Impressão vindo do get: ");
        System.out.println(estudante.getNome());
        System.out.println(estudante.getIdade());
        //Se usa get com arrays colocando colchetes depois do método chamado
        System.out.println(estudante.getNotas()[1]);

       // estudante.imprimeDados();
        estudante.tiraMedia();
    }
}