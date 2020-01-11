package br.com.abc.javacore.Fmodificadorestatico.test;

import br.com.abc.javacore.Fmodificadorestatico.classes.Carro;

/**
 * CarroTest
 */
public class CarroTest {

    public static void main(String[] args) {
        // Ao alterar o atributo static você altera o atributo de todos os objetos(instâncias)
        // Você não deve acessar um atributo estático por meio de um objeto, mas direto
        // na classe
        // Métodos estáticos podem buscar e alterar valores sem nenhum objeto ter sido criado
        Carro.setVelocidadeLimite(220);

        Carro carro1 = new Carro("BMW", 280);
        Carro carro2 = new Carro("Audi", 275);
        Carro carro3 = new Carro("Mercedes", 290);

        carro1.imprime();
        carro2.imprime();
        carro3.imprime();

        System.out.println("##########################");

        carro1.imprime();
        carro2.imprime();
        carro3.imprime();

    }
}