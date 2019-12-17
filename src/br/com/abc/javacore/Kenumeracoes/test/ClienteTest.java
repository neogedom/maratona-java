package br.com.abc.javacore.Kenumeracoes.test;

import br.com.abc.javacore.Kenumeracoes.classes.Cliente;
import br.com.abc.javacore.Kenumeracoes.classes.TipoCliente;

/**
 * ClienteTest
 */
public class ClienteTest {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Anna", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.APRAZO);
        System.out.println(TipoCliente.PESSOA_FISICA.getId());
        System.out.println(cliente);
    }
}