package br.com.abc.javacore.Minterfaces.test;

import br.com.abc.javacore.Minterfaces.classes.Produto;

/**
 * ProdutoTest
 */
public class ProdutoTest {

    public static void main(String[] args) {
        Produto produto = new Produto("notebook", 4, 3000);
        // Você pode criar uma variável de referência de uma interface, mas não pode criar um objeto
        // com new Tributavel()
        // Tributavel t;
        produto.calculaImposto();
        produto.calculaFrete(); 
        System.out.println(produto);
    }
}