package br.com.abc.javacore.Oexcecao.checkedexceptions.classes;

import java.io.FileNotFoundException;
//import java.io.IOException;

/**
 * Funcionario
 */
public class Funcionario extends Pessoa {
    //Não dá nenhum erro na chamada porque, mesmo que o salvar de Pessoa lance exceção
    // não é obrigado que o método sobrescrito chame exceção
    // public void salvar () {

    // }

    // Dá pra declarar relançar as exceções apenas parcialmente também
    // public void salvar () throws LoginInvalidoException {

    // }

    //Eu não posso declarar exceções que não foram declaradas
    // no método da classe pai
    // public void salvar () throws IOException {

    // }

    //Eu não posso nem mesmo declarar exceções que estão na linha de herança das exceções declaradas
    // no método da classe pai. A única exceção que posso declarar é RuntimeException
    // public void salvar () throws Exception {

    // }

    //Você pode declarar uma classe filha das exceções declaradas no método da classe pai   
    public void salvar () throws FileNotFoundException {

    }



    
}