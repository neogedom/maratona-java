package br.com.abc.javacore.Npolimorfismo.test;

import br.com.abc.javacore.Npolimorfismo.classes.Funcionario;
import br.com.abc.javacore.Npolimorfismo.classes.Gerente;
import br.com.abc.javacore.Npolimorfismo.classes.RelatiorioPagamento;
import br.com.abc.javacore.Npolimorfismo.classes.Vendedor;

/**
 * PolimorfismoTest
 */
// Polimorfismo:  Uma variável pode se comportar de diversas formas 
// baseadas no tipo do objeto que ela está referenciando
// É análogo ao cast das variáveis do tipo primitivo, mas para variáveis de referência

public class PolimorfismoTest {

    public static void main(String[] args) {
        Gerente gerente = new Gerente("Osvaldo", 5000, 2000);
        Vendedor vendedor = new Vendedor("Yuri", 2000, 20000); 
        RelatiorioPagamento relatiorioPagamento = new RelatiorioPagamento();
        // relatiorioPagamento.relatorioPagamentoGerente(gerente);
        // System.out.println("-------------------------------");
        // relatiorioPagamento.relatorioPagamentoVendedor(vendedor);



        // O nome disso é cast widening
        //O argumento (variável de referência) funcionario de relatorioPagamentoGenerico aponta para
        // o objeto gerente e usa o método calculaPagamento dele e depois aponta para o objeto vendedor
        // e usa o objeto calculaPagamento dele 
        relatiorioPagamento.relatiorioPagamentoGenerico(gerente);
        System.out.println("-------------------------------");
        relatiorioPagamento.relatiorioPagamentoGenerico(vendedor);

        // É simplesmente chamar a função ou atributo de um objeto filho por meio da classe pai (desde que 
        // o método chamado esteja na classe pai)
        // Nessa instrução digo que a classe funcionário vai referenciar o mesmo objeto que a
        // a variável gerente está referenciando
        Funcionario funcionario = gerente;
        System.out.println("--------------------------");
        System.out.println(funcionario.getSalario());
       

        // Porque switch é code smell? Pq os cases podem ser passados por meio do tipo da variável de referência
    }
}