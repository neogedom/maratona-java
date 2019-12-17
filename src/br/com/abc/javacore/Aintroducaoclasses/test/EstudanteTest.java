package br.com.abc.javacore.Aintroducaoclasses.test;

import br.com.abc.javacore.Aintroducaoclasses.classes.Estudante;

/**
 * EstudanteTest
 */
public class EstudanteTest {

    public static void main (String [] args) {
        //Aqui vamos instanciar os objetos das classes
        // Lembre-se: importe os pacotes
        // A palavra reservada new cria objetos (que são variáveis de referência e funcionam de forma similar aos arrays)
        Estudante joao = new Estudante();
       
        //Acessando os atributos da classe por intermédio do objeto
        joao.nome = "João";
        joao.matricula = "1212";
        joao.idade = 15;

        //Imprimindo os valores dos atributos
        System.out.println(joao.nome);
        System.out.println(joao.matricula);
        System.out.println(joao.idade);
    }
}