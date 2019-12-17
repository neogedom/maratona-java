package br.com.abc.javacore.Jmodificadorfinal.test;

import br.com.abc.javacore.Jmodificadorfinal.classes.Carro;

/**
 * CarroTest
 */
public class CarroTest {

    public static void main(String[] args) {
        Carro carro = new Carro();
        System.out.println( carro.getCOMPRADOR());
        
        //Os valores dentro de uma variável constante de referência podem mudar
        carro.getCOMPRADOR().setNome("Will");
        System.out.println( carro.getCOMPRADOR());

        //Referenciar para outro objeto em outro endereço de memória que dá erro
        //carro.COMPRADOR = new Comprador(); 
       

    }
}