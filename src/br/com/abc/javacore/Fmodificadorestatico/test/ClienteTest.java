package br.com.abc.javacore.Fmodificadorestatico.test;

import br.com.abc.javacore.Fmodificadorestatico.classes.Cliente;

/**
 * ClienteTest
 */
public class ClienteTest {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        System.out.println("\nExibindo a quantidade de parcelas possíveis");

        // for(int parcela : cliente.getParcelas()) {
        //     System.out.print(parcela + " ");
        // } 

        System.out.println("Tamanho: " + Cliente.getParcelas().length);
        System.out.println("Tamanho: " + Cliente.getParcelas().length);
        System.out.println("Tamanho: " + Cliente.getParcelas().length);
    }
}